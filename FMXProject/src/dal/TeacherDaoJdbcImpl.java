package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import entity.Teacher;
import util.DBUtil;

public class TeacherDaoJdbcImpl implements TeacherDaoInf{
	public void save(Teacher t) throws SQLException {			
		// 添加教师
		Connection conn=DBUtil.getConnection();
		PreparedStatement prep1=conn.prepareStatement("insert into fmx_tea(username,tname,tage,pwd,tgender,tschool,usergroup) values(?,?,?,?,?,?,?)");
		PreparedStatement prep2=conn.prepareStatement("insert into fmx_user(username,pwd,tname,usergroup) values(?,?,?,?)");
		//将sql语句 -> 进行赋值
		prep1.setString(1,t.getUsername());
		prep1.setString(2,t.getTname());
		prep1.setInt(3,t.getTage());
		prep1.setString(4,t.getPwd());
		prep1.setString(5,t.getTgender());
		prep1.setString(6, t.getTschool());
		prep1.setInt(7, t.getUsergroup());
		prep2.setString(1, t.getUsername());
		prep2.setString(2, t.getPwd());
		prep2.setString(3, t.getTname());
		prep2.setInt(4, t.getUsergroup());
		//执行sql
		prep1.executeUpdate();
		prep2.executeUpdate();
		conn.close();
	}
	
	public void delete(String username) throws SQLException {			
		// 删除教师
		Connection conn = DBUtil.getConnection();
		PreparedStatement prep1=conn.prepareStatement("delete from fmx_tea where username=?");
		PreparedStatement prep2=conn.prepareStatement("delete from fmx_user where username=?");
		prep1.setString(1, username);
		prep2.setString(1, username);
		prep1.executeUpdate();
		prep2.executeUpdate();
		conn.close();
	}

	public List<Teacher> findAll() throws SQLException {	
		//查询所有学生信息
		Connection conn = DBUtil.getConnection();
		Statement stat = conn.createStatement();
		ResultSet rs = stat.executeQuery("select * from fmx_tea");
		List<Teacher> tea = new ArrayList<Teacher>();
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
		conn.close();
		return tea;
	}


	public void update(Teacher t) throws SQLException {	
		// 更新教师信息
		Connection conn=DBUtil.getConnection();
		PreparedStatement prep1 =conn.prepareStatement("update fmx_tea set tname=?,tage=?,tgender=?,tschool=? where id=?");
		PreparedStatement prep2 =conn.prepareStatement("update fmx_user set tname=? where id=?");
		prep1.setString(1, t.getTname());
		prep1.setInt(2, t.getTage());
		prep1.setString(3, t.getTgender());
		prep1.setString(4, t.getTschool());
		prep1.setLong(5, t.getId());
		prep2.setString(1, t.getTname());
		prep2.setLong(2, t.getId());
		//执行update语句
		prep1.executeUpdate();
		prep1.executeUpdate();
		conn.close();
	}

	public Teacher findById(long id) throws Exception {
		// 修改学生信息
		Connection conn=DBUtil.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("select * from fmx_tea where id="+id);
		Teacher t = new Teacher();
		while(rs.next()){
			t.setId(rs.getLong("id"));
			t.setUsername(rs.getString("username"));
			t.setTname(rs.getString("tname"));
			t.setTage(rs.getInt("tage"));
			t.setPwd(rs.getString("pwd"));
			t.setTgender(rs.getString("tgender"));
			t.setTschool(rs.getString("tschool"));
			t.setUsergroup(rs.getInt("usergroup"));
		}
		conn.close();
		return t;
	}

public Teacher findByUsername(String username) throws Exception {
	Connection conn=DBUtil.getConnection();
	Statement stmt=conn.createStatement();
	ResultSet rs=stmt.executeQuery("select * from fmx_tea where username='"+username+"'");
	Teacher t = new Teacher();
	while(rs.next()){
		t.setUsername(rs.getString("username"));
		t.setTname(rs.getString("tname"));
		t.setTage(rs.getInt("tage"));
		t.setPwd(rs.getString("pwd"));
		t.setTgender(rs.getString("tgender"));
		t.setTschool(rs.getString("tschool"));
		t.setUsergroup(rs.getInt("usergroup"));
	}
	conn.close();
	return t;
   }
}
