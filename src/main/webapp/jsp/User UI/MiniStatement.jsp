<%@page import="com.bankz.helper.Supplement"%>
<%@page import="com.bankz.pojo.Transaction"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List, java.util.ArrayList" %>
	<%@ page import="com.bankz.pojo.Transaction" %>

	
    
<!DOCTYPE html>
<html>

<head>
    <title>Mini Statement</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0">
    <link rel="stylesheet" href="<%request.getContextPath(); %>css/sCustomerFrontPageStyle.css">

</head>
<style>
	.content{
		text-align:center;
	}
    .content table{
        text-align: center;
		margin-right:0px;
		margin-left:250px;
        margin-top: 50px;
        column-gap: 100mm;
        column-width: 200px;
        border-style:groove;
        border-color: black;
        background-color: whitesmoke;
    }
    .content table th{
        width: 200px;
        height: 100px;
        background-color: #627282;
        column-fill: auto;
        padding: auto;
        text-align: center;
        border: 2px solid black;
    }
    .content table td{
    	border: 2px solid black;
    
    }
</style>
<body bgcolor="#273341">
    <jsp:include page="/jsp/User UI/Header.jsp"></jsp:include>
    
    <div class="content">
    <table>
        <tr>
            <th>Transaction Id</th>
            <th>Amount</th>
            <th>Balance</th>
            <th>Sender Account No.</th>
            <th>Receiver Account No.</th>
            <th>Time</th>
            <th>Description</th>
         </tr>
         <% List<Transaction> transactionList=(List<Transaction>)request.getAttribute("transactionList");
         for( Transaction transaction:transactionList){%>
        	<tr>
        		<td><%= transaction.getTransactionId()%></td>
        		<td><%=transaction.getTranscationAmount()%></td>
        		<td><%=transaction.getBalance() %></td>
        		<td><%=transaction.getPrimaryAccNum() %></td>
        		<td><%=transaction.getSecondaryAccNum()%></td>
        		<td><%=Supplement.millisToActualTime(transaction.getTimeStamp())%></td>
        		<td><%=transaction.getDescription() %></td>
        	</tr> 
         <% }%>
         
       </table></div>
       <a href="/BankZ/app/miniStatement"><button style="margin-left: 80%;margin-top: 20%;width: 150px;" 
       																onclick="setIterationFatcor()">Next</button></a>
      <jsp:include page="/jsp/User UI/NavBar.jsp"></jsp:include>
      <script>
       		function setIterationFactor(){
       			session.setAttribute("i",1);
       		}
       </script>
    </body>