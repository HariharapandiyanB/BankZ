<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page errorPage="request.getContextPath()/jsp/User UI/Error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>bankZ login</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/LoginStyles.css">

</head><style>
	
.header{
  background-color:#627282;
  color: white;
  margin-top: 30px;
  text-align: center;
  padding:20px;
  border-radius: 15px;
}
.formBox{
  background-color:#627282;
  display:flex;
  flex-direction: column;
  width: 20%;
  height: 40%;
  margin-top: 10%;
  margin-left: 40%;
  box-shadow: 0 2px 15px 0 rgba(30,37,44,0.29);
  border-radius: 5%;
  text-align: center;
  padding-bottom:20px;
  
}
.userElements{
  display: flex;
  margin-top: 20px;
}
.userIdBoxSpace{
 display: flex;
  margin-top: 5%;
  margin-left: auto;
  
}
.passwordIdBoxSpace{
  display: flex;
  margin: auto;
  margin-top: 20px;
  text-align: center;
}

.endSearch{
  padding-top: 30px;
  text-align: center;

}
.forgotPassword{ margin:auto;
  text-align: center;
  padding: 20px;
  font-size: 8px;
}
button{
 
  align-items: center;
  text-align: center;
  border-radius: 10px;
  padding: 10px;
  width: 40%;
 
 
  
}

input{
  
  width: 60%;
  padding: 10px;
  border-radius: 10px;
 
 
  
}
img{
  display: inline-block;
  width: 18%;
  height: 18%;
  margin-left: 20%;

}

	
</style>

<body>
	<div class="header">
		<h1>bankZ!</h1>
	</div>
	<div class="formBox">
		<form action="dashboard" method="post">
			<h1>
				<b>Login</b>
			</h1>
			<div class="userIdBoxSpace">
				<input style="margin-left: 70px; width: 60%; align: center;"
					type="number" min="1"  name="userId" placeholder="userId" required>

			</div>
			<div class="passwordIdBoxSpace">
				<input style="margin-left: 70px; width: 60%; align: center;"
					type="password" name="password" placeholder="password" required>
			</div>
			<div class="endSearch">

				<button
					style="background-color: #627282; border-color: #627282; color: white;">Submit</button>
				

			</div>
		</form>

	</div>
	
</body>
</html>