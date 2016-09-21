<%@ page import="dao.*,util.*,entity.*,java.util.*" pageEncoding="utf-8" contentType="text/html"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="stu_include.jsp" %>
<!--学生申请的项目审核不通过，点击修改进入的界面-->
<html>
<link type="text/css" rel="stylesheet" href="css/style.css" />
 <div id="m_right">
 <form action="applyedit.apply" method="post" id="stu_ar">
  <div class="row">	 
	     <div class="col-md-3"></div>
         <div class="col-md-1">学号：</div>
         <div class="col-md-8">${username}</div>
	  </div>
	  <div class="row margin-top-15">	 
	     <div class="col-md-3"></div>
         <div class="col-md-1">姓名：</div>
		 <div class="col-md-8">${sname}</div>
	  </div>
	 <div class="row margin-top-15">	 
	     <div class="col-md-3"></div>
         <div class="col-md-1">项目名称：</div>
		 <div class="col-md-8">${title}</div>
	  </div>
	  <div class="row margin-top-15">	 
	     <div class="col-md-3"></div>
         <div class="col-md-1">指导老师：</div>
		 <div class="col-md-8">${guidetea}</div>
	  </div>
	  <div class="row margin-top-15">	 
	     <div class="col-md-3"></div>
         <div class="col-md-1">申报日期：</div>
		 <div class="col-md-8">${finishtime}</div>
	  </div>
	  <div class="row margin-top-15">	 
	     <div class="col-md-3"></div>
         <div class="col-md-1">项目需求：</div>
		 <div class="col-md-7">${need}</div>
		 <div class="col-md-1"></div>
	  </div>
	  <div class="row margin-top-15">   
	     <div class="col-md-3"></div>
         <div class="col-md-1">项目简述：</div>
		 <div class="col-md-8">
		 	<textarea cols="80" rows="8" name="content" placeholder="请填写你的创新项目设计方案等，不超过800字" maxlength="800" style="text-align:left;">${content}</textarea>
		 </div>
	 </div>
	 <div class="row margin-top-15">   
	     <div class="col-md-6"></div>
		 <div class="col-md-6">
		 	<input type="submit" class="button" value="提交"/>
		 </div>
	 </div>
	 </form>
    </div> 
</html>