<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>폼 응답</title>
</head>
<body>
	오늘 날짜 : <%= new Date() %>
	<h1>응답:</h1>
	<h2><%= request.getParameter("memid") %></h2>
	<h2><%= request.getParameter("mempw") %></h2>
	<h2><%= request.getParameter("memname") %></h2>
</body>
</html>