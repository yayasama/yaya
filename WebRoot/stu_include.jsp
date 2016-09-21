<%@ page language="java" import="dao.*,util.*,entity.*,util.*,dal.*,java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.text.SimpleDateFormat"%>
<!DOCTYPE>
<!--学生主界面-->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>管理系统 - 学生</title>
<link type="text/css" rel="stylesheet" href="lib/bootstrap/css/bootstrap.css"/>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="js/menu.js"></script>
<script type="text/javascript" src="lib/bootstrap/js/bootstrap.min.js"></script>
</head>

<body>
<div class="top"></div>
<div class="header">
	<div class="logo">学生实践创新项目管理系统 - 学生</div>
	<div class="navigation">
		<ul>
		 	<li>欢迎您，${sname}！</li>
		 	<li>日期：<%SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd"); %>
				<%=sd.format(new Date())%></li>
			<li><a href="login.jsp">退出</a></li>
		</ul>
	</div>
</div>
	<div class="left_menu">
	 <ul id="nav_dot">
      <li>
          <h4 class="M1">申报项目</h4>
          <div class="list-item none">
            <a href="<c:url value="judgeapply.apply" /> ">申报实践项目</a>
          </div>
        </li> 
        <li>
          <h4 class="M3">查看结果</h4>
          <div class="list-item none">
            <a href="<c:url value="result.apply" /> ">查看结果</a>
          </div>
        </li>
        <li>
          <h4 class="M2">提交报告</h4>
          <div class="list-item none">
            <a href="<c:url value="judge1.report" /> ">提交季度报告</a>
            <a href="<c:url value="judge2.report" /> ">提交中期报告</a>
            <a href="<c:url value="judge3.report" /> ">提交结题报告</a>
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
