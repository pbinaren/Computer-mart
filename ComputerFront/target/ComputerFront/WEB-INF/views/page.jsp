<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
    
    <c:set var="contextRoot" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<title>Computer Mart - ${title}</title>
<style>
html {
	height:100%;
}

body {
    padding-top: 70px;
    height:100%;
}


.carousel-inner img {
      width: 100%;
      height: 100%;
  }

.wrapper {	
	min-height:100%;
	position: relative;
}


.content {
	padding-bottom: 100px; /*height of the footer*/	
}

.navbar-custom {
	background-color:#47c9af;
    color:#ffffff;
  	border-radius:0;
  	min-height:50px
}
  
.navbar-custom .navbar-nav > li > a {
  	color:#fff;
  	padding-left:20px;
  	padding-right:20px;
}
.navbar-custom .navbar-nav > .active > a, .navbar-nav > .active > a:hover, .navbar-nav > .active > a:focus {
    color: #ffffff;
	background-color:transparent;
}
      
.navbar-custom .navbar-nav > li > a:hover, .nav > li > a:focus {
    text-decoration: none;
    background-color: #236457;
}
      
.navbar-custom .navbar-brand {
  	color:#eeeeee;
}
.navbar-custom .navbar-toggle {
  	background-color:#eeeeee;
}
.navbar-brand{
padding-top:0;
}
.footer {
   position: absolute;
   left: 0;
   bottom: 0;
   width: 100%;
   background-color: #47c9af;
   color: white;
   text-align: center;
}
.button{
background-color: #318C7A;
color: white;
}
.label-info{
background-color: #318C7A;
color: white;
}
</style>
</head>

    <%@ include file = "navbar.jsp" %>
<body>
<div class="wrapper">
<div class="content">
<c:if test="${userClickHome == true }">
<%@ include file="home.jsp" %>
</c:if>
<c:if test="${userClickAbout == true }">
<%@ include file="about.jsp" %>
</c:if>

<c:if test="${userClickContact == true }">
<%@ include file="contact.jsp" %>
</c:if>


<c:if test="${userClickProducts == true }">
<%@ include file="productgrid.jsp" %>
</c:if>


<c:if test="${userClickProdCat == true }">
<%@ include file="productgrid.jsp" %>	
</c:if>

<c:if test="${userClickManageCategory == true }">
<%@ include file="categorylist.jsp" %>
</c:if>


<c:if test="${userClickManageProducts == true }">
<%@ include file="productslist.jsp" %>
</c:if>

<c:if test="${userClickProductInfo == true }">
<%@ include file="product.jsp" %>
</c:if>

<c:if test="${userClickLogin == true }">
<%@ include file="login.jsp" %>
</c:if>

<c:if test="${userClickRegistration == true }">
<%@ include file="registration.jsp" %>
</c:if>

<c:if test="${userClickCart == true }">
<%@ include file="cart.jsp" %>
</c:if>

<c:if test="${userClickCheckOut == true }">
<%@ include file="address.jsp" %>
</c:if>

<c:if test="${userClickInvoice == true }">
<%@ include file="invoice.jsp" %>
</c:if>

</div>
<%@ include file="footer.jsp" %>
</div>
</body>
</html>