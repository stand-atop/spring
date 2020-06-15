<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.rosuda.REngine.Rserve.RConnection" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RConnection page</title>
</head>
<body>
	<% RConnection rc = new RConnection();	//서버연결 
		// rc.assign(arg0, arg1)	데이터셋이름, 값
		//rc.eval(cmd)
		int [] num = {1,2,3,4,5,6};	//자바의 배열 = R의 벡터
		rc.assign("v1", num);	//v1 <- c(1,2,3,4,5,6) 과 같은문법//assign은 void타입 - return값이 없음
		num = rc.eval("v1+10").asIntegers(); //=REXP rp = rc.eval("v1+10"); - 같은 문법
		for(int n:num){
			out.println(n+"<br/>");
		}
		rc.close();
	%>
	<h1>연결객체 = <%= rc %></h1>
</body>
</html>