<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajax - Time</title>
</head>
<body>
	<%
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date day = new Date();
		out.println(sdf.format(day));
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		out.println(id+"="+name);
	%>
</body>
</html>