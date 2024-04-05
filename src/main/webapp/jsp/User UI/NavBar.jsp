<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Navigation Bar</title>
</head>
<style>
	.navbar{
    height: 100%;
  accent-colorwidth: 300px;
  display: block;
  position: fixed;
  left: 0px;
  top: 127px;
  z-index: 5;
  background-color: #011722;
  color:red;
  }
  .navbar button{
    background-color: transparent;
    border-color: transparent;
    align-items: center;
    text-align: center;
    height: 50px;
    width:100mm;
    color: white;
    font-size: large;
  }
</style>
<body>
<%int userType=(int)request.getSession().getAttribute("userType");
	if(userType==0){ %>
		<div class="navbar">
	 <table>
                
               <tr><td><a href="/BankZ/app/createCustomerPage"><button>Add Customer</button></a></td></tr>  
               <tr><td><a href="/BankZ/app/customerPersonalDetailsPage"  ><button>Customer Details</button></a></td></tr>  
               <tr><td><a href="/BankZ/app/removeCustomerPage"><button>Remove Customer</button></a></td></tr>  
               <tr><td><a href="/BankZ/app/createAccountPage"><button>Add Account</button></a></td></tr>  
               <tr><td><a href="/BankZ/app/accountDetailsPage"><button>Account Details</button></a></td></tr>  
               <tr><td><a href="/BankZ/app/removeAccountPage"><button>Remove Account</button></a></td></tr>  
               <tr><td><a href="/BankZ/app/blockAccountPage"><button>Block Account</button></a></td></tr> 
               <tr><td><a href="/BankZ/app/createEmployeePage"><button>Add Employee</button></a></td></tr> 
               <tr><td><a href="/BankZ/app/removeEmployeePage"><button>Remove Employee</button></a></td></tr> 
               <tr><td><a href="/BankZ/app/blockEmployeePage"><button>Block Employee</button></a></td></tr> 
               <tr><td><a href="/BankZ/app/branchDetailsPage"><button>Branch Details</button></a></td></tr>  
               <tr><td><a href="/BankZ/app/createBranchPage"><button>Add Branch</button></a></td></tr> 
               <tr><td><a href="/BankZ/app/removeBranchPage"><button>Remove Branch</button></a></td></tr> 
               <tr><td><a href="/BankZ/app/transactionDetailsPage"><button>Transaction Details</button></a></td></tr>  
               <tr><td><a href="/BankZ/app/otherEmployeeDetailsPage"><button>Employee Details</button></a></td></tr>  
               <tr><td><a href="/BankZ/app/resetPasswordPage"><button>Reset Password</button></a></td></tr>  
                <tr><td><a href="/BankZ/app/checkStatus"><button>Check Status</button></a></td></tr>   
                
           </table>
     </div>
	<%}else if(userType==1){%>
		<div class="navbar">
            <table>
              
               <tr><td><a href="/BankZ/app/createCustomerPage"><button>Add Customer</button></a></td></tr>  
               <tr><td><a href="/BankZ/app/customerPersonalDetailsPage"  ><button>Customer Details</button></a></td></tr>  
               <tr><td><a href="/BankZ/app/removeCustomerPage"><button>Remove Customer</button></a></td></tr>  
               <tr><td><a href="/BankZ/app/createAccountPage"><button>Add Account</button></a></td></tr>  
               <tr><td><a href="/BankZ/app/accountDetailsPage"><button>Account Details</button></a></td></tr>  
               <tr><td><a href="/BankZ/app/removeAccountPage"><button>Remove Account</button></a></td></tr>  
               <tr><td><a href="/BankZ/app/blockAccountPage"><button>Block Account</button></a></td></tr>  
               <tr><td><a href="/BankZ/app/branchDetailsPage"><button>Branch Details</button></a></td></tr>  
               <tr><td><a href="/BankZ/app/transactionDetailsPage"><button>Transaction Details</button></a></td></tr>  
               <tr><td><a href="/BankZ/app/otherEmployeeDetailsPage"><button>Employee Details</button></a></td></tr>  
               <tr><td><a href="/BankZ/app/resetPasswordPage"><button>Reset Password</button></a></td></tr>  
                <tr><td><a href="/BankZ/app/checkStatus"><button>Check Status</button></a></td></tr>   
                
           </table>
        </div>
	<%}else{%>
		<div class="navbar">
            <table>
               <tr><td><a href="/BankZ/app/accountDetails"><button>Account Details</button></a></td></tr>   
                
               <tr><td><a href="/BankZ/app/depositPage"><button>Deposit Amount</button></a></td></tr>  
               <tr><td><a href="/BankZ/app/withdrawPage"  ><button>Withdraw Amount</button></a></td></tr>  
               <tr><td><a href="/BankZ/app/miniStatement"  ><button>Mini Statement</button></a></td></tr>  
               <tr><td><a href="/BankZ/app/resetPasswordPage"  ><button>Reset Password</button></a></td></tr>  
                <tr><td><a href="/BankZ/app/checkStatus"  ><button>Check Status</button></a></td></tr>   
                <tr><td><a href="/BankZ/app/moneyTransferPage"  ><button>Money Transfer</button></a></td></tr>  
               
           </table>
        </div>
        <%} %>
	</body>
	
</html>