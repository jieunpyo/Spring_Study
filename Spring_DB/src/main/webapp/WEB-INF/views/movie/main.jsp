<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	*{
		text-align: center;
		margin: 0 auto;
	}
</style>

</head>
<body>
	
	<br><hr>
	
	<h2>${movie.userName }님 안녕하세요!!</h2>
	
	<hr><br>
	
	<h2>현재 포인트 잔액 : ${movie.point }</h2>
	
	<br>
	
	<h2>현재 티켓 구입 수 : ${ticketNumber}</h2>
	
	<br>
	
	<a href="/db/movie/buyTicket">영화 티켓 구입하기</a>
	
	&nbsp;&nbsp;&nbsp;
	
	<a href="/db/movie/logout">로그아웃</a>
	
</body>
</html>
















