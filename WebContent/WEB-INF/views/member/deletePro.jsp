<%@ page contentType="text/html;charset=euc-kr" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/etc/color.jsp"%>
<link href="style.css" rel="stylesheet" type="text/css">
<html>
<head>
<title>ȸ��Ż��</title>
</head>

<c:if test="${ check ==1 }" >
<body bgcolor="${ bodyback_c }">
<form method="post" action="/spring/member/main.do" name="userinput" >
<table width="270" border="0" cellspacing="0" cellpadding="5" align="center">
  <tr bgcolor="${ title_c }"> 
    <td height="39" align="center">
	  <font size="+1" ><b>ȸ�������� �����Ǿ����ϴ�.</b></font></td>
  </tr>
  <tr bgcolor="${ value_c }">
    <td align="center"> 
      <p>�ȳ���������.</p>
      <meta http-equiv="Refresh" content="5;url=/spring/member/main.do" >
    </td>
  </tr>
  <tr bgcolor="${ value_c }">
    <td align="center"> 
      <input type="submit" value="Ȯ��">
    </td>
  </tr>
</table>
</form>
</c:if>
<c:if test="${ check != 1 }">
	<script> 
	  alert("��й�ȣ�� ���� �ʽ��ϴ�.");
      history.go(-1);
	</script>
</c:if>

</body>
</html>
