 
<%@page import="models.Cities"%>
<%@page import="models.GetStateNCities"%>
<%@page import="java.util.List"%>
 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<title>Register</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<body>
  
<%
String st=request.getParameter("title");
if(st.equals("0"))
{
	%>
	<input type="text" name="title1" class="form-control"/>
	<% 
}
   %><br/>
</body>
</html>