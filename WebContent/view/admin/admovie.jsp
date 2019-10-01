<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#adm{

border: 2px solid #0af;
align:center;
width :900px;
position: relative;
left:450px;
top:20px;

}

</style>

</head>
<body>
<div>
<div id="adm">

		<form  action="?c=mm" method="post">
			<table align="center">
				
				<tr >
					<td>영화이름</td>
					<td><input type="text" name="name" /></td>
				</tr>
				<tr>	
					<td>영화줄거리</td>
					<td><textarea name="story" cols="30" rows="10"></textarea></td>
				</tr>
				<tr>
					
					<td colspan="2" align="right"><input type="submit" value="등록" /></td>
				</tr>
				
			</table>
		</form>

</div>		
</div>
</body>
</html>