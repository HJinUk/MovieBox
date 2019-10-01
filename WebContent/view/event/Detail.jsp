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
			<form name="coupon" action="coupon" method="post" enctype="multipart/form-data">
				<table class="wapper_table" border="1px soild #000">

					<tr>
						<td>${dto.eid }</td>
						<td class="event_title">${dto.title }</td>
					</tr>
					<tr>
						<td colspan="2">${dto.start_ev }~ ${dto.finish_ev }</td>
					</tr>
					<tr>
						<td colspan="2"><img
							src="../m_img/event/${dto.content_img }" alt="" /></td>
					</tr>
					<tr>
						<td colspan="2"><input type="hidden" name="coupon" value="${dto.coupon }" />
										<input type="submit" value="쿠폰받기" /></td>
					</tr>
				</table>
			</form>
		</div>
	</div>

</body>
</html>