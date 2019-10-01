
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 리스트</title>
</head>
<body>




<table border align="center">
	<tr>
		<td  colspan="4">
		<a href="../../mainProj/movielist/">영화리스트</a>
		<a href="fmovies">상영예정작</a>
		</td>
	</tr>
	<tr>
		<c:forEach var="dto" items="${moviedata }" varStatus="no" >	
			<td>
				<table border="">
					<tr>
						<td colspan="4">
							<a href="MDetail?mid=${dto.mid }">
							<img src="../m_img/${dto.imgurl }" alt="" width="300px" height="400px"/>
							</a>
						</td>
					</tr>
					<tr>
						<td colspan="4">
							${dto.name }
						</td>
					</tr>
					
					<!-- 평점 합계 변수  -->
			 	
				
<%-- 				<c:set var="totaltat" value="0" /> --%>
<%-- 				<c:forEach var="rev" items="${ReviewDetail }" varStatus="no"> --%>
<%-- 					<c:set var="totaltat" value="${totaltat + rev.tat }" /> --%>
<%-- 					<c:set var="cnt" value="${no.index+1 }" /> --%>
<%-- 				</c:forEach> --%>
<%-- 					<c:set var="totaltat" value="${totaltat/cnt }"/> --%>
<%-- 					<fmt:parseNumber var="tt" value="${totaltat }" integerOnly="true" /> --%>

					<tr>
						<td width="25%">예매율</td>
						<td width="25%"></td>
						<td width="25%">만족도</td>
						<td width="25%">${tt }</td>
					</tr>
					<tr>
						<td colspan="2">개봉일</td>
						<td colspan="2">${dto.open }</td>
					</tr>
				</table>	
			</td>
			<c:if test="${((no.index+1)%4)==0}">
				</tr>
				<tr>
			</c:if>
		</c:forEach>
	</tr>
	<tr align="center">
		<td colspan="4">
			<c:if test="${pageStart>1 }">
				<a href="?page=${pageStart-1 }">[Back]</a>
			</c:if>
			<c:forEach begin ="${pageStart }" end="${pageEnd }" var="i" step="1">
				<c:choose>
					<c:when test="${i==pageNow }">
						[${i }]
					</c:when>
					<c:otherwise>
						<a href="?page=${i }">${i }</a>
					</c:otherwise>
				</c:choose>
			 </c:forEach>
			<c:if test="${pageEnd<pageTotal }">
				<a href="?page=${pageEnd+1 }">[Next]</a>	
			</c:if> 
		</td>
	</tr>
</table>
</body>
</html>