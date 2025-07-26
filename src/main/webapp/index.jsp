 
<%@page import="java.util.ArrayList"%>
 
 
<%@page import="java.util.List"%> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
 
<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Real Time Product Tracking and Notification System</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Favicons -->
  <link href="assets/img/favicon.png" rel="icon">
  <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="assets/vendor/icofont/icofont.min.css" rel="stylesheet">
  <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="assets/vendor/venobox/venobox.css" rel="stylesheet">
  <link href="assets/vendor/owl.carousel/assets/owl.carousel.min.css" rel="stylesheet">
  <link href="assets/vendor/aos/aos.css" rel="stylesheet">

  <!-- Template Main CSS File -->
  <link href="assets/css/style.css" rel="stylesheet">
<!-- Start WOWSlider.com HEAD section --> <!-- add to the <head> of your page -->
	<link rel="stylesheet" type="text/css" href="engine1/style.css" />
	<script type="text/javascript" src="engine1/jquery.js"></script>
	<!-- End WOWSlider.com HEAD section -->
    
<script language="Javascript" type="text/javascript">
 

function createRequestObject() {
    var tmpXmlHttpObject;
    if (window.XMLHttpRequest) {
            tmpXmlHttpObject = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        tmpXmlHttpObject = new ActiveXObject("Microsoft.XMLHTTP");
    }

    return tmpXmlHttpObject;
}


var http = createRequestObject();

function makeGetRequest(st) {
   // st=document.frm.state.value;
   
    http.open('get', 'Districts?state=' + st);
    http.onreadystatechange = processResponse;
    http.send(null);
}

function processResponse() {
    if(http.readyState == 4){
        var response = http.responseText;
        document.getElementById('districts').innerHTML = response;
    }
}
function makeGetRequest_rec(st) {
	   // st=document.frm.state.value;
	   
	    http.open('get', 'Districts_rec?state=' + st);
	    http.onreadystatechange = processResponse_rec;
	    http.send(null);
	}

	function processResponse_rec() {
	    if(http.readyState == 4){
	        var response = http.responseText;
	        document.getElementById('rec_districts').innerHTML = response;
	    }
	}
