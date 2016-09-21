package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;
import entity.Program;
import entity.Report1;
import entity.Report2;
import entity.Report3;

public class PageDaoTea {
	/*
	resultCount	：总共记录数
	pageCount：总共页数
	currentPage：当前页数	
	pageSize：页面大小
	offset：起始大小
	 */
	private List<Integer> pageinf = new ArrayList<Integer>();
	//————————————————————————————————————————
    //教师申请项目模块
	public Integer getCount(String tname){
         int count = 0;
         Connection conn=DBUtil.getConnection();
		 ResultSet rs = null;
		 String sql = "select count(*) from stu_program where guidetea='"+tname+"' and username is null";		
		 try {
			Statement st = conn.createStatement();
		    rs = st.executeQuery(sql);  
		    if(rs.next()){
		       count = rs.getInt(1);	     
		    }
		 } catch (SQLException e) {
			e.printStackTrace();
		 }
		return count;
	}
	
	//分页查找记录
	public List<Program> findByPage_teaapply(int currentPage, int pageSize,String tname){  
	List<Program> pro = new ArrayList<Program>();
    //默认处理：当用户设置的pageSize大小为小于等于零的数的情况
    if(pageSize <= 0){
    	pageSize = 12;
    }
	int resultCount = this.getCount(tname);
	//设置默认的总页面数为一页
	int pageCount = 1;
	if((resultCount % pageSize)>0){
		pageCount = resultCount/pageSize +1;
	}else{
		pageCount = resultCount/pageSize; 
	}
	//默认处理：当用户设置的currentPage不符合条件时
	if(currentPage <= 0 ||currentPage > pageCount){
		currentPage = 1;
	}
	int offset = (currentPage-1)*pageSize;	
    //封装分页信息
    this.pageinf.add(resultCount);
    this.pageinf.add(pageCount);
    this.pageinf.add(currentPage);
    this.pageinf.add(pageSize);
    this.pageinf.add(offset);
    
	Connection conn=DBUtil.getConnection();
	ResultSet rs = null;
	String sql = "select * from stu_program where guidetea='"+tname+"' and username is null limit "+offset+","+pageSize;
	try {
		Statement st = conn.createStatement();
	   rs = st.executeQuery(sql);  
	   while(rs.next()){ 
		   Program p = new Program();
			p.setId(rs.getLong("id"));
			p.setTitle(rs.getString("title"));
			p.setGuidetea(rs.getString("guidetea"));
			p.setNeed(rs.getString("need"));
			p.setResultadm(rs.getString("resultadm"));
			p.setProstate(rs.getString("prostate"));
			p.setFinish(rs.getString("finish"));
			p.setApplytime(rs.getString("applytime"));
			pro.add(p);
	   }
	} catch (SQLException e) {
		e.printStackTrace();
	} 
        return pro;
	}
	
	//————————————————————————————————————————
    //教师审核学生申报项目
	public Integer getCountReview(String tname){
         int count = 0;
         Connection conn=DBUtil.getConnection();
		 ResultSet rs = null;
		 String sql = "select count(*) from stu_program where guidetea='"+tname+"' and username is not null";		
		 try {
			Statement st = conn.createStatement();
		    rs = st.executeQuery(sql);  
		    if(rs.next()){
		       count = rs.getInt(1);	       
		    }
		 } catch (SQLException e) {
			e.printStackTrace();
		 }
		return count;
	}
	
