<%@page import="com.bankz.enums.AccountType"%>
<%@page import="com.bankz.enums.UserType"%>
<%@page import="com.bankz.enums.UserStatus"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import="java.util.List, java.util.ArrayList" %>
	<%@ page import="com.bankz.pojo.Branch" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Branch Details</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width,initial-scale=1.0">
        <link rel="stylesheet" href="<%request.getContextPath(); %>/css/Common.css">
    </head>
    <style>
    	
  
 .container table{
        text-align: center;
		margin-right:0px;
		margin-left:400px;
        margin-top: 50px;
        column-gap: 100mm;
        column-width: 200px;
        border-style:groove;
        border-color: black;
        background-color: whitesmoke;
    }
    .container table th{
        width: 200px;
        height: 100px;
        background-color: #627282;
        column-fill: auto;
        padding: auto;
        text-align: center;
        border: 2px solid black;
    }
    .container table td{
    	border: 2px solid black;
    
    }
    
    </style>
    <body bgcolor="#273341">
        <jsp:include page="/jsp/User UI/Header.jsp"></jsp:include>
        <div class="container">
           
            <form>
                 <table>
        <tr>
            <th>Branch Id</th>
            <th>Branch Name</th>
            <th>IFSC code</th>
            <th>Address</th>
            <th>Active Employees</th>
            <th>Active Accounts</th>
            
         </tr>
         <% Branch branch=(Branch)request.getAttribute("branch");%>
        	<tr>
        		<td><%=branch.getBranchId()%></td>
        		<td><%=branch.getName()%></td>
        		<td><%=branch.getiFSCcode()%></td>
        		<td><%=branch.getAddress()%></td>
        		<td><%=branch.getNumOfActiveEmployees()%></td>
        		<td><%=branch.getNumOfActiveAccounts()%></td>
        		
        	</tr> 
   
         
    	   </table>
   	</form>
   	</div>
    <jsp:include page="/jsp/User UI/NavBar.jsp"></jsp:include>

    </body>
</html>