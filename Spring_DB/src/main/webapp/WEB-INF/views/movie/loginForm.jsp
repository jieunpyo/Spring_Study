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
	<h2>로그인 폼</h2>	
	<hr><br>
	
	<form action="/db/movie/login" method="post">
	
		<table border="1">
			<tr>
				<th>아이디</th>
				<td><input type="text" name="userId"></td>
			</tr>
			
			<tr>
				<th>비밀번호</th>
				<td><input type="text" name="userPw"></td>
			</tr>
			
			<tr>
				<td colspan="2">
					<input type="submit" value="로그인">
				</td>
			</tr>
			
		</table>
	
	</form>
	
</body>
</html>