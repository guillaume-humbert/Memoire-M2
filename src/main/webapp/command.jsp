<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<h1>Help</h1>

<form action="command.html" method="get">
	<select name="helpFile">
		<option value="ls.html">ls.html</option>
		<option value="cat.html">cat.html</option>
	</select>
	<br/>
	<input type="submit" value="Submit">
</form>

<br/><br/>

<%
String file = request.getParameter("helpFile");
if (file != null && !file.isEmpty()) {
    Process p = Runtime.getRuntime().exec("sh -c cat " + file);
    
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
    //out.print("Exit value: " + p.exitValue());
    //p.destroy();
    
}
%>