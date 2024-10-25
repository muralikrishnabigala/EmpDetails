<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">

table{
margin:auto;
}

h1{
text-align:center;
}

table thead{
background-color:grey;
text-align:center;
font-weight:bold;
}

#btn{
   margin-left:67%;
  
}
</style>


</head>
<body>

<h1>All Employee Details</h1>

<button type="submit" id="btn"><a href="register.jsp">Register New  Employee</a></button>
<table border="4" cellpadding="10px" cellspacing="10px">

<thead>
<tr>
<th>ID</th>
<th>NAME</th>
<th>E-MAIL</th>
<th>PHN</th>
<th>ROLE</th>	
<th>PASSWORD</th>
<th colspan="2">ACTION</th>

</tr>

</thead>

      <%
		ResultSet rs = (ResultSet) request.getAttribute("rs");
		while (rs.next()) {
			
		%>
		
		<tr>
				<td><%=rs.getInt(1)%></td>
				<td><%=rs.getString(2)%></td>
				<td><%=rs.getString(3)%></td>
				<td><%=rs.getLong(4)%></td>
				<td><%=rs.getString(5) %>
				<td><%=rs.getString(6)%></td>
				<td><button><a href="delete?id=<%=rs.getInt(1)%>">delete</a></button></td>
				<td><button><a href="updatepage?id=<%=rs.getInt(1)%>">update</a></button></td>
				
			</tr>
	
     <%
		}
     %>

</table>

</body>
</html>