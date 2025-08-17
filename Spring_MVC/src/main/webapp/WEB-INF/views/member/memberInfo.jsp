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
	
	<c:if test="${msg != null}">
		<script>
			alert('${msg}');
		</script>
	</c:if>
	
	<br><hr>
	<h2><a href="/mvc/member/list">회원 리스트 보기</a></h2>
	<hr><br>
	
	<table border="1">
	
		<tr>
			<th>아이디</th>
			<td>${member.id}</td>
		</tr>
		
		<tr>
			<th>비밀번호</th>
			<td>${member.pw}</td>
		</tr>
		
		<tr>
			<th>이름</th>
			<td>${member.name}</td>
		</tr>
		
		<tr>
			<th>전화번호</th>
			<td>${member.tel}</td>
		</tr>
		
		<tr>
			<th>이메일</th>
			<td>${member.email}</td>
		</tr>
		
		<tr>
			<th>주소</th>
			<td>${member.address}</td>
		</tr>
		
		<tr>
			<td colspan="2">
				
				<form name="modifyForm" action="/mvc/member/modifyForm" method="post">
					
					<input type="hidden" name="id" value="${member.id}">
					<input type="submit" value="회원정보 수정">
					
					&nbsp;&nbsp;&nbsp;
					
					<input type="button" value="회원 탈퇴" onclick="deleteCheck()">
					
				</form>
				
			</td>
		</tr>
		
	</table>
	
	
	<script>
		function deleteCheck(){
			
			var check = confirm('정말 회원탈퇴를 하시겠습니까?');
			
			if(check){
				
				var modifyForm = document.modifyForm;
				
				modifyForm.method = "post";
				modifyForm.action = "/mvc/member/delete";
				modifyForm.submit();
				
			}else{
				return;
			}
			
		}
	</script>
	
</body>
</html>





