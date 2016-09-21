<%@ page import="dao.*,util.*,entity.*,java.util.*" pageEncoding="utf-8" contentType="text/html"%>
<%@include file="include.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 管理员添加教师界面 -->
<html>
  <div id="m_right">
		<div class="content">
			<br><h2 style="margin-left:45px;">添加教师信息</h2><br>
			<form action="add.do2" method="post">
				<table class="table_form">
					<tr>
						<td valign="middle" align="right">教师编号：</td>
						<td valign="middle" align="left">
							<input type="text" class="inputgri" name="username" maxlength="15" required/>
						</td>
						<span style="color: red; font-style: italic; font-size: 16px;">
							<c:if test="${!empty requestScope.tea_username_duplicate}">
						    ${requestScope.tea_username_duplicate} </c:if> </span>
					</tr>
					<tr>
						<td valign="middle" align="right">教师姓名：</td>
						<td valign="middle" align="left">
							<input type="text" class="inputgri" name="tname" maxlength="10" required/>
						</td>
					</tr>
					<tr>
						<td valign="middle" align="right">教师年龄：</td>
						<td valign="middle" align="left">
							<input type="text" class="inputgri" name="tage" maxlength="3" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" required/>
						</td>
					</tr>
					<tr>
						<td valign="middle" align="right">登陆密码：</td>
						<td valign="middle" align="left">
							<input type="text" class="inputgri" name="pwd" maxlength="20" required/>
						</td>
					</tr>
					<tr>
						<td valign="middle" align="right">所属院系：</td>
						<td valign="middle" align="left">
							<input type="text" class="inputgri" name="tschool" maxlength="20" required/>
						</td>
					</tr>
					<tr>
						<td valign="middle" align="right">教师性别：</td>
						<td valign="middle" align="left">
							<input name="tgender" type="radio" value="男" required/>男 &nbsp;&nbsp;&nbsp;
							<input name="tgender" type="radio" value="女" required/>女
						</td>
					</tr>
					<tr>
						<td valign="middle" align="right">用户类别：</td>
						<td valign="middle" align="left">
							<input name="usergroup" type="radio" value="2" required/>教师
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
