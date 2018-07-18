
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="CR"
	value="${pageContext.request.contextPath}/resources/productimages" />

<div class="container">


	<div class="row">
		<div class="col-sm-5 ">

			<div>
				<img src="${CR}/${product.id}.jpg" width="300px" height="300px">
			</div>
		</div>
		<div class="col-sm-7">
			<div class="card-body p-5">
				<h3 class="title mb-3">${product.name}</h3>

				<p class="price-detail-wrap">
					<span class="price h3 text-warning"> <span class="currency">&#8377</span><span
						class="num">${product.price}</span>
					</span>
				</p>
				<!-- price-detail-wrap .// -->
				<dl class="item-property">
					<dt>Description</dt>
					<dd>
						<p>${product.description}</p>
					</dd>
				</dl>
				<!-- item-property-hor .// -->
				<dl class="param param-feature">
					<dt>Color</dt>
					<dd>Black and white</dd>
				</dl>
				<!-- item-property-hor .// -->
				<dl class="param param-feature">
					<dt>Delivery</dt>
					<dd>Free Shipping And COD For Coimbatore, Chennai AND
						Bangalore</dd>
				</dl>
<c:if test="${product.quantity != 0}">
				<label>Enter Quantity</label> <input type="number" min="1" max="5"
					name="upqty" id="upqty" class="text-center" value="1"></c:if>
				<p id="demo"></p>
				<br>
				<c:if test="${msg}">
					<span class="alert alert-danger">Requested quantity not
						available</span>
				</c:if>
				<br>
				<hr>
				<c:if test="${product.quantity == 0 }">
					<span class="btn button">Out of stock</span>
				</c:if>
				
					<a href="${contextRoot}/products" class="btn button">Continue
						Shopping</a>
						<c:if test="${product.quantity != 0}">
					<button type="button" name="refreshcart" id="refreshcart"
						onclick='setURL()' value="${product.id}" class="btn button">
						<span class="glyphicon glyphicon-shopping-cart"></span>Add to Cart
					</button>
					</c:if>
					<a href="${contextRoot}/cart/addwish/${product.id}"
						class="btn button"> <span class="glyphicon glyphicon-heart"></span>Add
						to Wishlist
					</a>
			</div>
			<!-- card-body.// -->
		</div>
		<!-- col.// -->
	</div>
	<!-- row.// -->


</div>
<script>
	$('button[name="refreshcart"]').click(
			function() {
				var text;
				var count = $('#upqty');
				orgcount = count.attr('value');

				var pid = document.getElementById("refreshcart").value;
				console.log(pid);
				var qnty = document.getElementById("upqty").value;
				if (qnty<1 || qnty>5) {
					count.val(orgcount);
					text = "Min 1/Max 5";

				} else {
					text = "";
					var url = "http://localhost:8080/ComputerFront/addprod/"
							+ pid + "?qnty=" + qnty;
					window.location.href = url;
				}
				document.getElementById("demo").innerHTML = text;

			});
</script>