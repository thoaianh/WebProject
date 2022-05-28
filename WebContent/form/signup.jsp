<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setLocale value="${param.lang}" />
<fmt:setBundle basename="resources.messages" />

<!DOCTYPE html>
<html lang="${param.lang}">
<head>
<title>Sign up</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" media="all" />
<link href="${pageContext.request.contextPath}/css/signup.css"
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
							href="${pageContext.request.contextPath}/ListBookServlet"><fmt:message
									key="home" /></a></li>
						<li class="breadcrumb-item"><a
							href="${pageContext.request.contextPath}/CheckLogin"><fmt:message
									key="login" /></a></li>
						<li class="breadcrumb-item"><a
							href="${pageContext.request.contextPath}/signup.jsp"><fmt:message
									key="signup" /></a></li>


					</ol>
				</nav>
			</div>
		</div>
	</div>
	<!--end header-->


	<!--Sign up-->
	<div class="container-fluit">
		<div class="row">
			<div class="col-md-6">
				<form id="fileForm"
					action="${pageContext.request.contextPath}/AddAccount"
					method="post">
					<h3 style="text-align: center;">
						<fmt:message key="signup" />
					</h3>
					<br>
					<div class="form-group">
						<label for="username"><span class="req">* </span> <fmt:message
								key="username" />: </label> <input class="form-control" type="text"
							name="name" id="txt" required />
						<div id="errLast"></div>
					</div>

					<div class="form-group">
						<label for="phonenumber"><span class="req">* </span> <fmt:message
								key="phone" />: </label> <input required type="text" name="phone"
							id="phone" class="form-control phone" maxlength="28"
							onkeyup="validatephone(this);" placeholder="" />
						<h5>${phoneErr}</h5>
					</div>



					<div class="form-group">
						<label for="email"><span class="req">* </span> <fmt:message
								key="email" />: </label> <input class="form-control" required
							type="email" name="email" id="email"
							onchange="email_validate(this.value);" />
						<h5>${emailErr}</h5>
						<div class="status" id="status"></div>
					</div>

					<div class="form-group">
						<label for="addr"><span class="req">* </span> <fmt:message
								key="address" />: </label> <input class="form-control" required
							type="text" name="address" id="address" />
						<div class="status" id="status"></div>
					</div>



					<div class="form-group">
						<label for="password"><span class="req">* </span> <fmt:message
								key="pwd" />: </label> <input required name="password" type="password"
							class="form-control inputpass" minlength="4" maxlength="16" />

					</div>
					<%
						String userRole = (String) session.getAttribute("userRole");
						if (userRole != null) {
					%>
					<div class="form-group">
						<label for=""><span class="req">* </span> <fmt:message
								key="role" />: </label> <input class="form-control" required
							type="text" name="role" id="address" value="admin" />
						<div class="status" id="status"></div>
					</div>
					<%
						}
					%>
					<input class="btn btn-success" type="submit"
						value=<fmt:message
									key="submit" />
						style="margin-left: 180px">


				</form>

			</div>
		</div>
	</div>
	<%@ include file="/bookstore/footer.jsp"%>
</body>
</html>