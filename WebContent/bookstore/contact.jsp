<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<%@ page session="true" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="resources.messages"/>

<!DOCTYPE html>
<html lang="${sessionScope.lang}">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" media="all" />
<link href="${pageContext.request.contextPath}/css/homepage.css"
	rel="stylesheet" type="text/css" media="all" />
<link href="${pageContext.request.contextPath}/css/model.css"
	rel="stylesheet" type="text/css" media="all" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/contact.css"
	type="text/css">
<link href="${pageContext.request.contextPath}/css/footer.css" rel="stylesheet" type="text/css"  media="all" />
	


<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/fontawesome-all.css"
	type="text/css">


<script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-3.5.1.min.js"></script>



<title>Contact</title>
</head>

<body>
	 <%@ include file="/bookstore/header.jsp"%>
	<div class="container-fluit">
		<div class="row">
			<div class="col">
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb">
						<c:url var="url" value="../ListBookServlet"></c:url>
						<li class="breadcrumb-item"><a href="${url}"><fmt:message key="home" /></a></li>
							<c:url var="urlContact" value="./bookstore/contact.jsp"></c:url>
						<li class="breadcrumb-item"><a href="${urlContact}"><fmt:message key="contact" /></a></li>


					</ol>
				</nav>
			</div>
		</div>
	</div>
	<!--End header-->

	<!--Contact, feedback-->
	<div class="container-fluit contact-fb">
		<!--feedback-->
		<div class="row feedback">

			<div class="col-md-12">
				<form class="form-horizontal form" method="post" action="../FeedBackServlet">
					<h3>
						<b><fmt:message key="feedBack" />:</b>
					</h3>
					<br>

					<div class="form-group">
						<div class="col-md-2">
							<label class="control-label" for="name"><fmt:message key="name" />:</label>
						</div>
						<div class="col-md-10">
							<input type="text" class="form-control" id="name" placeholder="" name="name">
						</div>
					</div>

					<div class="form-group">
						<div class="col-md-2">
							<label class="control-label" for="name"><fmt:message key="email" />:</label>
						</div>
						<div class="col-md-10">
							<input type="email" class="form-control" id="email"
								placeholder="" name="email">
						</div>
					</div>

					<div class="form-group">
						<div class="col-md-2">
							<label class="control-label" for="name"><fmt:message key="content" /></label>
						</div>
						<div class="col-md-10">
							<input type="text" class="form-control" id="content"
								placeholder="" name="content">
						</div>
					</div>

					<div class="form-group submit">
						<button type="submit" class="btn btn-success "><fmt:message key="send" /></button>
					</div>

				</form>
			</div>
		</div>

	</div>
	</div>



	<!--contatc-->
	<div class="row contact">
		<div class="col-md-5 info-address">
			<h3>
				<b>Contact:</b>
			</h3>
			<br>
			<div class="row">
				<div class="col-md-4">
					<label>Email:</label>
				</div>
				<div class="col-md-8">
					<p>xxx@gmail.com</p>
				</div>
			</div>

			<div class="row">
				<div class="col-md-4">
					<label>SDT:</label>
				</div>
				<div class="col-md-8">
					<p>0987654321</p>
				</div>
			</div>

			<div class="row">
				<div class="col-md-4">
					<label>Địa chỉ:</label>
				</div>
				<div class="col-md-8">
					<p>Đường..., Quận..., TPHCM</p>
				</div>
			</div>
		</div>

		<div class="col-md-5  map">
			<iframe
				src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3918.2482728322752!2d106.78536971405745!3d10.868711792258923!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x31752891cf0ca363%3A0x356ed7098d266f31!2zVHLGsOG7nW5nIMSQ4bqhaSBI4buNYyBOw7RuZyBMw6JtIFRQLkhDTQ!5e0!3m2!1svi!2s!4v1594446523937!5m2!1svi!2s"
				width="400" height="300" frameborder="0" style="border: 0;"
				allowfullscreen="" aria-hidden="false" tabindex="0"></iframe>
		</div>
	</div>
 <%@ include file="/bookstore/footer.jsp"%>
</body>
</html>

</body>
</html>