
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="CR"
	value="${pageContext.request.contextPath}/resources/productimages" />
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<div class="container">
	<div class="row">


		<ol class="breadcrumb">

			<li><a href="${contextRoot}/home">Home</a>
			<li class="active">Manage Products</li>
		</ol>
		<br>
		<c:url value='/admin/setproduct' var="url"></c:url>

		<div class="row col-md-6 col-md-offset-2 custyle">
			<form:form class="form-horizontal" method="post"
				modelAttribute="product" action="${url}"
				enctype="multipart/form-data">
				<c:if test="${edit}">
					<div class="form-group">
						<label class="control-label" for="catid">Product Id</label>
						<div class="controls">
							<form:input type="text" class="form-control input-xlarge"
								path="id" readonly="true" />
						</div>
					</div>
				</c:if>

				<div class="form-group">
					<c:if test="${status }">
						<span class="btn button1 form-control">Failed to process
							the data</span>
					</c:if>
					<form:label class="control-label" path="name">Enter Product Name</form:label>
					<div class="controls">
						<form:input class="form-control input-xlarge" path="name" />
						<form:errors path="name" cssStyle="color:red"></form:errors>
					</div>
				</div>
				<div class="form-group">
					<form:label path="description">Enter Product Desription</form:label>
					<div class="controls">
						<form:input class="form-control input-xlarge" path="description" />
						<form:errors path="description" cssStyle="color:red"></form:errors>
					</div>
				</div>

				<div class="form-group">
					<form:label path="price">Enter Price &#8377</form:label>
					<div class="controls">
						<form:input class="form-control input-xlarge" path="price" />
						<form:errors path="price" cssStyle="color:red"></form:errors>
					</div>
				</div>

				<div class="form-group">
					<form:label path="quantity">Enter Quantity</form:label>
					<div class="controls">
						<form:input class="form-control input-xlarge" path="quantity" />
						<form:errors path="quantity" cssStyle="color:red"></form:errors>
					</div>
				</div>
				<div class="form-group">
					<label>Category</label>
					<form:select path="cid" class="form-control input-xlarge">
						<c:forEach items="${categorylist}" var="cat">
							<div class="controls">
								<form:option class="form-control input-xlarge"
									value="${cat.cid}">${cat.cname}</form:option>
							</div>
						</c:forEach>
					</form:select>
				</div>
				<c:if test="${edit == false}">
					<div class="form-group">
						<form:input class="form-control input-xlarge" type="file"
							name="fileToUpload" id="fileToUpload" path="image"
							required="true"></form:input>
					</div>
				</c:if>
				<c:if test="${edit == true}">
					<div class="form-group">
						<form:input class="form-control input-xlarge" type="file"
							name="fileToUpload" id="fileToUpload" path="image"></form:input>
					</div>

				</c:if>
				<div class="form-group">
					<input type="submit" class="btn button"> <a
						href="${contextRoot}/admin/products" class="btn button">Reset</a>
				</div>


			</form:form>
		</div>
		<table class="table table-striped custab">
			<thead>
				<tr>
					<th>Image</th>
					<th>Product Details</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
			</thead>
			<c:forEach var="pl" items="${productlist}">
				<tr>
					<td><img src="${CR}/${pl.id}.jpg" width="100" height="100" /></td>
					<td>
						<ul>
							<li>Product Name ${pl.name}</li>
							<li>Product Description ${pl.description}</li>
							<li>Price &#8377 ${pl.price} /-</li>
							<li>Quantity ${pl.quantity}</li>
						</ul>
					</td>
					<td><a class='btn button btn-xs' href="editprod/${pl.id}"><span
							class="glyphicon glyphicon-edit"></span> Edit</a></td>
					<td><a href="delprod/${pl.id}" class="btn button btn-xs"><span
							class="glyphicon glyphicon-remove"></span> Del</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>







