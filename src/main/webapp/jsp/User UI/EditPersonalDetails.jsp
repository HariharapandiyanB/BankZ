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

.container button{
  background-color: white;
  align-items: center;
  text-align: center;
  border-radius: 10px;
  padding: 10px;
  width: 20%;
  margin-left:60%;
 
  
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
	padding-bottom:20px;
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
	<form action="editCustomerPersonalDetails" method=post>
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
				<td><input type="text" name="name" value="<%=customer.getName() %>" ></td>
			</tr>
			<tr>
				<td>DOB:</td>
				<td><input type="text" name="dob" value="<%=Supplement.longToDate(customer.getDob())%>"></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="email" name="email" value="<%=customer.getEmail()%>"></td>
			</tr>
			<tr>
				<td>Address:</td>
				<td><input type="text" name="address" value="<%=customer.getAddress()%>"></td>
			</tr>
			<tr>
				<td>Contact:</td>
				<td><input type="number" name="contactNumber" value="<%=customer.getContactNum()%>"></td>
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
		<button
					style="background-color: #627282; border-color: #627282; color: white;">Submit</button>
		
	</div>
	</form>
	<%}else if(userType==1|userType==0){ %>
	<form action="editEmployeePersonalDetails" method=post>
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
				<td><input type="text" name="name" value="<%=employee.getName()%>"></td>
			</tr>
			<tr>
				<td>DOB:</td>
				<td><input type="date" name="dob" value="<%=Supplement.longToDate(employee.getDob())%>"></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="email" name="email" value="<%=employee.getEmail()%>"></td>
			</tr>
			<tr>
				<td>Address:</td>
				<td><input type="text" name="address" value="<%=employee.getAddress()%>"></td>
			</tr>
			<tr>
				<td>Contact:</td>
				<td><input type="number" name="contactNumber" value="<%=employee.getContactNum()%>"></td>
			</tr>
			
			
		</table>
		<button style="background-color: #627282; border-color: #627282; color: white;">Submit</button>
		
	</div>
	<div class="container">
		<h2>Other Details</h2>
		
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
		</form>
	<jsp:include page="/jsp/User UI/NavBar.jsp"></jsp:include>
</body>
</html>