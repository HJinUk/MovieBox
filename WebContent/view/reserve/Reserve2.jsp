<%@page import="reserve.ReserveDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>reserve</title>
<style>
.tot{
	margin-left: 520px;
}

.movie{
	
  	 overflow:scroll;
  	 width:300px;	
     border-bottom: 1px solid #000;	
  	  
}
.theater{

	overflow: scroll
}
.time{
	width:250px;
}
</style>

</head>
<body>


<div class="container">
	<div class="wapper">
<form action="Movie">
		
<div ></div>

<table border="" height="450px" width="850px" class="tot" >

	
		<td>
		<ul><li>d</li></ul>
			<table  class="movie" width="350px">
				<tr>
					<td style="background: #000; color:#fff; padding:5px">영화</td>
				</tr>
				<c:forEach var="dto" items="${data }" varStatus="no">
				<tr>
					<td style="padding:5px;">${dto.name}</td>
				</tr>
				</c:forEach>	
			</table>
		</td>
		<td>
			<table border="" class="theater"  >
				<c:forEach var="dto2" items="${theater }" varStatus="no2">
				<tr>
					<td>${dto2.name }</td>
				</tr>
				</c:forEach>
			</table>
		</td>
		<td>
		 	<table border="" class="time">
		 		
		 			<input type="date" name="day"/>
		 		
		 		
		 	</table>
		</td>
	</tr>
	<tr>
		<td width="300px"></td>
		<td></td>	
		<td><input type="submit" value="예매하기" /></td>
	</tr>
	
</table>
</form>	
	

	</div>
</div>

</body>
</html>