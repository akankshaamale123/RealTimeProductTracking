<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="DefaultTop.jsp"></jsp:include>
<div class="container"><br/><br/>
<%
if(request.getParameter("type").toString().trim().equals("Reg"))
{
	%><h2 class="h2">Your Registration Done Successfully....</h2>
	<br/>
	<a href="admin">Home</a>
<%}
if(request.getParameter("type").toString().trim().equals("ProdReg"))
{
	%><h2 class="h2">Product Registered Successfully....</h2>
	<br/>
	<a href="admin">Home</a>
<%}
if(request.getParameter("type").toString().trim().equals("RegUser"))
{
	%><h2 class="h2">Your Registration Done Successfully....</h2>
	<br/>
	<a href="admin">Home</a>
<%}
else if(request.getParameter("type").toString().trim().equals("RegProd"))
{
	%><h2 class="h2">Product Registered Successfully....</h2>
	<br/>
	<a href="farmer">Home</a>
<%
}
else if(request.getParameter("type").toString().trim().equals("prodMoreReg"))
{
	%>
	Product Photo Registered Successfully...
	<br/>
	<a href="retailer">Home</a>
	<%
}
else if(request.getParameter("type").toString().trim().equals("CateReg"))
{
	%>
	Category Registered Successfully...
	<br/>
	<a href="retailer">Home</a>
	<%
}
else if(request.getParameter("type").toString().trim().equals("prodReg"))
{
	%>
	Product Registered Successfully...
	<br/>
	<a href="retailer">Home</a>
	<%
}
else if(request.getParameter("type").toString().trim().equals("ProdPerReg"))
{
	%><h2 class="h2">Product Percentage Registered Successfully....</h2>
	<br/>
	<a href="admin">Home</a>
<%
}
else if(request.getParameter("type").toString().trim().equals("ProdUpdate"))
{
	%><h2 class="h2">Product Updated Successfully....</h2>
	<br/>
	<a href="viewProducts">Home</a>
<%
}
else if(request.getParameter("type").toString().trim().equals("placeOrder"))
{
	%><h2 class="h2">Order Placed Successfully....</h2>
	<br/>
	<a href="<%=session.getAttribute("utype").toString().trim() %>">Home</a>
<%
}
else if(request.getParameter("type").toString().trim().equals("OrderProcess"))
{
	%><h2 class="h2">Order Processed Successfully....</h2>
	<br/>
	<a href="<%=session.getAttribute("utype").toString().trim() %>">Home</a>
<%
}
else if(request.getParameter("type").toString().trim().equals("DocReg"))
{
	%><h2 class="h2">Document Registration Done Successfully....</h2>
	<br/>
	<a href="userHome">Home</a>
<%
}
else if(request.getParameter("type").toString().trim().equals("Req"))
{
	%><h2 class="h2">Request Sent Successfully....</h2>
	<br/>
	<a href="/userHome">Home</a>
<%
}
else if(request.getParameter("type").toString().trim().equals("ChangePass"))
{
	%><h2 class="h2">Password Changed Successfully....</h2>
	<br/>
	<a href="/<%=session.getAttribute("utype").toString().trim() %>">Home</a>
<%
}
else if(request.getParameter("type").toString().trim().equals("ReqUpd"))
{
	%><h2 class="h2">Request Updated Successfully....</h2>
	<br/>
	<a href="cityadminHome">Home</a>
<%
}
else if(request.getParameter("type").toString().trim().equals("passEmail"))
{
	%><h2 class="h2">New Password Sent on your registered email id Successfully....</h2>
	<br/>
	<a href="home">Home</a>
<%
}
else if(request.getParameter("type").toString().trim().equals("Doc"))
{
	%><h2 class="h2">Document Uploaded Successfully....</h2>
	<br/>
	<a href="userHome">Home</a>
<%
}
%>
</div>
</body>
</html>