<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />

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
	window.contextRoot = '${contextRoot}'
</script>
<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Bootstrap cearulean theme CSS -->
<link href="${css}/cearulean-bootstrap-theme.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${css}/myapp.css" rel="stylesheet">

</head>

<body>

	<div class="wrapper">

		<!-- Header -->

		<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
			<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="${contextRoot}/home">Online
					Shopping</a></div>
			</div>
		</nav>

		<!-- Index Content -->
		<div class="content">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<div class="jumbotron">
							<h1>${errorTitle}</h1>
							<hr/>
							<blockquote>
							
								${errorDescription}
							
							</blockquote>

						</div>

					</div>
				</div>

			</div>



		</div>
		<!-- /.container -->

		<!-- Footer -->

		<%@include file="./shared/footer.jsp"%>

	</div>
</body>

</html>
