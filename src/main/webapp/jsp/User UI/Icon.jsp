<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.bankz.pojo.Customer"%>
<%@ page import="com.bankz.helper.Supplement"%>
<%@ page import="com.bankz.pojo.Employee"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Header</title>
</head>
<style>
.header {
	display: flex;
	flex-direction: row;
	align-items: center;
	background-color: #627282;
	color: white;
	top: 0px;
	height: 100px;
	text-align: center;
	padding: 10px;
	border-radius: 15px;
}

.header button {
	text-align: center;
	border-radius: 15px;
	background-color: white;
	margin-left: 70%;
	width: 200px;
}

img {
	text-align: center;
	border-radius: 15px;
	margin-left: 25%;
	padding: 20px;
	width: 100px;
	height: 100px;
}

input {
	background-color: transparent;
	border-color: transparent;
}

.container {
	background-color: #627282;
	color: white;
	display: flex;
	text-align: justify;
	flex-direction: column;
	width: 700px;
	height: 300px;
	margin-top: 90px;
	margin-left: 25%;
	font-size: auto;
	box-shadow: 0 2px 15px 0 rgba(30, 37, 44, 0.29);
	border-radius: 10px;
	padding-left: 90px;
	padding-top: 30px;
}

.navbar {
	height: 100%;
	accent-colorwidth: 300px;
	display: block;
	position: fixed;
	left: 0px;
	top: 127px;
	z-index: 5;
	background-color: #011722;
	color: red;
}

.navbar button {
	background-color: transparent;
	border-color: transparent;
	align-items: center;
	text-align: center;
	height: 50px;
	width: 100mm;
	color: white;
	font-size: large;
}

.header button {
	align-items: center;
    text-align: center;
    border-radius: 10px;
    padding: 10px;
    width: 100px;
    margin-right:500px;
   
}

tr td{
	padding-top: 10px;
}
</style>
<body bgcolor="#273341">
	<div class="header">
		<h1 style="margin-left: 50%">bankZ</h1>
		<a href="/BankZ/app/login"><button>logout</button></a>

	</div>
	<% int userType=(int)(request.getSession().getAttribute("userType"));
	if(userType==2){ %>
	<div class="container" style="display: flex; flex-direction: column;">
		<h2>Personal Details</h2>
		<%
		Customer customer = (Customer) request.getAttribute("customer");
		%>
		<table>
			<tr>
				<td>UserId:</td>
				<td><%=customer.getId()%></td>
			</tr>
			<tr>
				<td>Name:</td>
				<td><%=customer.getName()%></td>
			</tr>
			<tr>
				<td>DOB:</td>
				<td><%=Supplement.longToDate(customer.getDob())%></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><%=customer.getEmail()%></td>
			</tr>
			<tr>
				<td>Address:</td>
				<td><%=customer.getAddress()%></td>
			</tr>
			<tr>
				<td>Contact:</td>
				<td><%=customer.getContactNum()%></td>
			</tr>

		</table>

	</div>
	<div class="container">
		<h2>KYC Details</h2>
		<table>
			<tr>
				<td>Aadhaar Number:</td>
				<td><%=customer.getAadharNum()%></td>
			</tr>
			<tr>
				<td>PAN Number:</td>
				<td><%=customer.getPanNum()%></td>
			</tr>
		</table>
	</div>
	<%}else if(userType==1|userType==0){ %>
		<div class="container" style="display: flex; flex-direction: column;">
		<h2>Personal Details</h2>
		<%
		Employee employee = (Employee) request.getAttribute("employee");
		%>
		<table>
			<tr>
				<td>UserId:</td>
				<td><%=employee.getId()%></td>
			</tr>
			<tr>
				<td>Name:</td>
				<td><%=employee.getName()%></td>
			</tr>
			<tr>
				<td>DOB:</td>
				<td><%=Supplement.longToDate(employee.getDob())%></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><%=employee.getEmail()%></td>
			</tr>
			<tr>
				<td>Address:</td>
				<td><%=employee.getAddress()%></td>
			</tr>
			<tr>
				<td>Contact:</td>
				<td><%=employee.getContactNum()%></td>
			</tr>

		</table>

	</div>
	<div class="container">
		<h2>KYC Details</h2>
		<table>
			<tr>
				<td>Department:</td>
				<td><%=employee.getDepartment()%></td>
			</tr>
			<tr>
				<td>Branch:</td>
				<td><%=employee.getBranch()%></td>
			</tr>
		</table>
	</div>
		<%} %>
	<jsp:include page="/jsp/User UI/NavBar.jsp"></jsp:include>
</body>
</html>