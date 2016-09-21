<%@ page import="dao.*,util.*,entity.*,java.util.*" pageEncoding="utf-8" contentType="text/html"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="tea_include.jsp" %>
<!--教师审核学生提交的中期报告，点击审核出现的界面-->
<html>
<link type="text/css" rel="stylesheet" href="css/style.css" />
 <div id="m_right">
 <form action="report2result.review?id=${id}" method="post" id="stu_ar">
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
         <div class="col-md-1">标题：</div>
		 <div class="col-md-8">${title}</div>
	  </div>
	  <div class="row margin-top-15">   
	     <div class="col-md-3"></div>
         <div class="col-md-1">项目进展：</div>
		 <div class="col-md-7">${progress}</div>
		 <div class="col-md-1"></div>
	 </div>
	 <div class="row margin-top-15">   
	     <div class="col-md-3"></div>
         <div class="col-md-1">个人收获：</div>
		 <div class="col-md-7">${gain}</div>
		 <div class="col-md-1"></div>
	 </div>
	 <div class="row margin-top-15">   
	     <div class="col-md-3"></div>
         <div class="col-md-1">审核结果：</div>
		 <div class="col-md-8">
		<select name="result" id="教师审核">   
        <option value="优秀">优秀</option>   
        <option value="良好">良好</option>   
        <option value="中等">中等</option>   
        <option value="合格">合格</option>   
        <option value="不合格">不合格</option>     
      </select>   
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