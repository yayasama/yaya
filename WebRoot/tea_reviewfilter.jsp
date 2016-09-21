<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="tea_include.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--教师审核学生申报的项目界面，按学号搜索后出现的内容-->
<html>
<link type="text/css" rel="stylesheet" href="css/style.css" />
  <div id="m_right">
  <h5 style="position:absolute;top:100px;left:780px;">
    <form action="username.review" method="post">
          根据学生学号搜索：&nbsp;<input type="text" class="inputgri" size="10" name="username" />
    &nbsp;<input type="submit" class="button" value="搜索" /></form></h5>
    <h5 style="position:absolute;top:100px;left:1060px;">
    <form action="listpro.review" method="post">
    &nbsp;<input type="submit" class="button" value="查看全部" /></form></h5><br><br>
	 <table class="table-1">
		<tr class="stu_table1">
			<td width="80px">学生学号</td>
			<td width="80px">学生姓名</td>
			<td width="400px">项目名称</td>
			<td width="80px">指导老师</td>
			<td width="100px">申报时间</td>
			<td width="80px">审核结果</td>
	</tr>
	
	<tr class="stu_table2">	
			<td>${username}</td>
			<td>${sname}</td>
			<td>${title}</td>
			<td>${guidetea}</td>
			<td>${finishtime}</td>
			<td>${resulttea}</td>
			</tr>	
	</table>
</div>
 </html>