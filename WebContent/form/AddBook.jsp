<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setLocale value="${param.lang}" />
<fmt:setBundle basename="resources.messages" />

<!DOCTYPE html>
<html lang="${param.lang}">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" media="all" />
<link href="${pageContext.request.contextPath}/css/homepage.css"
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


<title></title>
</head>
<body>
	<%@ include file="/bookstore/header.jsp"%>
	<div class="containner-fluit" style="margin:100px 100px">
		<form method="POST" action="Add">
			<div class="row">
				<div class="col-md-2">
					<span>*<fmt:message key="bookId" />:</span>
				</div>
				<div class="col-md-5">
					<input type="text" name="id" size="20">
				</div>
			</div>

			<div class="row">
				<div class="col-md-2">
					<span>*<fmt:message key="bookTitle" />:</span>
				</div>
				<div class="col-md-5">
					<input type="text" name="title" size="20">
				</div>
			</div>




			<div class="row">
				<div class="col-md-2">
					<span><fmt:message key="author" />:</span>
				</div>
				<div class="col-md-5">
					<input type="text" name="author" size="20">
				</div>
			</div>
			<div class="row">
				<div class="col-md-2">
					<span>*<fmt:message key="price" />:</span>
				</div>
				<div class="col-md-3">
					<input type="text" name="price" size="20">
				</div>
				<div class="col-md-5">
					<h5>${errorPrice}</h5>
				</div>
				
			</div>
			<div class="row">
				<div class="col-md-2">
					<span><fmt:message key="decription" />:</span>
				</div>
				<div class="col-md-3">
					<input type="text" name="decription" size="20">
				</div>
			</div>
			<div class="row">
				<div class="col-md-2">
					<span>*<fmt:message key="amountInCart" />:</span>
				</div>
				<div class="col-md-3">
					<input type="text" name="amount" size="20">
				</div>
				<div class="col-md-5">
					<h5>${errorAmount}</h5>
				</div>
				
			</div>
			<div class="row" style="margin-top:20px">
				<div class="col-md-2">
					<c:url var="url" value="ListBookServlet"></c:url>
					<input type="submit" value=<fmt:message key="addBook" />
						class="btn btn-success btn-block"
						>
					
				</div>
				<div class="col-md-2">
					<a class="btn btn-success btn-block" href="${url}"><fmt:message key="cancel" /></a>
				</div>
			</div>


		</form>
	</div>
	<%@ include file="/bookstore/footer.jsp"%>
</body>
</html>