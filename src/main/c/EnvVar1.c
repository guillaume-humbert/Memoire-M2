#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int getDirsNb() {
	return 2;
}

// Gets an array of strings that contains the authorized directories for
// the environment variable.
char** getAuthorizedDirs() {

	int i;
	char** authorizedDirs = (char**)malloc(getDirsNb() * sizeof(char*));

	for (i = 0; i < getDirsNb(); i++) {
		authorizedDirs[i] = (char*)malloc((50 + 1) * sizeof(char));
	}

	strcpy(authorizedDirs[0], "/bin");
	strcpy(authorizedDirs[1], "/usr/bin");
	return authorizedDirs;

}

// Gets the application directory by validating the environment variable.
// If this variable is an authorized directory, it is returned. Otherwise
// NULL is returned.
char* getAppDir() {
	
	char** authorizedDirs = getAuthorizedDirs();
	char* appDir = getenv("APPDIR");
	int found = 0;
	int i;

	if (appDir == NULL) {
		return NULL;
	}

	for (i = 0; i < getDirsNb() && found == 0; i++) {
		if (strcmp(authorizedDirs[i], appDir) == 0) {
			found++;
			i = sizeof(authorizedDirs);
		}
	}

	if (found > 0) {
		return appDir;
	}

	return NULL;

}

int main(int argc, char** argv) {

	char* appDir = getAppDir();
	char bin[] = "ls";

	if (appDir == NULL) {
		fprintf(stderr, "Invalid application directory.\n");
		return 1;
	}

	char* cmd = (char*)malloc((strlen(appDir) + 1 + strlen(bin) + 1) * sizeof(char));
	strcpy(cmd, appDir);
	strcat(cmd, "/");
	strcat(cmd, bin);

	system(cmd);

	return 0;

}

