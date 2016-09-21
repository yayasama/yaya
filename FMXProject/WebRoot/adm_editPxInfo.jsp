<%@page language="java" import="dao.*,util.*,entity.*,util.*,dal.*,java.util.*" pageEncoding="utf-8"%>
<%@include file="include.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--管理员修改培训教师界面-->
<html>
<link type="text/css" rel="stylesheet" href="css/style.css" />
  <div class="m_right">
		<div class="content">
			<br><h2 style="margin-left:45px;">修改培训教师信息</h2><br>
			<form action="update.do3?id=${id}" method="post">
				<table class="table_form">
					<tr>
						<td valign="middle" align="right">教师姓名：</td>
						<td valign="middle" align="left">
							<input name="name" value="${name}" maxlength="10" required/>
						</td>
					</tr>
					<tr>
						<td valign="middle" align="right">教师年龄：</td>
						<td valign="middle" align="left">
							<input name="age" value="${age}" maxlength="3" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" required/>
						</td>
					</tr>
					<tr>
						<td valign="middle" align="right">培训机构：</td>
						<td valign="middle" align="left">
							<input name="institution" value="${institution}" maxlength="15" required/>
						</td>
					</tr>
					<tr>
						<td valign="middle" align="right">培训课程：</td>
						<td valign="middle" align="left">
							<input name="category" value="${category}" maxlength="15" required/>
						</td>
					</tr>
					<tr>
						<td valign="middle" align="right">培训时间：</td>
						<td valign="middle" align="left">
							<input name="time" value="${time}" maxlength="15" required/>
						</td>
					</tr>
					<tr>
						<td valign="middle" align="right">教师性别：</td>
						<td valign="middle" align="left">
							<input name="gender" type="radio" value="男" checked/>男 &nbsp;&nbsp;&nbsp;
							<input name="gender" type="radio" value="女"/>女
						</td>
					</tr>
				</table>
				<p style="margin-left:100px;">
					<input type="submit" class="button" value="确认" />
				</p>
			</form>
		</div>
	</div>
</html>
