<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title></title>
<style>
input[type=button] {
	border: none;
	margin: 0;
	outline: 0;
	padding: 0;
	color: orange;
	background-color: #000;
	text-align: center;
	cursor: pointer;
	width: 8rem;
	height: 40px;
	font-size: 14px;
	border-radius: 2rem;
}

input[type=submit] {
	border: none;
	margin: 0;
	outline: 0;
	padding: 0;
	color: orange;
	background-color: #000;
	text-align: center;
	cursor: pointer;
	width: 8rem;
	height: 40px;
	font-size: 14px;
	border-radius: 2rem;
}

#friend {
	display: flex;
	justify-content: center;
	margin-top: 5rem;
}

#special {
	margin: 0;
	padding: 5px;
	color: orange;
	font-size: 25px;
}

ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	background-color: #f0ede9;
}

#nav {
	margin: 0;
	padding: 0;
	diplay: flex;
}

#log {
	float: right;
	padding: 3px;
}
</style>
</head>
<body>
	<form action="Logout" method="post">
		<div id="nav">

			<ul>
				<span id="special"><b>Metacube Parking</span>
				<span id="log"> <input type="submit" value="logout"></span>
			</ul>
		</div>
	</form>
	<div id="friend">
		<form action="friends" method="post">
			<a href="userdetail.jsp"><input type="button" value="showProfile"></a>
			<input type="submit" value="friends">
		</form>
	</div>
</body>
</html>