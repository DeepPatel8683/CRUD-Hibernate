<%@page import="java.util.List"%>
<%@page import="com.hib.StudentDao"%>
<%@page import="com.hib.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View All Student Details</title>
</head>
<body>



<table border="1" width="50%">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Email</th>
			<th>Password</th>
			<th>Delete</th>
			<th>Update</th>
			
			
			</tr>

<%
  List<Student> list = StudentDao.GetStudentDetail();
  for (Student e : list) {

%>

     <tr>
     		<td><a href="StudentServlet?action=update&id=<%= e.getId()%>"><%=e.getId()%></td>
            <td><%=e.getName()%></td>
			<td><%=e.getEmail()%></td>
			<td><%=e.getPassword()%></td>
			<td><a href="StudentServlet?action=delete&id=<%= e.getId()%>">Delete</a></td>
			<td><a href="StudentServlet?action=update&id=<%= e.getId()%>">Update</a></td>
	</tr>


	<%
		}
		%>

</body>
</html>