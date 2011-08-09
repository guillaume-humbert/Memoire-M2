<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>

<h1>Choose an action</h1>

<form action="command.html" method="get">
	<select name="command">
	    <option value="ls">List directory contents</option>
	    <option value="date">Print the current date</option>
	</select>
	<input type="submit" value="Execute">
</form>

<%
String command = request.getParameter("command");
if (command != null && !command.isEmpty()) {
    
    Process p = Runtime.getRuntime().exec(command);
    
    BufferedReader in = new BufferedReader(
            new InputStreamReader(p.getInputStream()));

    String line = in.readLine();
    while (line != null) {
        out.print(line + "<br/>");
        line = in.readLine();
    }
    in.close();
    
    in = new BufferedReader(
            new InputStreamReader(p.getErrorStream()));
    
    line = in.readLine();
    while (line != null) {
        out.print(line + "<br/>");
        line = in.readLine();
    }
    in.close();
    p.destroy();
    
}
%>