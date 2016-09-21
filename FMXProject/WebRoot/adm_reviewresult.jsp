<%@ page import="dao.*,util.*,entity.*,java.util.*" pageEncoding="utf-8" contentType="text/html"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="include.jsp" %>
<!--管理员审核界面，点击相应教师审核项目-->
<html>
<link type="text/css" rel="stylesheet" href="css/style.css" />
 <div id="m_right">
 <form action="resultadm.admin?id=${id}" method="post" id="stu_ar">
     <div class="row margin-top-15">   
	     <div class="col-md-3"></div>
         <div class="col-md-1">项目题目</div>
		 <div class="col-md-8">${title}</div>
	 </div>
	  <div class="row margin-top-15">   
	     <div class="col-md-3"></div>
         <div class="col-md-1">申请教师：</div>
		 <div class="col-md-8">${guidetea}</div>
	 </div>
	 <div class="row margin-top-15">   
	     <div class="col-md-3"></div>
         <div class="col-md-1">申请时间：</div>
		 <div class="col-md-8">${applytime}</div>
	 </div>
	  <div class="row margin-top-15">   
	     <div class="col-md-3"></div>
         <div class="col-md-1">项目需求：</div>
		 <div class="col-md-7">${need}</div>
		 <div class="col-md-1"></div>
	 </div>
	 <div class="row margin-top-15">   
	     <div class="col-md-3"></div>
         <div class="col-md-1">审核结果：</div>
		 <div class="col-md-8">
		 <input name="resultadm" type="radio" value="通过" required/>通过
		 &nbsp;&nbsp;&nbsp;
		 <input name="resultadm" type="radio" value="不通过" required/>不通过
		 </div>
	 </div>
	 <div class="row margin-top-15">   
	     <div class="col-md-6"></div>
		 <div class="col-md-6">
		 	<input type="submit" class="button" value="确认"/>
		 </div>
	 </div>
	 </form>
    </div> 
</html>