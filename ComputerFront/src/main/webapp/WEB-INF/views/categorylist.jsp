    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
<div class="container">
<div class="row">


<ol class="breadcrumb">

<li><a href="${contextRoot}/home">Home</a>
<li class="active">Manage Categories</li>
</ol>
	<br>
	<c:url value='/admin/setcategory' var="url"></c:url>
	<div class="container">
    <div class="row col-md-6 col-md-offset-2 custyle">
    <form:form class="form-horizontal" action='${url}' method="POST" modelAttribute="category">
  
  <div class="form-group">
  <c:if test="${status }">
  <span class="btn button1 form-control">Failed to process the data</span>
  </c:if>
  </div>
  <c:if test="${edit}">
		 			<div class="form-group"> 
		 				<label class="control-label" for="catid">Category Id</label> 
		 				<div class="controls"> 
		 					<form:input type="text" id="catid" name="catid" placeholder="" 
		 						class="form-control input-xlarge" path="cid" readonly="true"/>
		 				</div> 
		 			</div>
		</c:if>
    <div class="form-group">
      
      <label class="control-label"  for="catname">Category Name</label>
      <div class="controls">
        <form:input type="text" id="catname" name="catname" placeholder="" class="form-control input-xlarge" path="cname" />
        <form:errors path="cname" cssStyle="color:red"></form:errors>
        </div>
    </div>
 
    <div class="form-group">
      <label class="control-label"  for="submit"></label>
      <div class="controls">
        <input type="submit" id="submit" name="submit" class="btn button">
       <a href="${contextRoot}/admin/categories" class="btn button">Reset</a>
      </div>
    </div>
  
</form:form>
    <table class="table table-striped custab">
    <thead>
       <tr>
            <th>Category</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
    </thead>
    <c:forEach var="cl" items="${categorylist}">
            <tr>
                <td>${cl.cname}</td>
                <td><a class='btn button btn-xs' href="editcat/${cl.cid}"><span class="glyphicon glyphicon-edit"></span> Edit</a></td>
                <td><a href="delcat/${cl.cid}" class="btn button btn-xs"><span class="glyphicon glyphicon-remove"></span> Del</a></td>
            </tr>
            </c:forEach>
            </table>
    </div>
</div>

</div>


</div>




