<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login_suc.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   <s:form name="edit" action="bus_update" method="post">
   <s:hidden name="bus.id"/>  
   <s:textfield name="bus.id" label="id"/>
   <s:textfield name="bus.start" label="start"/>
   <s:textfield name="bus.arrive" label="arrive"/>
   <s:textfield name="bus.st_time" label="st_time"/>
   <s:textfield name="bus.ar_time" label="ar_time"/>
   <s:textfield name="bus.price" label="price"/>
   <s:textfield name="bus.passenger_num" label="passenger_num"/>
   <s:textfield name="bus.st_station" label="st_station"/>
   <s:submit value="update"/>
   </s:form>
  </body>
</html>
