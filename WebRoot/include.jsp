<%@ page language="java" import="dao.*,util.*,entity.*,util.*,dal.*,java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.text.SimpleDateFormat"%>
<!DOCTYPE>
<!--管理员主界面-->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>管理系统 - 管理员</title>
<link type="text/css" rel="stylesheet" href="lib/bootstrap/css/bootstrap.css"/>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="js/menu.js"></script>
<script type="text/javascript" src="lib/bootstrap/js/bootstrap.min.js"></script>
</head>

<body>
<div class="header">
	<div class="logo">学生实践创新项目管理系统 - 管理员</div>
	<div class="navigation">
		<ul>
		 	<li>欢迎您，管理员！</li>
		 	<li>日期：<%SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd"); %>
				<%=sd.format(new Date())%></li>
			<li><a href="<c:url value="adm_changepwd.jsp" /> ">修改密码</a></li>
			<li><a href="login.jsp">退出</a></li>
		</ul>
	</div>
</div>
	<div class="left_menu">
	 <ul id="nav_dot">
      <li>
          <h4 class="M1">审核项目</h4>
          <div class="list-item none">
            <a href="<c:url value="listtea.admin" /> ">教师申报项目</a>
          </div>
  
        </li> 
        <li>
          <h4 class="M2">发布项目</h4>
          <div class="list-item none">
            <a href="<c:url value="distribute.admin" /> ">向学生发布项目</a>
           </div>
        </li>
        <li>
          <h4 class="M3">管理项目</h4>
          <div class="list-item none">
            <a href="<c:url value="manage.admin" /> ">项目实施情况</a>
          </div>
        </li>
			<li>
          <h4 class="M4">管理信息</h4>
          <div class="list-item none">
            <a href="<c:url value="list.do" /> ">管理学生信息</a>
            <a href="<c:url value="list.do2" /> ">管理教师信息</a>
            <a href="<c:url value="list.do3" /> ">培训教师信息</a>
          </div>
        </li>
  </ul>
</div>
<div class="footer"></div>
<script>navList(4);
</script>
</body>
</html>
