package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;
import entity.Program;

public class PageDaoStu {
	/*
	resultCount	：总共记录数
	pageCount：总共页数
	currentPage：当前页数	
	pageSize：页面大小
	offset：起始大小
	 */
	private List<Integer> pageinf = new ArrayList<Integer>();
	//————————————————————————————————————————
    //学生查看教师申请项目
	public Integer getCount(){
         int count = 0;
         Connection conn=DBUtil.getConnection();
		 ResultSet rs = null;
		 String sql = "select count(*) from stu_program where prostate='已发布'";		
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
	
	//分页查找记录，显示已发布的实践项目
	public List<Program> findByPage_stuapply(int currentPage, int pageSize){  
	List<Program> pro = new ArrayList<Program>();
    //默认处理：当用户设置的pageSize大小为小于等于零的数的情况
    if(pageSize <= 0){
    	pageSize = 10;
    }
	int resultCount = this.getCount();
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
	String sql = "select * from stu_program where prostate='已发布' limit "+offset+","+pageSize;
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
	
	public List<Integer> getPageinf() {
		return pageinf;
	}
}
