<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
            <h1>Account Details</h1>
            <form action="app/createAccount" method="post">
                <table>
                    <tr><td>UserId</td><td><input type="number" name="userId" required></td></tr>
                    <tr><td>Account Number</td><td><input type="number" name="accountNumber" required></td></tr>
                    <tr><td>Initial Balance</td><td><input type="number" name="initialBalance" required></td></tr>
                    <tr><td>Account Type</td><td><input type="text" name="accountType" required></td></tr>
                    <tr><td>Account Status</td><td><input type="text" name="accountStatus" required></td></tr>
                    <tr><td>Branch Id</td><td><input type="number" name="branchId" required></td></tr>
                </table>
                <button style="margin-top: 20px; width: 80px;" type ="submit">Submit</button>
            </form>
        </div>
		
           <jsp:include page="/jsp/User UI/NavBar.jsp"></jsp:include>
       
    </body>
</html>