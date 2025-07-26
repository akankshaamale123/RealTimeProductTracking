<%@page import="models.States"%>
<%@page import="java.util.List"%>
<%@page import="models.GetStateNCities"%>
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
   
    http.open('get', 'Cities?state=' + st);
    http.onreadystatechange = processResponse;
    http.send(null);
}

function processResponse() {
    if(http.readyState == 4){
        var response = http.responseText;
        document.getElementById('cities').innerHTML = response;
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

<img src="images/custreg.jpg" width="100%"/>
</div>
<div class="col-md-6">
<div ><center><h2>Registration</h2></center><br/>
 <form id="frm" action="RegUser" method="post">
									 
									  <table class="tblform">
									 <tr><td>UserName</td>
                <td><input type="text" class="form-control"  name="name" required></td></tr>
            <tr><td>UserID</td>
                <td><input type="text"  class="form-control"  name="userid" required></td></tr>
                       
             <tr><td>Password</td>
                <td><input type="password"  class="form-control"  name="pass" required></td></tr>
            
			<tr>
				<td>Mobile Number</td>
				<td>
				<input type="text"  class="form-control"  name="mobile" pattern="^\d{10}$"  >
				</td>
			</tr>
			
                <tr><td>Email ID:</td>
                    <td><input type="text" class="form-control" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$"  name="email" required></td>
                </tr>
                  <tr>
<td>Gender</td>
<td>
<input type="radio" name="gender" value="Male"   checked="true" required >Male</input>
<input type="radio" name="gender" value="Female"  required>Female</input>
</td>
</tr>    
  <tr>
									  
	            <td>  Address</td>
		            <td>
		            <textarea rows="5" cols="25" name="addr" class="form-control" ></textarea>          
		            </td>
            </tr>
								 
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