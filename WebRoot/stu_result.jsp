<%@page language="java" import="dao.*,util.*,entity.*,util.*,dal.*,java.util.*" pageEncoding="utf-8"%>
<%@include file="stu_include.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--学生查看审核结果界面-->
<html>
<link type="text/css" rel="stylesheet" href="css/style.css" />
  <div id="m_right"> 
	 <table class="table-1">
		<tr class="stu_table1">
			<td width="80px">学号</td>
			<td width="80px">姓名</td>
			<td width="400px">项目名称</td>
			<td width="120px">教师审核结果</td>
	</tr>
	
	<tr class="stu_table2">
			<td>${username}</td>
			<td>${sname}</td>
			<td>${title}</td>
			<td>${resulttea}</td>
	</tr>	
	</table><br>
  </div>
 </html>