<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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


<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/fontawesome-all.css"
	type="text/css">


<script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-3.5.1.min.js"></script>


<title>Document</title>
</head>
<body>
	<!--header-->
	<div class="container-fluit">
		<div class="row">
			<div class="col-md-12 title">
				<h3 class="store_name">BOOK STORE</h3>
			</div>
		</div>
	<%
								String	isUserRole = (String) session.getAttribute("userRole");
									if (isUserRole!=null ) {
									%>
		<div class="row list-menu">
			<nav class="navbar navbar-expand-md col-md-12 menu">
				<ul class="navbar-nav ">
				
					<c:url var="urlListBook" value="ListBookServlet">
											
					</c:url>
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/${urlListBook}"
						targer="_self"><fmt:message key="home" /></a></li>
					
                    <c:url var="urlContact" value="bookstore/contact.jsp">
											
					</c:url>
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/${urlContact}"
						targer="_self"><fmt:message key="contact" /></a></li>
	
				</ul>

				<form class="form-inline ">
					<div class="input-group input-group-sm">

						<span> <input type="text" class="form-control"
							aria-label="Small" placeholder=<fmt:message key="search" />
							name="searchBook"></span>
						<div class="input-group-append">
							<button type="button" class="btn btn-success btn-number">
								<i class="fa fa-search"></i>
							</button>
						</div>
					</div>
				<%
				String userRole = (String) session.getAttribute("userRole");
				if (userRole.equals("custormer")) {
				%>
								<c:url var="url" value="bookstore/cart.jsp">
								</c:url>
								
								<a class="btn btn-success btn-sm ml-3" href="${pageContext.request.contextPath}/${url}"><fmt:message
										key="cart" /> 
				<%} %>
				<%
				String role = (String) session.getAttribute("userRole");
				if (role.equals("admin")) {
				%>
			
				
						<c:url var="url" value="ListBookServlet">
							<c:param name="action" value="Add"></c:param>
						</c:url>
						<a href="${url}" class="btn btn-success btn-sm ml-3 addProd"><fmt:message key="addBook" /> </a>
				
					
					
			
				<%} %>
						<c:url var="urlAcc" value="bookstore/account.jsp">
						</c:url> 
						</a> <a class="account ml-3" href="${pageContext.request.contextPath}/${urlAcc}" style="color: white;">
						${acc.name} </a>

				</form>
			</nav>
<%} %>
		</div>
	</div>

</body>
</html>