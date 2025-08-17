<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h2>아이디와 비밀번호 입력 폼</h2>
	
	<form action="/mvc/param/data1" method="post" >
		
		아이디 : <input type="text" name="id"><br>
		비밀번호 : <input type="password" name="pw"><br>
		
		<input type="submit" value="데이터전송">
	
	</form>
	
</body>
</html>