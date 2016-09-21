<%@ page import="dao.*,util.*,entity.*,java.util.*" pageEncoding="utf-8" contentType="text/html"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="tea_include.jsp" %>
<!--教师审核学生申报项目，点击审核出现的界面-->
<html>
<link type="text/css" rel="stylesheet" href="css/style.css" />
 <div id="m_right">
 <form action="proresulttea.review?id=${id}" method="post" id="stu_ar">
     <div class="row">	 
	     <div class="col-md-3"></div>
         <div class="col-md-1">学生学号： </div>
         <div class="col-md-8">${username}</div>
	  </div>
      <div class="row margin-top-15">	 
	     <div class="col-md-3"></div>
         <div class="col-md-1">学生姓名： </div>
         <div class="col-md-8">${sname}</div>
	  </div>
	 <div class="row margin-top-15">	 
	     <div class="col-md-3"></div>
         <div class="col-md-1">项目名称：</div>
		 <div class="col-md-8">${title}</div>
	  </div>
	  <div class="row margin-top-15">	 
	     <div class="col-md-3"></div>
         <div class="col-md-1">申报日期：</div>
		 <div class="col-md-8">${finishtime}</div>
	  </div>
	  <div class="row margin-top-15">   
	     <div class="col-md-3"></div>
         <div class="col-md-1">项目简述：</div>
		 <div class="col-md-7">${content}</div>
		 <div class="col-md-1"></div>
	 </div>
	 <div class="row margin-top-15">   
	     <div class="col-md-3"></div>
         <div class="col-md-1">审核结果：</div>
		 <div class="col-md-8">
		 <input name="resulttea" type="radio" value="通过" required/>通过
		 &nbsp;&nbsp;&nbsp;
		 <input name="resulttea" type="radio" value="不通过" required/>不通过
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