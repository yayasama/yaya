<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="include.jsp" %>
<html>
<!-- 管理员修改密码界面 -->
<link type="text/css" rel="stylesheet" href="css/style.css" />
  <div id="m_right">
      <div id="stu_ar" class="row margin-top-15">
         <div class="col-md-3"></div>
         <div class="col-md-1">用户名：</div>
         <div class="col-md-8">
      <input type="text" name="username" value="${username} " size="20" disabled/></div>
      </div>
      <form action="change.admin" method="post">
      <div class="row margin-top-15">
         <div class="col-md-3"></div>
         <div class="col-md-1">新密码：</div>
         <div class="col-md-8">
      <input type="password" name="pwd" size="20"/></div>
      </div>
      <div class="row margin-top-15">	 
	     <div class="col-md-3"></div>
         <div class="col-md-1">再次输入： </div>
         <div class="col-md-8">
    <input type="password" name="pwd1" size="20"/></div>
      </div>
    <div class="row margin-top-15">
    <div class="col-md-4"></div>
    <div class="col-md-8">
    <input type="submit" value="确认"/></div>
    </div>
    <br/>
    <span style="margin-left:455px;color:red;font-style:italic;font-size:16px;position:fixed;"><c:if test="${!empty requestScope.pwd_null}">
	${requestScope.pwd_null }</c:if></span>
    <span style="margin-left:455px;color:red;font-style:italic;font-size:16px;position:fixed;"><c:if test="${!empty requestScope.pwd_error}">
	${requestScope.pwd_error }</c:if></span>
   </form>
 </div>
</html>