function makeGetRequest_taluka(district) {
	    st=document.frm.state.value;
	   //alert(st);
	    http.open('get', 'Taluka?district=' + district+'&state='+st);
	    http.onreadystatechange = processResponse_taluka;
	    http.send(null);
	}

	function processResponse_taluka() {
	    if(http.readyState == 4){
	        var response = http.responseText;
	        document.getElementById('taluka').innerHTML = response;
	    }
	}
	function makeGetRequest_taluka_rec(district) {
	    st=document.frm.rec_state.value;
	   //alert(st);
	    http.open('get', 'Taluka_rec?district=' + district+'&state='+st);
	    http.onreadystatechange = processResponse_taluka_rec;
	    http.send(null);
	}

	function processResponse_taluka_rec() {
	    if(http.readyState == 4){
	        var response = http.responseText;
	        document.getElementById('rec_taluka').innerHTML = response;
	    }
	}
	function makeGetRequest_locality(taluka) {
		   st=document.frm.state.value;
		   dist=document.frm.district.value;
		    
		  //  alert(st);
		  //  alert(dist);
		    http.open('get', 'Locality?taluka='+taluka+'&state='+st+'&district=' + dist);
		    http.onreadystatechange = processResponse_locality;
		    http.send(null);
		}

		function processResponse_locality() {
		    if(http.readyState == 4){
		        var response = http.responseText;
		        document.getElementById('locality').innerHTML = response;
		    }
		}
		function makeGetRequest_locality_rec(taluka) {
			   st=document.frm.rec_state.value;
			   dist=document.frm.rec_district.value;
			    
			   // alert(st);
			  //  alert(dist);
			    http.open('get', 'Locality_rec?taluka='+taluka+'&state='+st+'&district=' + dist);
			    http.onreadystatechange = processResponse_locality_rec;
			    http.send(null);
			}

			function processResponse_locality_rec() {
			    if(http.readyState == 4){
			        var response = http.responseText;
			        document.getElementById('rec_locality').innerHTML = response;
			    }
			}
			function makeGetRequest_pincode_rec(locality) {
			    st=document.frm.rec_state.value;
			    taluka=document.frm.rec_taluka.value;
				dist=document.frm.rec_district.value;
			   // alert(locality);
			    http.open('get', 'Pincode_rec?locality=' + locality+'&taluka=' + taluka+'&state=' + st+'&district=' + dist);
			    http.onreadystatechange = processResponse_Pincode_rec;
			    http.send(null);
			}

			function processResponse_Pincode_rec() {
			    if(http.readyState == 4){
			        var response = http.responseText;
			        document.getElementById('rec_pincodes').innerHTML = response;
			    }
			}
		function makeGetRequest_pincode(locality) {
			    st=document.frm.state.value;
			    taluka=document.frm.taluka.value;
				dist=document.frm.district.value;
			   // alert(locality);
			    http.open('get', 'Pincode?locality=' + locality+'&taluka=' + taluka+'&state=' + st+'&district=' + dist);
			    http.onreadystatechange = processResponse_Pincode;
			    http.send(null);
			}

			function processResponse_Pincode() {
			    if(http.readyState == 4){
			        var response = http.responseText;
			        document.getElementById('pincodes').innerHTML = response;
			    }
			}
			function makeGetRequest_PO(event) {
				 event.preventDefault(); 
				// alert("in po");
			   // st=document.frm.rec_state.value;
			  //  taluka=document.frm.rec_taluka.value;
				//dist=document.frm.rec_district.value;
				locality=document.frm.locality.value;
				//alert(locality);
				pincode="NA"
				if(locality=="other")
					{
					locality=document.frm.locality1.value;
					pincode=document.frm.pincode1.value
					}
				else
					{
					locality=document.frm.locality.value;
					pincode=document.frm.pincode.value
					}
			   //  alert(pincode);
			    http.open('get', 'GetPO?locality=' + locality+'&taluka=' + taluka+'&state=' + st+'&district=' + dist+'&pincode='+pincode);
			    http.onreadystatechange = processResponse_GetPO;
			    http.send(null);
			}

			function processResponse_GetPO() {
			    if(http.readyState == 4){
			        var response = http.responseText;
			        document.getElementById('sender_po').innerHTML = response;
			    }
			}
			function makeGetRequest_PO_Rec(event) {
				 event.preventDefault(); 
				 //alert("in po");
			    st=document.frm.rec_state.value;
			    taluka=document.frm.rec_taluka.value;
				dist=document.frm.rec_district.value;
				locality=document.frm.rec_locality.value;
				addr=document.frm.rec_addr.value;
				//alert(locality);
				pincode="NA"
				if(locality=="other")
					{
					locality1="other";
					locality=document.frm.rec_locality1.value;
					pincode=document.frm.rec_pincode1.value
					}
				else
					{
					locality=document.frm.rec_locality.value;
					locality1=document.frm.rec_locality.value;
					pincode=document.frm.rec_pincode.value
					}
			     alert(pincode);
			    http.open('get', 'GetPO_Rec.jsp?addr='+addr+'&locality1=' + locality1+'&locality=' + locality+'&taluka=' + taluka+'&state=' + st+'&district=' + dist+'&pincode='+pincode);
			    http.onreadystatechange = processResponse_GetPO_Rec;
			    http.send(null);
			}

			function processResponse_GetPO_Rec() {
			    if(http.readyState == 4){
			        var response = http.responseText;
			        document.getElementById('rec_po').innerHTML = response;
			    }
			}
			function makeGetRequest1_otp(event) {
				event.preventDefault(); 
				 email=document.frmotp.email_otp.value;
				    custtype=document.frmotp.custType.value;
				   // alert(email);
				    
				   // alert(custtype);
				   //custtype="sender";
					http.open('get', '/sendOTP?email=' + email+'&custtype='+custtype);
					http.onreadystatechange = processResponse1;
					http.send(null);
				}
				
				function processResponse1() {
					if(http.readyState == 4){
						var response = http.responseText;
						if(response.includes("OTP Sending Failed, Please try Again!!"))
						{
							//alert("yes")
							document.getElementById('email_otp').value=""
						}
						document.getElementById('otp').innerHTML = response;
					}
				}
