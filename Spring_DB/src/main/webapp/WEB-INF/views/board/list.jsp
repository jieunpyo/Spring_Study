<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">

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
	
	<br><hr>
	<h2><a href="/db/board/list">게시판 목록</a></h2>
	<hr><br>
		
	<table border="1">
		
		<tr>
			<th>글번호</th>
			<th>작성자</th>
			<th>제목</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		
		<c:forEach var="dto" items="${list}" >
			
			<tr>
				<td>${dto.id}</td>
				<td>${dto.writer}</td>
				<td>
					<a href="/db/board/contentView?id=${dto.id}">${dto.title}</a>
				</td>
				<td>
					<fmt:formatDate value="${dto.regDate}" pattern="yyyy년 MM월 dd일" />
				</td>
				<td>${dto.viewCount}</td>
			</tr>
			
		</c:forEach>
		
		<tr>
			<td colspan="5">
				<a href="/db/board/write">글 작 성</a>
			</td>
		</tr>
		
	</table>
	
	
</body>
</html>












