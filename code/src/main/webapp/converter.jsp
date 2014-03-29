<jsp:useBean id="converterBean" scope="session"
    class="org.miage.memoire.bean.ConverterBean"/>
    <%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html; charset=UTF-8" %>
    <% request.setCharacterEncoding("UTF-8"); %>
<%= request.getCharacterEncoding() %>

<% converterBean.setStringToConvert(request.getParameter("stringToConvert")); %>

<%
if ("convertToJavaScriptHexString".equals(request.getParameter("action"))) {
    converterBean.convertToJavaScriptHexString();
} else if ("convertToUrlHexadecimalFormat".equals(
        request.getParameter("action"))) {
    converterBean.convertToUrlHexadecimalFormat();
}
%>

<h1>Converter</h1>

<form action="converter.html" method="get">
<h2>Text to convert</h2>
<select name="action">
    <option value="convertToJavaScriptHexString">Javascript toCharCode string</option>
    <option value="convertToUrlHexadecimalFormat">Hexadecimal URL</option>
</select>
<textarea rows="10" cols="50" name="stringToConvert"><jsp:getProperty property="stringToConvert" name="converterBean"/></textarea>
<input type="submit" value="Convert"/>
</form>

<div>
<h2>Results</h2>
<textarea rows="10" cols="50"><jsp:getProperty property="convertedString" name="converterBean"/></textarea>
</div>