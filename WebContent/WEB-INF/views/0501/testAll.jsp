<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>testAll페이지 - mybatis</title>
</head>
<body>

	<c:forEach var="dto" items="${ list }">
		${ dto.id } ${ dto.pw } ${ dto.name } ${ dto.age } ${ dto.reg } <br/>
	</c:forEach>

</body>
</html>