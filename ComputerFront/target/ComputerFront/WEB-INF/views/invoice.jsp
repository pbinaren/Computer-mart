
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="CR"
	value="${pageContext.request.contextPath}/resources/productimages" />
	
<div class="row">
	<div class="col-lg-8 col-md-8 col-sm-8 col-lg-offset-2">
		<div class="panel panel-default main">
		    <div class="panel-body">
		        <div class="row">
		                <h1 class="text-center">Invoice</h1>
		        </div>
		        <!--row-->
		        
		        <hr>
		        <div class="row">
		            <div class="col-lg-8 col-md-8 col-sm-8">
		                <h3>To</h3>
		                <p></p>
		                <p class="offset-margin">${baddress.addressLine1 }</p>
		                <p class="offset-margin">${baddress.addressLine2 }</p>
	            </div>
		            <c:forEach var="o" items="${orderdetail}" begin="0" end="0">
		            <div class="col-lg-4 col-md-4 col-sm-4">
		                <p><label>Order#:</label> ${o.orderId}</p>
		                <p><label>Order Date:</label>${o.date}</p>

		            </div>
		            </c:forEach>
		        </div>
		        <!--row-->
		        
		        
		        <div class="row">
		            <div class="col-lg-10 col-md-10 col-sm-10 col-lg-offset-1 col-md-offset-1 col-sm-offset-1 content">
		                <div class="panel panel-default">
		                    <!--<div class="panel-heading">-->
                		    <!--    <h1 class="panel-title">Invoice Details</h1>-->
                		    <!--</div>-->
		                    <div class="panel-body">
		                        <div class="row">
    		                        <div class=" col-lg-12 col-md-12 col-sm-12 description">
            		              <table class="table">
                                    <thead>
                                      <tr>
                                        <th></th>
                                        <th>Product Name</th>
                                        <th>Qty</th>
                                        <th>Price</th>
                                      </tr>
                                    </thead>
                                    <tbody>
                                    <c:set var="totalPrice" value="0"></c:set>
                    <c:forEach var="o" items="${orderdetail}" >                
                                      <tr>
                                     
                                        <td><img src="${CR}/${o.pid}.jpg" class="img-responsive" width="100" height="100"></td>
                                        <td> ${o.pname}</td>
                                        <td>${o.qty}</td>
                                        <td>${o.subtotal}</td>
                                        <c:set var="totalPrice" value="${totalPrice + o.subtotal}"></c:set>
                                      </tr>
                                      </c:forEach>
                                    </tbody>
                                  </table>
    		                            
    		                         
    		                       </div>
    		                       
    		                       <div class="col-lg-8 pull-left" style="border-top:solid #ddd 1px;"></div>
    		                        
        		                        <div class="col-lg-4 col-md-4 col-sm-4 pull-right blank">
        		                            
        		                  <table class="table table bordered">
        		                      <tbody>
        		                       <tr style="background-color:#eee;">
		                                    <td><label>Total:</label><span class="pull-right">&#8377 ${totalPrice }</span></td>
		                                </tr>
        		                      </tbody>

		                            </table>
        		                        </div>
    		                        </div>
		                        <!--row-->
		                    </div>
		                    
		                </div>
		            </div>
		        </div>
		        
		        
		    </div>
		    
		</div>
	</div>
</div>