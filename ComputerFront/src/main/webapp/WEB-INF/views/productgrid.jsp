<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="CR"
	value="${pageContext.request.contextPath}/resources/productimages" />
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<div class="container">
	<div class="row">

		<ol class="breadcrumb">

			<li><a href="${contextRoot}/home">Home</a>
			<li class="active">Products</li>
		</ol>

		<div class="col-md-12">
			<c:forEach var="pl" items="${productlist}">

				<div class="col-sm-6 col-md-4">
					<div class="thumbnail">
						<h4 class="text-center">
							<span class="label label-info">${pl.name}</span>
						</h4>
						<img src="${CR}/${pl.id}.jpg" class="img-responsive">

						<div class="caption">
							<div class="row">
								<div class="col-md-6">
									<h4 class="text-center">&#8377 ${pl.price} /-</h4>

								</div>

								<div class="col-md-6">
								
									<a href='${contextRoot}/info/${pl.id}'
										class="btn button"><span
										class="glyphicon glyphicon-info-sign"></span> Info</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
</div>
</div>