<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>admin</title>

</head>
<body>


<div class="container">
	<div class="wapper">

		<div ><jsp:include page="adtag.jsp"></jsp:include></div>
		<c:if test="${url!=null }">
		<div ><jsp:include page="${url }"></jsp:include></div>
		</c:if>
	
		
	</div>
	
</div>








</body>
</html>