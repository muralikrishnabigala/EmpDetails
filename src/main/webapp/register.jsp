<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Page</title>

<style type="text/css">


fieldset{
width:400px;
margin:10px auto;
background:linear-gradient(pink,yellow);
border-radius: 20px;
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

<h1><marquee behavior="alternate">Employee Registration Portal</marquee></h1>

<fieldset>
<legend>Registration</legend>
<form action="register" method="post">
<input type="text" placeholder="enter your ID" name="id">
<input type="text" placeholder="enter your name" name="name">
<input type="text" placeholder="enter your email" name="email">
<input type="text" placeholder="enter your phn no." name="phn">
<input type="text" placeholder="enter your Role" name="course">
<input type="text" placeholder="enter your password" name="password">

<button type="submit">Register</button>
<button type="reset">Reset</button>

</form>
</fieldset>
</body>
</html>