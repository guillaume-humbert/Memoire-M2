package org.miage.memoire.bean;

import java.util.LinkedList;
import java.util.List;

/**
 * This bean saves a list of logged users as strings.
 * @author Guillaume Humbert
 */
public class LoggedUsersBean {

    /**
     * The list of logged users.
     */
    private List<String> loggedUsers = new LinkedList<String>();
    
    /**
     * Default constructor.
     */
    public LoggedUsersBean() {
        this.loggedUsers.add("Admin");
        this.loggedUsers.add("Guest");
        this.loggedUsers.add("Atta<b>ck</b>er");
    }
    
    /**
     * Getter on the 'loggedUsers' attribute.
     * @return The list of logged users.
     */
    public List<String> getLoggedUsers() {
        return this.loggedUsers;
    }

    /**
     * Setter on the 'loggedUsers' attribute.
     * @param loggedUsers The list of logged users.
     */
    public void setLoggedUsers(final List<String> loggedUsers) {
        this.loggedUsers = loggedUsers;
    }
    
}
