 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="soham"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/bootstrap.min.css">
 <link rel="stylesheet" href="css/cust.css">

<title> </title>
</head>
<body><jsp:include page="Top.jsp"></jsp:include>
<%

String userid=String.valueOf(session.getAttribute("userid"));
String usertype=String.valueOf(session.getAttribute("usertype"));
if(!userid.equalsIgnoreCase("null")){	
	
session.setMaxInactiveInterval(10*60); 
%>


<div class="row">
<div class="col-md-6">
<h2>Product Categories</h2>
<hr>

<table class="table table-bordered">
<tr style="background-color:seashell">
<th>Category</th> 
 
</tr>


<soham:forEach items="${std}" var="rec">

<tr>
<td>${rec.type}</td> 
  
</tr>

</soham:forEach>
</table>
</div>
<div class="col-md-6"><h2>Products Category Registration</h2>
  <form name="frm" method="post" action="RegCategory">
         <table class="tblform"> 
         <tr><td>Category</td>
         <td>
          <input type="text" class="form-control" name="type" required>
          </td>
          </tr>
           
          <tr><td colspan="2"><input type="submit" class="btn btn-primary" value="Submit"></td></tr>
          </table>
				<br/><br/>			 
							 
							 
						</form>
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

%>
</body>
</html>