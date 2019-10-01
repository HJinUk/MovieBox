<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!-- 영화 상세 정보 -->
<c:set var="mov" value="${MovieDetail }" />
<c:set var="gen" value="${GenDetail }" />

<table align="center" class=""  width="80%">
	<tr id="">
		<td id="" width="20%">
			<img src="../m_img/${mov.imgurl }" alt="" width="230px" height="300px" align="center"/>
		</td>
		
		<td id="" width="60%" style="vertical-align: top">
			<table width="100%">
				<tr height="40%">
					<td colspan="2" align="left"><h1>${mov.name }</h1></td>
				</tr>
				
				<tr>
				
					<td align="left" width="15%">
						<h5>예매율 100%</h5>
					</td>
					
					<!-- 평점 합계 변수  -->
					<fmt:parseNumber var="tt" value="0" integerOnly="true" />
					<c:choose>
						<c:when test="${ReviewDetail != null }">
							<c:set var="totaltat" value="0" />
							<c:forEach var="rev" items="${ReviewDetail }" varStatus="no">
								<c:set var="totaltat" value="${totaltat + rev.tat }" />
								<c:set var="cnt" value="${no.index+1 }" />
							</c:forEach>
								<c:set var="totaltat" value="${totaltat/cnt }"/>
								<fmt:parseNumber var="tt" value="${totaltat }" integerOnly="true" />
					</c:when>
						<c:otherwise>
								<c:set var="tt" value="0"/>
							</c:otherwise>
					</c:choose>	
						
					<td align="left">
						<h5>
						평점	${tt }점
						</h5>
					</td>
					
				</tr>
				
				<tr>
					<td colspan="2" align="left"><h4>감독 : ${mov.foreman } / 배우 : ${mov.actor }</h4></td>
				</tr>
				
				<tr>
					<td colspan="2" align="left"><h4>장르 : 
					<c:forEach var="gen" items="${GenDetail }" varStatus="no">
						
						<c:choose>
							<c:when test="${no.last }">
								${gen.genre }
							</c:when>
							<c:otherwise>
								${gen.genre }, 
							</c:otherwise>
						</c:choose>
					</c:forEach>
					 / 기본 : 
					
					<c:choose>
						<c:when test="${mov.year == 0 }">
							미정, 
						</c:when>
						<c:when test="${mov.year == 1 }">
							전체 이용가, 
						</c:when>
						<c:otherwise>
							${mov.year }세 이상, 
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${mov.year == 0 }">
							미정
						</c:when>
						<c:otherwise>
							${mov.play }분
						</c:otherwise>
					</c:choose>
					(${mov.country })</h4></td>
				</tr>
			</table>
		
		
		</td>
		
		<td id="" width="20%">
			예매 버튼
		</td>
		
	</tr>
	<tr id="">
		<td id="" colspan="3" align="left"><br>${mov.storyBr }<br><br></td>
	</tr>
	<tr id="">
		<td id="" colspan="3">
		
			<iframe width="100%" height="650px" src="${mov.murl }" 
			frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
			
		</td>
	</tr>
</table>