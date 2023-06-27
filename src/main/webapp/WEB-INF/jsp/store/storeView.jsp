<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>배탈의 민족</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>

<link rel="stylesheet" type="text/css" href="/css/store/storeStyle.css">
</head>
<body>
	<div class="container col-4">
		<h2 class="bg-info text-white">
			배탈의 민족
		</h2>
		<h1>
			우리동네 가게
		</h1>
		<c:forEach items="${storeList}" var="store">
		<div class="borders m-1" name="${store.name}">
			<div><b>${store.name}</b></div>
			<div>전화 번호 : ${store.phoneNumber}</div>
			<div>주소 : ${store.address}</div>
		</div>
		</c:forEach>
		<c:forEach items="${storeList}" var="store">
		<ul class="nav p-1">
			<li class="nav-item">
			<a href="http://localhost:8080/store/reviews?storeId=${store.id}&storeName=${store.name}" class="nav-link list-font">
				<div><b>${store.name}</b></div>
				<div>전화 번호 : ${store.phoneNumber}</div>
				<div>주소 : ${store.address}</div>
			</a>
			</li>
		</ul>
		
		
		</c:forEach>
		<hr>
		<div>
			<div>
				(주)우와한형제
			</div>
			<div class="font-weight-light text-secondary">
				고객센터 : 1500-1500
			</div>
		</div>
	</div>
	<script>
		$(document).ready(function() {
			
		});
	</script>
</body>
</html>