<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Chatting</title>
<script src="/spring/js/jquery-1.10.2.min.js"></script>
<script src="/spring/js/socket.io.js"></script>
<script>
	$(document).ready(function() {
		// 메시지를 보냄
		var socket = io.connect("http://192.168.0.25:12345");  //서버연결 - 본인 IP
		socket.on('response', function(msg){// 서버로부터 채팅메세지를 계속 받고있음. 계속 받아줘야 늦지 않게 보내줌 
			//$('#msgs').append(msg.msg+'<BR>');		// 채팅 메세지 받아 출력 append-아래로 이어서 출력
			//$('#msgs').append(msg.id+'<BR>');			
 			
			//조건을 넣을 때 - 해당 아이디인 사람에게로만 보내짐
 			if(msg.to == '${sessionScope.memId}' || msg.id == '${id}'){
 				if(msg.id == '${id}'){
 					$('#msgs').append('<tr><td></td><td align="right">'+msg.msg+'</td></tr><BR/>');
 				}else{
 					$('#msgs').append('<tr><td>'+msg.msg+'</td><td></td><BR/>');
 				}
			} else if(msg.to == '') {
 				if(msg.id == '${id}'){
 					$('#msgs').append('<tr><td></td><td align="right">'+msg.msg+'</td></tr><BR/>');
 				}else{
 					$('#msgs').append('<tr><td>'+msg.msg+'</td><td></td><BR/>');
 				}
			}
			
		});
/* 		socket.on('aaa', function(msg){
			$("h1").html(msg.id);
		}); */
		
		// 텍스트박스내부의 채팅 내용 보내기
		$("#sendBtn").bind("click", function() {	
			//var msg = $("input[name=chat]").val();
			var msg = '${id}' + "-" + $("#chat").val(); //val():채팅창 textbox, id를 msg변수에 넣음
			var to = $("#to").val();
			//socket.emit('abc', {msg:msg});
			socket.emit('msg',{msg:msg, id:'${id}', to:to}); //msg라는 이름으로 서버에 보냄. 파라미터이름:값 
										//id를 bean에서 세션으로 받아옴
		});
	});
</script>
 		<script> //채팅 사용자 목록
	   	window.setInterval("chatUser()", 1000);
	   	function chatUser(){
	   		$.ajax({
	   			url:"/spring/member/chattingOnList.do",
	   			success:function(data){
	   				$("#chattingOnList").html(data);
	   			}
	   		});
	   	}
	   	//선택 아이디 자동입력
	   	$(function (){
	   		$('#select').change(function(){
	   			var value = $("#select option:selected").text();
	   			$('#to').val(value);
	   		});
	   	});
	   </script> 
</head>
<body>
	<h1>참여자</h1>
		<label id="chattingOnList">${chattingOnList }</label>
<%-- 		<c:forEach items="${ chattingOnList }" var="list">
			${ list } <br/>
		</c:forEach> --%>
		
	<h1>채팅창</h1>
		<!-- <input type="text" name="chat" /> --><!-- name속성은 파라미터나 클래스에서 사용하는 속성 --> 
		<b>받는 사람</b><br/>
			
				<select id="select">
					<label id="chattingOnList">
						<option>${ chattingOnList }</option>
					</label>
				</select>
			
			<input type="text" id="to" /> <br/>
		<b>메시지</b> <br/>
			<input type="text" id="chat" /><!-- id속성은 css나 스크립xm에서 사용하는 속성?/class는 한꺼번에 변경할 묶음 속성 -->
			<input type="button" value="send" id="sendBtn" /><br/>
			 <span id="msgs"></span> <br/>
</body>
</html>