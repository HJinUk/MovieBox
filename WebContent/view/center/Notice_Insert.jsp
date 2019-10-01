<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기 작성</title>
</head>
<body>
<div class="container">
	<div class="wapper">
	<ul>
		<li><jsp:include page="cttags.jsp"></jsp:include></li>
	</ul>

	<div>글쓰기 작성</div>
	
	
	<form action="Notice_Insert" method="post" enctype="multipart/form-data">
	<table border="" width="100%">
		<tr>
			<td>제목</td><td><input type="text" name="title"></td>
		</tr><tr>
			<td>작성자</td><td><input type="text" name="pname"></td>
		</tr><tr>
			<td>암호</td><td><input type="password" name="pw"></td>
		</tr><tr>
			<td>파일</td><td><input type="file" name="file"></td>
		</tr><tr>
			<td>내용</td><td><textarea  name="content" cols="30" rows="10"></textarea></td>
		</tr><tr>
			<td colspan="2" align="center">
				<input type="submit" value="작성">
				<a href="Notice_List&page=${page}">목록으로</a>
			</td>
		</tr>
	</table>
</form>
	



	
	

	</div>
</div>
</body>
</html>