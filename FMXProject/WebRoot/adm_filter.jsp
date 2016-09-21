<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="include.jsp" %>
<!--管理员管理项目实施情况，按学号搜索-学号输入错误界面-->
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
	<div id="stu_all_apply">
	   <hr>
	   <h4>你输入的学号不存在或该学生没有申报项目。</h4>
	</div>
   </div>
 </html>