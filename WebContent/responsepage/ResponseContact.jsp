<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
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
							href="${pageContext.request.contextPath}/ListBookServlet">Trang
								chủ</a></li>
						<li class="breadcrumb-item"><a
							href="${pageContext.request.contextPath}/reponsepage/ResponseContact.jsp">Phản hồi
								</a></li>


					</ol>
				</nav>
			</div>
		</div>
	</div>
	<!--end header-->

<div class="container-fluit">
<p>Hi Mr./Ms. ${cusName}, email: ${cusEmail}</p>
<p>Thanks for your comments, we would like to acknowledge and improve them.</p>
</div>
	<!-- /card-container -->
	<!-- /container -->
	<%@ include file="/bookstore/footer.jsp"%>
</body>
</html>