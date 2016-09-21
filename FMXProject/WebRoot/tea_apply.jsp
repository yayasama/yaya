<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="tea_include.jsp" %>
<!-- 教师申请项目界面 -->
<html>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<div id="m_right">
 <form action="add.apply2" method="post" id="stu_ar">
     <div class="row">
         <div class="col-md-5"></div>
         <div class="col-md-7"><h3>&nbsp;&nbsp;&nbsp;
         &nbsp;&nbsp;&nbsp;&nbsp;申请项目</h3> </div>
      </div>
 	 <div class="row margin-top-15">	 
	     <div class="col-md-3"></div>
         <div class="col-md-1">项目名称：</div>
		 <div class="col-md-8">
		 	<input type="text" name="title" size="80" required/>
		 </div>
	  </div>
	  <div class="row margin-top-15">   
	     <div class="col-md-3"></div>
         <div class="col-md-1">项目需求：</div>
		 <div class="col-md-8">
		 	<textarea cols="80" rows="10" name="need" placeholder="不超过500字" maxlength="500" required></textarea>
		 </div>
	 </div>
	 <div class="row margin-top-15">	 
	     <div class="col-md-3"></div>
	     <div class="col-md-1">申请人： </div>
         <div class="col-md-8">
         <input type="text" name="guidetea" value="${tname}" size="20" readonly="readonly"/></div>
	  </div>
	 <div class="row margin-top-15">	 
	     <div class="col-md-3"></div>
	     <div class="col-md-1">申请时间： </div>
         <div class="col-md-8">
         <input type="text" name="applytime" value="${applytime}" size="20" readonly="readonly"/>
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