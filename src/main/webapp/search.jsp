<h1>Search</h1>
<form action="search.html" method="get">
    <div>
        <span>Enter keywords:</span> <input type="text" size="20" name="q" />
        <input type="submit" value="Search" />
    </div>
</form>
<%
    String query = request.getParameter("q");
    if (query != null && !query.trim().isEmpty()) {
        out.print("<p>No results found for <b>" + query + "</b></p>");
    }
%>
