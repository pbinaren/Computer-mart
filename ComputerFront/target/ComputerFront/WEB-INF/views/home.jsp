<!-- Important Owl stylesheet -->
<link rel="stylesheet" href="owl-carousel/owl.carousel.css">
 
<!-- Default Theme -->
<link rel="stylesheet" href="owl-carousel/owl.theme.css">
 
<!--  jQuery 1.7+  -->
<script src="jquery-1.9.1.min.js"></script>
 
<!-- Include js plugin -->
<script src="assets/owl-carousel/owl.carousel.js"></script>

<div class="container">


<div id="owl-example" class="owl-carousel">
<div id="myCarousel" class="carousel slide" data-ride="carousel">
            <!-- Indicators -->
            <ol class="carousel-indicators">
                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                <li data-target="#myCarousel" data-slide-to="1"></li>
                <li data-target="#myCarousel" data-slide-to="2"></li>
                <li data-target="#myCarousel" data-slide-to="3"></li>
                <li data-target="#myCarousel" data-slide-to="4"></li>
                <li data-target="#myCarousel" data-slide-to="5"></li>
                
            </ol>
            <div class="carousel-inner" role="listbox">
                <div class="item active">
                    <img class="first-slide home-image" src="resources/images/c5.jpg" alt="first slide" height="100%" width="100%">
                                    </div>
                <div class="item">
                    <img class="second-slide home-image" src="resources/images/c2.jpg" alt="Second slide" height="100%" width="100%">
                    </div>
                <div class="item">
                    <img class="third-slide home-image " src="resources/images/c3.jpg" alt="Third slide" height="100%" width="100%">
                </div>
                 <div class="item">
                    <img class="forth-slide home-image " src="resources/images/c4.jpg" alt="forth slide" height="100%" width="100%">
                </div>
                <div class="item">
                    <img class="fifth-slide home-image " src="resources/images/c6.jpg" alt="forth slide" height="100%" width="100%">
                </div>
                <div class="item">
                    <img class="sixth-slide home-image " src="resources/images/c7.jpg" alt="forth slide" height="100%" width="100%">
                </div>
                
            </div>
            <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right" ></span>
                <span class="sr-only">Next</span>
            </a>
            </div>
        </div><!-- /.carousel -->


      <!-- Jumbotron Header -->
      <header class="jumbotron my-4">
      <br>
        <h1 class="display-3">Mega Sale!</h1>
        <p class="lead">Offers on Desktop Computers. 25% off on all desktop computers. Limited period only. Get yours soon. Hurry!!!</p>
        <a href="${contextRoot}/products" class="btn btn-primary btn-lg">Buy Now</a>
      </header>

      <!-- Page Features -->
      <div class="row text-center">

        <div class="col-lg-3 col-md-6 mb-4">
          <div class="card">
            <img class="card-img-top" src="resources/images/8.jpg" alt="">
            <div class="card-body">
              <h4 class="card-title">Laptop Models</h4>
              <p class="card-text">Hp, Lenovo, Apple, Acer, Dell, Sony, Toshiba, Asus, Ibm thinkpad, Samsung</p>
            </div>
            <div class="card-footer">
              <a href="${contextRoot}/products" class="btn btn-primary">Find Out More!</a>
            </div>
          </div>
        </div>

        <div class="col-lg-3 col-md-6 mb-4">
          <div class="card">
            <img class="card-img-top" src="resources/images/5.jpg" alt="">
            <div class="card-body">
              <h4 class="card-title">Desktop Models</h4>
              <p class="card-text">Hp, Lenovo, Acer, Zenith, Dell, Apple, Wipro, Asus, IBM</p>
            </div>
            <div class="card-footer">
              <a href="${contextRoot}/products" class="btn btn-primary">Find Out More!</a>
            </div>
          </div>
        </div>

        <div class="col-lg-3 col-md-6 mb-4">
          <div class="card">
            <img class="card-img-top" src="resources/images/12.jpg" alt="">
            <div class="card-body">
              <h4 class="card-title">Desktop Accessories</h4>
              <p class="card-text">Keyboards, Mouse, Speakers, Webcams, UPS </p>
            </div>
            <div class="card-footer">
              <a href="${contextRoot}/products" class="btn btn-primary">Find Out More!</a>
            </div>
          </div>
        </div>

        <div class="col-lg-3 col-md-6 mb-4">
          <div class="card">
            <img class="card-img-top" src="resources/images/18.jpg" alt="">
            <div class="card-body">
              <h4 class="card-title">Laptop Accessories</h4>
              <p class="card-text">Laptop Batteries, HDMI Cables, Pendrives, External HDD</p>
            </div>
            <div class="card-footer">
              <a href="${contextRoot}/products" class="btn btn-primary">Find Out More!</a>
            </div>
          </div>
        </div>

      </div>
      <!-- /.row -->

    </div>
    <!-- /.container -->
    <script>
    $(document).ready(function() {
    	 
    	  $("#owl-example").owlCarousel();
    	 
    	});</script>