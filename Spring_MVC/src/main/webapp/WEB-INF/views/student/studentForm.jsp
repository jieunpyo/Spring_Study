<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h2>학생정보 입력 폼</h2>
	
	<%--
		private Integer studentID; 
		private String name; 
		private Integer age;
		private String major; 
		private List<String> circle; 
	 --%>
	
	<form action="/mvc/student/data" method="post">
	
		학번 : <input type="number" name="studentID"> <br>
		이름 : <input type="text" name="name"><br>
		나이 : <input type="number" name="age"><br>
		전공 : <input type="text" name="major"><br>
		
		동아리 : <input type="checkbox" name="circle" value="밴드">밴드
		<input type="checkbox" name="circle" value="축구">축구
		<input type="checkbox" name="circle" value="등산">등산
		<input type="checkbox" name="circle" value="영화">영화
		<br>
		
		<input type="submit" value="학생정보 전송">
	
	</form>
	
</body>
</html>