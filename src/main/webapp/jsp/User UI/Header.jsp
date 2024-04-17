<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Header</title>
</head>
<style>
.header {
	display:flex;
flex-direction:row;
align-items:center;
	background-color: #627282;
	color: white;
	width:100%
	top: 0px;
	height: 100px;
	text-align: center;
	padding: 10px;
	
}
.header button {
	text-align: center;
	border-radius: 15px;
	background-color: white;
	margin-left: 10px;
	width: 150px;
}
img {

	text-align: center;
	border-radius: 15px;
	margin-left:430px;
	padding: 20px;
	width:150px;
	height:150px;
}
</style>
<body>
	<div class="header">
		<h1 style="margin-left:50%">bankZ</h1>
		<a href="/BankZ/app/getIconPage"><img alt="icon" src="../jsp/user-icon1.png"></a>
		<a href="/BankZ/app/login"><button>logout</button></a>


	</div>
</body>
</html>