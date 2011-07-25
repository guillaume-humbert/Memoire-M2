<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html;charset=utf-8" />
<link rel="stylesheet" type="text/css" href="resources/css/main.css"/>
<title><tiles:getAsString name="title" /></title>
</head>
<body>

<div id="header"><tiles:insertAttribute name="header" /></div>

<div id="left"><tiles:insertAttribute name="left" /></div>

<div id="center"><tiles:insertAttribute name="center" /></div>

<div id="footer"><tiles:insertAttribute name="footer" /></div>

</body>
</html>