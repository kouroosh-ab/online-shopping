<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />



<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<title>online shopping -${title }</title>
<script>
	window.menu = '${title}';
	window.contextRoot='${contextRoot}';
</script>


<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.css" rel="stylesheet">
<!-- Bootstrap readable theme -->
<link href="${css}/bootstrap-readable-theme.css" rel="stylesheet">
<!-- Bootstrap related data table -->
<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">

<!-- Add custom CSS here -->
<link href="${css}/myapp1.css" rel="stylesheet">

</head>

<body>
	<div class="wrapper">




		<div class="content">
			<!-- Navbar comes here -->
			<%@include file="./shared/navbar.jsp"%>
			<!-- Home.jsp comes here -->
			<c:if test="${userClickHome==true }">
				<%@include file="home.jsp"%>
			</c:if>


			<!-- Load only user clicks about  -->
			<c:if test="${userClickAbout==true}">
				<%@include file="about.jsp"%>
			</c:if>

			<!-- Load only user clicks contact -->
			<c:if test="${userClickContact==true}">
				<%@include file="contact.jsp"%>
			</c:if>

			<!-- Load only user clicks contact -->
			<c:if test="${userClickAllProducts==true or userClickCategoryProducts==true}">
				<%@include file="listproducts.jsp"%>
			</c:if>
			<!-- Load only user clicks view button -->
			<c:if test="${userClickShowProduct==true}">
				<%@include file="singleProduct.jsp"%>
			</c:if>

		</div>
		<!-- /.container -->

		<!-- Footer -->
		<%@include file="./shared/footer.jsp"%>
		<!-- /.container -->

		<!-- JavaScript -->
		<script src="${js}/jquery.js"></script>
		<script src="${js}/bootstrap.js"></script>
		<!-- Data table pluggin -->
		<script src="${js}/jquery.dataTables.js"></script>
		<!-- Data table bootstrap script -->
		<script src="${js}/dataTables.bootstrap.js"></script>
		<!-- Self coded java script -->
		<script src="${js}/myapp.js"></script>
	</div>

</body>

</html>
