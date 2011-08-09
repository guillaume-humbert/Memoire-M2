<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.LinkedList"%>
<%@page import="java.sql.Connection" %>
<%@page import="java.sql.DriverManager" %>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Statement" %>
<%@page import="java.util.List" %>
<%@page import="org.miage.memoire.User" %>

<h1>User info</h1>

<%!

public void initDb() throws SQLException {
    Statement statement = this.connection.createStatement();
    //statement.executeUpdate("DROP TABLE user IF EXISTS");
    statement.executeUpdate("CREATE TABLE IF NOT EXISTS user (id IDENTITY, "
            + "name VARCHAR(32), "
            + "accountNb VARCHAR(8))");
    
    if (this.getUsers().isEmpty()) {
	    statement.executeUpdate("INSERT INTO user VALUES ("
	            + "DEFAULT, 'Secret Admin', '777')");
	    statement.executeUpdate("INSERT INTO user VALUES ("
	            + "DEFAULT, 'John Doe', '1009')");
	    statement.executeUpdate("INSERT INTO user VALUES ("
	            + "DEFAULT, 'William Shakespeare', '1010')");
	    statement.executeUpdate("INSERT INTO user VALUES ("
	            + "DEFAULT, 'Haris Pilton', '1011')");
	    statement.executeUpdate("INSERT INTO user VALUES ("
	            + "DEFAULT, 'Bonnie Parker', '1012')");
    }
	    
    this.connection.commit();
    statement.close();
}

public List<User> getUsers() throws SQLException {
    List<User> users = new LinkedList<User>();
    
    Statement statement = this.connection.createStatement();
    
    try {
	    ResultSet resultSet = statement.executeQuery("SELECT id, name, "
	            + "accountNb FROM user WHERE name != 'Secret Admin'");
	    while (resultSet.next()) {
	        User user = new User();
	        user.setId(resultSet.getInt("id"));
	        user.setName(resultSet.getString("name"));
	        user.setAccountNb(resultSet.getString("accountNb"));
	        users.add(user);
	    }
    } finally {
        statement.close();
    }
    
    return users;
}

public User getUserById(final String id) throws SQLException {
    
    Statement statement = this.connection.createStatement();
    try {
	    
	    ResultSet resultSet = statement.executeQuery("SELECT id, name, "
	            + "accountNb FROM user WHERE id = " + id);
	    if (resultSet.next()) {
	        User user = new User();
	        user.setId(resultSet.getInt("id"));
	        user.setName(resultSet.getString("name"));
	        user.setAccountNb(resultSet.getString("accountNb"));
	        return user;
	    }
    } finally {
        statement.close();
    }
    
    return null;
}

public User getUserByName(final String name) throws SQLException {
    Statement statement = this.connection.createStatement();
    try {
        
        ResultSet resultSet = statement.executeQuery("SELECT id, name, "
                + "accountNb FROM user WHERE name = '" + name + "'");
        if (resultSet.next()) {
            User user = new User();
            user.setId(resultSet.getInt("id"));
            user.setName(resultSet.getString("name"));
            user.setAccountNb(resultSet.getString("accountNb"));
            return user;
        }
    } finally {
        statement.close();
    }
    
    return null;
}

private Connection connection = null;
%>

<%
this.connection = DriverManager.getConnection(
        "jdbc:hsqldb:mem:mymemdb", "SA", "");

this.initDb();
%>

<form action="sql.html" method="get">
    <div>Select by id</div>
    <select name="id">
        <%
        List<User> users = this.getUsers();
        for (User user : users) {
            out.print("<option value=\"" + user.getId() + "\">" + user.getName()
                    + "</option>");
        }
        %>
    </select>
    <input type="submit" value="Submit"/>
</form>

<form action="sql.html" method="get">
    <div>Select by name</div>
    <select name="name">
        <%
        for (User user : users) {
            out.print("<option value=\"" + user.getName() + "\">"
                    + user.getName() + "</option>");
        }
        %>
    </select>
    <input type="submit" value="Submit"/>
</form>

<div>
<%
String id = request.getParameter("id");
if (id != null && !id.isEmpty()) {
    User user = this.getUserById(id);
    if (user != null) {
        out.print("Account number for the user " + user.getName() + ": "
                + user.getAccountNb());
    } else {
        out.print("User does not exist.");
    }
}
%>
</div>
<div>
<%
String name = request.getParameter("name");
if (name != null && !name.isEmpty()) {
    User user = this.getUserByName(name);
    if (user != null) {
        out.print("Account number for the user id " + user.getId() + ": "
                + user.getAccountNb());
    } else {
        out.print("User does not exist.");
    }
}

this.connection.close();
%>
</div>