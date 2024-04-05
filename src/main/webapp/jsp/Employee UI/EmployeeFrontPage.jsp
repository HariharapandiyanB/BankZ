<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.bankz.pojo.Branch" %>
    
    <!DOCTYPE html>
<html>
    <head>
        <title>Employee Panel</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width,initial-scale=1.0">
        <link rel="stylesheet" href="<%= request.getContextPath() %>BankZ/css/CustomerFrontPage.css">

    </head>
    <style>
		
  
  .container{
    background-color:transparent;
    display:flex;
    flex-direction: column;
    width: 20%;
    height: 40%;
    margin-top: 10%;
    margin-left: 40%;
    box-shadow: 0 2px 15px 0 rgba(30,37,44,0.29);
    border-radius: 5%;
    text-align: center;
    
  }
  .container button{
 
    align-items: center;
    text-align: center;
    border-radius: 10px;
    padding: 10px;
    width:100mm;
   
   
    
  }
  button{
 
    align-items: center;
    text-align: center;
    border-radius: 10px;
    padding: 10px;
    width:fit-content;
   
   
    
  }    
    </style>
    <body bgcolor="#273341">
       <jsp:include page="/jsp/User UI/Header.jsp"></jsp:include>
       <div class="container" style="display: flex; flex-direction: column;">
		<h2>Branch Details</h2>
		<%
		Branch branch = (Branch) request.getAttribute("branch");
		%>
		<table>
			<tr>
				<td>BranchId:</td>
				<td><%=branch.getBranchId()%></td>
			</tr>
			<tr>
				<td>Name:</td>
				<td><%=branch.getName()%></td>
			</tr>
			<tr>
				<td>Address:</td>
				<td><%=branch.getAddress()%></td>
			</tr>
			<tr>
				<td>IFSC Code:</td>
				<td><%=branch.getiFSCcode()%></td>
			</tr>
			<tr>
				<td>Active Employees:</td>
				<td><%=branch.getNumOfActiveEmployees()%></td>
			</tr>
			<tr>
				<td>Active Accounts:</td>
				<td><%=branch.getNumOfActiveAccounts()%></td>
			</tr>

		</table>

	</div>
       
        <jsp:include page="/jsp/User UI/NavBar.jsp"></jsp:include>
    </body>
</html>