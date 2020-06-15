<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.rosuda.REngine.Rserve.RConnection" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>wordcloud2 page</title>
	<script src="/spring/js/htmlwidgets.js"></script>
	<script src="/spring/js/wordcloud2.js"></script>
	<script src="/spring/js/lib/wordcloud2-0.0.1/hover.js"></script>
	<script src="/spring/js/lib/wordcloud2-0.0.1/wordcloud2-all.js"></script>
	<link href="/spring/js/lib/wordcloud2-0.0.1/wordcloud.css" rel="stylesheet"/>
</head>
<body>
	<%
		RConnection rc = new RConnection();
		//rc.eval(".libPaths('d:/R/library')"); 경로를 변경했을 경우 작성
		rc.eval("library(wordcloud2)");
		rc.eval("library(htmltools)");
		rc.eval("wc <- wordcloud2(demoFreq)");
		rc.eval("rt <- renderTags(wc)");	//html태그처럼 변환시킴
		String wc = rc.eval("rt$html").asString();
		rc.close();
	%>
	
	<%=wc %>
	
	<!-- 
		그래프를 웹으로 출력
		- score.csv = 그래프
	 -->
	
	
	
</body>
</html>
