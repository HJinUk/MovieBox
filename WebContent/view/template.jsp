<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../view/csjs/style.css" type="text/css">
<script src="../view/csjs/js.js"></script>
</head>
<body>
  
    <c:if test="${msg!=null }">
		<script>
		alert('${msg}');
		</script>
		
</c:if>


<div class="container">
<div><jsp:include page="inc/luncher.jsp"/></div>
<div ><jsp:include page="inc/top.jsp"/></div>
<div><jsp:include page="${mainUrl}.jsp"/></div>
<div class="footer"><jsp:include page="inc/bottom.jsp"/></div>

</div>








</body>
</html>