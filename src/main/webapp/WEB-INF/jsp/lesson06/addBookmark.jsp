<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>즐겨찾기 추가하기</title>
<link rel="stylesheet"href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"crossorigin="anonymous">
<%-- AJAX를 사용하려면 jquery 원본 필요 --%>
<script src="https://code.jquery.com/jquery-3.7.0.js"integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM="crossorigin="anonymous"></script>
<script	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<h1>즐겨찾기 추가하기</h1>
		<div>제목</div><br>
		<input type="text" id="title" class="form-control"><br>
		<div>주소</div><br>
		<input type="text" id="address" class="form-control"><br>
		<input type="button" id="addBtn" class="btn btn-success text-white col-12" value="추가">
	</div>
	
<script>
	$(document).ready(function() {
		$('#addBtn').on('click', function() {
			// alert("클릭");
			
			// validation
			let title = $('#title').val().trim();
			let address = $('#address').val().trim();
			
			if (title == '') {
				alert("제목을 입력하세요");
				return 
			}
			if (!address) {
				alert("주소를 입력하세요");
				return 
			}
			if (!address.startsWith("http") && !address.startsWith("https")) {
				alert("http / https 까지 모두 입력하세요.")
				return
			}
			
			console.log(title);
			console.log(address);
			
			$.ajax({
				// request
				type:"post"
				, url:"/lesson06/quiz01/add_bookmark"
				, data:{"title":title, "address":address}
			
				// response
				, success:function(data) {
					alert(data);
					if (data == '성공') {
						location.href = "/lesson06/quiz01/after_add_bookmark_view";
					} else {
						alert ("즐겨찾기 입력에 실패했습니다.");
					}
					
				}
				, complete:function(data) {
					alert("성공이든 실패든 이 창이 뜬다.");
				}
				, error:function(request, status, error) {
					alert(request);
					alert(status);
					alert(error);
				}
			});
			
		});
		
	});
</script>	
</body>
</html>