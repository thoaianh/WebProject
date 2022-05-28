<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" media="all" />
<link href="${pageContext.request.contextPath}/css/model.css"
	rel="stylesheet" type="text/css" media="all" />
<link href="${pageContext.request.contextPath}/css/product.css"
	rel="stylesheet" type="text/css" media="all" />
<link href="${pageContext.request.contextPath}/css/footer.css"
	rel="stylesheet" type="text/css" media="all" />
<link href="${pageContext.request.contextPath}/css/account.css"
	rel="stylesheet" type="text/css" media="all" />
<link href="${pageContext.request.contextPath}/css/account.css"
	rel="stylesheet" type="text/css" media="all" />

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/fontawesome-all.css"
	type="text/css">


<script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-3.5.1.min.js"></script>


<title>Document</title>
</head>
<%@ include file="/bookstore/header.jsp"%>
<div class="container-fluit">
	<div class="row">
		<div class="col">
			<nav aria-label="breadcrumb">
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a
						href="${pageContext.request.contextPath}/ListBookServlet"><fmt:message
								key="home" /></a></li>
					<li class="breadcrumb-item"><a
						href="${pageContext.request.contextPath}/bookstore/product.jsp"><fmt:message
								key="productDetail" /></a></li>


				</ol>
			</nav>
		</div>
	</div>
</div>
<!--end header-->
<!--product-->
<div class="container product-detail">
	<div class="row">

		<div class="preview col-md-4">

			<div class="preview-pic">
				<div class="tab-pane active" id="pic">
					<img
						src="${pageContext.request.contextPath}/UploadFolder/${current.id}.jpg" />
				</div>
			</div>


		</div>
		<div class="details col-md-8">
			<h5 class="product-title">
				<fmt:message key="bookTitle" />
				: ${current.title}
			</h5>

			<div class="description">
				<div class="row author">
					<div class="col-md-5 author_name">
						<h6>
							<fmt:message key="author" />
							: ${current.author}
						</h6>
					</div>

				</div>
				<div class="product-decription">
					<p>${book.decription}</p>
				</div>
			</div>

			<h5 class="price">
				<fmt:message key="price" />
				: <span>${current.price }</span>
			</h5>



			<div class="col">
				<%
					String userRole = (String) session.getAttribute("userRole");
				if (userRole.equals("custormer")) {
				%>
				<div class="button">
					<c:url var="url" value="ListBookServlet">
						<c:param name="action" value="AddToCart" />
						<c:param name="id" value="${current.id}" />
					</c:url>
					<a class="btn btn-success btn-block addToCart" href="${url} "><fmt:message
							key="addToCart" /></a>

				</div>
   

			 <%} %>
			</div>
</div>
		</div>
	</div>
	<!--end product-->
	<%@ include file="/bookstore/footer.jsp"%>
	</body>
</html>