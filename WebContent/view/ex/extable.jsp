<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
     %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>extable</title>
</head>
<%
String blank ="mno3";
char a = 'a';
char o = "o".charAt(0);
char i = 97;
int line = 12;
%>

<script src="../csjs/jquery-3.4.1.min.js"></script>
    <script>
    
	$(document).ready(function(){ 
		
		$("#border").css("width",'<%=466%>px');
		
		$(".seat").click(function(){
			
			var backcol = $(this).css("background-color");
			if($(this).html()!=""){
			$(this).css("background-color","#555");
			
			if(backcol==$(this).css("background-color")){
				
				//alert(backcol);
				$(this).css("background-color","#fff");
				
// 				 	$(this).css({
// 				background: "#555"
				
// 			}); 
			}
			}	

		});
	
	});
	
</script>
<style>
#border{
 

height: 700px;
border: 1px solid #000; 

}

.seat{

box-sizing:border-box;
border: 1px solid #000;
width: 30px;
height: 30px;
float: left;
font-size: 1px;
margin-left: 1px;
margin-bottom: 1px;

}
.noseat{

box-sizing:border-box;

width: 30px;
height: 30px;
float: left;
font-size: 1px;
margin-left: 1px;
margin-bottom: 1px;

}
#blank{

width: 450px;
height: 50px;
margin-left: 1px;
margin-bottom: 1px;

}
#screen{
border: 1px solid #aaa;
width: 450px;
height: 50px;

}

#screen > div{

position: relative;
left:160px;
font-size: 40px;

}

.colorr{

background-color: "#555";

}

</style>
<body>
<h1>extable</h1>

<div id ="screen"><div>screen</div></div>
<div id="blank"></div>

<div id="border">

<%for(int c=0;c<=o-a;c++){ 
int	v =i+c;
char g = (char)v;
for(int cc=1;cc<=line;cc++){ 
%>

<div class="seat"><%=g %>-<%=cc %></div>
<%if(cc==2){ %>
<div class="noseat"></div><div class="noseat"></div>
<%} %>
<%if(cc==11){ %>
<div class="noseat"></div>
<%} %>

<%}} %>

</div>
</body>
</html>