 
<!doctype html>
<%@page import="models.Cart"%>
<html lang="en">
 
<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title> </title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Favicons -->
  <link href="assets/img/favicon.png" rel="icon">
  <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="assets/vendor/aos/aos.css" rel="stylesheet">
  <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
  <link href="assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">

  <!-- Template Main CSS File -->
  <link href="assets/css/style.css" rel="stylesheet">
 </head>

<body>

<%
try
{  response.setHeader("Pragma", "No-cache");
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.setDateHeader("Expires", -1);
if(session.getAttribute("userid")==null)
{
	response.sendRedirect("home");
}
%>
  <!-- ======= Top Bar ======= -->
  <section id="topbar" class="d-flex align-items-center">
    <div class="container d-flex justify-content-center justify-content-md-between">
      <div class="contact-info d-flex align-items-center">
        </div>
      <div class="social-links d-none d-md-block">
         </div>
    </div>
  </section>

  <!-- ======= Header ======= -->
  <header id="header" class="d-flex align-items-center">
    <div class="container  ">

      <h1 class="logo"><a href="home">Real Time Product Tracking and Notification System </a></h1>
      <!-- Uncomment below if you prefer to use an image logo -->
      <!-- <a href="index.html" class="logo"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>-->
</div><br/>
<div class="container d-flex align-items-center justify-content-between">

      <nav id="navbar" class="navbar">
        <ul>
         <li><a class="nav-link scrollto active" href="<%=session.getAttribute("utype").toString().trim() %>">Home</a></li>
         	
        <%if(session.getAttribute("utype").toString().trim().equals("admin"))
                                	{
                                	%> 
                                	<li><a class="nav-link" href="registration">User Registration</a></li>
		<li class="nav-item"><a class="nav-link" href="viewCategories" >Manage Categories</a></li>
         	<li class="nav-item"><a class="nav-link" href="uploadPart" >Register New Products </a></li>
         
                                	<li class="dropdown"><a href="#"><span>Reports</span> <i class="bi bi-chevron-down"></i></a>
            <ul> 
              <li><a href="viewCustomers">Customer Details</a></li>
              	 
             <!--   <li class="dropdown"><a href="#"><span>Deep Drop Down</span> <i class="bi bi-chevron-right"></i></a>
                <ul>
                  <li><a href="#">Deep Drop Down 1</a></li>
                  <li><a href="#">Deep Drop Down 2</a></li>
                  <li><a href="#">Deep Drop Down 3</a></li>
                  <li><a href="#">Deep Drop Down 4</a></li>
                  <li><a href="#">Deep Drop Down 5</a></li>
                </ul>
              </li> -->
             
            </ul>
          </li>
                               
             <%}else if(session.getAttribute("utype").toString().trim().equals("retailer"))
         	{
         	%>
          
         	<li class="nav-item"><a class="nav-link" href="viewCategories" >Manage Categories</a></li>
         	<li class="nav-item"><a class="nav-link" href="uploadPart" >Register New Products </a></li>
         
         	 <%}else if(session.getAttribute("utype").toString().trim().equals("customer"))
          	{
              	%>
                
              	 <%}%>
         	 
         	 
          <li><a class="nav-link scrollto" href="ChangePass">Change Password</a></li>
          <li><a class="nav-link scrollto" href="logout">Logout</a></li>
       <!--   <li class="dropdown"><a href="#"><span>Drop Down</span> <i class="bi bi-chevron-down"></i></a>
            <ul>
              <li><a href="#">Drop Down 1</a></li>
              <li class="dropdown"><a href="#"><span>Deep Drop Down</span> <i class="bi bi-chevron-right"></i></a>
                <ul>
                  <li><a href="#">Deep Drop Down 1</a></li>
                  <li><a href="#">Deep Drop Down 2</a></li>
                  <li><a href="#">Deep Drop Down 3</a></li>
                  <li><a href="#">Deep Drop Down 4</a></li>
                  <li><a href="#">Deep Drop Down 5</a></li>
                </ul>
              </li> 
              <li><a href="#">Drop Down 2</a></li>
              <li><a href="#">Drop Down 3</a></li>
              <li><a href="#">Drop Down 4</a></li>
            </ul>
          </li>-->
          </ul>
        <i class="bi bi-list mobile-nav-toggle"></i>
      </nav><!-- .navbar -->

    </div>
  </header><!-- End Header -->
 <div class="innerbanner"></div>
 <div class="container-fluid">
    <div class="CartPanel">
    <div class="row">
    <div class="col-md-9">
      Logged in as <%=session.getAttribute("username").toString() %>( <%=session.getAttribute("utype").toString() %>)
  <%if(!(session.getAttribute("utype").toString().trim().equals("customer")||session.getAttribute("utype").toString().trim().equals("admin"))){ %>
   |  <a href="ProcessedOrders">Processed Orders</a>
    |<a href="PaidOrders">Paid Orders</a>
   <%} %>
    
    </div>
    <div class="col-md-3">
   <%if(!(session.getAttribute("utype").toString().trim().equals("farmer") || session.getAttribute("utype").toString().trim().equals("admin")))
                                	{
                                	%>
    <% int totalItems=0;
    Cart cart=new Cart();
    totalItems=cart.totalItemsInCart(session.getAttribute("userid").toString().trim());
    %>
   <a href="ShowCart"> Total Items in your Cart : <i class="fa fa-cart"></i> <span><%=totalItems %></span> </a>
   <%} %>
   </div>
  </div>  </div>
    </div>
    <!--// end-smoth-scrolling -->
    <%}catch(Exception ex)
{
    	System.out.println("err="+ex.getMessage());
    	 
}%>
 <div class="container"> 
 
   <br/><br/>