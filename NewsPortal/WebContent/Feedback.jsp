<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@page import="daofiles.FeedbackDao"%>  
<jsp:useBean id="u" class="beans.FeedbackBean"></jsp:useBean>  
<jsp:setProperty property="*" name="u"/>  
<%  
int i=FeedbackDao.save(u);
response.sendRedirect("ReporterHome.jsp");  
%>  
</body>
</html>