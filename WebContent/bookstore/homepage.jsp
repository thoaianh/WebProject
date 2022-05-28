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


	<div class="container-fluit">
		<div class="row">
			<div class="col">
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb">
						<li class="breadcrumb-item">
						<c:url var="url" value="ListBookServlet"></c:url>
						<a
							href="${url}"><fmt:message key="home" /></a></li>

					</ol>
				</nav>
			</div>
		</div>
	</div>
	<%
	String userRole = (String) session.getAttribute("userRole");
	
	%>
	

	<div class="container-fluit container_category">

		<div class="row">
			<div class="col-12 col-sm-3">
				<div class="card bg-light mb-3">
					<div class="card-header bg-success text-white ">
						<i class="fa fa-list"></i> <fmt:message key="category" />
					</div>
					<ul class="list-group category_block">
					
					
						<li class="list-group-item"><p><fmt:message key="psychologicalBook" /></p></li>
						<li class="list-group-item"><p><fmt:message key="economicBook" /></p></li>
						<li class="list-group-item"><p><fmt:message key="scienceBook" /></p></li>

					</ul>
				</div>
			</div>
			<div class="col">

				<div class="row ">
					<div class="col-12 current_amount"
						style="background-color: rgb(236, 227, 227); padding: 10px 10px">
						<fmt:message key="currentBookInShop" />: <span>${list.size()}</span>
					</div>
				</div>


				<div class="row list_pros">
					<c:forEach items="${list}" var="book">
						<div class="col-12 col-md-6 col-lg-4">
							<div class="card">


								<img class="card-img-top"
								src="${pageContext.request.contextPath}/UploadFolder/${book.id}.jpg"	alt="Image">
								
								
								<div class="card-body">
									<h4 class="card-title">
										<c:url var="url" value="ListBookServlet">
											<c:param name="action" value="Detail" />
											<c:param name="id" value="${book.id}" />
											<c:param name="accId" value="${acc.id}" />
										</c:url>

										<a href="${url}" title="View Product" style="font-size: 20px;">${book.title}
										</a>
									</h4>
									<p class="card-text">${book.decription}</p>
									<div class="row">
										<div class="col">
											<p>
												Giá: <span class="price">${book.price}</span>
											</p>
										</div>
										
										<div class="col">
										<%
									userRole = (String) session.getAttribute("userRole");
									if (userRole.equals("custormer")) {
									%>
											<c:url var="url" value="ListBookServlet">
												<c:param name="action" value="AddToCart" />
												<c:param name="id" value="${book.id}" />
												<c:param name="accId" value="${acc.id}" />

											</c:url>
											
											<a href="${url}" class="btn btn-success btn-block addToCart">
												<fmt:message key="addToCart" /> </a>
										<%} %>
										</div>
									</div>
									<br>
									<%
									userRole = (String) session.getAttribute("userRole");
									if (userRole.equals("admin")) {
									%>
									<div class="row">

										<div class="col">
											<c:url var="url" value="ListBookServlet">
												<c:param name="action" value="EditBook"></c:param>
												<c:param name="id" value="${book.id}"></c:param>
												
											</c:url>
											<a href="${url}" class="btn btn-success btn-block editProd">
											<fmt:message key="editBook"/> </a>
										</div>


										<div class="col">
											<c:url var="url" value="ListBookServlet">
												<c:param name="action" value="Delete"></c:param>
													<c:param name="id" value="${book.id}"></c:param>
												
											</c:url>
											<a href="${url}" class="btn btn-danger btn-block dltProd">
												<fmt:message key="delete" /></a>
										</div>

									</div>

										<%
											}
										%>
								</div>
							</div>
						</div>
					</c:forEach>

				</div>
			</div>

		</div>
	</div>

	<%@ include file="/bookstore/footer.jsp"%>
</body>
</html>