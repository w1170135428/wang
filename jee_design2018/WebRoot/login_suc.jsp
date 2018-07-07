<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjr" uri="/struts-jquery-richtext-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户界面</title>
    
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
登陆成功，欢迎使用汽车购票系统<br>
<s:select list name="" label="出发城市" headerValue="--请选择--"headerKey="1"list=""></s:select>
<br>
<s:select list name="" label="到达城市" headerValue="--请选择--"headerKey="1"list=""></s:select>
<br>
<sj:datepicker name="test_date_jquery" label="Select a Date"
            displayFormat="%{getText('format.date.input')}"
            changeMonth="true" changeYear="true" />
<br>
<s:a href="http://localhost:8080/jee_design/WebRoot/order_list.jsp">查询我的订单</s:a>
  </body>
</html>
