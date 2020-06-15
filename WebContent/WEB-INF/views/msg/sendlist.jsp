<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>보낸 쪽지함</title>
</head>
<body>
	<h1>보낸 쪽지함</h1>
	<table>
		<tr>
			<td>번호</td>
			<td>보낸id</td>
			<td>받은id</td>
			<td>보낸시간</td>
		</tr>	
		<c:forEach var="senddto" items="${ sendlist }">
			<tr>
				<td>${ senddto.num }</td>
				<td>${ senddto.sendid }</td>
				<td>${ senddto.toid }</td>
				<td>${ senddto.reg }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>