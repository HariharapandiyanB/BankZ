<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Account Number</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width,initial-scale=1.0">
        <link rel="stylesheet" href="<%=request.getContextPath() %>/css/Common.css">
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
            
            <form action="app/<%=session.getAttribute("operation") %>" method="get">
                
                <h3>Account Number</h3><input type="number" name="accountNumber">
                
                
                    
                <button style="margin-top: 20px; width: 80px;" type ="submit">Submit</button>
            </form>
        </div>
        <jsp:include page="/jsp/User UI/NavBar.jsp"></jsp:include>

    </body>
</html>