package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;
import entity.Report1;
import entity.Report2;
import entity.Report3;

public class ReportDaoJdbcImpl implements ReportDaoInf{
	//1.季度报告
	//添加
	public void save(Report1 r1) throws Exception {
		Connection conn=DBUtil.getConnection();
		PreparedStatement prep=conn.prepareStatement("insert into stu_report1(username,sname,guidetea,title,progress,gain) values(?,?,?,?,?,?)");
		//将sql语句 -> 进行赋值
		prep.setString(1,r1.getUsername());
		prep.setString(2,r1.getSname());
		prep.setString(3,r1.getGuidetea());
		prep.setString(4,r1.getTitle());
		prep.setString(5,r1.getProgress());
		prep.setString(6,r1.getGain());
		//执行sql
		prep.executeUpdate();
		conn.close();
	}
	//查找
	public List<Report1> findReport1() throws Exception {
		Connection conn = DBUtil.getConnection();
		Statement stat = conn.createStatement();
		ResultSet rs = stat.executeQuery("select * from stu_report1");
		List<Report1> rep1 = new ArrayList<Report1>();
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
		conn.close();
		return rep1;
     }
	
	public Report1 findById(long id) throws Exception {
		// 根据id查找
		Connection conn=DBUtil.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("select * from stu_report1 where id="+ id);
		Report1 r1 = new Report1();
		while(rs.next()){
			r1.setId(rs.getLong("id"));
			r1.setUsername(rs.getString("username"));
			r1.setSname(rs.getString("sname"));
			r1.setTitle(rs.getString("title"));
			r1.setGuidetea(rs.getString("guidetea"));
			r1.setProgress(rs.getString("progress"));
			r1.setGain(rs.getString("gain"));
			r1.setResult(rs.getString("result"));
		}
		conn.close();
		return r1;
	}
	
	//根据用户名查找
	public Report1 findByUsername(String username) throws Exception{
		Connection conn=DBUtil.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("select * from stu_report1 where username= '"+username+"'");
		Report1 r1 = new Report1();
		while(rs.next()){
			r1.setId(rs.getLong("id"));
			r1.setUsername(rs.getString("username"));
			r1.setSname(rs.getString("sname"));
			r1.setTitle(rs.getString("title"));
			r1.setGuidetea(rs.getString("guidetea"));
			r1.setProgress(rs.getString("progress"));
			r1.setGain(rs.getString("gain"));
			r1.setResult(rs.getString("result"));
		}
		conn.close();
		return r1;
	}
	
	//根据guidetea查找
	public List<Report1> findByGuidetea(String tname) throws Exception {
		Connection conn = DBUtil.getConnection();
		Statement stat = conn.createStatement();
		ResultSet rs = stat.executeQuery("select * from stu_report1 where guidetea='"+tname+"'");
		List<Report1> rep1 = new ArrayList<Report1>();
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
		conn.close();
		return rep1;
     }
	public void updateResult1(Report1 r1) throws SQLException {	
		// 更新
		Connection conn=DBUtil.getConnection();
		PreparedStatement prep=conn.prepareStatement("update stu_report1 set result=? where id=?");	
		prep.setString(1,r1.getResult());
		prep.setLong(2, r1.getId());
		//执行update语句 
		prep.executeUpdate();
		conn.close();
	}
	
	
	//2.中期报告
	//添加
	public void save(Report2 r2) throws Exception {
		Connection conn=DBUtil.getConnection();
		PreparedStatement prep=conn.prepareStatement("insert into stu_report2(username,sname,guidetea,title,progress,gain) values(?,?,?,?,?,?)");
		//将sql语句 -> 进行赋值
		prep.setString(1,r2.getUsername());
		prep.setString(2,r2.getSname());
		prep.setString(3,r2.getGuidetea());
		prep.setString(4,r2.getTitle());
		prep.setString(5,r2.getProgress());
		prep.setString(6,r2.getGain());
		//执行sql
		prep.executeUpdate();
		conn.close();
	}
	
	//查找
	public List<Report2> findReport2() throws Exception {
		Connection conn = DBUtil.getConnection();
		Statement stat = conn.createStatement();
		ResultSet rs = stat.executeQuery("select * from stu_report2");
		List<Report2> rep2 = new ArrayList<Report2>();
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
		conn.close();
		return rep2;
     }
	
	public Report2 findById2(long id) throws Exception {
		// 根据id查找
		Connection conn=DBUtil.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("select * from stu_report2 where id="+ id);
		Report2 r2 = new Report2();
		while(rs.next()){
			r2.setId(rs.getLong("id"));
			r2.setUsername(rs.getString("username"));
			r2.setSname(rs.getString("sname"));
			r2.setTitle(rs.getString("title"));
			r2.setGuidetea(rs.getString("guidetea"));
			r2.setProgress(rs.getString("progress"));
			r2.setGain(rs.getString("gain"));
			r2.setResult(rs.getString("result"));
		}
		conn.close();
		return r2;
	}
	
