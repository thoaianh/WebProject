<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false"%>
<%@ page session="true"%>

<fmt:setLocale value="${sessionScope.lang}" />
<fmt:setBundle basename="resources.messages" />
<!DOCTYPE html>
<html lang="${sessionScope.lang}">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" media="all" />

<link href="${pageContext.request.contextPath}/css/model.css"
	rel="stylesheet" type="text/css" media="all" />
<link href="${pageContext.request.contextPath}/css/footer.css"
	rel="stylesheet" type="text/css" media="all" />


<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/fontawesome-all.css"
	type="text/css">


<script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-3.5.1.min.js"></script>


<title>Document</title>
</head>
<body>

	<!--footer-->
	<footer class="text-light">
		<div class="container">
			<div class="row">
				<div class="col-md-9 col-lg-9 col-xl-8">
					<h5>About</h5>
					<hr class="bg-white mb-2 mt-0 d-inline-block mx-auto w-25">
					<br>
					<i class="mb-0">At BookStore you will find the best books to
						read from our bookstore. We are proud to continue to offer you
						competitively low prices since our opening. We are affordable and
						quality collection series.</i>
				</div>


				<div class="col-md-4 col-lg-3 col-xl-3">
					<h5>Contact</h5>
					<hr class="bg-white mb-2 mt-0 d-inline-block mx-auto w-25">
					<ul class="list-unstyled">
						<li>BookStore</li>
						<li>bookstore@gmail.com</li>
						<li>Phone: 0987654321</li>
						<li>Phone: 0987654322</li>
					</ul>
				</div>
			</div>
		</div>
	</footer>
</body>
</html>