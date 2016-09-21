<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="tea_include.jsp" %>
<!--教师按学号搜索学生项目界面，学号不存在的情况 -->
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
	 <div id="stu_all_apply">
	   <hr>
	   <h4>你输入的学号不存在或该学生没有申报项目。</h4>
	</div>
</div>
 </html>