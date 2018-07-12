
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>
<c:set var="CR"
	value="${pageContext.request.contextPath}/resources/productimages" />


<div class="container">
	<div class="row">

		<ol class="breadcrumb">

			<li><a href="${contextRoot}/home">Home</a>
			<li class="active">Orders</li>
		</ol>
		<c:if test="${empty(orderlist)}">
		<h2 class="jumbotron">No Orders </h2>
							<a href="${contextRoot}/products" class="btn button"><i class="fa fa-angle-left"></i> Get your first order</a>
							
		</c:if>
		<c:forEach var="o" items="${orderlist}" >
		<div class="panel panel-default">
    <div class="panel-heading"><a href="${contextRoot}/viewbill/${o.orderId}/${o.addid}" class="btn button">${o.orderId}</a></div>
    <div class="panel-body">
    
    <div class="col-md-1"><img src="${CR}/${o.pid}.jpg" class="img-responsive" width="50" height="50"></div>
    <div class="col-md-5">${o.pname}</div>
    <div class="col-md-1">${o.qty}</div>
    <div class="col-md-5">&#8377 ${o.subtotal}</div>
    
    </div>
    <div class="panel-footer">Ordered on ${o.date}</div>
  </div>
  </c:forEach>
</div>
</div>