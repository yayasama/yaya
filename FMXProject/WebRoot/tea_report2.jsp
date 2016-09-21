<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="tea_include.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--教师审核学生提交的中期报告，显示学生提交的中期报告-->
<html>
<script>
function firstpage() {
	var strBack = "listzhongqi.review";
	document.form1.action = strBack;
	document.form1.submit();
}
function before(currentPage, pageSize) {
	this.currentPage = currentPage - 1;
	this.pageSize = pageSize;
	var strBefore = "page_report2.review?currentPage=" + this.currentPage
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
	var strBack = "page_report2.review?currentPage=" + this.currentPage
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
	var strBack = "page_report2.review?currentPage=" + this.currentPage
			+ "&pageSize=" + this.pageSize;
	document.form4.action = strBack;
	document.form4.submit();
}
</script>
<link type="text/css" rel="stylesheet" href="css/style.css" />
  <div id="m_right">
	 <table class="table-1">
		<tr class="stu_table1">
			<td width="80px">学生学号</td>
			<td width="80px">学生姓名</td>
			<td width="300px">中期报告标题</td>
			<td width="80px">指导老师</td>
			<td width="80px">审核结果</td>
			<td width="38px">操作</td>
	</tr>
	
	
	<!-- 接受传入的对象 -->
	<c:forEach items="${requestScope.rep2}" varStatus="status" var="r2" >
	<tr class="row${status.index%2+1}"></tr>
	<tr class="stu_table2">	
			<td>${r2.username}</td>
			<td>${r2.sname}</td>
			<td>${r2.title}</td>
			<td>${r2.guidetea}</td>
			<td>${r2.result}</td>
			<td>
			<c:if test="${r2.result == '待审核'}">
			<a href="<c:url value="report2.review?id=${r2.id}" /> ">审核</a>		
			</c:if>
			</td>
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