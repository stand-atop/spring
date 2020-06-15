<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>confirmId page</title>
</head>
<body>
<%
	String id = request.getParameter("id");
	if(id.equals("java")){
		out.println("<font color=red>불가능</font>");
	}else{
		out.println("<font color=green>가능</font>");
	}
%>
</body>
</html>