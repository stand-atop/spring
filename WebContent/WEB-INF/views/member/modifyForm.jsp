<%@ page contentType="text/html;charset=euc-kr" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/etc/color.jsp"%>

<html>
<head>
<title>ȸ����������</title>
<link href="style.css" rel="stylesheet" type="text/css">


<script language="JavaScript">
   <!-- 
    function checkIt() {
        var userinput = eval("document.userinput");
               
        if(!userinput.passwd.value ) {
            alert("��й�ȣ�� �Է��ϼ���");
            return false;
        }
        if(userinput.passwd.value != userinput.passwd2.value)
        {
            alert("��й�ȣ�� �����ϰ� �Է��ϼ���");
            return false;
        }
       
        if(!userinput.username.value) {
            alert("����� �̸��� �Է��ϼ���");
            return false;
        }
        if(!userinput.jumin1.value  || !userinput.jumin2.value )
        {
            alert("�ֹε�Ϲ�ȣ�� �Է��ϼ���");
            return false;
        }
    }
-->
</script>

<body bgcolor="${ bodyback_c }">
<form method="post" action="/spring/member/modifyPro.do" name="userinput" onsubmit="return checkIt()">
<c:forEach var="select" items="${ list }">
  <table width="600" border="1" cellspacing="0" cellpadding="3"  align="center">
    <tr > 
      <td  colspan="2" height="39" bgcolor="${ title_c }" align="center">
	     <font size="+1" ><b>ȸ�� ��������</b></font></td>
    </tr>
    <tr>
      <td colspan="2" class="normal" align="center">ȸ���� ������ �����մϴ�.</td>
    </tr>
     <tr> 
      <td width="200" bgcolor="${ value_c }"><b>���̵� �Է�</b></td>
      <td width="400" bgcolor="${ value_c }">&nbsp;</td>
    <tr>  

    <tr> 
      <td  width="200"> ����� ID</td>
      <td  width="400">${ select.id }</td>
        <input type="hidden" name="id" size="10" maxlength="10" value="${ select.id }"/>
    </tr>
    
     <tr> 
      <td width="200"> ��й�ȣ</td>
      <td width="400"> 
        <input type="password" name="passwd" size="10" maxlength="10" value="${ select.passwd }">
      </td>
    <tr>  
    <tr> 
      <td  width="200" bgcolor="${ value_c }"><b>�������� �Է�</b></td>
      <td width="400" bgcolor="${ value_c }">&nbsp;</td>
    <tr>  
    <tr> 
      <td   width="200">����� �̸�</td>
      <td  width="400"> 
        <input type="text" name="name" size="15" maxlength="20" value="${ select.name }">
      </td>
    </tr>
    <tr> 
      <td width="200">�ֹε�Ϲ�ȣ</td>
      <td width="400"> 
        ${ select.jumin1 }-${ select.jumin2 }
      </td>
    </tr>
   <tr> 
      <td width="200">E-Mail</td>
      <td width="400">
	    <c:if test="${ select.email == null }">
	      <input type="text" name="email" size="40" maxlength="30" >
		</c:if>
		<c:if test="${ select.email != null }">	
          <input type="text" name="email" size="40" maxlength="30" value="${ select.email }">	
		</c:if>
      </td>
    </tr>
    <tr> 
      <td width="200">Blog</td>
      <td width="400">
       	<c:if test="${ select.blog == null }">	
	      <input type="text" name="blog" size="60" maxlength="50" >
		</c:if>
		<c:if test="${ select.blog != null }">	
          <input type="text" name="blog" size="60" maxlength="50" value="${ select.blog }">
		</c:if>
      </td>
    </tr>      
    <tr> 
      <td colspan="2" align="center" bgcolor="${ value_c }"> 
       <input type="submit" name="modify" value="��   ��" >
       <input type="button" value="��  ��" onclick="window.location='/spring/member/main.do'">      
      </td>
    </tr>
  </table>
 </c:forEach>
</form>
</body>
</html>