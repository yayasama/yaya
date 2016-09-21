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
	resultCount	���ܹ���¼��
	pageCount���ܹ�ҳ��
	currentPage����ǰҳ��	
	pageSize��ҳ���С
	offset����ʼ��С
 */
public class PageDao {
	private List<Integer> pageinf = new ArrayList<Integer>();
	//��������������������������������������������������������������������������������
	//��ҳ���Ҽ�¼- adm_review����Ա��˽�ʦ������Ŀ
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
    //Ĭ�ϴ������û����õ�pageSize��СΪС�ڵ�������������
    if(pageSize <= 0){
    	pageSize = 10;
    }
	int resultCount = this.getCountReview();
	//����Ĭ�ϵ���ҳ����Ϊһҳ
	int pageCount = 1;
	if((resultCount % pageSize)>0){
		pageCount = resultCount/pageSize +1;
	}else{
		pageCount = resultCount/pageSize; 
	}
	//Ĭ�ϴ������û����õ�currentPage����������ʱ
	if(currentPage <= 0 ||currentPage > pageCount){
		currentPage = 1;
	}
	int offset = (currentPage-1)*pageSize;	
	System.out.println("�ܹ���¼����"+resultCount);		
	System.out.println("�ܹ�ҳ����"+pageCount);		
	System.out.println("��ǰҳ����"+currentPage);		
	System.out.println("ҳ���С��"+pageSize);		
	System.out.println("��ʼ��С��"+offset);	
    //��װ��ҳ��Ϣ
    this.pageinf.add(resultCount);
    this.pageinf.add(pageCount);
    this.pageinf.add(currentPage);
    this.pageinf.add(pageSize);
    this.pageinf.add(offset);
    
	Connection conn=DBUtil.getConnection();
	ResultSet rs = null;
	//(��ʼ��С,��Ŀ��)    (5,10) ��ʾ6-15
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
	
	//��������������������������������������������������������������������������������
	//��ҳ���Ҽ�¼- adm_distribute ����Ա������Ŀ
	public Integer getCountDis(){
        int count = 0;
        Connection conn=DBUtil.getConnection();
		 ResultSet rs = null;
		 String sql = "select count(*) from stu_program where resultadm='ͨ��'";		
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
    //Ĭ�ϴ������û����õ�pageSize��СΪС�ڵ�������������
    if(pageSize <= 0){
    	pageSize = 10;
    }
	int resultCount = this.getCountDis();
	//����Ĭ�ϵ���ҳ����Ϊһҳ
	int pageCount = 1;
	if((resultCount % pageSize)>0){
		pageCount = resultCount/pageSize +1;
	}else{
		pageCount = resultCount/pageSize; 
	}
	//Ĭ�ϴ������û����õ�currentPage����������ʱ
	if(currentPage <= 0 ||currentPage > pageCount){
		currentPage = 1;
	}
	int offset = (currentPage-1)*pageSize;	
    //��װ��ҳ��Ϣ
    this.pageinf.add(resultCount);
    this.pageinf.add(pageCount);
    this.pageinf.add(currentPage);
    this.pageinf.add(pageSize);
    this.pageinf.add(offset);
    
	Connection conn=DBUtil.getConnection();
	ResultSet rs = null;
	String sql = "select * from stu_program where resultadm='ͨ��' limit "+offset+","+pageSize;
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
	
	//��������������������������������������������������������������������������������
	//��ҳ���Ҽ�¼- adm_manage ����Ա������Ŀ��ʵʩ���
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
    //Ĭ�ϴ������û����õ�pageSize��СΪС�ڵ�������������
    if(pageSize <= 0){
    	pageSize = 10;
    }
	int resultCount = this.getCountManage();
	//����Ĭ�ϵ���ҳ����Ϊһҳ
	int pageCount = 1;
	if((resultCount % pageSize)>0){
		pageCount = resultCount/pageSize +1;
	}else{
		pageCount = resultCount/pageSize; 
	}
	//Ĭ�ϴ������û����õ�currentPage����������ʱ
	if(currentPage <= 0 ||currentPage > pageCount){
		currentPage = 1;
	}
	int offset = (currentPage-1)*pageSize;	
    //��װ��ҳ��Ϣ
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

	//��������������������������������������������������������������������������������
	//����Ա����ѧ����Ϣ
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
	
	
	//��ҳ����
	public List<Student> findByPage_stu(int currentPage, int pageSize){  
	List<Student> stu = new ArrayList<Student>();
    //Ĭ�ϴ������û����õ�pageSize��СΪС�ڵ�������������
    if(pageSize <= 0){
    	pageSize = 12;
    }
	int resultCount = this.getStuCount();
	//����Ĭ�ϵ���ҳ����Ϊһҳ
	int pageCount = 1;
	if((resultCount % pageSize)>0){
		pageCount = resultCount/pageSize +1;
	}else{
		pageCount = resultCount/pageSize; 
	}
	//Ĭ�ϴ������û����õ�currentPage����������ʱ
	if(currentPage <= 0 ||currentPage > pageCount){
		currentPage = 1;
	}
	int offset = (currentPage-1)*pageSize;	
    //��װ��ҳ��Ϣ
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
	
	//��������������������������������������������������������������������������������
	//����Ա�����ʦ��Ϣ
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
	
	
	//��ҳ����
	public List<Teacher> findByPage_tea(int currentPage, int pageSize){  
	List<Teacher> tea = new ArrayList<Teacher>();
    //Ĭ�ϴ������û����õ�pageSize��СΪС�ڵ�������������
    if(pageSize <= 0){
    	pageSize = 12;
    }
	int resultCount = this.getTeaCount();
	//����Ĭ�ϵ���ҳ����Ϊһҳ
	int pageCount = 1;
	if((resultCount % pageSize)>0){
		pageCount = resultCount/pageSize +1;
	}else{
		pageCount = resultCount/pageSize; 
	}
	//Ĭ�ϴ������û����õ�currentPage����������ʱ
	if(currentPage <= 0 ||currentPage > pageCount){
		currentPage = 1;
	}
	int offset = (currentPage-1)*pageSize;	
    //��װ��ҳ��Ϣ
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
	
	//��������������������������������������������������������������������������������
	//����Ա������ѵ��ʦ��Ϣ
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
	
	
	//��ҳ����
	public List<Peixun> findByPage_px(int currentPage, int pageSize){  
	List<Peixun> px = new ArrayList<Peixun>();
    //Ĭ�ϴ������û����õ�pageSize��СΪС�ڵ�������������
    if(pageSize <= 0){
    	pageSize = 12;
    }
	int resultCount = this.getPxCount();
	//����Ĭ�ϵ���ҳ����Ϊһҳ
	int pageCount = 1;
	if((resultCount % pageSize)>0){
		pageCount = resultCount/pageSize +1;
	}else{
		pageCount = resultCount/pageSize; 
	}
	//Ĭ�ϴ������û����õ�currentPage����������ʱ
	if(currentPage <= 0 ||currentPage > pageCount){
		currentPage = 1;
	}
	int offset = (currentPage-1)*pageSize;	
    //��װ��ҳ��Ϣ
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
