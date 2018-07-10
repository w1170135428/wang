<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
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
    <s:head/>
    <sj:head/>
  </head>
  
  <body>
登陆成功，欢迎使用汽车购票系统<br><br>



<s:form action="findByPassenger" method ="post">
<s:select name="bus.st_city" label="出发城市" headerValue="--请选择--" headerKey="1" list="{'北京','天津','上海','南京','广州','大理','福州','郑州','深圳','大同','西安','武汉','长沙','成都','重庆','宁夏','长春','哈尔滨','珠海','厦门','杭州','沈阳','合肥'}"></s:select>
<s:select name="bus.ar_city" label="到达城市" headerValue="--请选择--" headerKey="1" list="{'北京','天津','上海','南京','广州','大理','福州','郑州','深圳','大同','西安','武汉','长沙','成都','重庆','宁夏','长春','哈尔滨','珠海','厦门','杭州','沈阳','合肥'}"></s:select>
 <sj:datepicker id="today" name="bus.st_time	" label="出发时间"
            displayFormat="%{getText('format.date.input')}"
            changeMonth="true" changeYear="true" />
<s:submit  value="查询车次" />
</s:form>
<br>
<s:url var="orderUrl" action="OrderAction" ></s:url>
<a href="${orderUrl}">查询我的订单</a><br><br>

  </body>
</html>