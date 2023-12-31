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
		<div class="form-group">
			<label for="name">제목</label>
			<input type="text" id="name" class="form-control"><br>
		</div>
			
		<div class="form-group">
			<label for="url">주소</label>
			<div class="d-flex">
				<input type="text" id="url" class="form-control mr-2"><br>
				<button id="urlCheckBtn" class="btn btn-info col-1">중복확인</button>
			</div>
			<small id="duplicationText" class="text-danger d-none">중복된 url입니다.</small>
			<small id="availableText" class="text-success d-none">저장 가능한 url입니다.</small>
			<!-- <small id="urlStatusArea"></small> -->
		</div>
		
		<input type="button" id="addBtn" class="btn btn-success text-white btn-block" value="추가">
	</div>
	
<script>
	$(document).ready(function() {
		
		$('#urlCheckBtn').on('click', function() {
			
			let url = $('#url').val().trim();
			if (!url) {
				alert("검사할 url을 입력해주세요.");
				return;
			}
			
			// AJAX 통신 => DB URL 존재 여부
			// 다른 방식
			$.ajax({
				// request
				type:'post'
				, url:'/lesson06/quiz02/is_duplication_url'
				, data:{"url":url}
				
				// response
				, success:function(data) {
					// {"code":1, "isDuplication":true}
					if (data.isDuplication) { // 중복
						$('#duplicationText').removeClass('d-none');
						$('#availableText').addClass('d-none');
					} else { // 사용 가능 (중복 아님)
						$('#duplicationText').addClass('d-none');
						$('#availableText').removeClass('d-none');
					}
				}
				
			
			});
			
			
			
			// 내가 한 것들
			/* $.ajax({
				// request
				type:"get"
				, url:""
				, data:{"url":url}
			
				// response
				, success:function(data) {
					if (data.isDuplication) {
						$('#urlStatusArea').append(
							'<span class="text-danger">중복된 url입니다.</span>'		
						);
					} else {
						$('#urlStatusArea').append(
							'<span class="text-success">저장 가능한 url입니다.</span>'		
						);
					}
				}
			}); */
			
			
			
		});
		
		$('#addBtn').on('click', function() {
			// alert("클릭");
			
			// validation
			let name = $('#name').val().trim();
			let url = $('#url').val().trim();
			
			if (name == '') {
				alert("제목을 입력하세요");
				return 
			}
			if (!url) {
				alert("주소를 입력하세요");
				return 
			}
			if (!url.startsWith("http://") && !url.startsWith("https://")) {
				alert("http / https 까지 모두 입력하세요.")
				return
			}
			
			console.log(name);
			console.log(url);
			
			// 중복확인 체크
			if ($('#availableText').hasClass('d-none')) {	// 잘못된 경우 availableText => d-none인 경우
				alert("중복된 url입니다. 다시 확인해주세요");
				return;
			}
			
			$.ajax({
				// request
				type:"post"
				, url:"/lesson06/quiz02/add_bookmark2"
				, data:{"name":name, "url":url}
			
				// response
				, success:function(data) {	// ()값은 String, JSON 두개가 올 수 있는데 ajax에서 알아서 파악함
											// String, JSON => 자바스크립트의 객체 변환
					/* alert(data.code);
					alert(data.result); */
					if (data.result == '성공') {
						location.href = "/lesson06/quiz02/after_add_bookmark_view2"; // GET method
					} else {
						alert ("즐겨찾기 입력에 실패했습니다.");
					}
					
				}
				/* , complete:function(data) {
					alert("성공이든 실패든 이 창이 뜬다.");
				} */
				, error:function(request, status, error) {
					/* alert(request);
					alert(status);
					alert(error); */
					alert("즐겨찾기 추가하는데 실패했습니다.");
				}
			});
		});
	});
</script>	
</body>
</html>