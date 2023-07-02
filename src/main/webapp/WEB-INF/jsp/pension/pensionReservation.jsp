<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약 하기</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<%-- AJAX를 사용하려면 jquery 원본 필요 --%>
<script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>

<!-- datepicker -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>


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
				<div class="text-center font-weight-bold m-4">예약 하기</div>
				<div class="my-1">
					<div>이름</div>
					<input type="text" class="form-control my-1" name="name">
					<div>예약날짜</div>
					<input type="text" class="form-control my-1" id="date" name="date">
					<div>숙박일수</div>
					<input type="text" class="form-control my-1" name="day">
					<div>숙박인원</div>
					<input type="text" class="form-control my-1" name="headcount">
					<div>전화번호</div>
					<input type="text" class="form-control my-1" name="phoneNumber">
					
					<button id="resBtn" type="button" class="btn btn-warning w-100">예약하기</button>
				</div>
					
					
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
			//alert('준비');
			
			$('#date').datepicker({
				chaneMonth : true,
				chaneYear : true,
				dateFormat : "yy-mm-dd"
				
			});
			
			$('#resBtn').on('click', function() {
				//alert("버튼클릭");
				let name = $('input[name=name]').val().trim();
				let date = $('input[name=date]').val().trim();
				let day = $('input[name=day]').val().trim();
				let headcount = $('input[name=headcount]').val().trim();
				let phoneNumber = $('input[name=phoneNumber]').val().trim();
				
				if (name == '') {
					alert ('이름을 입력해주세요');
					return;
				}
				if (date == '') {
					alert ('날짜를 선택해주세요');
					return;
				}
				if (day == '') {
					alert ('숙박일수를 입력해주세요');
					return;
				}
				if (headcount == '') {
					alert ('숙박인원을 입력해주세요');
					return;
				}
				if (phoneNumber == '') {
					alert ('전화번호를 입력해주세요');
					return;
				}
				
				console.log(name);
				console.log(date);
				console.log(day);
				console.log(headcount);
				console.log(phoneNumber);
				
				$.ajax({
					// request
					type: "post"
					, url: "/pension/pensionReservation"
					, data: {"name" : name, "date" : date, "day" : day, "headcount" : headcount, "phoneNumber" : phoneNumber}
					
					// response
					, success: function(data) {
						if (data.result == "성공") {
							alert('예약이 완료되었습니다');
							
							//location.href ="pension/afterpensionReservation";
						} else {
							alert('예약이 실패했습니다. 관리자에게 문의해주세요');
						}
					}
					, error: function(request, status, error) {
							alert(request);
							//alert(status);
							//alert(error);
					}
					
					
				});
			});
			
			
		});
	
	</script>
</body>
</html>