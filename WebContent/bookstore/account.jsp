<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false"%>
<%@ page session="true"%>

<fmt:setLocale value="${sessionScope.lang}" />
<fmt:setBundle basename="resources.messages" />

<!DOCTYPE html>
<html lang="${sessionScope.lang}">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">


<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" media="all" />
<link href="${pageContext.request.contextPath}/css/account.css"
	rel="stylesheet" type="text/css" media="all" />
<link href="${pageContext.request.contextPath}/css/model.css"
	rel="stylesheet" type="text/css" media="all" />
<link href="${pageContext.request.contextPath}/css/footer.css"
	rel="stylesheet" type="text/css" media="all" />


<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/fontawesome-all.css"
	type="text/css">


<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-3.5.1.min.js"></script>


<title></title>

</head>

<body>
	<div class="container-fluit">
		<div class="row">
			<div class="col-md-12 title">
				<h3 class="store_name">BOOK STORE</h3>
			</div>
		</div>

		<div class="row list-menu">
			<nav class="navbar navbar-expand-md col-md-12 menu">
			<ul class="navbar-nav ">
					<c:url var="urlListBook" value="../ListBookServlet">
											
					</c:url>
					<li class="nav-item"><a class="nav-link"
						href="${urlListBook}"
						targer="_self"><fmt:message key="home" /></a></li>
                    <c:url var="urlContact" value="../bookstore/contact.jsp">
											
					</c:url>
					<li class="nav-item"><a class="nav-link"
						href="${urlContact}"
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
					<c:url var="url" value="bookstore/cart.jsp">
					</c:url>
					<a class="btn btn-success btn-sm ml-3" href="${pageContext.request.contextPath}/${url}"><fmt:message
							key="cart" /> 
						<c:url var="urlAcc" value="bookstore/account.jsp">
						</c:url> 
						</a> <a class="account ml-3" href="${pageContext.request.contextPath}/${urlAcc}" style="color: white;">
						${acc.name} </a>

				</form>
			</nav>

		</div>
	</div>

	<div class="container-fluit">
		<div class="row">
			<div class="col">
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb">
						<li class="breadcrumb-item">
						<c:url var="url" value="ListBookServlet"></c:url>
							<c:url var="url" value="ListBookServlet"></c:url>
						<a href="${pageContext.request.contextPath}/${url}"><fmt:message key="home" /></a></li>
						<li class="breadcrumb-item"><a
							href="${pageContext.request.contextPath}/bookstore/account.jsp"><fmt:message
									key="account" /></a></li>

					</ol>
				</nav>
			</div>
		</div>
	</div>
	<!--account-->
	<div class="container-fluit profile">
		<div class="row ">
			<div class="col-md-12">
				<h3 class="profile-head">
					<b><fmt:message key="accInfo" /></b>
				</h3>
			</div>
		</div>
		<div class="row ">
			<div class="col-md-3">
				<div class="profile-img">
					<img class="image"
						src="${pageContext.request.contextPath}/image/account_img.png"
						alt="Image" />
					<h5>${acc.name}<h5>
				</div>

				<ul class=" nav nav-pills flex-column profile-work" role="tablist">
				    <c:url var="urlAcc" value="bookstore/account.jsp"></c:url>
					<li class=" nav-item nav1 "><a class="nav-link active"
						id="info-tab" data-toggle="pill"
						href="${pageContext.request.contextPath}/${urlAcc}"><fmt:message
								key="personalInfo" /></a></li>
					<c:url var="urlBill" value="bookstore/bill.jsp"></c:url>
					<li class=" nav-item nav2 "><a class="nav-link" id="bills-tab"
						data-toggle="pill"
						href="${pageContext.request.contextPath}/${urlBill}"><fmt:message
								key="proIsBought" /></a></li>
				
				   <c:url var="urlState" value="bookstore/state.jsp"></c:url>
					<li class="  nav-item nav4"><a class="nav-link" id="state-tab"
						data-toggle="pill"
						href="${pageContext.request.contextPath}/${urlState}"><fmt:message
								key="billDetail" /></a></li>
					 <c:url var="urlAddr" value="bookstore/address.jsp">
					 <c:param name="accId" value="${acc.id}" />
					 </c:url>
					<li class="  nav-item nav5"><a class="nav-link"
						id="address-tab" data-toggle="pill"
						href="${pageContext.request.contextPath}/${urlAddr}"><fmt:message
								key="address" /></a></li>


					<li class="  nav-item nav5"><c:url var="url" value="../Logout">
							<c:param name="action" value="Logout"></c:param>
						

						</c:url> <a href="${url}" class="btn btn-basic btn-block logout" style="text-align:left"> <fmt:message
								key="signout" /></a></li>
				</ul>
			</div>

			<div class="col-md-8 col-md-offset-1">

				<div
					class="tab-content well profile-info border border-success border-right-0 border-top-0 border-bottom-0  ">

					<div id="infomation" class="tab-pane  in active " role="tabpanel"
						aria-labelledby="info-tab">

						<div class="row">
							<div class="col-md-4">
								<label><fmt:message key="name" />: </label>
							</div>
							<div class="col-md-8">
								<p>${acc.name}</p>
							</div>
						</div>



						<div class="row">
							<div class="col-md-4">
								<label><fmt:message key="phone" />:</label>
							</div>
							<div class="col-md-8">
								<p>${acc.phone}</p>
							</div>
						</div>

						<div class="row">
							<div class="col-md-4">
								<label><fmt:message key="email" />:</label>
							</div>
							<div class="col-md-8">
								<p>${acc.email}</p>
							</div>
						</div>

					</div>

				</div>
			</div>
		</div>
	</div>

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