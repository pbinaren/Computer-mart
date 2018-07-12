
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="CR"
	value="${pageContext.request.contextPath}/resources/productimages" />
	<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>
	
<div class="container">
<div class="row">
<div class="col-xs-1"></div>
<div class="col-xs-10">
<c:if test="${empty(wishlist)}">
							<h2 class="jumbotron">Wishlist Is Empty</h2>
							<a href="${contextRoot}/products" class="btn button"><i class="fa fa-angle-left"></i> Continue Shopping</a>
							</c:if>
					<c:if test="${!empty(wishlist)}">
					
	<table id="cart" class="table table-hover table-condensed ">
    				<thead>
						<tr>
							<th style="width:50%">Product</th>
							<th style="width:10%">Price</th>
							<th style="width:10%"></th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="wl" items="${wishlist}">
						<tr>
							<td data-th="Product">
								<div class="row">
								
									<div class="col-sm-2 hidden-xs"><img src="${CR}/${wl.pid}.jpg" class="img-responsive"></div>
									<div class="col-sm-10">
										<h4 class="nomargin">${wl.pname}</h4>
										
									</div>
								</div>
							</td>
							<td data-th="Price">&#8377 ${wl.pprice}</td>
							<td class="actions" data-th="">
								<a href="${contextRoot}/deletewish/${wl.id}" class="btn button btn-sm"><i class="fa fa-trash-o"></i></a>								
							<a href="${contextRoot}/info/${wl.pid}" class="btn button btn-sm">Buy</a></td>
						</tr>
						</c:forEach>
						
					</tbody>
					
					<tfoot>
						
				
						<tr>
							<td><a href="${contextRoot}/products" class="btn button"><i class="fa fa-angle-left"></i> Continue Shopping</a></td>
							
							<td></td>
							
							<td colspan="2" class="hidden-xs"></td>
							</tr>
					</tfoot>
				</table>
				</c:if>
				</div>
<div class="col-xs-1"></div>
				</div>
</div>
