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
    
    <title>增加车次</title>
    
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
   <s:form name="new" action="bus_save" method="post">  
   <s:textfield name="bus.id" label="车次"/>
   <s:textfield name="bus.st_city" label="出发城市"/>
   <s:textfield name="bus.ar_city" label="到达城市"/>
   <sj:datepicker id="today" name="bus.st_time" label="出发时间"
            displayFormat="%{getText('format.date.input')}"
            changeMonth="true" changeYear="true" />
   <sj:datepicker id="tomorrow" name="bus.ar_time" label="到达时间"
            displayFormat="%{getText('format.date.input')}"
            changeMonth="true" changeYear="true" />
   <s:textfield name="bus.price" label="价格"/>
   <s:textfield name="bus.passenger_num" label="额定乘客"/>
   <s:textfield name="bus.st_station" label="出发站"/>
   <s:submit value="add"/>
   </s:form>
  </body>
</html>
