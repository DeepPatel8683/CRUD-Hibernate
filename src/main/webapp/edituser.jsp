<%@page import="com.hib.StudentDao"%>
 
<jsp:useBean id="e" class="com.hib.Student"></jsp:useBean>  
<jsp:setProperty property="*" name="e"/>  
<%  
int i=StudentDao.update(e);  
response.sendRedirect("AllStuden_Details.jsp");  
%>  