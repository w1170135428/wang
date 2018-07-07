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
    
    <title>管理员操作界面</title>
    
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
管理员，欢迎登录<br>
请选择您要进行的操作：<br>
<s:a href="http://localhost:8080/jee_design/WebRoot/bus_list.jsp">管理车次信息</s:a><br>
<s:a href="http://localhost:8080/jee_design/WebRoot/order_list.jsp">购票统计</s:a><br>
<s:a href="http://localhost:8080/jee_design/WebRoot/user_list.jsp">浏览旅客信息</s:a><br>
 </body>
</html>
