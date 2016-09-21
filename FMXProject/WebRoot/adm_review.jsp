<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="include.jsp"%>
<!--管理员审核教师申请项目界面-->
<html>
<script>
function firstpage() {
	var strBack = "listtea.admin";
	document.form1.action = strBack;
	document.form1.submit();
}
function before(currentPage, pageSize) {
	this.currentPage = currentPage - 1;
	this.pageSize = pageSize;
	var strBefore = "page_review.admin?currentPage=" + this.currentPage
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
	var strBack = "page_review.admin?currentPage=" + this.currentPage
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
	var strBack = "page_review.admin?currentPage=" + this.currentPage
			+ "&pageSize=" + this.pageSize;
	document.form4.action = strBack;
	document.form4.submit();
}
</script>
<link type="text/css" rel="stylesheet" href="css/style.css" />
 <div id="m_right"> 
 <h3 style="position:absolute;top:100px;left:300px;">教师申报项目</h3><br><br>
	 <table class="table-1">
		<tr class="stu_table1">
			<td width="400px">项目名称</td>
			<td width="80px">申请教师</td>
			<td width="100px">申请时间</td>
			<td width="80px">审核结果</td>
			<td width="38px">操作</td>
	</tr>
	
	<!-- 接受传入的pro对象 -->
	<c:forEach items="${requestScope.pro}" varStatus="status" var="p" >
	<tr class="row${status.index%2+1}"></tr>
	<tr class="stu_table2">	
	        <td>${p.title}</td>
			<td>${p.guidetea}</td>
			<td>${p.applytime}</td>
			<td>${p.resultadm}</td>
			<td>
			 <c:if test="${p.resultadm !='通过'}">	
			  <a href="<c:url value="list.admin?id=${p.id}" /> ">审核</a>	
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