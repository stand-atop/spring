<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쪽지목록</title>
</head>
<body>
	<h1>쪽지목록</h1>
	<button onclick="window.location='/spring/msg/form.do'">쪽지쓰기</button>
	<button onclick="window.location='/spring/msg/tolist.do?ch=toid'">받은 쪽지함</button>
	<button onclick="window.location='/spring/msg/sendlist.do?ch=sendid'">보낸 쪽지함</button>
	<br/>
	
	<table>
		<tr>
			새로 온 쪽지
		</tr>
		<tr>
			<c:forEach items="${tolist}" var="todto">
				<c:if test="${todto.state == 1 }">
					<a href="/spring/msg/conent.do?num=${todto.num}">${todto.num} ${todto.sendid} ${todto.toid} ${todto.reg}</a>
				</c:if>
				<c:if test="${todto.state == 0 }">
					새로 받은 쪽지가 없습니다.
				</c:if>
			</c:forEach>
		</tr>
	</table>
	
<%-- 	<table>
		<tr>
			<td>받은 쪽지함</td>
			<td>보낸 쪽지함</td>
		</tr>
		<tr>
			<td>
				<c:forEach items="${tolist}" var="todto">
					${todto.num} ${todto.sendid} ${todto.toid} ${todto.reg}
					<c:if test="${todto.state == 1 }">
						<b><a href="/spring/msg/content.do?num=${todto.num}">[안읽음]</a></b>
					</c:if>
					<c:if test="${todto.state == 0}">
						<b><a href="/spring/msg/content.do?num=${todto.num}">[읽음]</a></b>
					</c:if>
					<button onclick="window.location='/spring/msg/delete.do?num=${todto.num}'">삭제</button>
					<br/>
				</c:forEach>
			</td>
			<td>
				<c:forEach items="${sendlist}" var="senddto">
					${senddto.num} ${senddto.sendid} ${senddto.toid} ${senddto.reg}
					<c:if test="${senddto.state == 1 }">
						<b><a href="/spring/msg/content.do?num=${senddto.num}">[안읽음]</a></b>
					</c:if>
					<c:if test="${senddto.state == 0}">
						<b><a href="/spring/msg/content.do?num=${senddto.num}">[읽음]</a></b>
					</c:if>
					<button onclick="window.location='/spring/msg/delete.do?num=${senddto.num }'">삭제</button>
					<br/>
				</c:forEach>
			</td>
		</tr>
	</table> --%>
</body>
</html>