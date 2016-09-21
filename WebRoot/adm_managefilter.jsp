<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="include.jsp" %>
<!--管理员管理管理项目实施情况界面，按学号搜索-->
<html>
<link type="text/css" rel="stylesheet" href="css/style.css" />
  <div id="m_right">
    <h3 style="position:absolute;top:100px;left:300px;">项目完成情况</h3><br><br>
    <h5 style="position:absolute;top:100px;left:850px;">
    <form action="username.admin" method="post">
          根据学号搜索：&nbsp;<input type="text" class="inputgri" size="10" name="username" />
    &nbsp;<input type="submit" class="button" value="搜索" /></form></h5>
    <h5 style="position:absolute;top:100px;left:1100px;">
    <form action="manage.admin" method="post">
    &nbsp;<input type="submit" class="button" value="查看全部" /></form></h5>
	
	 <table class="table-1"> 
		<tr class="stu_table1">
			<td width="300px">项目名称</td>
			<td width="80px">学生学号</td>
			<td width="80px">学生姓名</td>
			<td width="75px">申报人</td>
			<td width="110px">学生完成情况</td>
			<td width="110px">教师审核情况</td>
			<td width="90px">完成时间</td>
	    </tr>
	   <tr class="stu_table2">	
	        <td>${title}</td>
			<td>${username}</td>
			<td>${sname}</td>
			<td>${guidetea}</td>
			<td>${finish}</td>
			<td>${resulttea}</td>
			<td>${finishtime}</td>
			</tr>	
	</table>
   </div>
 </html>