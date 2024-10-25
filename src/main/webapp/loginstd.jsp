<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login page</title>

<style type="text/css">

h1{
text-align:center;
text-decoration:underline;
}
fieldset{
width:400px;
margin:10px auto;
background:linear-gradient(pink,yellow);
}
legend{
text-align:center;
font-size:30px;
font-weight:bold;
}

form{
display:flex;
flex-direction:column;
margin:auto;
row-gap:20px;

}
form input{
text-align:center;
padding:13px;
border-radius:15px;
}

h1{
color:red;
font-size:35px;
font-weight:bold;
}

form button{
border-radius:15px;
width:50%;
display:flex;
flex-direction:column;
margin:auto;
}

</style>

</head>
<body>

<h1>LOGIN PORTAL</h1>

<h1><marquee behavior="alternate">Student LOGIN Portal</marquee></h1>

<fieldset>
<legend>Login</legend>
<form action="login" method="post">

<input type="text" placeholder="enter your email" name="email">
<input type="text" placeholder="enter your password" name="password">

<button type="submit">Login</button>
<button type="reset">Reset</button>

</form>
</fieldset>


</body>
</html>