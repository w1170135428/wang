<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>浏览旅客信息</title>
    
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
  旅客信息
  <table style="border:1px solid green"><tr><td>旅客姓名<td>身份证号<td>手机号
    <s:iterator value="usersByObj" var="users">
    <tr>
      <td><s:property value="#users.username"/>
      <td><s:property value="#users.userid"/>
      <td><s:property value="#users.usertelephone"/>
      <td>
   </s:iterator>
  
  <br>
  </body>
</html>
