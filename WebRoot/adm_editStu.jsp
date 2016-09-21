<%@page language="java" import="dao.*,util.*,entity.*,util.*,dal.*,java.util.*" pageEncoding="utf-8"%>
<%@include file="include.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--学生信息显示界面-->
<html>
<script>
function firstpage() {
	var strBack = "list.do";
	document.form1.action = strBack;
	document.form1.submit();
}
function before(currentPage, pageSize) {
	this.currentPage = currentPage - 1;
	this.pageSize = pageSize;
	var strBefore = "page_stulist.do?currentPage=" + this.currentPage
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
	var strBack = "page_stulist.do?currentPage=" + this.currentPage
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
	var strBack = "page_stulist.do?currentPage=" + this.currentPage
			+ "&pageSize=" + this.pageSize;
	document.form4.action = strBack;
	document.form4.submit();
}
</script>
<link type="text/css" rel="stylesheet" href="css/style.css" />
  <div id="m_right">
	 <table class="table-1">
		<tr class="stu_table1">
			<td width="100px">学生学号</td>
			<td width="100px">学生姓名</td>
			<td width="80px">学生年龄</td>
			<td width="100px">学生班级</td>
			<td width="80px">学生性别</td>
			<td width="80px">&nbsp;操作</td>
	</tr>
	
	
	<!-- 接受传入的stu对象 -->
	<c:forEach items="${requestScope.stu}" varStatus="status" var="s" >
	<tr class="row${status.index%2+1}"></tr>
	<tr class="stu_table2">	
			<td>${s.username}</td>
			<td>${s.sname}</td>
			<td>${s.sage}</td>
			<td>${s.sclass}</td>
			<td>${s.sgender}</td>
			<td>
			<a href="<c:url value="edit.do?id=${s.id}" /> ">修改</a>	
			<a href="<c:url value="delete.do?username=${s.username}" /> ">删除</a>	
			</td>
			</tr></c:forEach>		
	</table><br>
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
	<div class="sub_add">	
	  <input type="submit" class="button" value="添加学生" onclick="location='adm_addStu.jsp'"/></div>
 </div>
 </html>