<%@page import="com.bankz.enums.AccountType"%>
<%@page import="com.bankz.enums.UserType"%>
<%@page import="com.bankz.enums.UserStatus"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import="java.util.List, java.util.ArrayList" %>
	<%@ page import="com.bankz.pojo.Account" %>
	<%@ page errorPage="/BankZ/jsp/User UI/Error.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Account Details</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width,initial-scale=1.0">
        <link rel="stylesheet" href="<%request.getContextPath(); %>/css/Common.css">
    </head>
    <style>
    	
  .container{
  	text-align:center;
  	margin-left:70px;
  	display:flex;
  }
  .content{
		text-align:center;
	}
  .content table{
        text-align: center;
		margin-left:250px;
        margin-top: 50px;
        column-gap: 100mm;
        column-width: 200px;
        border-style:groove;
        border-color: black;
        background-color: whitesmoke;
    }
    .content table th{
        width: 250px;
        height: 100px;
        background-color: #627282;
        column-fill: auto;
        padding: auto;
        text-align: center;
        border: 2px solid black;
    }.content table td{
        border: 2px solid black;
        
    }  
    
    </style>
    <body bgcolor="#273341">
        <jsp:include page="/jsp/User UI/Header.jsp"></jsp:include>
        <div class="container">
            
            <div class="content">
            <form>
                 <table>
        <tr>
            <th>Account Number</th>
            <th>Customer Id</th>
            <th>Account Type</th>
            <th>Balance</th>
            <th>Status</th>
            <th>BranchId</th>
            
         </tr>
         <% List<Account> accountList=(List<Account>)request.getAttribute("accountList");
         for( Account account:accountList){%>
        	<tr>
        		<td><%=account.getAccountNum()%></td>
        		<td><%=account.getCustomerId()%></td>
        		<td><%=AccountType.values()[account.getType()]%></td>
        		<td><%=account.getBalance() %></td>
        		<td><%=UserStatus.values()[account.getStatus()]%></td>
        		<td><%=account.getBranchId() %></td>
        		
        	</tr> 
         <% }%>
         
       </table>
       
   
               
            </form></div>
        </div>
	<jsp:include page="/jsp/User UI/NavBar.jsp"></jsp:include>
    </body>
</html>