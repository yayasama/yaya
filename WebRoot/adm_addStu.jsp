<%@ page import="dao.*,util.*,entity.*,java.util.*" pageEncoding="utf-8" contentType="text/html"%>
<%@include file="include.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 管理员添加学生页面 -->
<html>
  <div id="m_right">
		<div class="content">
			<br><h2 style="margin-left:45px;">添加学生信息</h2><br>
			<form action="add.do" method="post">
				<table class="table_form">
					<tr>
						<td valign="middle" align="right">学生学号：</td>
						<td valign="middle" align="left">
							<input type="text" class="inputgri" name="username" maxlength="10" required />
						</td>
						<span style="color: red; font-style: italic; font-size: 16px;">
							<c:if test="${!empty requestScope.username_duplicate}">
						    ${requestScope.username_duplicate} </c:if> </span>
					</tr>
					<tr>
						<td valign="middle" align="right">学生姓名：</td>
						<td valign="middle" align="left">
							<input type="text" class="inputgri" name="sname" maxlength="10" required/>
						</td>
					</tr>
					<tr>
						<td valign="middle" align="right">学生班级：</td>
						<td valign="middle" align="left">
							<input type="text" class="inputgri" name="sclass" maxlength="10" required/>
						</td>
					</tr>
					<tr>
						<td valign="middle" align="right">学生年龄：</td>
						<td valign="middle" align="left">
							<input type="text" class="inputgri" name="sage" maxlength="3" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" required/>
						</td>
					</tr>
					<tr>
						<td valign="middle" align="right">登陆密码：</td>
						<td valign="middle" align="left">
							<input type="text" class="inputgri" name="pwd" maxlength="20" required/>
						</td>
					</tr>
					<tr>
						<td valign="middle" align="right">学生性别：</td>
						<td valign="middle" align="left">
							<input name="sgender" type="radio" value="男" required/>男 &nbsp;&nbsp;&nbsp;
							<input name="sgender" type="radio" value="女" required/>女
						</td>
					</tr>
					<tr>
						<td valign="middle" align="right">用户类别：</td>
						<td valign="middle" align="left">
							<input name="usergroup" type="radio" value="3" required/>学生</td>
					</tr>
				</table>
				<p style="margin-left:100px;">
					<input type="submit" class="button" value="确认" />
				</p>
			</form>
		</div>
	</div>
</html>
