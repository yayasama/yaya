<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="tea_include.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--教师审核学生申报项目界面-->
<html>
<script>
function firstpage() {
	var strBack = "listpro.review";
	document.form1.action = strBack;
	document.form1.submit();
}
function before(currentPage, pageSize) {
	this.currentPage = currentPage - 1;
	this.pageSize = pageSize;
	var strBefore = "page_teareview.review?currentPage=" + this.currentPage
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
	var strBack = "page_teareview.review?currentPage=" + this.currentPage
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
	var strBack = "page_teareview.review?currentPage=" + this.currentPage
			+ "&pageSize=" + this.pageSize;
	document.form4.action = strBack;
	document.form4.submit();
}
</script>
<link type="text/css" rel="stylesheet" href="css/style.css" />
  <div id="m_right">
  <h5 style="position:absolute;top:100px;left:780px;">
    <form action="username.review" method="post">
          根据学生学号搜索：&nbsp;<input type="text" class="inputgri" size="10" name="username" />
    &nbsp;<input type="submit" class="button" value="搜索" /></form></h5>
    <h5 style="position:absolute;top:100px;left:1060px;">
    <form action="listpro.review" method="post">
    &nbsp;<input type="submit" class="button" value="查看全部" /></form></h5><br><br>
	 <table class="table-1">
		<tr class="stu_table1">
			<td width="80px">学生学号</td>
			<td width="80px">学生姓名</td>
			<td width="400px">项目名称</td>
			<td width="80px">指导老师</td>
			<td width="100px">申报时间</td>
			<td width="80px">审核结果</td>
			<td width="38px">操作</td>
	</tr>
	
	
	<!-- 接受传入的stu对象 -->
	<c:forEach items="${requestScope.pro}" varStatus="status" var="p" >
	<tr class="row${status.index%2+1}"></tr>
	<tr class="stu_table2">	
			<td>${p.username}</td>
			<td>${p.sname}</td>
			<td>${p.title}</td>
			<td>${p.guidetea}</td>
			<td>${p.finishtime}</td>
			<td>${p.resulttea}</td>
			<td>
			<c:if test="${p.resulttea != '通过'}">
			<a href="<c:url value="pro.review?id=${p.id}" /> ">审核</a>		
			</c:if>
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
</div>
 </html>