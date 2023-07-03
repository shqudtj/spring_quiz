<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약 조회</title>
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
			<section class="banner">
				<img id="bannerImg" src="/image/banner1.jpg" alt="banner" width="1200" height="500">					
			</section>
			<section class="reserve d-flex">
			<section
				class="real-time-reserved col-4 d-flex justify-content-center align-items-center">
				<div class="display-4 text-white">
					실시간<br>예약하기
				</div>
			</section>
			<section class="confirm col-4">
				<div class="m-3">
					<span class="reserve-confirm mr-3">예약 확인</span>
				</div>

				<!-- 예약 확인 -->
				<div id="memberInputBox" class="m-2">
					<div class="d-flex justify-content-end mr-3">
						<span class="text-white">이름:</span> 
						<input type="text" id="name" class="form-control input-form">
					</div>
					<div class="d-flex mt-2 justify-content-end mr-3">
						<span class="text-white">전화번호:</span> 
						<input type="text" id="phoneNumber" class="form-control input-form">
					</div>

					<!-- 버튼 -->
					<div class="text-right mt-3 mr-3">
						<button type="button" id="searchBtn" class="btn btn-success submit-btn">조회하기</button>
					</div>
				</div>

			</section>
			<section
				class="inquiry col-4 d-flex justify-content-center align-items-center">
				<div class="text-white">
					<h4 class="font-weight-bold">예약문의:</h4>
					<h1>
						010-<br>0000-1111
					</h1>
				</div>
			</section>
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
			//alert("ready");
			
			$('#searchBtn').on('click', function() {
				//alert("버튼 클릭");
				
				let name = $('#name').val().trim();
				//alert(name);
				let phoneNumber = $('#phoneNumber').val().trim();
				//alert(phoneNumber);
				
				if (name == '') {
					alert("이름을 입력해주세요.");
					return;
				}
				if (phoneNumber.length < 1) {
					alert("전화번호를 입력해주세요.");
					return;
				}
				
				
				$.ajax({
					// request
					type:"post"
					, url:"/pension/searchBooking"
					, data: {"name":name, "phoneNumber":phoneNumber}
					
					// response
					, success: function(data) {
						if (data.code == 1) {
							alert("이름" + data.booking.name
									+ "\n날짜" + data.booking.date.slice(0, 10)
									+ "\n일수" + data.booking.day
									+ "\n인원" + data.booking.headcount
									+ "\n상태" + data.booking.state);
						} else {
							alert(data.errorMessgae);
						}
					}
					, error: function(request, status, error) {
						alert("에러발생");
					}	
					
				});
				
			});
			
		});
	</script>
</body>
</html>


