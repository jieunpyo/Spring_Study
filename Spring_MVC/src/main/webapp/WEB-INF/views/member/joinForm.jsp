<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
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
	
	<c:if test="${msg != null }">
	
		<script>
			alert('${msg}');
		</script>
	
	</c:if>
	
	<%--
		private String id;
		private String pw;
		private String name;
		private String tel;
		private String email;
		private String address;
		private Timestamp regDate;
	 --%>
	
	<br><hr>
	<h2>회원 가입 폼</h2>
	<hr><br>
	
	<form action="/mvc/member/join" method="post">
		
		<table border="1">
			<tr>
				<th>아이디</th>
				<td><input type="text" name="id"></td>
			</tr>
			
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pw"></td>
			</tr>
			
			<tr>
				<th>이름</th>
				<td><input type="text" name="name"></td>
			</tr>
			
			<tr>
				<th>전화번호</th>
				<td><input type="text" name="tel"></td>
			</tr>
			
			<tr>
				<th>이메일</th>
				<td><input type="text" name="email"></td>
			</tr>
			
			<tr>
				<th>주소</th>
				<td><input type="text" name="address"></td>
			</tr>
			
			<tr>
				<td colspan="2">
					<input type="submit" value="회원가입">
				</td>
			</tr>
			
		</table>
	
	
	</form>
	
	
	
</body>
</html>







