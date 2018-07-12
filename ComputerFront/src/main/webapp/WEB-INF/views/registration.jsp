
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:url value='/addcustomer' var="url"></c:url>

<div class="container">
	<div class="row">
		<div class="form-signin">
			<c:if test="${status }">
				<span class="alert alert-danger">Failed to process the data</span>
			</c:if>
		</div>

		<div class="col-sm-6 col-md-4 col-md-offset-4">
			<div class="account-wall">

				<form:form class="form-signin" method="post"
					modelAttribute="customer" action="${url}">
					<div class="form-group">
						<label class="control-label">Enter Name</label>
						<div class="controls">
							<form:input type="text" class="form-control" placeholder="Name"
								path="name" />
							<form:errors path="name" cssStyle="color:red"></form:errors>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label">Enter Email</label>
						<div class="controls">
							<form:input type="text" id="usename" name="usename"
								class="form-control" placeholder="Email" path="EmailId" />
							<form:errors path="EmailId" cssStyle="color:red"></form:errors>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label">Enter Password</label>
						<div class="controls">
							<form:input type="password" id="userpassword" name="userpassword"
								class="form-control" placeholder="Password" path="passsword" />
							<form:errors path="passsword" cssStyle="color:red"></form:errors>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label">Enter Phone Number</label>
						<div class="controls">
							<form:input type="text" class="form-control"
								placeholder="Phone Number" path="phoneNumber" />
							<form:errors path="phoneNumber" cssStyle="color:red"></form:errors>
						</div>
					</div>
					<button class="btn button" type="submit">Submit</button>
				</form:form>
			</div>

		</div>
	</div>
</div>





