<%@ page import="dao.*,util.*,entity.*,java.util.*" pageEncoding="utf-8" contentType="text/html"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="tea_include.jsp" %>
<!-- 教师查看项目详情界面 -->
<html>
<link type="text/css" rel="stylesheet" href="css/style.css" />
 <div id="m_right">
 <div id="stu_ar">
	  <div class="row margin-top-15">	 
	     <div class="col-md-3"></div>
         <div class="col-md-1">项目名称：</div>
		 <div class="col-md-8">${title}</div>
	  </div>
	  <div class="row margin-top-15">   
	     <div class="col-md-3"></div>
         <div class="col-md-1">申请人：</div>
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
		 <div class="col-md-8">${resultadm}</div>
	 </div>
	 <div class="row margin-top-15">   
	     <div class="col-md-3"></div>
         <div class="col-md-1">发布状态：</div>
		 <div class="col-md-8">${prostate}</div>
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