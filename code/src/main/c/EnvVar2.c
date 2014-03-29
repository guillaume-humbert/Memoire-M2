#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// Returns the expected hash of the binary to be executed.
char* getBinHash() {
	char binHash[] = "1c6eed569135471892bab7ebbc7b33fbd592e857fe16beef15ce5ce1c45ffe524b8f7df6499807201e20285eb6d8112591d0013df8a91e2f2aaef150425e8c11";
	char* hash = malloc(129 * sizeof(char));
	strcpy(hash, binHash);
	return hash;
}

// Calculates and return the sha512 sum of the specified file.
char* computeSha512(char* file) {
	char shaCmd[] = "/usr/bin/sha512sum -b ";

	char* cmd = (char*)malloc((strlen(shaCmd) + strlen(file) + 1) * sizeof(char));
	
	strcpy(cmd, shaCmd);
	strcat(cmd, file);

	FILE* ptr;
	char* buff = (char*)malloc(129 * sizeof(char));
	if ((ptr = popen(cmd, "r")) != NULL) {
		fgets(buff, 129, ptr);
		pclose(ptr);
	}

	return buff;
}

// Returns 0 if the binary is corrupted, 1 otherwise.
int checkBin(char* binName) {
	
	if (strcmp(getBinHash(), computeSha512(binName)) == 0) {
		return 1;
	}

	return 0;
}

int main(int argc, char** argv) {

	char* appDir = getenv("APPDIR");
	char bin[] = "ls";

	if (appDir == NULL) {
		fprintf(stderr, "Invalid application directory.\n");
		return 1;
	}

	char* cmd = (char*)malloc((strlen(appDir) + 1 + strlen(bin) + 1) * sizeof(char));
	strcpy(cmd, appDir);
	strcat(cmd, "/");
	strcat(cmd, bin);

	if (checkBin(cmd)) {
		system(cmd);
	} else {
		printf("The binary is corrupted.\n");
	}

	return 0;

}

