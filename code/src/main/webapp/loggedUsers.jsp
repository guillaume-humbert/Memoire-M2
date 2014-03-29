<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<jsp:useBean id="loggedUsersBean" scope="session"
    class="org.miage.memoire.bean.LoggedUsersBean"/>

<ul>
    <c:forEach var="s" items="${loggedUsersBean.loggedUsers}">
        <li>${fn:escapeXml(s)}</li>
    </c:forEach>
</ul>

<%
String login = request.getParameter("login");
if (login != null && !login.isEmpty()) {
    loggedUsersBean.getLoggedUsers().add(login);
}
%>

<h1>Logged users</h1>

<h1>Login</h1>

<form action="loggedUsers.html" method="post">
    Login:&nbsp;<input type="text" name="login"/>
    <input type="submit" value="Login"/>
</form>

<ul>
	<%
    for (String s : loggedUsersBean.getLoggedUsers()) {
        out.print("<li>" + s + "</li>");
    }
    %>
</ul>


<br/><br/><br/>

<ul>
	<c:forEach var="s" items="${loggedUsersBean.loggedUsers}">
	    <li>${fn:escapeXml(s)}</li>
	</c:forEach>
</ul>