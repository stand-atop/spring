<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.rosuda.REngine.Rserve.RConnection" %>
<%@ page import="org.rosuda.REngine.REXP" %>
<%@ page import="org.rosuda.REngine.RList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RConnection2 page</title>
</head>
<body>
	<%-- 
		REXP 
		- R과 JAVA 서로의 자료구조와 데이터 타입을 사용할 수 있도록 지원하는 데이터 모델형 클래스
		- R에서 보내온 데이터셋을 JAVA에서 받을 때 사용된다.  
		- R : 논리형/숫자/문자
		- JAVA : 논리형/숫자(int, double)/문자(String)
		- R에서 보내온 숫자형 데이터는 JAVA에서 double로 받음/int(정수형)로 받을 수 없음
		- asDoubles/ asStrings/ AsList
	--%>
	
	<%
		RConnection rc = new RConnection();
		/*double [] result = rc.eval("rnorm(20)").asDoubles();
		for(double d:result){
			out.println(d+"<br/>");
		}*/
		
		rc.eval("v1 <- c('java', 'jsp', 'web', 'frame')");
		rc.eval("df <- data.frame(v1, c(1:4))");	//4=데이터 열의 갯수
		RList list = rc.eval("df").asList();

		/* String [] v1 = list.at(0).asStrings();	//R[1]과 JAVA[0]의 배열의 시작값이 다름 - JAVA에서 0부터 가져와야 R의 1번째 값
		for(String s:v1){
			out.println(s+"<br/>");
		} */
		
		int cols = list.size(); //열
		for(int i=0; i< cols; i++){
			String [] col = list.at(i).asStrings();
			for(String s:col){
				out.println(s+"<br/>");
			}
		}		
		rc.close();		
	%>
</body>
</html>