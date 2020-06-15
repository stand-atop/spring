<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쪽지보내기</title>
</head>
<body>
	<h1>쪽지보내기</h1>
	<form action="/spring/msg/formPro.do" method="post">
		<input type="hidden" name="sendid" value="${sessionScope.memId }"/>
		받는ID: <input type="text" name="toid"/> <br/>
		내용:<textarea name="msg"></textarea><br/>
		<input type="submit" value="쪽지 보내기"/>
	</form>
</body>
</html>