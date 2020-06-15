<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>받는 쪽지함</title>
</head>
<body>
	<h1>받은 쪽지함</h1>
	<table>
		<tr>
			<td>번호</td>
			<td>보낸id</td>
			<td>받은id</td>
			<td>보낸시간</td>
		</tr>
		<c:forEach var="todto" items="${ tolist }">
			<tr>
				<td>${todto.num}</td>
				<td>${todto.sendid}</td>
				<td>${todto.toid}</td>
				<td>${todto.reg}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>