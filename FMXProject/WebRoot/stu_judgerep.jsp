<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="stu_include.jsp" %>
<!--学生项目审核通过，点击申报项目出现的界面-->
<html>
<link type="text/css" rel="stylesheet" href="css/style.css" />
  <div id="m_right">
  <div id="stu_all_apply">
    <p>你已经提交过报告！以下为项目报告详情！</p><br>
  <div class="row">	 
         <div class="col-md-2">学号：</div>
         <div class="col-md-10">${username}</div>
	  </div>
	  <div class="row margin-top-15">	 
         <div class="col-md-2">姓名：</div>
		 <div class="col-md-10">${sname}</div>
	  </div>
	 <div class="row margin-top-15">	 
         <div class="col-md-2">标题：</div>
		 <div class="col-md-10">${title}</div>
	  </div>
	  <div class="row margin-top-15">	 
         <div class="col-md-2">项目进度：</div>
		 <div class="col-md-9">${progress}</div>
		 <div class="col-md-1"></div>
	  </div>
	  <div class="row margin-top-15">	 
         <div class="col-md-2">个人收获：</div>
		 <div class="col-md-9">${gain}</div>
		 <div class="col-md-1"></div>
	  </div>
	   <div class="row margin-top-15">	 
         <div class="col-md-2">指导老师：</div>
		 <div class="col-md-10">${guidetea}</div>
	  </div>
	  <div class="row margin-top-15">   
         <div class="col-md-2">教师评分：</div>
		 <div class="col-md-10">${result}</div>
	 </div>
   </div>
   </div>
</html>