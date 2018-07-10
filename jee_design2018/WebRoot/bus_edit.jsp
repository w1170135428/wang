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
    
    <title>修改车次信息</title>
    
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
   <s:form name="update" action="BusAction.update" method="post">
   <s:hidden name="bus.id"/>  
   <s:textfield name="bus.id" label="id"/>
   <s:textfield name="bus.st_city" label="st_city"/>
   <s:textfield name="bus.ar_city" label="ar_city"/>
  <sj:datepicker id="today" name="bus.st_time" label="st_time"
            displayFormat="%{getText('format.date.input')}"
            changeMonth="true" changeYear="true" />
   <sj:datepicker id="tomorrow" name="bus.ar_time" label="ar_time"
            displayFormat="%{getText('format.date.input')}"
            changeMonth="true" changeYear="true" />
   <s:textfield name="bus.price" label="price"/>
   <s:textfield name="bus.passenger_num" label="passenger_num"/>
   <s:textfield name="bus.st_station" label="st_station"/>
   <s:submit value="update"/>
   </s:form>
  </body>
</html>
