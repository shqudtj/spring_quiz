<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약 정보</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<%-- AJAX를 사용하려면 jquery 원본 필요 --%>
<script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>

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
				<div class="text-center font-weight-bold m-4">예약 정보</div>
				<table>
					<tr>
						<th>이름</th>
						<td>${booking.name}</td>
					</tr>
					<tr>
						<th>예약날짜</th>
						<td>${booking.date}</td>
					</tr>
					<tr>
						<th>숙박일수</th>
						<td>${booking.day}</td>
					</tr>
					<tr>
						<th>숙박인원</th>
						<td>${booking.headcount}</td>
					</tr>
					<tr>
						<th>전화번호</th>
						<td>${booking.phoneNumber}</td>
					</tr>
				</table>					
					
			</section>
			<footer class="font-weight-small">
					제주특별자치도 제주시 애월읍<br>
					사업자등록번호:111-22-255222 / 농어촌민박사업자지정 / 대표:김통목<br>
					Copyright © marondal 2021
			</footer>
		</div>
	</div>
</body>
</html>