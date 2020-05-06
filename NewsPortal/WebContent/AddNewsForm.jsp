<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add News</title>
    <style>
        .reg table{width: 500px; height: 425px;margin-left: 415px; border-radius:20px;}     
        .reg input[type="tel"],input[type="email"],input[type="number"],input[type="text"],input[type="password"],input[type="date"]{ width: 300px; height: 35px;  }
        .reg input[type="submit"]{ width: 300px; height: 35px;  border-bottom: 2px solid black;}
    	.reg input[type="reset"]{width:100px; height:35px; border-bottom: 2px solid black;}
    	.reg td
    	{font-size: 20px;}
    	.topnav {
			overflow: hidden;
			background-color: #21618C;
			}
		
		.topnav a {
			float: left;
			display: block;
			color: #f2f2f2;
			text-align: center;
			padding: 14px 16px;
			text-decoration: none;
			font-size: 17px;
		}
		
		.topnav a:hover {
			background-color: gray;
			color: black;
		}
    	
    </style>
    </head>
<body bgcolor="#ADD8E6">
	<jsp:include page="Header.jsp" />  
	<div class="topnav" class="containerh">
		<a href="Home.jsp">Home</a><a href="Category.jsp">Category</a>
		<a href="Contact.jsp">Contact</a> <a href="About.jsp">About</a>
	</div>		
			
	<br>
<center><font size=20><b>Add News</b></font></center>
<hr>
	<form action="AddNews.jsp method="post">
	<div class="reg">
	<table bgcolor="#f2f2f2" cellspacing="15px">
		<tr><td></td></tr>
		<tr><td>ReporterId</td><td><input type="number" name="rid"  readonly="readonly" value="<%=(Integer)request.getAttribute("id")%>"></td></tr>
		<tr><td>Headline</td><td><input  type="text" name="headline" placeholder="Enter Headline" required="required"></td></tr>
		<tr><td>Description:</td><td><textarea rows="5" cols="40" name="description" placeholder="Enter the description" required="required"></textarea></td></tr>
		<tr><td>Category</td><td><input  type="text" name="category" placeholder="Enter category" required="required"></td></tr>
		<tr><td><input type="reset"><td><input type="submit" name="submit" value="Submit"></td></td></tr>
		<tr><td></td></tr>
	</table>
	</div>
	</form>
	<hr><jsp:include page="Footer.jsp" />
</body>
</html>