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
  <form>
管理员，欢迎登录<br>
请选择您要进行的操作：<br>
<s:url var="listUrl" action="BusAction" ></s:url>
<a href="${listUrl}">管理车次信息</a><br>
 <s:url var="orderUrl" action="OrderAction" ></s:url>
<a href="${orderUrl}">购票统计</a><br>  
<s:url var="userUrl" action="UserAction" ></s:url>
<a href="${userUrl}">浏览旅客信息</a><br>
</form>
 </body>
</html>
