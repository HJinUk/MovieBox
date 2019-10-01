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
.movie{
  	 width:140px;	
     border-bottom: 1px solid #000;	
  	 overflow: scroll;
  	 float:left;
}
#mname{
 padding: 5px;
 float:left;
}
.tot{
	margin-left: 520px;
}
.list{
		
  	overflow: scroll;
    width:280px;
}

.movie td{
  	width:150px;
  	float:left;
  
  	text-align: left;
}
.theater{
	width:120px;
	
}
.area{
	
	width:110px;
	 float:left;
}
.time{
	width:250px;

}

#mov{
	 width:160px;
	 height: 600px; 
 	overflow:scroll;
}
#movielist{
	 width:300px;
	 height: 600px; 
 	overflow:scroll;
}
.top{
	background: #0070c0;
	color: #fff;
	padding-bottom: 5px;
	padding-top:5px;
	top: 0px;
}	

</style>
</head>
<script>

 function go(areacode){
	
	
	//alert(areacode);
	
	$.ajax({
		url:"Aaaaa",
		type:'get',
		data:{"areacode" : areacode},
		dataType:'json',  ////json을 안하면 문자열로 , json 처리하면 object로 묶어서 받음
		success:function(qqq){
			
			var row= $("<tr></tr>");	
			var ro ;
			$.each(qqq,function(i,e){
				
				ro = $("<td>"+e.name+"</td>")
			    row.append(ro);
			});

			$(".movie").html(row);
		},
		error:function(qqq){
			
				alert("dd");
			tot.html(qqq.responseText);
		}
		
	});
	
}


$(document).ready(function(){
	
	
	var movie = $(".movie");
	
	go(1);
	
});
 
</script>
<body>


<div class="container">
	<div class="wapper">
<form action="Movie">

<div ></div>

<table border="" height="450px" width="850px" class="tot" >

	<tr>
		<td>
			<div class="top">영화</div>
			<div id = "movielist">
			<table class="list">
				<c:forEach var="dto" items="${data }" varStatus="no">
				<tr>
					<td id="mname">${dto.name}</td>
				</tr>
				</c:forEach>	
			</table>
			</div>
		</td>
		
		<td>
			<div class="top">극장</div>
			
			<table class="area" >
				<c:forEach var="area" items="${areaa }" varStatus="no3">
					<tr>
						<td class="theater" onclick='go(${area.areacode})'>${area.name }</td><!--  onclick='go(${area.areacode})' -->
					</tr>
				</c:forEach>	
			</table>
			<div id="mov">
			<table class="movie">
<%-- 				<c:forEach var="dto2" items="${theater }" varStatus="no2"> --%>
<!-- 					<tr> -->
<%-- 						<td style="float:left">${dto2.name }</td> --%>
<!-- 					</tr> -->
<%-- 				</c:forEach> --%>
			</table>
			</div>
		</td>
		<td>
		 	<div class="time"><input type="date" name="day"/></div>
		</td>
	</tr>
	<tr>
		<td width="280px"></td>
		<td></td>	
		<td><input type="submit" value="예매하기" /></td>
	</tr>
	
</table>
</form>
	

	</div>
</div>

</body>
</html>