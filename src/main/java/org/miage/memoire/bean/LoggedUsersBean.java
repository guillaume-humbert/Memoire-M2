package org.miage.memoire.bean;

import java.util.LinkedList;
import java.util.List;

public class LoggedUsersBean {

    public LoggedUsersBean() {
        this.loggedUsers.add("Admin");
        this.loggedUsers.add("Guest");
        this.loggedUsers.add("Atta<b>ck</b>er");
    }
    
    public List<String> getLoggedUsers() {
        return this.loggedUsers;
    }

    public void setLoggedUsers(List<String> loggedUsers) {
        this.loggedUsers = loggedUsers;
    }

    private List<String> loggedUsers = new LinkedList<String>();
    
}
