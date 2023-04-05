
<%@page import="com.hib.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page import="com.hib.StudentDao"%>
<%@page import="com.hib.Student"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
<title>Insert title here</title>
</head>
<body>

<%  
 Student e = (Student)request.getAttribute("student");
%> 

<form action="StudentServlet?action=update" method="post">  
<input type="hidden" name="id" value="<%=e.getId() %>"/>  
<table>  
<tr><td>Name:</td><td>  
<input type="text" name="name" value="<%= e.getName()%>" /></td></tr> 
<tr><td>Email:</td><td>  
<input type="email" name="email" value="<%= e.getEmail()%>" /></td></tr> 
<tr><td>Password:</td><td>  
<input type="password" name="password" value="<%= e.getPassword()%>"  /></td></tr>  

  

<tr><td colspan="2"><input type="submit" /></td></tr> 
</table>  
</form> 


</body>
</html>