<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	
	form{
		display: inline;
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
	<h2><a href="/web/board/list?page=${param.page}&searchWord=${param.searchWord}&key=${param.key}">게시판 목록으로 이동</a></h2>
	<hr><br>
	
	
	<table border="1">
	
		<tr>
			<th>번호</th>
			<td>${contentView.id }</td>
		</tr>
		
		<tr>
			<th>조회수</th>
			<td>${contentView.viewCount }</td>
		</tr>
		
		<tr>
			<th>작성자</th>
			<td>${contentView.writer }</td>
		</tr>
		
		<tr>
			<th>제목</th>
			<td>${contentView.title }</td>
		</tr>
		
		<tr>
			<th>내용</th>
			<td>${contentView.content }</td>
		</tr>
		
		<tr>
			<td colspan="2">
				
				<form action="/web/board/modifyForm" method="post">
					
					<input type="hidden" name="id" value="${contentView.id }">
					<input type="hidden" name="viewCount" value="${contentView.viewCount }">
					<input type="hidden" name="writer" value="${contentView.writer }">
					<input type="hidden" name="title" value="${contentView.title }">
					<input type="hidden" name="content" value="${contentView.content }">
					
					<input type="submit" value="글 수 정">
				
				</form>
				
				&nbsp;&nbsp;&nbsp;
				
				<form action="/web/board/delete" method="post">
					<input type="hidden" name="id" value="${contentView.id }">	
					<input type="submit" value="글 삭 제">
					
				</form>
				
			</td>
		</tr>
		
	</table>
	
</body>
</html>










