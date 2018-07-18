<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>
<spring:url var="images" value="/resources/images"/>

<div class="container">
    <div class="row">
        <div class="col-sm-6 col-md-4 col-md-offset-4">
            <div class="account-wall">
            <c:if test="${loginerror }">
				<span class="alert alert-danger">Invalid email/password</span>
			</c:if>
			
            <c:if test="${regsuccess}">
				<span class="alert alert-success">Registered Successfully</span>
			</c:if>
                <img class="profile-img" src="${images}/logo.jpg"
                    height="100px" width="350px">
                <form class="form-signin" action='<c:url value='/perform_login'></c:url>' method="POST">
                <div class="form-group">
                <label class="control-label" >Enter Email</label>
                <input type="text" id="j_username" name="j_username" class="form-control" placeholder="Email" required autofocus>
                </div>
                <div class="form-group">
                <label class="control-label" >Enter Password</label>
                <input type="password" id="j_password" name="j_password"  class="form-control" placeholder="Password" required>
                </div>
                <button class="btn button " type="submit">
                    Sign in</button><br>
                    <label class="control-label" >New User?</label>
                    <a href="${contextRoot}/registration">Sign Up</a>
                </form>
                    <a data-toggle="modal" data-target="#myModal">Forgot Password?</a>
            </div>
            <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Password Rest</h4>
        </div>
        <div class="modal-body">
                <form class="form-signin" action='<c:url value='/resetpassword'></c:url>' method="POST">
                <div class="form-group">
                <label class="control-label" >Enter Email</label>
                <input type="text" id="j_username" name="j_username" class="form-control" placeholder="Email" required autofocus>
                </div>
                <button class="btn button " type="submit">
                    Reset</button><br>
               </form>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>
  
            
        </div>
    </div>
</div>


