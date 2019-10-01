<%@page import="reserve.ReserveDTO"%>
<%@page import="reserve.ReserveDAO"%>
<%@page import="calculate.CalculateDAO"%>
<%@page import="movielist.MovieListDAO"%>
<%@page import="movielist.MovieListDTO"%>
<%@page import="theater.TheaterDTO"%>
<%@page import="theater.TheaterDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="movielist.GenresDAO"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="movielist.GenresDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	ArrayList<GenresDTO> marr = new GenresDAO().list();
	ArrayList<TheaterDTO> aarr = new TheaterDAO().arealist();
	ArrayList<TheaterDTO> tarr = new TheaterDAO().list();
	ArrayList<MovieListDTO> moarr = new MovieListDAO().list();
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#cc {
	border: 2px solid #0af;
	align: center;
	width: 1500px;
	position: relative;
	left: 200px;
	top: 20px;
}

</style>

</head>
<body>
	<script src="//code.jquery.com/jquery.min.js"></script>
	<script src='//rawgit.com/tuupola/jquery_chained/master/jquery.chained.min.js'></script>
	

	<div>
		<div id="cc">

			<form action="?c=cal" method="post" >
				<table align="center">
				<tr><td>
						<select name="th">
							<option value="">--상영관별--</option>
							<option value="">2d</option>
						</select>
					</td><td>
						<select name="mg">

							<option value="">--영화장르--</option>
							<%for (GenresDTO dto : marr) {%>
							<option value=""><%=dto.getGenre()%></option>
							<%}%>
						</select>
					</td><td>
						<select id="mo1" name="ar">
							<option value="">--지역--</option>
							<%for (TheaterDTO dto : aarr) {%>
							<option value="<%=dto.getAreacode()%>"><%=dto.getName()%></option>
							<%}%>
						</select>
					</td><td>
						<select id="mo2"name="th">
							<option value="">--영화관--</option>
							<%for (TheaterDTO dto : tarr) {%>
							<option class="<%=dto.getAreacode()%>" value="<%=dto.getName()%>">
								<%=dto.getName()%></option>
							<%}%>
						</select>
					</td><td>
					
					<script>
						$("#mo2").chained("#mo1");
					</script>
					
						<select name="mo">
							<option value="">--영화--</option>
							<%for (MovieListDTO dto : moarr) {%>
							<option value=""><%=dto.getName()%></option>
							<%}%>
						</select>
						
						<td>시작일</td>
						<td><input type="date" id="date1" max="9999-12-31"/>~</td>
						<td>종료일</td>
						<td><input type="date" id="date2" max="9999-12-31"></td>
					
						<td colspan="2" align="right"><input type="submit" value="검색" /></td>
					</tr>
					
					<table border="" align="center" width="1300px">
					
						<tr>
							<td width="50px">번호</td>
							<td width="150px">아이디</td>
							<td width="80px">이름</td>
							<td width="150px">상영관</td>
							<td width="150px">장르</td>
							<td width="150px">지역</td>
							<td width="150px">영화관</td>
							<td width="300px">영화</td>
							<td width="100px">결제금액</td>
							<td width="100px">할인금액</td>
							<td width="50px">쿠폰</td>
							<td width="200px">결제일</td>
						</tr>
<%-- <c:forEach var="dto" items="${data }" varStatus="no"> --%>
						<tr>
							<td>${start + no.index+1 }</td>
							<td></td>
							<td></td>
							<td>상영관</td>
							<td>장르</td>
							<td>지역</td>
							<td>영화관</td>
							<td>영화</td>
							<td>결제금액</td>
							<td>할인금액</td>
							<td>쿠폰</td>
							<td>결제일</td>
						</tr>
						<%-- </c:forEach> --%>
					</table>
					
				</table>
			</form>
		</div>
	</div>
	
	
</body>
</html>