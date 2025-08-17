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
	<h2><a href="/web/board/list">게시판 목록</a></h2>
	<hr><br>
	
	<%--
		작성자, 제목, 내용을 선택을 하여[select 태그] 검색어를 입력하는 폼 만들기
	 --%>
	
	<form action="/web/board/list">
		
		<input type="hidden" name="num" value="1">
		
		<select name="searchWord">
			<option value="writer">작성자</option>
			<option value="title">제목</option>
			<option value="content">내용</option>
		</select>
		
		<input type="text" name="key" placeholder="검색어를 입력해주세요" value="${param.key}">
		
		<input type="submit" value="검색">
			
	</form>
	
	
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
					<a href="/web/board/contentView?id=${dto.id}&page=${param.page}&searchWord=${param.searchWord}&key=${param.key}">
						${dto.title}
					</a>
					
					<%-- new 마크 --%>
					&nbsp;
					<c:if test="${dto.newMark}">
						<span style="color:orange;">[new]</span>
					</c:if>
					
				</td>
				<td>
					<fmt:formatDate value="${dto.regDate}" pattern="yyyy년 MM월 dd일" />
				</td>
				<td>${dto.viewCount}</td>
			</tr>
			
		</c:forEach>
		
		<tr>
			<td colspan="5">
				<a href="/web/board/write">글 작 성</a>
			</td>
		</tr>
		
	</table>
	
	<%--
		이전버튼 활성화 여부
	 --%>
	<c:if test="${paging.prev}">
		<a href="/web/board/list?page=${paging.startPage -1}&searchWord=${param.searchWord}&key=${param.key}">[이전]</a>
	</c:if>
	
	<%--
		페이지 버튼
	--%>
	<c:forEach var="pageNum" begin="${paging.startPage }" end="${paging.endPage}" >
		
		<a href="/web/board/list?page=${pageNum}&searchWord=${param.searchWord}&key=${param.key}"
		style="${pageNum == paging.currentPage ? 'color:red' : 'color:blue'}">
			<b>${pageNum}</b>
		</a>
		
	</c:forEach>
	
	<%--
		다음버튼 활성화 여부
	 --%>
	<c:if test="${paging.next }">
		<a href="/web/board/list?page=${paging.endPage +1}&searchWord=${param.searchWord}&key=${param.key}">[다음]</a>
	</c:if>
	
	
	
</body>
</html>












