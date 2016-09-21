<%@ page import="dao.*,util.*,entity.*,java.util.*" pageEncoding="UTF-8" contentType="text/html"%>
<%@include file="stu_include.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 学生提交季度报告界面 -->
<html>
 <div id="m_right">
 <form action="add1.report" method="post" id="stu_ar">
      <div class="row">
         <div class="col-md-5"></div>
         <div class="col-md-7"><h3>&nbsp;&nbsp;&nbsp;
         &nbsp;&nbsp;&nbsp;&nbsp;项目季度报告</h3> </div>
      </div>
      <div class="row margin-top-15">	 
	     <div class="col-md-3"></div>
         <div class="col-md-1">学号： </div>
         <div class="col-md-2">
         <input type="text" name="username" value="${username}" size="30" readonly="readonly"/></div>
         <div class="col-md-6">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                           姓名：&nbsp;&nbsp;&nbsp;
         <input type="text" name="sname" value="${sname}" size="30" readonly="readonly"/></div>
      </div>
         <div class="row margin-top-15">	 
	     <div class="col-md-3"></div>
         <div class="col-md-1">指导老师：</div>
		 <div class="col-md-8">
		 	<input type="text" name="guidetea" value="${guidetea}" size="30" readonly="readonly"/></div>
	  </div>
	  <div class="row margin-top-15">	 
	     <div class="col-md-3"></div>
         <div class="col-md-1">标题：</div>
		 <div class="col-md-8">
		 	<input type="text" name="title" size="80" required/></div>
	  </div>  
	  <div class="row margin-top-15">   
	     <div class="col-md-3"></div>
         <div class="col-md-1">完成情况：</div>
		 <div class="col-md-8">
		 	<textarea cols="80" rows="6" name="progress" placeholder="不超过300字" maxlength="300" required></textarea>
		 </div>
	 </div>
	 <div class="row margin-top-15">   
	     <div class="col-md-3"></div>
         <div class="col-md-1">个人收获：</div>
		 <div class="col-md-8">
		 	<textarea cols="80" rows="6" name="gain" placeholder="不超过500字" maxlength="500" required></textarea>
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