	//分页查找记录
	public List<Program> findByPage_teareview(int currentPage, int pageSize,String tname){  
	List<Program> pro = new ArrayList<Program>();
    //默认处理：当用户设置的pageSize大小为小于等于零的数的情况
    if(pageSize <= 0){
    	pageSize = 10;
    }
	int resultCount = this.getCountReview(tname);
	//设置默认的总页面数为一页
	int pageCount = 1;
	if((resultCount % pageSize)>0){
		pageCount = resultCount/pageSize +1;
	}else{
		pageCount = resultCount/pageSize; 
	}
	//默认处理：当用户设置的currentPage不符合条件时
	if(currentPage <= 0 ||currentPage > pageCount){
		currentPage = 1;
	}
	int offset = (currentPage-1)*pageSize;	
    //封装分页信息
    this.pageinf.add(resultCount);
    this.pageinf.add(pageCount);
    this.pageinf.add(currentPage);
    this.pageinf.add(pageSize);
    this.pageinf.add(offset);
    
	Connection conn=DBUtil.getConnection();
	ResultSet rs = null;
	String sql = "select * from stu_program where guidetea='"+tname+"' and username is not null limit "+offset+","+pageSize;
	try {
		Statement st = conn.createStatement();
	   rs = st.executeQuery(sql);  
	   while(rs.next()){ 
		   Program p = new Program();
			p.setId(rs.getLong("id"));
			p.setUsername(rs.getString("username"));
			p.setSname(rs.getString("sname"));
			p.setTitle(rs.getString("title"));
			p.setGuidetea(rs.getString("guidetea"));
			p.setNeed(rs.getString("need"));
			p.setContent(rs.getString("content"));
			p.setResulttea(rs.getString("resulttea"));
			p.setResultadm(rs.getString("resultadm"));
			p.setProstate(rs.getString("prostate"));
			p.setFinish(rs.getString("finish"));
			p.setFinishtime(rs.getString("finishtime"));
			pro.add(p);
	   }
	} catch (SQLException e) {
		e.printStackTrace();
	} 
        return pro;
	}
	
	//————————————————————————————————————————
    //教师审核季度报告
	public Integer getCountReport1(String tname){
         int count = 0;
         Connection conn=DBUtil.getConnection();
		 ResultSet rs = null;
		 String sql = "select count(*) from stu_report1 where guidetea='"+tname+"'";		
		 try {
			Statement st = conn.createStatement();
		    rs = st.executeQuery(sql);  
		    if(rs.next()){
		       count = rs.getInt(1);	       
		    }
		 } catch (SQLException e) {
			e.printStackTrace();
		 }
		return count;
	}
	
	//分页查找记录
	public List<Report1> findByPage_report1(int currentPage, int pageSize,String tname){  
	List<Report1> rep1 = new ArrayList<Report1>();
    //默认处理：当用户设置的pageSize大小为小于等于零的数的情况
    if(pageSize <= 0){
    	pageSize = 12;
    }
	int resultCount = this.getCountReport1(tname);
	//设置默认的总页面数为一页
	int pageCount = 1;
	if((resultCount % pageSize)>0){
		pageCount = resultCount/pageSize +1;
	}else{
		pageCount = resultCount/pageSize; 
	}
	//默认处理：当用户设置的currentPage不符合条件时
	if(currentPage <= 0 ||currentPage > pageCount){
		currentPage = 1;
	}
	int offset = (currentPage-1)*pageSize;	
    //封装分页信息
    this.pageinf.add(resultCount);
    this.pageinf.add(pageCount);
    this.pageinf.add(currentPage);
    this.pageinf.add(pageSize);
    this.pageinf.add(offset);
    
	Connection conn=DBUtil.getConnection();
	ResultSet rs = null;
	String sql = "select * from stu_report1 where guidetea='"+tname+"' limit "+offset+","+pageSize;
	try {
		Statement st = conn.createStatement();
	   rs = st.executeQuery(sql);  
	   while(rs.next()){ 
				Report1 r1 = new Report1();
				r1.setId(rs.getLong("id"));
				r1.setUsername(rs.getString("username"));
				r1.setSname(rs.getString("sname"));
				r1.setTitle(rs.getString("title"));
				r1.setGuidetea(rs.getString("guidetea"));
				r1.setProgress(rs.getString("progress"));
				r1.setGain(rs.getString("gain"));
				r1.setResult(rs.getString("result"));
				rep1.add(r1);
	   }
	} catch (SQLException e) {
		e.printStackTrace();
	} 
        return rep1;
	}
	
	//————————————————————————————————————————
	//教师审核中期报告
	public Integer getCountReport2(String tname){
         int count = 0;
         Connection conn=DBUtil.getConnection();
		 ResultSet rs = null;
		 String sql = "select count(*) from stu_report2 where guidetea='"+tname+"'";		
		 try {
			Statement st = conn.createStatement();
		    rs = st.executeQuery(sql);  
		    if(rs.next()){
		       count = rs.getInt(1);	       
		    }
		 } catch (SQLException e) {
			e.printStackTrace();
		 }
		return count;
	}
	
