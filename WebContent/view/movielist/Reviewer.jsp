<%@page import="review.ReviewDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="rev" value="${ReviewDetail }"/>

<!-- 리뷰 정보 -->
<form action="ReviewInsert" method="post" enctype="multipart/form-data">
	<table border="" align="center" width="80%">
		<tr id="">
			<td id="" colspan="2" align="left">갬성도</td>
		</tr>
		<tr id="">
			<td id="" width="30%">대충 별 그림</td>
			<td id="" width="70%" >
				
				<c:forEach var="rev" items="${ReviewDetail }" varStatus="no">
					<c:if test="${no.last }">
						이 영화는 <h2> ${no.count }명이</h2>
					</c:if>
				</c:forEach>
				 평가하였습니다
			</td>
		</tr>
		
		<!-- 리뷰 작성 -->
		
		<tr>
			<td>평점</td>
			<td>누르는 그림 같은거</td>
		</tr>
		
		<tr>
			<td colspan="2">
				<table border="" width="100%">
					<tr>
						<td height="200px">
							<textarea cols="150" rows="11" id="reviewtext" ></textarea>
						</td>
						<td align="center">
							<input type="submit" value="리뷰 작성" />
						</td>
					</tr>
				</table>
			</td>
		</tr>
		
		<!-- 리뷰 댓글 출력 -->
	
<c:choose>
	<c:when test="${ReviewPage!=null }">
		<tr id="" width="100%">	
			<c:forEach var="rev" items="${ReviewPage }" varStatus="no">
					<td id="" width="50%">
						<table align="center" width="100%" border> 
							<tr>
								<td width="25%" height="50px" align="left">${rev.id  }</td>
								<td height="50px" align="left">${rev.tat }점</td>
							</tr>
							<tr>
								<td colspan="2" height="100px" align="left"><h3>${rev.text }</h3></td>
							</tr>
							<tr>
								<td width="25%" height="30px" align="left">${rev.date }</td>
								<td height="30px" align="left">추천 : ${rev.reco }</td>
							</tr>
						</table>
					</td>
				<c:if test="${((no.index+1)%2)==0 }">
					</tr>
					<tr>
				</c:if>
			</c:forEach>		
		</tr>
			<tr align="center">
				<td colspan="2">
					<c:if test="${pageStart>1 }">
						<a href="MDetail?mid=&page=${pageStart-1 }">[이전]</a>
					</c:if>
					<c:forEach begin ="${pageStart }" end="${pageEnd }" var="i" step="1">
						<c:choose>
							<c:when test="${i==pageNow }">
								[${i }]
							</c:when>
							<c:otherwise>
								<a href="MDetail?mid=<%=request.getParameter("mid") %>&page=${i }">${i }</a>
							</c:otherwise>
						</c:choose>
					 </c:forEach>
					<c:if test="${pageEnd<pageTotal }">
						<a href="MDetail?mid=${dto.mid }&page=${pageEnd+1 }">[다음]</a>	
					</c:if> 
				</td>	
			</tr>
		</c:when>
		<c:otherwise>
			<tr>
				<td colspan="2">
					등록된 리뷰가 없습니다
				</td>
			</tr>
		</c:otherwise>
	</c:choose>

	</table>
</form>