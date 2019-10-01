<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Event</title>
</head>
<body>
	<div class="container">
		<div class="wapper">
			<div>
				<ul>
					<li><jsp:include page="evtags.jsp"></jsp:include></li>
				</ul>
			</div>
			<table class="wapper_table">
				<tr>
					<c:forEach var="dto" items="${dto }" varStatus="no">
						<td>
							<table border="">

								<tr>
									<td class="event_title">${dto.title }</td>
								</tr>
								<tr>
									<td><a href="Detail?eid=${dto.eid }"><img src="../m_img/event/${dto.title_img }" alt="" /></a></td>
								</tr>
								<tr>
									<td>${dto.start_ev }~${dto.finish_ev }</td>
								</tr>

							</table>
						</td>
						<c:if test="${((no.index+1)%4)==0}">
				</tr>
				<tr>
					</c:if>
					</c:forEach>
				</tr>
			</table>


		</div>
	</div>
</body>
</html>