 
<%@page import="models.JavaFuns"%>
<%@page import="java.util.Vector"%>
<%@page import="models.ProductsList"%>
<%@page import="java.util.Random"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
 
<%@page import="java.util.List"%>
 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
   
    http.open('get', 'NewProd.jsp?title=' + st);
    http.onreadystatechange = processResponse;
    http.send(null);
}

function processResponse() {
    if(http.readyState == 4){
        var response = http.responseText;
        document.getElementById('NewProd').innerHTML = response;
    }
}
 
</script>

</head>
<body>
<jsp:include page="Top.jsp"></jsp:include>
<%  response.setHeader("Pragma", "No-cache");
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.setDateHeader("Expires", -1);%>
<div class="container">
<div class="row">

<div class="col-md-6">
<img src="images/upload.jpg" width="100%"/>
</div>
<div class="col-md-6">
<%
Date dt1=new Date();
String dt=(dt1.getDate())+"/"+(dt1.getMonth()+1)+"/"+(dt1.getYear()+1900);
String tm=dt1.getHours()+":"+dt1.getMinutes();

%>
<%
	ProductsList bl = new ProductsList();
	List<ProductsList> lst = bl.getProdTypeList();
%>
<%
Vector v=new Vector();
JavaFuns jf=new JavaFuns();
v=jf.getValue("select distinct(title) from products ", 1);
%>
<div ><center><h2>Upload Products</h2></center><br/>
 <form id="frm" action="/RegProduct" method="post"  enctype="multipart/form-data">
									 
									  <table class="tblform">
								  
									  <tr>
									 <td>Title
									 </td>
									 <td> 
									 <select name="title" required class="form-control" required onchange="makeGetRequest(this.value)">
   <option value=""><--Select--></option>
   <%for(int i=0;i<v.size();i++)
	   {%>
   <option value="<%=v.elementAt(i).toString().trim() %>"><%=v.elementAt(i).toString().trim() %></option>
   <%} %>
   <option value='0'>Other</option>
   </select>
   <br/>
   <div id="NewProd"></div>
								 	 </td>
									 </tr>
									 	 <tr>
       	<td>Product Type</td>
       	<td><select name="productType" required class="form-control">
       	<%for(int i=0 ;i<lst.size();i++) {%>
       			<option value="<%=lst.get(i).getType() %>"><%=lst.get(i).getType() %></option>
		<%} %>
       	</select></td>
       	
       </tr>
									   <tr>
									 <td>Stock
									 </td>
									 <td> 
								 <input type="Number" name="stock" required class="form-control"/>
									 </td>
									 </tr>
									  <tr>
									 <td>Price/Product
									 </td>
									 <td> 
								 <input type="Number" name="price" required class="form-control"/>
									 </td>
									 </tr>
									 <tr>
									 <td>Availability
									 </td>
									 <td> 
								 <input type="radio" name="avail" value="Available"   checked="true" required >Available</input>
<input type="radio" name="avail" value="NotAvailable"  required>NotAvailable</input>

									 </td>
									 </tr>
									  <tr>
									 <td>Description
									 </td>
									 <td> 
								 <input type="text" name="docdesc" required class="form-control"/>
									 </td>
									 </tr>
									    
									 
	           <tr> <td>  Photo</td>
		            <td>
		             <input type="file" name="file" class="form-control" required ></input>
 
		            <input type="hidden" name="userid" value="<%=session.getAttribute("userid").toString().trim() %>"/>
		            <input type="hidden" name="dt" value="<%=dt %>"/>
		            <input type="hidden" name="tm" value="<%=tm %>"/>
		             </td>
            </tr>
								 
	 <tr>
     <td>Expiry Date</td>
     <td>
  <input type="date"   name="edt" class="form-control" required></input>
     
 </td></tr>

									 <tr>
									 <td colspan="2"><input type="submit" value="Submit" class="btn btn-primary"/>
									 </td></tr>
									 </table>
									 </form>
</div>
</div>

</div>

</div>
</body>
</html>