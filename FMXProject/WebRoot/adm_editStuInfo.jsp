<%@ page import="dao.*,util.*,entity.*,java.util.*" pageEncoding="utf-8" contentType="text/html"%>
<%@include file="include.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--管理员修改学生信息界面-->
<html>
  <div id="m_right">
		<div class="content">
			<br><h2 style="margin-left:45px;">修改学生信息</h2><br>
			<form action="update.do?id=${id}" method="post">
				<table class="table_form">
					<tr>
						<td valign="middle" align="right">学生姓名：</td>
						<td valign="middle" align="left">
						<!-- <%=request.getAttribute("sname")%> -->
							<input name="sname" value="${sname}" maxlength="10" required/>
						</td>
					</tr>
					<tr>
						<td valign="middle" align="right">学生班级：</td>
						<td valign="middle" align="left">
							<input name="sclass" value="${sclass}" maxlength="10" required/>
						</td>
					</tr>
					<tr>
						<td valign="middle" align="right">学生年龄：</td>
						<td valign="middle" align="left">
							<input name="sage" value="${sage}" maxlength="3" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" required/>
						</td>
					</tr>
					<tr>
						<td valign="middle" align="right">学生性别：</td>
						<td valign="middle" align="left">
							<input name="sgender" type="radio" value="男" checked/>男 &nbsp;&nbsp;&nbsp;
							<input name="sgender" type="radio" value="女" />女
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
