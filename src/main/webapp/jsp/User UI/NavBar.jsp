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
    align-items: left;
    text-align: left;
    height: 50px;
    width:60mm;
    color: white;
    font-size: large;
  }
  .dropdown-container {
  display: none;
  background-color: #627282;
  padding-left: 8px;
}
 .navbar a,.dropdown-btn {
  padding: 6px 8px 6px 16px;
  text-decoration: none;
  font-size: 20px;
  color: white;
  display: block;
  border: none;
  background: none;
  width: 100%;
  text-align: left;
  cursor: pointer;
  outline: none;
}

.fa-caret-down {
  float: right;
  padding-right: 8px;
}
</style>
<body>
<%int userType=(int)request.getSession().getAttribute("userType");
	if(userType==0){ %>
		<div class="navbar">
	 
              <button class="dropdown-btn">Customer 
    <i class="fa fa-caret-down"></i>
  </button>
  <div class="dropdown-container">
    <a href="/BankZ/app/createCustomerPage"><button>Add Customer</button></a>  
               <a href="/BankZ/app/customerPersonalDetailsPage"><button>Customer Details</button></a>  
               <a href="/BankZ/app/removeCustomerPage"><button>Remove Customer</button></a>  
               <a href="/BankZ/app/transactionDetailsPage"><button>Transaction Details</button></a>  
               
  </div>   
  	 <button class="dropdown-btn">Employee 
    <i class="fa fa-caret-down"></i>
  </button>
  <div class="dropdown-container">
    <a href="/BankZ/app/createEmployeePage"><button>Add Employee</button></a> 
               <a href="/BankZ/app/removeEmployeePage"><button>Remove Employee</button></a> 
               <a href="/BankZ/app/blockEmployeePage"><button>Block Employee</button></a> 
                <a href="/BankZ/app/otherEmployeeDetailsPage"><button>Employee Details</button></a>  
              
  </div>
  	<button class="dropdown-btn">Account 
    <i class="fa fa-caret-down"></i>
  </button>
  <div class="dropdown-container">
    
               <a href="/BankZ/app/createAccountPage"><button>Add Account</button></a>  
               <a href="/BankZ/app/accountDetailsPage"><button>Account Details</button></a>  
               <a href="/BankZ/app/removeAccountPage"><button>Remove Account</button></a>  
               <a href="/BankZ/app/blockAccountPage"><button>Block Account</button></a> 
               
  </div>
  <button class="dropdown-btn">Branch 
    <i class="fa fa-caret-down"></i>
  </button>
  <div class="dropdown-container">
    
               <a href="/BankZ/app/branchDetailsPage"><button>Branch Details</button></a>  
               <a href="/BankZ/app/createBranchPage"><button>Add Branch</button></a> 
               <a href="/BankZ/app/removeBranchPage"><button>Remove Branch</button></a> 
               
  </div>
               <a href="/BankZ/app/resetPasswordPage"><button>Reset Password</button></a>  
                <a href="/BankZ/app/checkStatus"><button>Check Status</button></a>   
                
           
     </div>
	<%}else if(userType==1){%>
		<div class="navbar">
			<button class="dropdown-btn">Customer 
    <i class="fa fa-caret-down"></i>
  </button>
  <div class="dropdown-container">
    <a href="/BankZ/app/createCustomerPage"><button>Add Customer</button></a>  
               <a href="/BankZ/app/customerPersonalDetailsPage"><button>Customer Details</button></a>  
               <a href="/BankZ/app/removeCustomerPage"><button>Remove Customer</button></a>  
               <a href="/BankZ/app/transactionDetailsPage"><button>Transaction Details</button></a>  
               
  </div> 
  <button class="dropdown-btn">Account 
    <i class="fa fa-caret-down"></i>
  </button>
  <div class="dropdown-container">
    
               <a href="/BankZ/app/createAccountPage"><button>Add Account</button></a>  
               <a href="/BankZ/app/accountDetailsPage"><button>Account Details</button></a>  
               <a href="/BankZ/app/removeAccountPage"><button>Remove Account</button></a>  
               <a href="/BankZ/app/blockAccountPage"><button>Block Account</button></a> 
               
  </div>
  			<a href="/BankZ/app/branchDetailsPage"><button>Branch Details</button></a>
            <a href="/BankZ/app/otherEmployeeDetailsPage"><button>Employee Details</button></a>  
            <a href="/BankZ/app/resetPasswordPage"><button>Reset Password</button></a>  
            <a href="/BankZ/app/checkStatus"><button>Check Status</button></a>   
               
            
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
	<script>
var dropdown = document.getElementsByClassName("dropdown-btn");
var i;

for (i = 0; i < dropdown.length; i++) {
  dropdown[i].addEventListener("click", function() {
    this.classList.toggle("active");
    var dropdownContent = this.nextElementSibling;
    if (dropdownContent.style.display == "block") {
      dropdownContent.style.display = "none";
    } else {
      dropdownContent.style.display = "block";
    }
  });
}
</script>
	
</html>