<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="stu_include.jsp" %>
<!--学生项目审核不通过界面，点击申报项目出现的界面-->
<html>
<link type="text/css" rel="stylesheet" href="css/style.css" />
  <div id="m_right">
  <div id="stu_all_apply">
    <p>你的实践项目审核不通过，请联系你的指导老师。</p><br>
    <a href="<c:url value="reviewfail.apply" /> ">修改</a>
   </div>
   </div>
</html>