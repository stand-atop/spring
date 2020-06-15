<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
	<script src="/spring/js/jquery-1.10.2.min.js"></script>
	<script src="/spring/js/socket.io.js"></script>
	<script>
	
	</script>
</head>
<body>
	<h1>채팅</h1>
	
		<input type="text" id="chat" /><!-- id속성은 css나 스크립xm에서 사용하는 속성?/class는 한꺼번에 변경할 묶음 속성 -->
		<input type="button" onclick="window.location='/spring/member/chat.do'" id="sendRoom" />
		 <span id="msgs"></span>
</body>
</html>