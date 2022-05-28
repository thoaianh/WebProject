<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<link href="${pageContext.request.contextPath}/css/model.css"
	rel="stylesheet" type="text/css" media="all" />

<link href="${pageContext.request.contextPath}/css/footer.css"
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
	<%@ include file="/bookstore/header.jsp"%>
	<div class="container-fluit">
		<div class="row">
			<div class="col">
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a
							href="${pageContext.request.contextPath}/ListBookServlet"><fmt:message key="home" /></a></li>
						<li class="breadcrumb-item"><a
							href="${pageContext.request.contextPath}/bookstore/checkout.jsp"><fmt:message key="checkout" /> </a></li>
					</ol>
				</nav>
			</div>
		</div>
	</div>
	<div class="container-fluit"
		style="margin-left: 100px; margin-bottom: 100px">

		<c:forEach items="${cart.books}" var="item">

			<div class="row pro_num">

				<div class="col-md-2">
					<img class="img_prod"
						src="${pageContext.request.contextPath}/UploadFolder/${item.book.id}.jpg"
						alt="Image">
				</div>

				<div class="col-md-2">
					<p><fmt:message key="bookId" />:</p>
					<p><fmt:message key="bookTitle" />:</p>
					<p><fmt:message key="price" />:</p>
					<p><fmt:message key="amountInCart" />:</p>
					<br>

				</div>

				<div class="col-md-8">
					<p class="id-prod">${item.book.id }</p>
					<p class="name-prod">${item.book.title}</p>
					<p class="price-prod">${item.book.price}</p>
					 <p >${item.quantity}</p>

	<br>

				</div>

			</div>
			<hr>
		</c:forEach>

		<div class="row">
			<div class="col-md-4">
				<p class="amuont"><fmt:message key="total" />: ${cart.numberOfItems}</p>
			</div>
			<div class="col-md-8">

				<p class="total_price"><fmt:message key="totalCost" />: ${cart.total}</p>

			</div>


		</div>

		<div class="row">

			<div class="col-md-4">

			<fmt:message key="address" />:	<input class="acc-address" value=" ${acc.address}">

			</div>
			
				<div class="col-md-8">

			<fmt:message key="phone" />:	<input class="acc-phone" value=" ${acc.phone}">

			</div>


		</div>

		<div class="row">
			<div class="col-md-4">
				<p style="color: red">
					<i><fmt:message key="pay" /></i>
				</p>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4">
				<p style="color: red">
					<i><fmt:message key="buyMessage" /></i>
				</p>
				<c:url var="url" value="/CartServlet">
					<c:param name="id" value="${item.book.id}" />
					<c:param name="accId" value="${acc.id}" />
					<c:param name="action" value="Checkout" />
				</c:url>
			</div>		
			<div class="col-md-1">
				<a class=" btn btn-success btn btn-block" href="${url}"><fmt:message key="yes" /></a>

			</div>
			<div class="col-md-1">
				<a class=" btn btn-danger  btn btn-block" href="${pageContext.request.contextPath}/ListBookServlet"><fmt:message key="no" /></a>

			</div>



		</div>
	</div>

	<%@ include file="/bookstore/footer.jsp"%>
</body>
</html>