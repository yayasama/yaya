<%@ page import="dao.*,util.*,entity.*,java.util.*" pageEncoding="utf-8" contentType="text/html"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="stu_include.jsp" %>
<!--学生项目审核通过，点击查看详情出现的界面-->
<html>
<link type="text/css" rel="stylesheet" href="css/style.css" />
 <div id="m_right">
 <div id="stu_ar">
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
		 <div class="col-md-7">${content}</div>
		 <div class="col-md-1"></div>
	 </div>
	 <div class="row margin-top-15">   
	     <div class="col-md-6"></div>
		 <div class="col-md-6">
		 	<input type="submit" class="button" value="返回" onclick="javascript:history.go(-1)"/>
		 </div>
	 </div>
	 </div>
    </div> 
</html>