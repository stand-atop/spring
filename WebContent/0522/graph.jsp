<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.rosuda.REngine.Rserve.RConnection" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>graph page</title>
</head>
<body>
	<% 
		String path = request.getRealPath("0522");	//클라이언트에게 서비스 하기 위한 파일은 컴퓨터 경로가 아닌 프로젝트, 서버 경로가 들어가야함.
		RConnection rc = new RConnection();
		rc.eval("score <- read.csv('d:/R/score.csv')"); //R에서 경로 작성시 / 하나, 자바는 // 둘
		path = path.replace("\\", "/");
		System.out.println(path); //패스경로 로그
		rc.eval("png('"+path+"/scoreResult.png')");
		
		rc.eval("plot(score$math,type='o',col='red',lty=2,axes=F , ann=F, ylim=c(0,100) , xlim=c(1 ,length(score$id)))");
		rc.eval("lines(score$english, type='o' ,lty=2, col='green')");
		rc.eval("lines(score$science, type='o' ,lty=2, col='blue')");
		rc.eval("mean <- trunc(rowMeans(score[,3:5]))");
		rc.eval("lines(mean, col='black')");
		rc.eval("axis(1 , at=1:length(score$id), lab=score$id)");
		rc.eval("axis(2 , at=seq(0,100,10))"); 
		rc.eval("box()");
		rc.eval("title(main='성적그래프',col.main='red',font.main=4)");
		rc.eval("title(xlab='학번',col.lab='red')");
		rc.eval("title(ylab='점수',col.lab='red')");
		rc.eval("legend(15,20,c('수학','영어','과학','평균'),cex=0.8,col=c('red','green','blue','black'),lty=c(2,2,2,1))");
		
		rc.eval("dev.off()");
		rc.close();
		
	%>	
	<img src="scoreResult.png"/>
</body>
</html>