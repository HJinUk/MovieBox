<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reg</title>
</head>
<body>
<div class="container">
	<div class="wapper">
	
	회원가입
	<form action="../user/regMain"method= "post"  >

	<table>
		<tr>
			<td>이름</td>
			<td><input type="text" name="name" /></td>
		</tr>
		
		  <tr>
         	 <td>주민등록번호:</td>
         	 <td colspan="4">
        	 <input type="text" name="jumin" id="">-<input type="text" name="jumin1" id="">
          									예)123456789</td>
         </tr>
		
		<tr>
			<td>아이디  </td>
			<td><input type="text" name="id" /><button>중복확인</button></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="text" name="pw" /></td>
		</tr>
		<tr>
			<td>비밀번호 확인</td>
			<td><input type="text" name="pw2" /></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><input type="text" name="email" /></td>
		</tr>
		<tr>
			<td>번호</td>
			<td><input type="text" name="tel" /></td>
		</tr>
		
		<tr>
			<td>장르</td>
			<td>
				<input type="checkbox" value="코미디 " name="genre">코미디
				<input type="checkbox" value="공포" name="genre">공포
				<input type="checkbox" value="액션" name="genre">액션
				<input type="checkbox" value="멜로" name="genre">멜로
			</td>
		</tr>




		<tr>
		   <form action="../user/RegMain" method="post">
			<td colspan="2" align="center">
				<input type="submit" value="작성" />
				<!-- <a href="List">목록으로</a> -->
			</td>
			</form>
			
		</tr>
	</table>
</form>

		
	</div>
</div>
</body>
</html>