<%@ page contentType="text/html;charset=euc-kr" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <%@ page import = "ch11.logon.LogonDBBean" %> --%>
<%-- <% request.setCharacterEncoding("euc-kr");%> --%>

<%-- <%
    String id = request.getParameter("id");
	String passwd  = request.getParameter("passwd");	
	
	LogonDBBean manager = LogonDBBean.getInstance();
    int check= manager.userCheck(id,passwd);

	if(check==1){ --%>
		<!-- session.setAttribute("memId",id);
		response.sendRedirect("main.jsp");
	}else if(check==0){%> -->
	<%-- <%	}else{ %> --%>
	<%-- <%}	%>	 --%>
	
	<c:choose>
		<c:when test="${ check == 1 }">
			${ sessionScope.memId };
			<c:redirect url="/member/main.do"/>
		</c:when>
		
		<c:when test="${ check == 0 }" >
			<script> 
		  	alert("��й�ȣ�� ���� �ʽ��ϴ�.");
	    	  history.go(-1);
			</script>
		</c:when>
		
		<c:otherwise>
			<script>
			  alert("���̵� ���� �ʽ��ϴ�..");
			  history.go(-1);
			</script>
		</c:otherwise>
	</c:choose>
