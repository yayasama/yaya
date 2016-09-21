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
	resultCount	���ܹ���¼��
	pageCount���ܹ�ҳ��
	currentPage����ǰҳ��	
	pageSize��ҳ���С
	offset����ʼ��С
	 */
	private List<Integer> pageinf = new ArrayList<Integer>();
	//��������������������������������������������������������������������������������
    //ѧ���鿴��ʦ������Ŀ
	public Integer getCount(){
         int count = 0;
         Connection conn=DBUtil.getConnection();
		 ResultSet rs = null;
		 String sql = "select count(*) from stu_program where prostate='�ѷ���'";		
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
	
	//��ҳ���Ҽ�¼����ʾ�ѷ�����ʵ����Ŀ
	public List<Program> findByPage_stuapply(int currentPage, int pageSize){  
	List<Program> pro = new ArrayList<Program>();
    //Ĭ�ϴ������û����õ�pageSize��СΪС�ڵ�������������
    if(pageSize <= 0){
    	pageSize = 10;
    }
	int resultCount = this.getCount();
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
	String sql = "select * from stu_program where prostate='�ѷ���' limit "+offset+","+pageSize;
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
