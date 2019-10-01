<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자주찾는 질문</title>
</head>
<body>
<div class="container">
	<div class="wapper">
	
	<ul>
		<li><jsp:include page="cttags.jsp"></jsp:include></li>
	</ul>
		
		
		<div>자주찾는질문</div>
	<table border="" width="100%">
	<tr>
		<td>번호</td>  <td>			</td>
	</tr><tr>
		<td>제목</td>  <td>			</td>
	</tr><tr>
		<td>작성자</td> <td>		</td>
	</tr><tr>
		<td>작성일</td> <td><fmt:formatDate value="${dto.regdate }" pattern="yyyy년 MM월 dd일 HH:mm:ss"/> </td>
	</tr><tr>
		<td>조회수</td> <td>		</td>
	</tr><tr>
	
	
	
	</div>
</div>
</body>
</html>