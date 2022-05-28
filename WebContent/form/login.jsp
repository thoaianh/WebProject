<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false"%>

<fmt:setLocale value="${param.lang}" />
<fmt:setBundle basename="resources.messages" scope="session" />


<!DOCTYPE html>
<html lang="${param.lang}">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Login</title>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" media="all" />
<link href="${pageContext.request.contextPath}/css/login.css"
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

</head>

<body>
	<%@ include file="/bookstore/header.jsp"%>
	<div class="container-fluit">
		<div class="row">
			<div class="col">
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb">

						<li class="breadcrumb-item"><a
							href="${pageContext.request.contextPath}/login.jsp"><fmt:message
									key="login" /></a></li>


					</ol>
				</nav>
			</div>
		</div>
	</div>
	<!--end header-->


	<!--Sign in-->
	<ul>
		<li><span><fmt:message key="defaultLanguage" />: </span><a href="?sessionLocale=en"><fmt:message key="lang.en" /></a></li>    
		<li><span><fmt:message key="other" />: </span><a href="?sessionLocale=vi"><fmt:message key="lang.vi" /></a></li>
		<li><span><fmt:message key="other" />: </span><a href="?sessionLocale=fr"><fmt:message key="lang.fr" /></a></li>	

	</ul>

	<h4 style="text-align: center">
		<i><fmt:message key="loginMessage" /> </i>
	</h4>

	<div class="card card-container">


		<p id="profile-name" class="profile-name-card"></p>


		<form class="form-signin" method="post"
			action="${pageContext.request.contextPath}/CheckLogin">
			<h3 style="text-align: center;">
				<fmt:message key="login" />
			</h3>
			<span><fmt:message key="email" /></span> <input type="text"
				id="inputName" class="form-control" name="name"> <span><fmt:message
					key="pwd" /></span> <input type="password" id="inputPassword"
				class="form-control" name="pass"> <input
				class="btn btn-lg btn-primary btn-block btn-signin" type="submit"
				value=<fmt:message key="login" />>

			<c:url var="url" value="/form/signup.jsp">
				<c:param name="action" value="../AddAccount"></c:param>
			</c:url>



			<a href="${url}"><fmt:message key="signupMessage" /> </a>

		</form>


	</div>
	<!-- /card-container -->
	<!-- /container -->
	<%@ include file="/bookstore/footer.jsp"%>
</body>
</html>