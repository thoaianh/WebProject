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
<link href="${pageContext.request.contextPath}/css/cart.css"
	rel="stylesheet" type="text/css" media="all" />
<link href="${pageContext.request.contextPath}/css/model.css"
	rel="stylesheet" type="text/css" media="all" />

<link href="${pageContext.request.contextPath}/css/footer.css"
	rel="stylesheet" type="text/css" media="all" />
<link href="${pageContext.request.contextPath}/css/account.css"
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
						<li class="breadcrumb-item">
						<c:url var="url" value="ListBookServlet"></c:url>
						<a href="${pageContext.request.contextPath}/${url}"><fmt:message key="home" /></a></li>
						<li class="breadcrumb-item"><a
							href="${pageContext.request.contextPath}/bookstore/cart.jsp"><fmt:message key="cart" /></a></li>


					</ol>
				</nav>
			</div>
		</div>
	</div>


	<!--cart content-->
	<div class="container-fluit cart">
		<div class="row title">
			<div class="col-md-12">
				<h3><fmt:message key="cart" /></h3>
			</div>
		</div>
		<c:forEach items="${cart.books}" var="item">

			<div class="row pro_num">

				<div class="col-md-2">
					<img class="img_prod"
						src="${pageContext.request.contextPath}/UploadFolder/${item.book.id}.jpg"
						alt="Image">
				</div>

				<div class="col-md-2">
					
					<p><fmt:message key="bookTitle" />:</p>
					<p><fmt:message key="price" />:</p>
					<p><fmt:message key="currentAmountOfBook" />:</p>
					<br>	
					<c:url var="url" value="/CartServlet">
						<c:param name="id" value="${item.book.id}" />
						<c:param name="action" value="Remove" />
					</c:url>
				
			
             
				<a  class="btn btn-success"  href="${url}"><fmt:message key="delete" /></a>
				

				</div>

				<div class="col-md-8">
					
					<p class="name-prod">${item.book.title}</p>
					<p class="price-prod">${item.book.price}</p>
					<p class="quantity-prod" style="color: orange">${currentAmount}</p>
				    <br/>

                  
				  <p >
				    <c:url var="decrease_url" value="/CartServlet">
						<c:param name="id" value="${item.book.id}" />
						<c:param name="action" value="Decrease" />
					</c:url>
				
				  <a  class="btn btn-outline-success"  href="${decrease_url}">-</a>
			
				  ${item.quantity}
				  
				     <c:url var="increase_url" value="/CartServlet">
						<c:param name="id" value="${item.book.id}" />
						<c:param name="action" value="Increase" />
					</c:url>
				
				  <a  class="btn btn-outline-success"  href="${increase_url}">+</a>
				  </p>
				


				</div>

			</div>
			<hr>
		</c:forEach>

		<div class="row">
			<div class="col-md-2">
				<p class="amount"><fmt:message key="total" />: ${cart.numberOfItems}</p>
			</div>
			<div class="col-md-2">

				<p class="total_price"><fmt:message key="totalCost" />: ${cart.total}</p>

			</div>
			<div class="col-md-8">
				<c:url var="url" value="/CartServlet">
						<c:param name="id" value="${item.book.id}" />
						<c:param name="accId" value="${acc.id}"/>
						<c:param name="action" value="SeeBill" />
					</c:url>
			
				<a class=" btn btn-success " href="${url}"><fmt:message key="buy" /></a>
			</div>

		</div>


	</div>
	<%@ include file="/bookstore/footer.jsp"%>
</body>
</html>