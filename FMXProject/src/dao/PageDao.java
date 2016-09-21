package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;

import entity.Peixun;
import entity.Program;
import entity.Student;
import entity.Teacher;
	/*
	resultCount	：总共记录数
	pageCount：总共页数
	currentPage：当前页数	
	pageSize：页面大小
	offset：起始大小
 */
public class PageDao {
	private List<Integer> pageinf = new ArrayList<Integer>();
	//————————————————————————————————————————
	//分页查找记录- adm_review管理员审核教师申请项目
	public Integer getCountReview(){
        int count = 0;
        Connection conn=DBUtil.getConnection();
		 ResultSet rs = null;
		 String sql = "select count(*) from stu_program where username is null";		
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
	
	public List<Program> findByPage_review(int currentPage, int pageSize){  
	List<Program> pro = new ArrayList<Program>();
    //默认处理：当用户设置的pageSize大小为小于等于零的数的情况
    if(pageSize <= 0){
    	pageSize = 10;
    }
	int resultCount = this.getCountReview();
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
	System.out.println("总共记录数："+resultCount);		
	System.out.println("总共页数："+pageCount);		
	System.out.println("当前页数："+currentPage);		
	System.out.println("页面大小："+pageSize);		
	System.out.println("起始大小："+offset);	
    //封装分页信息
    this.pageinf.add(resultCount);
    this.pageinf.add(pageCount);
    this.pageinf.add(currentPage);
    this.pageinf.add(pageSize);
    this.pageinf.add(offset);
    
	Connection conn=DBUtil.getConnection();
	ResultSet rs = null;
	//(起始大小,条目数)    (5,10) 显示6-15
	String sql = "select * from stu_program where username is null limit "+offset+","+pageSize;
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
			p.setApplytime(rs.getString("applytime"));
		   pro.add(p);   
	   }
	} catch (SQLException e) {
		e.printStackTrace();
	} 
        return pro;
	}
	
	//————————————————————————————————————————
	//分页查找记录- adm_distribute 管理员发布项目
	public Integer getCountDis(){
        int count = 0;
        Connection conn=DBUtil.getConnection();
		 ResultSet rs = null;
		 String sql = "select count(*) from stu_program where resultadm='通过'";		
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
	
	public List<Program> findByPage_dis(int currentPage, int pageSize){  
	List<Program> pro = new ArrayList<Program>();
    //默认处理：当用户设置的pageSize大小为小于等于零的数的情况
    if(pageSize <= 0){
    	pageSize = 10;
    }
	int resultCount = this.getCountDis();
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
	String sql = "select * from stu_program where resultadm='通过' limit "+offset+","+pageSize;
	try {
		Statement st = conn.createStatement();
	   rs = st.executeQuery(sql);  
	   while(rs.next()){ 
	       Program p = new Program();
	       p.setId(rs.getLong("id"));
			p.setTitle(rs.getString("title"));
			p.setGuidetea(rs.getString("guidetea"));
			p.setResultadm(rs.getString("resultadm"));
			p.setProstate(rs.getString("prostate"));
			p.setApplytime(rs.getString("applytime"));
		   pro.add(p);   
	   }
	} catch (SQLException e) {
		e.printStackTrace();
	} 
        return pro;
	}
	
	//————————————————————————————————————————
	//分页查找记录- adm_manage 管理员管理项目的实施情况
	public Integer getCountManage(){
        int count = 0;
        Connection conn=DBUtil.getConnection();
		 ResultSet rs = null;
		 String sql = "select count(*) from stu_program where username is not null";		
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
	
	public List<Program> findByPage_manage(int currentPage, int pageSize){  
	List<Program> pro = new ArrayList<Program>();
    //默认处理：当用户设置的pageSize大小为小于等于零的数的情况
    if(pageSize <= 0){
    	pageSize = 10;
    }
	int resultCount = this.getCountManage();
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
	String sql = "select * from stu_program where username is not null and username is not null order by finishtime desc limit "+offset+","+pageSize;
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
	//管理员管理学生信息
	public Integer getStuCount(){
         int count = 0;
         Connection conn=DBUtil.getConnection();
		 ResultSet rs = null;
		 String sql = "select count(*) from fmx_stu";		
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
	
	
	//分页查找
	public List<Student> findByPage_stu(int currentPage, int pageSize){  
	List<Student> stu = new ArrayList<Student>();
    //默认处理：当用户设置的pageSize大小为小于等于零的数的情况
    if(pageSize <= 0){
    	pageSize = 12;
    }
	int resultCount = this.getStuCount();
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
	String sql = "select * from fmx_stu limit "+offset+","+pageSize;
	try {
       Statement st = conn.createStatement();
	   rs = st.executeQuery(sql);  
	   while(rs.next()){ 
			Student s = new Student();
			s.setId(rs.getLong("id"));
			s.setUsername(rs.getString("username"));
			s.setSname(rs.getString("sname"));
			s.setSage(rs.getInt("sage"));
			s.setSclass(rs.getString("sclass"));
			s.setPwd(rs.getString("pwd"));
			s.setSgender(rs.getString("sgender"));
			s.setUsergroup(rs.getInt("usergroup"));
			stu.add(s);
	   }
	} catch (SQLException e) {
		e.printStackTrace();
	} 
        return stu;
	}
	
	//————————————————————————————————————————
	//管理员管理教师信息
	public Integer getTeaCount(){
         int count = 0;
         Connection conn=DBUtil.getConnection();
		 ResultSet rs = null;
		 String sql = "select count(*) from fmx_tea";		
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
	
	
	//分页查找
	public List<Teacher> findByPage_tea(int currentPage, int pageSize){  
	List<Teacher> tea = new ArrayList<Teacher>();
    //默认处理：当用户设置的pageSize大小为小于等于零的数的情况
    if(pageSize <= 0){
    	pageSize = 12;
    }
	int resultCount = this.getTeaCount();
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
	String sql = "select * from fmx_tea limit "+offset+","+pageSize;
	try {
       Statement st = conn.createStatement();
	   rs = st.executeQuery(sql);  
	   while(rs.next()){ 
		   Teacher t = new Teacher();
			t.setId(rs.getLong("id"));
			t.setUsername(rs.getString("username"));
			t.setTname(rs.getString("tname"));
			t.setTage(rs.getInt("tage"));
			t.setPwd(rs.getString("pwd"));
			t.setTgender(rs.getString("tgender"));
			t.setTschool(rs.getString("tschool"));
			t.setUsergroup(rs.getInt("usergroup"));
			tea.add(t);
	   }
	} catch (SQLException e) {
		e.printStackTrace();
	} 
        return tea;
	}
	
	//————————————————————————————————————————
	//管理员管理培训教师信息
	public Integer getPxCount(){
         int count = 0;
         Connection conn=DBUtil.getConnection();
		 ResultSet rs = null;
		 String sql = "select count(*) from fmx_peixun";		
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
	
	
	//分页查找
	public List<Peixun> findByPage_px(int currentPage, int pageSize){  
	List<Peixun> px = new ArrayList<Peixun>();
    //默认处理：当用户设置的pageSize大小为小于等于零的数的情况
    if(pageSize <= 0){
    	pageSize = 12;
    }
	int resultCount = this.getPxCount();
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
	String sql = "select * from fmx_peixun limit "+offset+","+pageSize;
	try {
       Statement st = conn.createStatement();
	   rs = st.executeQuery(sql);  
	   while(rs.next()){ 
			Peixun p = new Peixun();
			p.setId(rs.getLong("id"));
			p.setUsername(rs.getString("username"));
			p.setName(rs.getString("name"));
			p.setAge(rs.getInt("age"));
			p.setGender(rs.getString("gender"));
			p.setInstitution(rs.getString("institution"));
			p.setCategory(rs.getString("category"));
			p.setTime(rs.getString("time"));
			p.setUsergroup(rs.getInt("usergroup"));
			px.add(p);
	   }
	} catch (SQLException e) {
		e.printStackTrace();
	} 
        return px;
	}
	
	public List<Integer> getPageinf() {
		return pageinf;
	}
}
