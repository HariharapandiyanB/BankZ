<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
<html>
    <head>
        <title>Customer Panel.bankZ</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width,initial-scale=1.0">
        <link rel="stylesheet" href="<%= request.getContextPath() %>/css/CustomerFrontPage.css">

    </head>
    <style>
	
  .container{
    background-color:transparent;
    display:flex;
    flex-direction: column;
    width: 20%;
    height: 40%;
    margin-top: 10%;
    margin-left: 40%;
    box-shadow: 0 2px 15px 0 rgba(30,37,44,0.29);
    border-radius: 5%;
    text-align: center;
    
  }
  .container button{
 
    align-items: center;
    text-align: center;
    border-radius: 10px;
    padding: 10px;
    width:100mm;
   
   
    
  }
  button{
 
    align-items: center;
    text-align: center;
    border-radius: 10px;
    padding: 10px;
    width:fit-content;
   
   
    
  }    
    </style>
    <body bgcolor="#273341">
       <jsp:include page="/jsp/User UI/Header.jsp"></jsp:include>
        <jsp:include page="/jsp/User UI/NavBar.jsp"></jsp:include>
    </body>
</html>