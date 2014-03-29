package org.miage.memoire.bean;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This bean allows database access. It is intentionnaly not well programmed:
 * the queries and data retrieval must be performed on a different lower layer.
 * @author Guillaume Humbert
 */
public final class DbBean {

    /**
     * A database connection.
     */
    private Connection connection;
    
    /**
     * Default empty constructor.
     */
    public DbBean() {
        super();
    }
    
    /**
     * Gets an user address by providing his name.
     * @param name The name of the user.
     * @return The address of the user, or null if not found.
     * @throws SQLException When a SQL error occurs.
     */
    public String getUserAddressByName(final String name) throws SQLException {
        
        final String query = "SELECT address FROM user WHERE name = ?";
        final PreparedStatement statement =
            this.connection.prepareStatement(query);
        final ResultSet resultSet;
        
        statement.setString(1, name);
        
        resultSet = statement.executeQuery();
        
        if (resultSet.next()) {
            return resultSet.getString(1);
        }
        
        return null;
    }
    
    /**
     * Gets an user function by providing his name.
     * @param name The name of the user.
     * @return The function of the user, or null if not found.
     * @throws SQLException When a SQL error occurs.
     */
    public String getUserFunctionByName(final String name) throws SQLException {
        
        final String query = "{call getUserFunctionByName(?)}";
        final CallableStatement statement = this.connection.prepareCall(query);
        statement.setString(1, name);
        
        final ResultSet resultSet = statement.executeQuery();
        
        if (resultSet.next()) {
            return resultSet.getString(1);
        }
        
        return null;
    }
    
}
