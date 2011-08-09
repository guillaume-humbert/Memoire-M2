package org.miage.memoire;

/**
 * This class represents an user, and is used in the SQL injection part.
 * @author Guillaume Humbert
 */
public class User {

    /**
     * The user id.
     */
    private int id;
    
    /**
     * The user name.
     */
    private String name;
    
    /**
     * The user account number.
     */
    private String accountNb;
    
    /**
     * Empty default constructor.
     */
    public User() {
        super();
    }
    
    /**
     * Getter on the 'id' attribute.
     * @return The user id.
     */
    public int getId() {
        return this.id;
    }

    /**
     * Setter on the 'id' attribute.
     * @param id The user id.
     */
    public void setId(final int id) {
        this.id = id;
    }

    /**
     * Getter on the 'name' attribute.
     * @return The user name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Setter on the 'name' attribute.
     * @param name The user name.
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Getter on the 'accountNb' attribute.
     * @return The user account number.
     */
    public String getAccountNb() {
        return this.accountNb;
    }

    /**
     * Setter on the 'accountNb' attribute.
     * @param accountNb The user account number.
     */
    public void setAccountNb(final String accountNb) {
        this.accountNb = accountNb;
    }
    
}
