<%@ page import="dao.*,util.*,entity.*,java.util.*" pageEncoding="utf-8" contentType="text/html"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="stu_include.jsp" %>
<!--学生点击项目申报界面，需要填写项目简述-->
<html>
<link type="text/css" rel="stylesheet" href="css/style.css" />
 <div id="m_right">
 <div id="stu_ar">
  <form action="applyedit.apply" method="post">
	   <div class="row margin-top-15">	 
	     <div class="col-md-3"></div>
         <div class="col-md-1">学号： </div>
         <div class="col-md-2">
         <input type="text" name="username" value="${username}" size="30" required readonly="readonly"/></div>
         <div class="col-md-6">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                           姓名：&nbsp;&nbsp;&nbsp;
         <input type="text" name="sname" value="${sname}" size="30" required readonly="readonly"/></div>
      </div>
      <div class="row margin-top-15">	 
	     <div class="col-md-3"></div>
         <div class="col-md-1">标题：</div>
		 <div class="col-md-2">
         <input type="text" name="title" value="${title}" size="30" required readonly="readonly"/></div>
         <div class="col-md-6">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                           日期：&nbsp;&nbsp;&nbsp;
         <input type="text" name="finishtime" value="${finishtime}" size="30" required  readonly="readonly"/></div>
      </div>
      <div class="row margin-top-15">	 
	     <div class="col-md-3"></div>
         <div class="col-md-1">指导老师：</div>
		 <div class="col-md-8">
		 	<input type="text" name="guidetea" value="${guidetea}" size="30" required  readonly="readonly"/></div>
	  </div>
	  <div class="row margin-top-15">   
	     <div class="col-md-3"></div>
         <div class="col-md-1">项目需求：</div>
         <div class="col-md-8">
		 <textarea cols="80" rows="7" name="need" value="${need}" style="text-align:left;" required readonly="readonly">${need}</textarea>
	     </div>
	 </div>
	 <div class="row margin-top-15">   
	     <div class="col-md-3"></div>
         <div class="col-md-1">项目简述：</div>
		 <div class="col-md-8">
		 	<textarea cols="80" rows="7" name="content" placeholder="请填写你的创新项目设计方案等，不超过800字" maxlength="800" style="text-align:left;" required>${content}</textarea>
		 </div>
	 </div>
	 <div class="row margin-top-15">   
	     <div class="col-md-6"></div>
		 <div class="col-md-6">
		 	<input type="submit" class="button" value="申报"/>
		 </div>
	 </form>
	 </div>
	 <div style="margin-left:780px; margin-top:-28px; position:fixed;">
		 	<input type="submit" class="button" value="返回" onclick="javascript:history.go(-1)"/>
	 </div>
   </div> 
</html>