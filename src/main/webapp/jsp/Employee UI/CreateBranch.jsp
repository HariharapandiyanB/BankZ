<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Branch Details</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width,initial-scale=1.0">
        
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
            <h1>Branch Details</h1>
            <form action="app/createBranch" method="post">
                <table>
                    <tr><td>BranchId</td><td><input type="number" name="branchId"></td></tr>
                    <tr><td>Branch Name</td><td><input type="text" name="name"></td></tr>
                    <tr><td>IFSC Code</td><td><input type="text" name="ifscCode"></td></tr>
                    <tr><td>Address</td><td><input type="text" name="address"></td></tr>
                    <tr><td>No. of Active Employees</td><td><input type="number" name="numOfActiveEmployees"></td></tr>
                    <tr><td>No. of Active Accounts</td><td><input type="number" name="numOfActiveAccounts"></td></tr>
                </table>
                <button style="margin-top: 20px; width: 80px;" type ="submit">Submit</button>
            </form>
        </div>
		<jsp:include page="/jsp/User UI/NavBar.jsp"></jsp:include>
    </body>
</html>