<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<c:set var="contextRoot" value="${pageContext.request.contextPath }" />


<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Online Shopping - ${title}</title>


<script type="text/javascript">
	window.menu = '${title}';
	window.contextRoot='${contextRoot}'
</script>
<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Bootstrap cearulean theme CSS -->
<link href="${css}/cearulean-bootstrap-theme.css" rel="stylesheet">

<!-- Bootstrap data tables CSS -->
<link href="${css}/dataTables.bootstrap4.css" rel="stylesheet">

<!-- Bootstrap data tables CSS -->
<link href="${css}/web-fonts-with-css/css/fontawesome-all.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${css}/myapp.css" rel="stylesheet">

</head>

<body>

	<div class="wrapper">

		<!-- Navigation -->

		<%@include file="./shared/navbar.jsp"%>

		<!-- Index Content -->
		<div class="content">


			<!-- Load only when Home clicked -->
			<c:if test="${userClickHome == true }">
				<%@include file="home.jsp"%>
			</c:if>

			<!-- Load only when About clicked -->
			<c:if test="${userClickAbout == true }">
				<%@include file="about.jsp"%>
			</c:if>

			<!-- Load only when Contact clicked -->
			<c:if test="${userClickContact == true }">
				<%@include file="contact.jsp"%>
			</c:if>
			
			<!-- Load only when All products  clicked -->
			<c:if test="${userClickAllProducts == true or userClickCategoryProducts==true}">
				<%@include file="listProducts.jsp"%>
			</c:if>
			
			<!-- Load only when user click show products  clicked -->
			<c:if test="${userClickShowProduct == true}">
				<%@include file="singleProduct.jsp"%>
			</c:if>

		</div>
		<!-- /.container -->

		<!-- Footer -->

		<%@include file="./shared/footer.jsp"%>

		<!-- Bootstrap core JavaScript -->
		<script src="${js}/jquery.js"></script>
		<script src="${js}/bootstrap.bundle.min.js"></script>
		
		<!-- Data table plugin -->
		<script src="${js}/jquery.dataTables.js"></script>
		
		<!-- Data table plugin -->
		<script src="${js}/dataTables.bootstrap4.js"></script>
		
		<script src="${js}/myApp.js"></script>
	</div>
</body>

</html>
