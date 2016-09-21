package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBUtil;
import entity.Program;

public class ApplyDaoJdbcImpl implements ApplyDaoInf{
	public void save(Program p) throws Exception {
		Connection conn=DBUtil.getConnection();
		PreparedStatement prep=conn.prepareStatement("insert into stu_program(title,guidetea,need,applytime) values(?,?,?,?)");
		//将sql语句 -> 进行赋值
		prep.setString(1,p.getTitle());
		prep.setString(2,p.getGuidetea());
		prep.setString(3,p.getNeed());
		prep.setString(4, p.getApplytime());
		//执行sql
		prep.executeUpdate();
		conn.close();
	}
	
	public void saveApply(Program p) throws Exception {
		Connection conn=DBUtil.getConnection();
		PreparedStatement prep=conn.prepareStatement("insert into stu_program(username,sname,title,finishtime,guidetea,need,content) values(?,?,?,?,?,?,?)");
		//将sql语句 -> 进行赋值
		prep.setString(1,p.getUsername());
		prep.setString(2,p.getSname());
		prep.setString(3,p.getTitle());
		prep.setString(4, p.getFinishtime());
		prep.setString(5,p.getGuidetea());
		prep.setString(6,p.getNeed());
		prep.setString(7, p.getContent());
		
		//执行sql
		prep.executeUpdate();
		conn.close();
	}
	

	public List<Program> findAll() throws Exception {
		Connection conn = DBUtil.getConnection();
		Statement stat = conn.createStatement();
		ResultSet rs = stat.executeQuery("select * from stu_program");
		List<Program> pro = new ArrayList<Program>();
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
			p.setApplytime(rs.getString("applytime"));
			pro.add(p);
			
		}
		conn.close();
		return pro;
     }
	
	public List<Program> findAll2(String tname) throws Exception {
		Connection conn = DBUtil.getConnection();
		Statement stat = conn.createStatement();
		ResultSet rs = stat.executeQuery("select * from stu_program where guidetea='"+tname+"'");
		List<Program> pro = new ArrayList<Program>();
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
			p.setApplytime(rs.getString("applytime"));
			pro.add(p);
		}
		conn.close();
		return pro;
     }
	
	public List<Program> findPassPro() throws Exception {
		Connection conn = DBUtil.getConnection();
		Statement stat = conn.createStatement();
		ResultSet rs = stat.executeQuery("select * from stu_program where resultadm='通过'");
		List<Program> pro = new ArrayList<Program>();
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
			p.setApplytime(rs.getString("applytime"));
			pro.add(p);
		}
		conn.close();
		return pro;
     }


	public Program findByUsername(String username) throws Exception {
		// 根据学号查找学生
		Connection conn=DBUtil.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("select * from stu_program where username='"+ username + "'");
		Program p = new Program();
		while(rs.next()){
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
			p.setApplytime(rs.getString("applytime"));
		}
		conn.close();
		return p;
	}
	
	public Program findByCondition(String username) throws Exception {
		// 根据两个条件
		Connection conn=DBUtil.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("select * from stu_program where username='"+username+"' and prostate='已发布'");
		Program p = new Program();
		while(rs.next()){
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
			p.setApplytime(rs.getString("applytime"));
		}
		conn.close();
		return p;
	}


	public Program findById(long id) throws Exception {
		// 根据id查找
		Connection conn=DBUtil.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("select * from stu_program where id="+ id);
		Program p = new Program();
		while(rs.next()){
			p.setId(rs.getLong("id"));
			p.setUsername(rs.getString("username"));
			p.setSname(rs.getString("sname"));
			p.setTitle(rs.getString("title"));
			p.setGuidetea(rs.getString("guidetea"));
			p.setContent(rs.getString("content"));
			p.setNeed(rs.getString("need"));
			p.setResulttea(rs.getString("resulttea"));
			p.setResultadm(rs.getString("resultadm"));
			p.setProstate(rs.getString("prostate"));
			p.setFinish(rs.getString("finish"));
			p.setFinishtime(rs.getString("finishtime"));
			p.setApplytime(rs.getString("applytime"));
		}
		conn.close();
		return p;
	}
	
	public void updateResult(Program p) throws SQLException {	
		// 更新
		Connection conn=DBUtil.getConnection();
		PreparedStatement prep=conn.prepareStatement("update stu_program set resulttea=? where id=?");	
		prep.setString(1,p.getResulttea());
		prep.setLong(2, p.getId());
		//执行update语句 
		prep.executeUpdate();
		conn.close();
	}
	
	public void updateResultadm(Program p) throws SQLException {	
		// 更新
		Connection conn=DBUtil.getConnection();
		PreparedStatement prep=conn.prepareStatement("update stu_program set resultadm=? where id=?");	
		prep.setString(1,p.getResultadm());
		prep.setLong(2, p.getId());
		//执行update语句 
		prep.executeUpdate();
		conn.close();
	}
	
	public void updateProstate(Program p) throws SQLException {	
		// 更新
		Connection conn=DBUtil.getConnection();
		PreparedStatement prep=conn.prepareStatement("update stu_program set prostate=? where id=?");	
		prep.setString(1,p.getProstate());
		prep.setLong(2, p.getId());
		//执行update语句 
		prep.executeUpdate();
		conn.close();
	}
	
	public void updateContent(Program p) throws SQLException {	
		// 更新
		Connection conn=DBUtil.getConnection();
		PreparedStatement prep=conn.prepareStatement("update stu_program set content=? where username=?");
		prep.setString(1, p.getContent());
		prep.setString(2, p.getUsername());
		//执行update语句 
		prep.executeUpdate();
		conn.close();
	}
	
	public void SetFinish(Program p) throws SQLException{
		Connection conn=DBUtil.getConnection();
		PreparedStatement prep=conn.prepareStatement("update stu_program set finish='已完成' where username=?");
		prep.setString(1, p.getUsername());
		//执行update语句 
		prep.executeUpdate();
		conn.close();
	}
	
	//更改完成时间
	public void SetFinishtime(Program p) throws SQLException{
		Connection conn=DBUtil.getConnection();
		PreparedStatement prep=conn.prepareStatement("update stu_program set finishtime=? where username=?");
		prep.setString(1, p.getFinishtime());
		prep.setString(2, p.getUsername());
		//执行update语句 
		prep.executeUpdate();
		conn.close();
	}
	
	//更改项目需求
	public void updateNeed(Program p) throws SQLException {	
		Connection conn=DBUtil.getConnection();
		PreparedStatement prep=conn.prepareStatement("update stu_program set need=? where id=?");
		prep.setString(1, p.getNeed());
		prep.setLong(2, p.getId());
		//执行update语句 
		prep.executeUpdate();
		conn.close();
	}
	
	//更新教师申请时间
	public void SetApplytime(Program p) throws SQLException{
		Connection conn=DBUtil.getConnection();
		PreparedStatement prep=conn.prepareStatement("update stu_program set applytime=? where id=?");
		prep.setString(1, p.getApplytime());
		prep.setLong(2, p.getId());
		//执行update语句 
		prep.executeUpdate();
		conn.close();
	}
}
