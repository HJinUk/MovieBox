<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

#uui{

align:center;
width :900px;
height:70px;
position: relative;
left:450px;
top:20px;
border-bottom: 1px solid #000;

}
</style>
</head>
<body>

<div class="container">
	<div class="wapper">
	<jsp:include page="theatag.jsp"/>
<div id="aaaa">
	<div id="uui">
	<table align="center">
		<ui >
		<c:forEach items="${data }" var="data" varStatus="no">
		<li >${data.name}</li>
		</c:forEach>		
		</ui>
		</table>
		</div>
		</div>
	</div>
</div>

		
</body>
</html>