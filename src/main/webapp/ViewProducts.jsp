 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="soham"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/bootstrap.min.css">
 <link rel="stylesheet" href="css/cust.css">

<title>Car Parts Recognition</title>
</head>
<body><jsp:include page="Top.jsp"></jsp:include>
<%
try{
String userid=String.valueOf(session.getAttribute("userid"));
String usertype=String.valueOf(session.getAttribute("usertype"));
if(!userid.equalsIgnoreCase("null")){	
	
session.setMaxInactiveInterval(10*60); 

%>


<div class="row">
<div class="col-md-12">
<h2>Registered Products</h2>
<hr>

 
  <div class="row">
<soham:forEach items="${lst}" var="rec">
<div class="col-md-3">
<table class="table table-bordered">
<tr>
<td colspan="2">
<div style="background-image:url('http://localhost:80/RetailProductsImageClassificationPython/DataSet/${rec.coverphoto}');height:150px;background-size:contain;background-repeat: no-repeat;"></div>
</td>
 </tr><tr>
<td>
<b>Title</b></td><td>${rec.title}
</td>
</tr>
<tr>
<td>
<b>Availability</b></td><td>${rec.availsts}
</td>
</tr>
<tr>
<td>
<b>Stock</b></td><td>${rec.quantity}
</td>
</tr>
<tr>
<td>
<b>Description</b></td><td colspan="2">${rec.desc}
</td>
</tr>
<tr>
<td>
<b>Category</b></td><td colspan="2">${rec.prodType}
</td>
</tr>
 <tr>
<td>
<b>Price</b></td><td colspan="2">${rec.price}
</td>
</tr>
<tr>
<td>
 <a href="uploadMoreParts?partId=${rec.prodId}&title=${rec.title}&category=${rec.prodType}">Upload More Photos</a>
</td>
<td>
 <a href="viewMoreParts?partId=${rec.prodId}&title=${rec.title}&category=${rec.prodType}">view More Photos</a>
</td>
</tr>
</table>
 
</div>
 
</soham:forEach>
 
</div>
 </div>
</div>

<%
}
else{
	%>
	<h2>Invalid Session...Login again</h2>
	<br>
	<a href="index.jsp">Login</a>
	
	<%
}
}catch(Exception ex)
{
	System.out.println("err="+ex.getMessage());
}
%>
</body>
</html>