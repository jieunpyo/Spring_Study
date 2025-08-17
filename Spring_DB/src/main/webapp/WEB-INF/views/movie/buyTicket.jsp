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
	
	<h2>영화 티켓 구입하기</h2>
	
	<hr><br>
	
	<form action="/db/movie/buyTicket" method="post">
		
		<input type="hidden" name="userId" value="${movie.userId }">
		
		<input type="number" name="ticketNumber" min="1">
		
		<input type="submit" value="티켓 구매">
	
	</form>
	
</body>
</html>












