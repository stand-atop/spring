<%@ page  contentType="text/html; charset=euc-kr"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/etc/color.jsp"%>


<%-- 	<% 
	session.invalidate();
	response.sendRedirect("main.jsp");
	%> --%>
	
	<c:redirect url="/member/main.do"/>
	<!-- redirect������ /mvc(��Ű��)���� -->