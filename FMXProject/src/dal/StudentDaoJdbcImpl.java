package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBUtil;
import entity.Student;
import entity.Teacher;

public class StudentDaoJdbcImpl implements StudentDaoInf{

	public void save(Student s) throws SQLException {			
		// 添加学生
		Connection conn=DBUtil.getConnection();
		PreparedStatement prep1=conn.prepareStatement("insert into fmx_stu(username,sname,sage,sclass,pwd,sgender,usergroup) values(?,?,?,?,?,?,?)");
		PreparedStatement prep2=conn.prepareStatement("insert into fmx_user(username,pwd,sname,usergroup) values(?,?,?,?)");
		//将sql语句 -> 进行赋值
		prep1.setString(1,s.getUsername());
		prep1.setString(2,s.getSname());
		prep1.setInt(3,s.getSage());
		prep1.setString(4,s.getSclass());
		prep1.setString(5,s.getPwd());
		prep1.setString(6,s.getSgender());
		prep1.setInt(7, s.getUsergroup());
		prep2.setString(1,s.getUsername());
		prep2.setString(2,s.getPwd());
		prep2.setString(3, s.getSname());
		prep2.setInt(4, s.getUsergroup());
		//执行sql
		prep1.executeUpdate();
		prep2.executeUpdate();
		conn.close();
	}
	
	public void delete(String username) throws SQLException {			
		// 删除学生
		Connection conn = DBUtil.getConnection();
		PreparedStatement prep1=conn.prepareStatement("delete from fmx_stu where username=?");
		PreparedStatement prep2=conn.prepareStatement("delete from fmx_user where username=?");
		prep1.setString(1, username);
		prep2.setString(1, username);
		prep1.executeUpdate();
		prep2.executeUpdate();
		conn.close();
	}

	public List<Student> findAll() throws SQLException {	
		//查询所有学生信息
		Connection conn = DBUtil.getConnection();
		Statement stat = conn.createStatement();
		ResultSet rs = stat.executeQuery("select * from fmx_stu");
		List<Student> stu = new ArrayList<Student>();
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
		conn.close();
		return stu;
	}

	public void update(Student s) throws SQLException {	
		// 更新学生信息
		Connection conn=DBUtil.getConnection();
		PreparedStatement prep1=conn.prepareStatement("update fmx_stu set sname=?,sage=?,sclass=?,sgender=? where id=?");	
		PreparedStatement prep2=conn.prepareStatement("update fmx_user set sname=? where id=?");	
		prep1.setString(1,s.getSname());
		prep1.setInt(2,s.getSage());
		prep1.setString(3, s.getSclass());
		prep1.setString(4,s.getSgender());		
		prep1.setLong(5, s.getId());
		prep2.setString(1,s.getSname());		
		prep2.setLong(2, s.getId());
		//执行update语句 
		prep1.executeUpdate();
		prep2.executeUpdate();
		conn.close();
	}

	public Student findById(long id) throws Exception {
		// 修改学生信息
		Connection conn=DBUtil.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("select * from fmx_stu where id ="+id);
		Student s = new Student();
		while(rs.next()){
			s.setId(rs.getLong("id"));
			s.setUsername(rs.getString("username"));
			s.setSname(rs.getString("sname"));
			s.setSage(rs.getInt("sage"));
			s.setSclass(rs.getString("sclass"));
			s.setPwd(rs.getString("pwd"));
			s.setSgender(rs.getString("sgender"));
			s.setUsergroup(rs.getInt("usergroup"));
		}
		conn.close();
		return s;
	}
	
	public Student findByUsername(String username) throws Exception {
		Connection conn=DBUtil.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("select * from fmx_stu where username='"+username+"'");
		Student s = new Student();
		while(rs.next()){
			s.setUsername(rs.getString("username"));
			s.setSname(rs.getString("sname"));
		}
		conn.close();
		return s;
	   }
}