	//根据用户名查找
	public Report2 findByUsername2(String username) throws Exception{
		Connection conn=DBUtil.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("select * from stu_report2 where username= '"+username+"'");
		Report2 r2 = new Report2();
		while(rs.next()){
			r2.setId(rs.getLong("id"));
			r2.setUsername(rs.getString("username"));
			r2.setSname(rs.getString("sname"));
			r2.setTitle(rs.getString("title"));
			r2.setGuidetea(rs.getString("guidetea"));
			r2.setProgress(rs.getString("progress"));
			r2.setGain(rs.getString("gain"));
			r2.setResult(rs.getString("result"));
		}
		conn.close();
		return r2;
	}
	
	//根据guidetea查找
	public List<Report2> findByGuidetea2(String tname) throws Exception {
		Connection conn = DBUtil.getConnection();
		Statement stat = conn.createStatement();
		ResultSet rs = stat.executeQuery("select * from stu_report2 where guidetea='"+tname+"'");
		List<Report2> rep2 = new ArrayList<Report2>();
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
		conn.close();
		return rep2;
     }
	
	public void updateResult2(Report2 r2) throws SQLException {	
		// 更新
		Connection conn=DBUtil.getConnection();
		PreparedStatement prep=conn.prepareStatement("update stu_report2 set result=? where id=?");	
		prep.setString(1,r2.getResult());
		prep.setLong(2, r2.getId());
		//执行update语句 
		prep.executeUpdate();
		conn.close();
	}
	
	
	
	//3.结题报告
	//添加
	public void save(Report3 r3) throws Exception {
		Connection conn=DBUtil.getConnection();
		PreparedStatement prep=conn.prepareStatement("insert into stu_report3(username,sname,guidetea,title,progress,gain) values(?,?,?,?,?,?)");
		//将sql语句 -> 进行赋值
		prep.setString(1,r3.getUsername());
		prep.setString(2,r3.getSname());
		prep.setString(3,r3.getGuidetea());
		prep.setString(4,r3.getTitle());
		prep.setString(5,r3.getProgress());
		prep.setString(6,r3.getGain());
		//执行sql
		prep.executeUpdate();
		conn.close();
	}
	
	//查找
	public List<Report3> findReport3() throws Exception {
		Connection conn = DBUtil.getConnection();
		Statement stat = conn.createStatement();
		ResultSet rs = stat.executeQuery("select * from stu_report3");
		List<Report3> rep3 = new ArrayList<Report3>();
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
		conn.close();
		return rep3;
     }
	
	public Report3 findById3(long id) throws Exception {
		// 根据id查找
		Connection conn=DBUtil.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("select * from stu_report3 where id="+ id);
		Report3 r3 = new Report3();
		while(rs.next()){
			r3.setId(rs.getLong("id"));
			r3.setUsername(rs.getString("username"));
			r3.setSname(rs.getString("sname"));
			r3.setTitle(rs.getString("title"));
			r3.setGuidetea(rs.getString("guidetea"));
			r3.setProgress(rs.getString("progress"));
			r3.setGain(rs.getString("gain"));
			r3.setResult(rs.getString("result"));
		}
		conn.close();
		return r3;
	}
	
	//根据用户名查找
	public Report3 findByUsername3(String username) throws Exception{
		Connection conn=DBUtil.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("select * from stu_report3 where username= '"+username+"'");
		Report3 r3 = new Report3();
		while(rs.next()){
			r3.setId(rs.getLong("id"));
			r3.setUsername(rs.getString("username"));
			r3.setSname(rs.getString("sname"));
			r3.setTitle(rs.getString("title"));
			r3.setGuidetea(rs.getString("guidetea"));
			r3.setProgress(rs.getString("progress"));
			r3.setGain(rs.getString("gain"));
			r3.setResult(rs.getString("result"));
		}
		conn.close();
		return r3;
	}
	
	//根据guidetea查找
	public List<Report3> findByGuidetea3(String tname) throws Exception {
		Connection conn = DBUtil.getConnection();
		Statement stat = conn.createStatement();
		ResultSet rs = stat.executeQuery("select * from stu_report3 where guidetea='"+tname+"'");
		List<Report3> rep3 = new ArrayList<Report3>();
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
		conn.close();
		return rep3;
     }
	
	public void updateResult3(Report3 r3) throws SQLException {	
		// 更新
		Connection conn=DBUtil.getConnection();
		PreparedStatement prep=conn.prepareStatement("update stu_report3 set result=? where id=?");	
		prep.setString(1,r3.getResult());
		prep.setLong(2, r3.getId());
		//执行update语句 
		prep.executeUpdate();
		conn.close();
	}
}
