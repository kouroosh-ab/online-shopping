<div class="container">

	<div class="row">


		<!-- would be to display sidebar -->
		<div class="col-md-3">
			<%@include file="./shared/sidebar.jsp"%>
		</div>

		<!-- Display the actual products -->
		<div class="row-md-9">
			<!-- adding breadcrumb component -->
			<div class="row">
				<div class="col-xlg-12">
					<c:if test="${userClickAllProducts==true}">
						<ol class="breadcrumb">
							<li><a href="${contextRoom}/home">Home</a></li>
							<li class="active">All Products</li>
						</ol>

					</c:if>
					<c:if test="${userClickCategoryProducts==true}">
						<ol class="breadcrumb">
							<li><a href="${contextRoom}/home">Home</a></li>
							<li class="active">Category</li>
							<li class="active">${category.name}</li>
						</ol>

					</c:if>
				</div>
			</div>
		</div>
	</div>
</div>