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
<title>Insert title here</title>
<style>
.tot{
	margin-left: 350px;

}

</style>
<%

	Calendar today = Calendar.getInstance();
	SimpleDateFormat format = new SimpleDateFormat("dd");
	

	int year = today.get(today.YEAR);
	int month = today.get(today.MONTH);
	int day = today.get(today.DATE);//  
	int limit = today.getActualMaximum(Calendar.DAY_OF_YEAR);
	today.set(year, month,1);
	
 	for (int i = 1; i <=limit; i++) {
		//mwd[today.get(Calendar.MONTH)]/* 달 */
				//[today.get(Calendar.WEEK_OF_MONTH)-1]/* 주 */
						//[today.get(Calendar.DAY_OF_WEEK)-1] = today.get(Calendar.DATE);/* 일 */
		//today.add(Calendar.DATE, 1);
	}

%>    
</head>
<body>


<div class="container">
	<div class="wapper">
<form action="/Movie">		
	<div style="left:0px; margin-left: 350px;" ><input type="date" value="<%=request.getParameter("day")%>"/></div>

	<table height="450px" width="800px" class="tot">

	<tr align="center">
		<td><%= request.getAttribute("day") %></td>
		
		<td></td>
	</tr>
	<tr>
		<td></td>
		<td></td>
	</tr>
	
</table>
</form>	
${day }


	</div>
</div>

</body>
</html>