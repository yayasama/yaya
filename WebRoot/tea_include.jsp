<%@ page language="java" import="dao.*,util.*,entity.*,util.*,dal.*,java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.text.SimpleDateFormat"%>
<!--教师主页面-->
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>管理系统 - 教师</title>
<link type="text/css" rel="stylesheet" href="lib/bootstrap/css/bootstrap.css"/>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="js/menu.js"></script>
<script type="text/javascript" src="lib/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div class="top"></div>
<div class="header">
	<div class="logo">学生实践创新项目管理系统 - 教师</div>
	<div class="navigation">
		<ul>
		 	<li>欢迎您，${tname}！</li>
		 	<li>日期：<%SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd"); %>
				<%=sd.format(new Date())%></li>
			<li><a href="login.jsp">退出</a></li>
		</ul>
	</div>
</div>
	<div class="left_menu">
	 <ul id="nav_dot">
	 <li>
          <h4 class="M3">申请项目</h4>
          <div class="list-item none">
            <a href="<c:url value="listallpro.apply2" /> ">申请实践项目</a>
          </div>
        </li>
      <li>
          <h4 class="M1">审核项目</h4>
          <div class="list-item none">
            <a href="<c:url value="listpro.review" /> ">学生申报项目</a>
          </div>
        </li> 
        <li>
          <h4 class="M2">审核报告</h4>
          <div class="list-item none">
            <a href="<c:url value="listjidu.review" /> ">审核季度报告</a>
            <a href="<c:url value="listzhongqi.review" /> ">审核中期报告</a>
            <a href="<c:url value="listjieti.review" /> ">审核结题报告</a>
           </div>
        </li>
  </ul>
</div>
<div class="bottom"></div>
<div class="footer"></div>
<script>navList(4);
</script>
</body>
</html>
