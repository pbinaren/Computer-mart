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
                    <label class="control-label" >New User?</label><br>
                    <a href="${contextRoot}/registration" class="btn button">Sign Up</a>
                </form>
            </div>
            
        </div>
    </div>
</div>


