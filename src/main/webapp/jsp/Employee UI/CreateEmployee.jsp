<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Personal Details</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width,initial-scale=1.0">
        <link rel="stylesheet" href="<%request.getContextPath(); %>/css/Common.css">
    </head>
     <style>
    	
  .container{
    background-color: #627282;
    color: white;
    display:flex;
    flex-direction: column;
    width: 30%;
    height: 40%;
    margin: 10%;
    margin-left: 35%;
    align-items: center;
    box-shadow: 0 2px 15px 0 rgba(30,37,44,0.29);
    border-radius: 5%;
    text-align: center;
    padding-bottom: 30px;
    
  }
  button{
 
    align-items: center;
    text-align: center;
    border-radius: 10px;
    padding: 10px;
    width: 20%;
   
   
    
  }
  .boxSpace{
    display: flex;
    margin: auto;
    margin-top: 20px;
    text-align: center;
  }
 
    	
    </style>
    <body bgcolor="#273341">
        <jsp:include page="/jsp/User UI/Header.jsp"></jsp:include>
        <div class="container">
            <h1>Personal Details</h1>
            <form action="app/createEmployee" method="post">
                <table>
                    <tr><td>UserId</td><td><input type="number" name="userId" required></td></tr>
                    <tr><td>Password</td><td><input type="password" name="password" required></td></tr>
                    <tr><td>Name</td><td><input type="text" name="name" required></td></tr>
                    <tr><td>DOB</td><td><input type="date" name="dob" required></td></tr>
                    <tr><td>Email</td><td><input type="email" name="email" required></td></tr>
                    <tr><td>Address</td><td><input type="text" name="address" required></td></tr>
                    <tr><td>Contact</td><td><input type="number" name="contactNum" required></td></tr>
                    <tr><td>Type</td><td><select name="type" required>
                    			<option value="1">Employee</option>
                    			<option value="0">Admin</option></select>
                    <tr><td>Department</td><td><select name="department" required>
                    			<option value="Administration">Administration</option>
                    			<option value="Manangement">Management</option>
                    			<option value="IT Services">IT Services</option>
                    			<option value="Customer Relation">Customer Relation</option></td></tr>
                    <tr><td>Branch</td><td><select name="branch" required>
                    			<%for(String branchName:(List<String>)request.getAttribute("branchList")){ %>
                    			<option ><%=branchName%><%} %></option></td></tr>
                </table>
                <button style="margin-top: 20px; width: 80px;" type ="submit">Submit</button>
            </form>
        </div>
         <jsp:include page="/jsp/User UI/NavBar.jsp"></jsp:include>

    </body>
</html>