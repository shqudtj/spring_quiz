<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>즐겨찾기 목록</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<%-- AJAX를 사용하려면 jquery 원본 필요 --%>
<script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<h1>즐겨찾기 목록</h1>
		<table class="table text-center">
			<thead>
				<tr>
					<th>No.</th>
					<th>이름</th>
					<th>주소</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${bookmarkList}" var="bookmark">
				<tr>
					<td>${bookmark.id}</td>
					<td>${bookmark.name}</td>
					<td>${bookmark.url}</td>
					<td>
						<button name="${bookmark.id}" type="button" class="btn btn-danger text-white deleteBtn">삭제</button>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
	
	<script>
		$(document).ready(function() {
			
			$('.deleteBtn').on('click', function() {
				//alert("삭제");
				let name = $('button[name=${bookmark.name}]').val();
				
				$.ajax({
					type:"post"
					, url:"/lesson06/quiz02/delete_bookmark"
					, data:{"name":name}
				
					, success:function(data) {
						if (data.result = '성공') {
							location.href="/lesson06/quiz02/after_add_bookmark_view2"
						} else {
							alert("즐겨찾기 삭제를 실패했습니다.");
						}
					}
					, error:function(request, status, error) {
						alert("에러가 발생했습니다.");
					}					
				});
				
				
			});
			
			
		});
	</script>	
</body>
</html>

