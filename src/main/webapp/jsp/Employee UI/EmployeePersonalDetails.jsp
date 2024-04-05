<%@page import="com.bankz.pojo.Employee"%>
<%@page import="com.bankz.helper.Supplement"%>
<%@page import="com.bankz.pojo.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.bankz.pojo.Employee" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Personal Details</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width,initial-scale=1.0">
        <link rel="stylesheet" href="<%request.getContextPath(); %>BankZ/css/Common.css">
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
            <form>
            	<%Employee employee=(Employee)request.getAttribute("employee"); %>
                <table>
                    <tr><td>UserId</td><td><input type="number" name="userId" value="<%=employee.getId() %>"></td></tr>
                    <tr><td>Name</td><td><input type="text" name="name" value="<%=employee.getName()%>"></td></tr>
                    <tr><td>DOB</td><td><input type="text" name="dob" value="<%=Supplement.longToDate(employee.getDob())%>"></td></tr>
                    <tr><td>Email</td><td><input type="email" name="email" value="<%=employee.getEmail()%>"></td></tr>
                    <tr><td>Address</td><td><input type="text" name="address" value="<%=employee.getAddress()%>"></td></tr>
                    <tr><td>Contact</td><td><input type="number" name="contact" value="<%=employee.getContactNum()%>"></td></tr>
                    <tr><td>Department</td><td><input type="text" name="department" value="<%=employee.getDepartment()%>"></td></tr>
                    <tr><td>Branch</td><td><input type="text" name="branch" value="<%=employee.getBranch()%>"></td></tr>
                </table>
                
            </form>
        </div>
        <jsp:include page="/jsp/User UI/NavBar.jsp"></jsp:include>

    </body>
</html>