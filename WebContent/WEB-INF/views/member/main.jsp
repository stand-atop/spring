<%@ page  contentType="text/html; charset=euc-kr"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/etc/color.jsp"%>
<html>
<head><title>메인입니다..</title>
<link href="/spring/etc/style.css" rel="stylesheet" type="text/css">
</head>

<script language="javascript">

</script>
</head>
   <c:if test="${ sessionScope.memId == null}">
   
<body onLoad="focusIt();" bgcolor="${bodyback_c}">
  <table width=500 cellpadding="0" cellspacing="0"  align="center" border="1" >
      <tr>
       <td width="300" bgcolor="${ bodyback_c }" height="20">
       &nbsp;
       </td>   
       <form name="inform" method="post" action="/spring/member/loginPro.do"  onSubmit="return checkIt();">

        <td bgcolor="${ title_c }"  width="100" align="right">아이디</td>
        <td width="100" bgcolor="${ value_c }">
            <input type="text" name="id" size="15" maxlength="10"></td>
      </tr>
      <tr > 
         <td rowspan="2" bgcolor="${ bodyback_c }" width="300" >메인입니다.</td>
         <td bgcolor="${ title_c }"  width="100" align="right">패스워드</td>
         <td width="100" bgcolor="${ value_c }">
            <input type="password" name="passwd" size="15" maxlength="10"></td>
       </tr>
       <tr>
          <td colspan="3" bgcolor="${ title_c }"   align="center">
            <input type="submit" name="Submit" value="로그인">
            <input type="button"  value="회원가입" onclick="window.location='/spring/member/inputForm.do'"/>

          </td></form></tr></table>
         
   </c:if>
     <c:if test="${sessionScope.memId != null}">
        <script src="//code.jquery.com/jquery-3.5.1.min.js"></script>
	   <script>
	   	window.setInterval("count()", 5000);
	   	function count(){
	   		$.ajax({
	   			url:"/spring/msg/count.do",
	   			success:function(data){
	   				$("#count").html(data);
	   			}
	   		});
	   	}
	   </script>
       <table width=500 cellpadding="0" cellspacing="0"  align="center" border="1" >
         <tr>
           <td width="300" bgcolor="${ bodyback_c }" height="20">하하하</td>

           <td rowspan="3" bgcolor="${ value_c }" align="center">
             ${ sessionScope.memId }님이 <br>방문하셨습니다
             <form  method="post" action="/spring/member/logout.do">  
             <input type="submit"  value="로그아웃">
             <input type="button" value="회원정보변경" onclick="window.location='/spring/member/modify.do'"/>
             <input type="button" value="게시판" onclick="window.location='/spring/member/list.do'"/>
             <input type="button" value="채팅" onclick="window.location='/spring/member/chat.do'"/>
<!--              <input type="button" value="채팅리스트" onclick="window.location='/spring/member/chattinList.do'"/>
 -->           <!--   <input type="button" value="쪽지" onclick="window.location='/spring/msg/list.do'"/> -->
           	<br/>
             <a href="/spring/msg/list.do">쪽지<label id="count">[${ count }]</label></a>
             </form>
         </td>
        </tr>
       <tr > 
         <td rowspan="2" bgcolor="${ bodyback_c }" width="300" >메인입니다.</td>
      </tr>
     </table>
     <br>
 </c:if>
 
 <br/>
 <center>
	 <form action="/spring/member/search.do" method="post">
	 	<select name="ch">
	 		<option value="id">아이디</option>
	 		<option value="name">이름</option>
	 	</select>
	 	<input type="text" name="search"/>
	 	<input type="submit" value="검색"/>
	 </form>
	 <c:forEach var="dto" items="${ list }">
	 	${ dto.id } ${ dto.name } ${ dto.email }<br/> 
	 </c:forEach>
 </center>
 </body>
</html>
