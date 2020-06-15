<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>deleteForm</title>
</head>
<body>
	<h1>deleteForm 페이지</h1>
	
	<form action="/spring/file/deletePro.do" method="post">
	<table>
		<tr>
			<td>num</td>
			<td>writer</td>
			<td>orgname</td>
			<td>sysname</td>
			<td>reg</td>
			<td>check</td>
		</tr>
	<c:forEach var="dto" items="${ list }">
		<tr>
			<td>${ dto.num }</td>
				<input type="hidden" name="num" value="${ dto.num }"/>
			<td>${ dto.writer }</td>
<%-- 				<input type="hidden" name="writer" value="${ dto.writer }"/> --%>
			<td>${ dto.orgname }</td>
<%-- 				<input type="hidden" name="orgname" value="${ dto.orgname }"/> --%>
			<td>${ dto.sysname }</td>
<%-- 				<input type="hidden" name="sysname" value="${ dto.sysname }"/> --%>
			<td>${ dto.reg }</td>
<%-- 				<input type="hidden" name="reg" value="${ dto.reg }"/> --%>
			<td><input type="submit" value="삭제"/></td>
		</tr>
	</c:forEach>
	</table> 
	</form>
	
</body>
</html>