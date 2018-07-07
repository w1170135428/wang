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
  <a href="bus_new.jsp">add bus</a>
  <table style="border:1px solid green"><tr><td>id<td>start<td>arrive<td>st_time<td>ar_time<td>price<td>passenger_num<td>st_station<td>action
    <s:iterator value="bus" var="row2">
    <tr>
      <td><s:property value="#row2[0]"/>
      <td><s:property value="#row2[1]"/>
      <td><s:property value="#row2[2]"/>
      <td><s:property value="#row2[3]"/>
      <td><s:property value="#row2[4]"/>
      <td><s:property value="#row2[5]"/>
      <td><s:property value="#row2[6]"/>
      <td><s:property value="#row2[7]"/>
      <td>
      <s:url var="editUrl" action="bus_edit">
         <s:param name="bus.id" value="#row2[0]"/>
      </s:url>
      <a href="${editUrl}">edit</a>
      
      <s:url var="delUrl" action="bus_del">
        <s:param name="bus.id" value="#row2[0]"/>
      </s:url>
      <a href="${delUrl}" onClick="return readyDel(<s:property value='#row2[0]'/>);">del</a>
      
    </s:iterator>
    </table>
    用对象bus来得到所有车次
    <s:iterator value="stusByObj" var="stu">
       id:<s:property value="#bus.id"/>
       <br>
    </s:iterator>
    <script>
      function readyDel(id){
        return confirm("是否真的删除"+id+"车次？");
      }
    </script>
    
  </body>
</html>
