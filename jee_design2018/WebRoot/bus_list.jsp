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
    
    <title>车次管理</title>
    
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
  <a href="bus_new.jsp">添加车次</a>
   <s:property value="#row2[0]"/>
  <table style="border:1px solid green"><tr><td>车次<td>出发城市<td>到达城市<td>出发时间<td>到达时间<td>价格<td>额定乘客<td>出发站<td>action
    <s:iterator value="bussByObj" var="bus">
    <tr>
      <td><s:property value="#bus.id"/>
      <td><s:property value="#bus.st_city"/>
      <td><s:property value="#bus.ar_city"/>
      <td><s:property value="#bus.st_time"/>
      <td><s:property value="#bus.ar_time"/>
      <td><s:property value="#bus.price"/>
      <td><s:property value="#bus.passenger_num"/>
      <td><s:property value="#bus.st_station"/>
       <br>
      <td>
      <s:url var="editUrl" action="bus_edit">
         <s:param name="bus.id" value="#bus.id"/>
      </s:url>
      <a href="${editUrl}">edit</a>
      
      <s:url var="delUrl" action="bus_del">
        <s:param name="bus.id" value="#bus.id"/>
      </s:url>
      <a href="${delUrl}" onClick="return readyDel(<s:property value='#row2[0]'/>);">del</a>
      
    </s:iterator>
    </table>
    <script>
      function readyDel(id){
        return confirm("是否真的删除"+id+"车次？");
      }
    </script>
    
  </body>
</html>
