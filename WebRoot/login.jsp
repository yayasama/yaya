<%@ page language="java" import="dao.*,util.*,entity.*,util.*,dal.*,java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--登陆界面-->
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>登陆</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/login_style.css" rel="stylesheet" type="text/css" />
</head>

<body class="login">
<div class="login_m">
	<div class="login_logo">学生实践创新项目管理系统 - 登陆</div>
	<div class="login_boder">
	<form action="login.in" method="post">
		<div class="login_padding">
			<h2>用户名</h2>
				<input type="text" name="username" class="txt_input txt_input2" maxlength="20" placeholder="请输入你的用户名" />
				<span style="color:red;font-style:italic;font-size:16px;">
				<c:if test="${!empty requestScope.username_error}">
						${requestScope.username_error} </c:if>
			    </span>
			    <span style="color:red;font-style:italic;font-size:16px;">
				<c:if test="${!empty requestScope.username_null}">
						${requestScope.username_null} </c:if>
			    </span>
			<h2>密码</h2>
				<input type="password" name="pwd" class="txt_input" maxlength="20" placeholder="请输入密码" />
				<span style="color:red;font-style:italic;font-size:16px;">
				<c:if test="${!empty requestScope.pwd_error}">
						 ${requestScope.pwd_error }</c:if>
			    </span>	
			<div class="rem_sub">
				<input type="submit" class="sub_button" name="button" value="登录" style="opacity: 0.7;"/>
			</div>
		</div>
		</form>
	</div>
</div>
</body>
</html>