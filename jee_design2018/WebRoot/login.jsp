<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">

    <title>欢迎使用汽车购票系统</title>
    
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
  欢迎使用汽车购票系统<br>
   <form action="LoginAction" method ="post">
    <s:actionerror/>
    <s:fielderror/>
  账号:<input name="username" type="text">
  <br>
  密码:<input name="password" type="password">
  <br>
  <input type="submit" value="登录">
 </form>
<a href="register.jsp">注册</a><br>
 </body>
</html>
