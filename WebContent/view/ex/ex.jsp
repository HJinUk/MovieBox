<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex</title>
<style>

#tt{

align:center;
width :900px;
height:70px; 
position: relative;
left:450px;
top:20px;
border-bottom: 1px solid #000;

}
#ff{

align:center;
width :900px; 
height:auto;
position: relative;
left:450px;
top:25px;
border: 1px solid #000;

}
li{
float: left;
	width: 180px;
}
</style>
<script src="../csjs/jquery-3.4.1.min.js"></script>
    <script>
    

    function go(name){
    		alert(name);
    }

    function ajaxGo(goUrl, getData){
    
    	$.ajax({
			url:"ex3",
			type:'get',
			data:getData,
			dataType:'json',  ////json을 안하면 문자열로 , json 처리하면 object로 묶어서 받음
			success:function(qqq){
				
				var ui=$("<ui></ui>");
				var li;
				$.each(qqq,function(i,e){
			
					li =$("<li onclick='go(\""+e.tid+"\")'>"+e.name+"</li>");

					ui.append(li);
					});

				$("#ff").html(ui);

			},
			error:function(qqq){
				alert("에러인가");
				tot.html(qqq.responseText);
			}
			
		});

    }

	$(document).ready(function(){
		
			tt=$("#tt");
			tot=$("#tot");
			
			$.ajax({
					url:"ex2",
					type:'post',
					
					dataType:'json',
					success:function(qqq){
										
						$.each(qqq,function(i,e){
					
				var li =$("<li onclick='ajaxGo(\"ex3\",{areacode:"+e.areacode+"})'>"+e.name+"</li>")

							a = $("#tot").append(li);
						});
										
 						$("#tt").html(a);
	
						
					},
					error:function(qqq){
						$("#tot").html(qqq.responseText);
					}
					
				});
		
		
			ajaxGo("ex3",{areacode:1});
		
	});
</script>
</head>
<body>
<h1>ex</h1>
<div id="tt">
<ui id="tot"></ui>

</div>
<div id="ff"></div>
<c:set var="i" value="1"/>



<div></div>


</body>
</html>