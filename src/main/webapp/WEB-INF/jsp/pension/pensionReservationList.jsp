<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>팬션 예약목록</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<%-- AJAX를 사용하려면 jquery 원본 필요 --%>
<script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>

<link rel="stylesheet" type="text/css" href="/css/pension/pensionStyle.css">
</head>
<body>
	<div class="container">
		<div id="wrap">
			<header class="d-flex justify-content-center align-items-center">
				<div class="display-4">통나무 펜션</div>
			</header>
			<nav>
				<ul class="nav nav-fill">
					<li class="nav-item"><a href="#" class="nav-link menu-font">펜션소개</a></li>
					<li class="nav-item"><a href="#" class="nav-link menu-font">객실보기</a></li>
					<li class="nav-item"><a href="/pension/make_booking_view" class="nav-link menu-font">예약하기</a></li>
					<li class="nav-item"><a href="/pension/pension_reservationList_view" class="nav-link menu-font">예약목록</a></li>
				</ul>
			</nav>
			<section class="contents">
				<div class="text-center font-weight-bold m-4">예약 목록 보기</div>
					<table class="table text-center">
						<thead>
							<tr>
								<th>이름</th>
								<th>예약날짜</th>
								<th>숙박일수</th>
								<th>숙박인원</th>
								<th>전화번호</th>
								<th>예약상태</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
						<c:forEach items="${bookingList}" var="booking">
							<tr>
								<td>${booking.name}</td>
								<td>
									<fmt:formatDate value="${booking.date}" pattern="yyyy년 M월 dd일" />
								</td>
								<td>${booking.day}</td>
								<td>${booking.headcount}</td>
								<td>${booking.phoneNumber}</td>
								<td>${booking.state}</td>
								<td>
									<button type="button" class="deleteBtn btn btn-danger form-control text-white col-6" data-booking-id="${booking.id}">삭제</button>
								</td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
			</section>
			<footer class="font-weight-small">
					제주특별자치도 제주시 애월읍<br>
					사업자등록번호:111-22-255222 / 농어촌민박사업자지정 / 대표:김통목<br>
					Copyright © marondal 2021
			</footer>
		</div>
	</div>
	
	<script>
		$(document).ready(function() {
			//alert("ㅎㅇ");
			$('.deleteBtn').on('click', function() {
				//alert("삭제버튼클릭");
				
				let deleteId = $(this).data('booking-id');
				//alert(deleteId);
				
				$.ajax({
					// request
					type:"delete"
					, url:"/pension/delete_booking"
					, data: {"bookingId": deleteId}
				
					// response
					, success: function(data) {
						/* alert(data); */
						if (data.code == 1) { // 성공
							location.reload();
						} else {
							alert(data.errorMessage);
						}
					}
					, error: function(request, status, error) {
						alert("삭제하는데 실패했습니다. 관리자에게 문의해주세요.");
					}
					
					
				});
				
			});
			
		});	
	
	</script>
</body>
</html>