	//分页查找记录
	public List<Report2> findByPage_report2(int currentPage, int pageSize,String tname){  
	List<Report2> rep2 = new ArrayList<Report2>();
    //默认处理：当用户设置的pageSize大小为小于等于零的数的情况
    if(pageSize <= 0){
    	pageSize = 12;
    }
	int resultCount = this.getCountReport2(tname);
	//设置默认的总页面数为一页
	int pageCount = 1;
	if((resultCount % pageSize)>0){
		pageCount = resultCount/pageSize +1;
	}else{
		pageCount = resultCount/pageSize; 
	}
	//默认处理：当用户设置的currentPage不符合条件时
	if(currentPage <= 0 ||currentPage > pageCount){
		currentPage = 1;
	}
	int offset = (currentPage-1)*pageSize;	
    //封装分页信息
    this.pageinf.add(resultCount);
    this.pageinf.add(pageCount);
    this.pageinf.add(currentPage);
    this.pageinf.add(pageSize);
    this.pageinf.add(offset);
    
	Connection conn=DBUtil.getConnection();
	ResultSet rs = null;
	String sql = "select * from stu_report2 where guidetea='"+tname+"' limit "+offset+","+pageSize;
	try {
		Statement st = conn.createStatement();
	   rs = st.executeQuery(sql);  
	   while(rs.next()){ 
				Report2 r2 = new Report2();
				r2.setId(rs.getLong("id"));
				r2.setUsername(rs.getString("username"));
				r2.setSname(rs.getString("sname"));
				r2.setTitle(rs.getString("title"));
				r2.setGuidetea(rs.getString("guidetea"));
				r2.setProgress(rs.getString("progress"));
				r2.setGain(rs.getString("gain"));
				r2.setResult(rs.getString("result"));
				rep2.add(r2);
	   }
	} catch (SQLException e) {
		e.printStackTrace();
	} 
        return rep2;
	}
	
	//————————————————————————————————————————
	//教师审核结题报告
	public Integer getCountReport3(String tname){
         int count = 0;
         Connection conn=DBUtil.getConnection();
		 ResultSet rs = null;
		 String sql = "select count(*) from stu_report3 where guidetea='"+tname+"'";		
		 try {
			Statement st = conn.createStatement();
		    rs = st.executeQuery(sql);  
		    if(rs.next()){
		       count = rs.getInt(1);	       
		    }
		 } catch (SQLException e) {
			e.printStackTrace();
		 }
		return count;
	}
	
	//分页查找记录
	public List<Report3> findByPage_report3(int currentPage, int pageSize,String tname){  
	List<Report3> rep3 = new ArrayList<Report3>();
    //默认处理：当用户设置的pageSize大小为小于等于零的数的情况
    if(pageSize <= 0){
    	pageSize = 12;
    }
	int resultCount = this.getCountReport3(tname);
	//设置默认的总页面数为一页
	int pageCount = 1;
	if((resultCount % pageSize)>0){
		pageCount = resultCount/pageSize +1;
	}else{
		pageCount = resultCount/pageSize; 
	}
	//默认处理：当用户设置的currentPage不符合条件时
	if(currentPage <= 0 ||currentPage > pageCount){
		currentPage = 1;
	}
	int offset = (currentPage-1)*pageSize;	
    //封装分页信息
    this.pageinf.add(resultCount);
    this.pageinf.add(pageCount);
    this.pageinf.add(currentPage);
    this.pageinf.add(pageSize);
    this.pageinf.add(offset);
    
	Connection conn=DBUtil.getConnection();
	ResultSet rs = null;
	String sql = "select * from stu_report3 where guidetea='"+tname+"' limit "+offset+","+pageSize;
	try {
		Statement st = conn.createStatement();
	   rs = st.executeQuery(sql);  
	   while(rs.next()){ 
				Report3 r3 = new Report3();
				r3.setId(rs.getLong("id"));
				r3.setUsername(rs.getString("username"));
				r3.setSname(rs.getString("sname"));
				r3.setTitle(rs.getString("title"));
				r3.setGuidetea(rs.getString("guidetea"));
				r3.setProgress(rs.getString("progress"));
				r3.setGain(rs.getString("gain"));
				r3.setResult(rs.getString("result"));
				rep3.add(r3);
	   }
	} catch (SQLException e) {
		e.printStackTrace();
	} 
        return rep3;
	}
	public List<Integer> getPageinf() {
		return pageinf;
	}
}
