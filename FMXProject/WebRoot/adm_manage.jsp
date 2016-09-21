<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="include.jsp" %>
<!--管理员管理项目实施情况界面-->
<html>
<script>
function firstpage() {
	var strBack = "manage.admin";
	document.form1.action = strBack;
	document.form1.submit();
}
function before(currentPage, pageSize) {
	this.currentPage = currentPage - 1;
	this.pageSize = pageSize;
	var strBefore = "page.admin?currentPage=" + this.currentPage
			+ "&pageSize=" + this.pageSize
	if (this.currentPage <= 0) {
		alert("当前已经是第一页");
	}
	document.form2.action = strBefore;
	document.form2.submit();

}
function back(currentPage, pageSize, pageCount) {
	this.currentPage = currentPage + 1;
	this.pageSize = pageSize;
	var strBack = "page.admin?currentPage=" + this.currentPage
			+ "&pageSize=" + this.pageSize;
	if (this.currentPage > pageCount) {
		alert("当前已经是最后一页");
		return;
	}
	document.form3.action = strBack;
	document.form3.submit();
}
function endpage(pageSize, pageCount) {
	this.currentPage = pageCount;
	this.pageSize = pageSize;
	var strBack = "page.admin?currentPage=" + this.currentPage
			+ "&pageSize=" + this.pageSize;
	document.form4.action = strBack;
	document.form4.submit();
}
</script>
<link type="text/css" rel="stylesheet" href="css/style.css" />
  <div id="m_right">
    <h3 style="position:absolute;top:100px;left:300px;">项目完成情况</h3><br><br>
    <form action="username.admin" method="post">
    <h5 style="position:absolute;top:100px;left:850px;">
          根据学号搜索：&nbsp;<input type="text" class="inputgri" size="10" name="username" />
    &nbsp;<input type="submit" class="button" value="搜索" /></form></h5>
    <h5 style="position:absolute;top:100px;left:1100px;">
    <form action="manage.admin" method="post">
    &nbsp;<input type="submit" class="button" value="查看全部" /></form></h5>
	
	
	 <table class="table-1"> 
		<tr class="stu_table1">
			<td width="300px">项目名称</td>
			<td width="80px">学生学号</td>
			<td width="80px">学生姓名</td>
			<td width="75px">申报人</td>
			<td width="110px">学生完成情况</td>
			<td width="110px">教师审核情况</td>
			<td width="90px">完成时间</td>
	</tr>
	
	<!-- 接受传入的pro对象 -->
	<c:forEach items="${requestScope.pro}" varStatus="status" var="p" >
	<tr class="row${status.index%2+1}"></tr>
	<tr class="stu_table2">	
	        <td>${p.title}</td>
			<td>${p.username}</td>
			<td>${p.sname}</td>
			<td>${p.guidetea}</td>
			<td>${p.finish}</td>
			<td>${p.resulttea}</td>
			<td>${p.finishtime}</td>
			</tr></c:forEach>		
	</table>
	
		<table class="page">
			<tr>
				<td width="66">
					<form name="form1" method="post">
						<input type="submit" name="Submit" value="首 页"
							onClick="firstpage()">
					</form>
				</td>
				<td width="93">
					<form name="form2" method="post" action="">
						<input type="submit" name="Submit2" value="上一页"
							onClick="before(${pageinf[2]},${pageinf[3]})">
					</form>
				</td>
				<td width="84">
					<form name="form3" method="post" action="">
						<input type="submit" name="Submit3" value="下一页"
							onClick="back(${pageinf[2]},${pageinf[3]},${pageinf[1]})">
					</form>
				</td>
				<td width="70">
					<form name="form4" method="post" action="">
						<input type="submit" name="Submit4" value="末 页"
							onClick="endpage(${pageinf[3]},${pageinf[1]})">
					</form>
				</td>
			</tr>
		</table>

	</div>
</html>