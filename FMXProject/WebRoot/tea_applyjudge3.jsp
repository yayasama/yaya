<%@ page import="dao.*,util.*,entity.*,java.util.*" pageEncoding="utf-8" contentType="text/html"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="tea_include.jsp" %>
<!--教师项目审核不通过，修改项目界面-->
<html>
<link type="text/css" rel="stylesheet" href="css/style.css" />
 <div id="m_right">
 <form action="applyedit.apply2?id=${id}" method="post" id="stu_ar">
  <div class="row">	 
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
		 <div class="col-md-8">
		 	<textarea cols="80" rows="8" name="need" placeholder="不超过500字" maxlength="500" style="text-align:left;">${need}</textarea>
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