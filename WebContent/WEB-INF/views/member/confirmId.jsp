<%@ page contentType="text/html;charset=euc-kr" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/etc/color.jsp"%>
<link href="/spring/etc/style.css" rel="stylesheet" type="text/css">
<html>
<head><title>ID �ߺ�Ȯ��</title>

<body bgcolor="${ bodyback_c }">

<c:if test="${ check == 1 }" >
<table width="270" border="0" cellspacing="0" cellpadding="5">
  <tr bgcolor="${ title_c }"> 
    <td height="39" >${ param.id }�̹� ������� ���̵��Դϴ�.</td>
  </tr>
</table>
<form name="checkForm" method="post" action="/spring/member/confirmId.do">
<table width="270" border="0" cellspacing="0" cellpadding="5">
  <tr>
    <td bgcolor="${ value_c }" align="center"> 
       �ٸ� ���̵� �����ϼ���.<p>
       <input type="text" size="10" maxlength="12" name="id"> 
       <input type="submit" value="ID�ߺ�Ȯ��">
    </td>
  </tr>
</table>
</form>
</c:if>
<c:if test="${ check != 1 }">
<table width="270" border="0" cellspacing="0" cellpadding="5">
  <tr bgcolor="${ title_c }"> 
    <td align="center"> 
      <p>�Է��Ͻ� ${ param.id } �� ����Ͻ� �� �ִ� ID�Դϴ�. </p>
      <input type="button" value="�ݱ�" onclick="setid()">
    </td>
  </tr>
</table>
</c:if>
</body>
</html>
<script language="javascript">
<!--
  function setid()
    {		
    	opener.document.userinput.id.value="${ param.id }";
		self.close();
		}
		-->
</script>