</script>
 <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
      <style>
        body {
            background: linear-gradient(to right, #6F4E37, #D2B48C); /* Coffee Gradient */
            color: white;
            font-family: 'Arial', sans-serif;
        }

        .gallery-section {
            text-align: center;
            padding: 50px 20px;
        }

        .gallery-section h2 {
            font-size: 36px;
            font-weight: bold;
            text-transform: uppercase;
            margin-bottom: 20px;
        }

        .carousel-inner img {
            width: 100%;
            height: 500px;
            object-fit: cover;
            border-radius: 15px;
            box-shadow: 0 10px 20px rgba(0, 0, 0, 0.3);
        }

        .carousel-control-prev, .carousel-control-next {
            filter: invert(100%);
        }
    </style>
</head>

<body>
<% // NearestLocalityService.main();
String filepath1=request.getServletContext().getRealPath("/");

//QRCodeAndAddressSticker.main(filepath1);
 //String filepath=request.getServletContext().getRealPath("/");
			 
//GMailer gobj=new GMailer(filepath1);
//gobj.sendMail("test", "hi", "acaprojects1415@gmail.com");
%>
  <!-- ======= Mobile nav toggle button ======= -->
  <button type="button" class="mobile-nav-toggle d-xl-none"><i class="icofont-navigation-menu"></i></button>

  <!-- ======= Header ======= -->
  <header id="header">
    <div class="d-flex flex-column">

      <div class="profile">
        <img src="images/logo.png" alt=""  width="90%" class="img-fluid rounded-circle">
        <h1 class="text-light"><a href="/home">Real Time Product Tracking and Notification System</a></h1>
         
      </div>

      <nav class="nav-menu">
        <ul>
          <li class="active"><a href="#hero"><i class="bx bx-home"></i> <span>Home</span></a></li>
          <li><a href="#about"><i class="bx bx-file-blank"></i> <span>About Us</span></a></li>
         <li><a href="#skills"><i class="bx bx-user"></i> <span>Login</span></a></li>
          <li><a href="#services"><i class="bx bx-server"></i>Services</a></li>
          <li><a href="#gallery"><i class="bx bx-server"></i>Gallery</a></li>
         
        </ul>
      </nav><!-- .nav-menu -->
      <button type="button" class="mobile-nav-toggle d-xl-none"><i class="icofont-navigation-menu"></i></button>

    </div>
  </header><!-- End Header -->
<div class="body"> 
	
  <!-- ======= Hero Section ======= -->
  <section id="hero1" class="d-flex flex-column justify-content-center align-items-center services-section" style="background: linear-gradient(135deg, #C19A6B, #FAE3C6);!important">
     <div class="hero-container" data-aos="fade-in">
   
   <!-- Start WOWSlider.com BODY section --> <!-- add to the <body> of your page -->
	<div id="wowslider-container1">
	<div class="ws_images"><ul>
		<li><a href="#"><img src="data1/images/2.jpg" alt="bootstrap slideshow" title="Real Time Product Tracking and Notification System" id="wows1_0"/></a></li>
		<li><img src="data1/images/logo.jpg"  alt="Parcel Tracking System" title="Parcel Tracking System" id="wows1_1"/></li>
	</ul></div>
	<div class="ws_bullets"><div>
		<a href="#" title="Real Time Product Tracking and Notification System"><span><img src="data1/tooltips/2.jpg" alt="Real Time Product Tracking and Notification System"/>1</span></a>
		<a href="#" title="Stocks Tracking and Expiry Tracking System"><span><img src="data1/tooltips/logo.jpg" alt="Parcel Tracking System"/>2</span></a>
	</div></div><div class="ws_script" style="position:absolute;left:-99%"><a href="#"> </a>  </div>
	<div class="ws_shadow"></div>
	</div>	
	<script type="text/javascript" src="engine1/wowslider.js"></script>
	<script type="text/javascript" src="engine1/script.js"></script>
	<!-- End WOWSlider.com BODY section -->
      <h1 class="h1style">Real Time Product Tracking and Notification System</h1>
      <p>  <span class="typed" data-typed-items="Online Products Tracking System with expiry and low stock levels notifications"></span></p>
  </div></section><!-- End Hero -->

  <main id="main">

     <!-- Welcome Section -->
    <section id="about" class="welcome-section">
        <div class="container">
            <h2>Welcome to Our Grocery Store</h2>
            <p>Providing fresh, high-quality groceries with a seamless shopping experience.</p>
        </div>
     
        <div class="row g-4">
            <div class="col-md-4">
                <div class="feature-box">
                    <i class="fas fa-shopping-basket"></i>
                    <h4>Wide Product Range</h4>
                    <p>We offer a variety of fresh and packaged goods to meet all your grocery needs.</p>
                </div>
            </div>
            <div class="col-md-4">
                <div class="feature-box">
                    <i class="fas fa-truck"></i>
                    <h4>Fast Delivery</h4>
                    <p>Get your groceries delivered quickly and efficiently to your doorstep.</p>
                </div>
            </div>
            <div class="col-md-4">
                <div class="feature-box">
                    <i class="fas fa-leaf"></i>
                    <h4>Fresh & Organic</h4>
                    <p>We prioritize fresh, organic, and high-quality ingredients for a healthier lifestyle.</p>
                </div>
            </div>
        </div>
    </section>
    
    <!-- ======= Skills Section ======= -->
    <section id="skills" class="skills section-bg">
      <div class="container">

       

        <div class="row skills-content">
<div class="col-lg-6" data-aos="fade-up" data-aos-delay="100">
			<img src="assets/img/login.jpg" width="70%"/>
             

          </div>

          <div class="col-lg-6" data-aos="fade-up">
 <h2>Login</h2>
            <form action="login" method="post">
                  <table class="tblform">
                      <tr>
                          <td>Userid</td>
                          <td>
                              <input type="text" name="txtuserid" required class="form-control" />
                          </td>
                      </tr>
                      <tr>
                          <td>Password</td>
                          <td>
                              <input type="password" name="txtpass" required class="form-control" />
                          </td>
                      </tr>
                      <tr>
                          <td colspan="2">
                          <input type="submit" value="Submit" class="btn btn-primary"/>
                          </td>
                      </tr>
                  </table>
              </form>

          </div>

          
        </div>

      </div>
    </section><!-- End Skills Section -->
     <section id="services" class="services-section">
        <h2>Our Services</h2>
        <div class="services-container">

            <div class="service-box">
                <i class="fas fa-box"></i>
                <h3>Real-Time Inventory Tracking</h3>
                <p>Monitor stock levels in real-time and prevent shortages or overstocking.</p>
            </div>

            <div class="service-box">
                <i class="fas fa-exclamation-triangle"></i>
                <h3>Expiry Date Alerts</h3>
                <p>Receive notifications when products are about to expire to minimize waste.</p>
            </div>

            <div class="service-box">
                <i class="fas fa-bell"></i>
                <h3>Low Stock Notifications</h3>
                <p>Get instant alerts when product stock reaches a low level to restock in time.</p>
            </div>

            <div class="service-box">
                <i class="fas fa-users-cog"></i>
                <h3>User & Admin Management</h3>
                <p>Manage users with secure authentication and role-based access control.</p>
            </div>

            <div class="service-box">
                <i class="fas fa-wallet"></i>
                <h3>Secure Payment & Wallet</h3>
                <p>Integrated digital wallet with AES encryption for secure transactions.</p>
            </div>

            <div class="service-box">
                <i class="fas fa-envelope"></i>
                <h3>Multi-Channel Notifications</h3>
                <p>Receive alerts via email, and in-app notifications for quick action.</p>
            </div>
 

        </div>
        
    </section>
    <section id="gallery" class="gallery-section">
        <h2>Our Gallery</h2>
        <div class="container">
            <div id="galleryCarousel" class="carousel slide" data-bs-ride="carousel">
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img src="images/g1.jpg" class="d-block w-100" alt="Grocery Store">
                    </div>
                    <div class="carousel-item">
                        <img src="images/g2.jpg" class="d-block w-100" alt="Fresh Vegetables">
                    </div>
                    <div class="carousel-item">
                        <img src="images/g3.webp" class="d-block w-100" alt="Fruits Section">
                    </div>
                    <div class="carousel-item">
                        <img src="images/g4.jpeg" class="d-block w-100" alt="Shopping Basket">
                    </div>
                    <div class="carousel-item">
                        <img src="images/g5.jpeg" class="d-block w-100" alt="Supermarket Shelf">
                    </div>
                </div>

                <!-- Navigation Controls -->
                <button class="carousel-control-prev" type="button" data-bs-target="#galleryCarousel" data-bs-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Previous</span>
                </button>
                <button class="carousel-control-next" type="button" data-bs-target="#galleryCarousel" data-bs-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Next</span>
                </button>
            </div>
        </div>
    </section>
         

    <!-- Lightbox -->
    <div class="lightbox" id="lightbox">
        <span class="close-btn" onclick="closeLightbox()">&times;</span>
        <img id="lightbox-img" src="" alt="Expanded View">
    </div>

    <script>
        function openLightbox(element) {
            const lightbox = document.getElementById('lightbox');
            const lightboxImg = document.getElementById('lightbox-img');

            lightboxImg.src = element.querySelector('img').src;
            lightbox.classList.add('active');
        }

        function closeLightbox() {
            document.getElementById('lightbox').classList.remove('active');
        }
    </script>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>


    <!-- Lightbox -->
    <div class="lightbox" id="lightbox">
        <span class="close-btn" onclick="closeLightbox()">&times;</span>
        <img id="lightbox-img" src="" alt="Expanded View">
    </div>

    <script>
        function openLightbox(element) {
            const lightbox = document.getElementById('lightbox');
            const lightboxImg = document.getElementById('lightbox-img');

            lightboxImg.src = element.querySelector('img').src;
            lightbox.classList.add('active');
        }

        function closeLightbox() {
            document.getElementById('lightbox').classList.remove('active');
        }
    </script>

     
  
  </main><!-- End #main -->

  <!-- ======= Footer ======= -->
  <footer id="footer">
    <div class="container">
      <div class="copyright">
        &copy; Copyright <strong><span>Real Time Product Tracking and Notification System</span></strong>
      </div>
     
    </div>
  </footer><!-- End  Footer -->

  <a href="#" class="back-to-top"><i class="icofont-simple-up"></i></a>

  <!-- Vendor JS Files -->
  <script src="assets/vendor/jquery/jquery.min.js"></script>
  <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="assets/vendor/jquery.easing/jquery.easing.min.js"></script>
  <script src="assets/vendor/php-email-form/validate.js"></script>
  <script src="assets/vendor/waypoints/jquery.waypoints.min.js"></script>
  <script src="assets/vendor/counterup/counterup.min.js"></script>
  <script src="assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
  <script src="assets/vendor/venobox/venobox.min.js"></script>
  <script src="assets/vendor/owl.carousel/owl.carousel.min.js"></script>
  <script src="assets/vendor/typed.js/typed.min.js"></script>
  <script src="assets/vendor/aos/aos.js"></script>

  <!-- Template Main JS File -->
  <script src="assets/js/main.js"></script>

</body>

</html>