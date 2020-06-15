<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="//code.jquery.com/jquery-3.5.1.min.js"></script> <!-- jquery선언 -->
<script>

	//var repeat = window.setInterval('time()',1000) //1초에 한번씩 time()를 호출
	var count = 0;
	
	//time()메소드. 시간이 흘러감
	function time(){
		//$("#time").append("뭐라냐<br>");
		//$("#time").html(++count);
		$.ajax({ //include와 비슷
			url:"confirmId.jsp", //"time.do" 등 지정한 주소 형식으로 작성하면 프레임웍으로 호출 가능.
			data:{id:$("#id").val()}, //파라미터를 보냄(이름:'값')
			success:function(data){
				$("#time").html(data);
			}
		})
	}
	//stop()메소드. 시간을 멈춤
	function stop(){
		clearInterval(repeat);//inteval을 멈춤, 변수 repeat을 선언해서 활용
	}
</script>
	<input type="text" name="id" id="id"/>
	<button id="confirm" onclick="time()">중복확인</button>
	<label id="result"></label>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main page</title>
</head>
<body>
	<h1>현재시간 : <label id="time"></label></h1>
	<button id="stop" onclick="stop();">멈춰</button>
</body>
</html>