package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;
import entity.Peixun;

public class PeixunDaoJdbcImpl implements PeixunDaoInf {
	//添加培训教师
	public void save(Peixun p) throws Exception {
		Connection conn=DBUtil.getConnection();
		PreparedStatement prep=conn.prepareStatement("insert into fmx_peixun(username,name,age,gender,institution,category,time,usergroup) values(?,?,?,?,?,?,?,?)");
		//将sql语句 -> 进行赋值
		prep.setString(1,p.getUsername());
		prep.setString(2,p.getName());
		prep.setInt(3,p.getAge());
		prep.setString(4,p.getGender());
		prep.setString(5,p.getInstitution());
		prep.setString(6,p.getCategory());
		prep.setString(7,p.getTime());
		prep.setInt(8,p.getUsergroup());
		//执行sql
		prep.executeUpdate();
		conn.close();
	}

	//查找所有学生
	public List<Peixun> findAll() throws Exception {
		Connection conn = DBUtil.getConnection();
		Statement stat = conn.createStatement();
		ResultSet rs = stat.executeQuery("select * from fmx_peixun");
		List<Peixun> px = new ArrayList<Peixun>();
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
			px.add(p);
		}
		conn.close();
		return px;
	}

   //根据id查找
	public Peixun findById(long id) throws Exception {
		Connection conn=DBUtil.getConnection();
	Statement stmt=conn.createStatement();
	ResultSet rs=stmt.executeQuery("select * from fmx_peixun where id="+id);
	Peixun p = new Peixun();
	while(rs.next()){
		p.setId(rs.getLong("id"));
		p.setUsername(rs.getString("username"));
		p.setName(rs.getString("name"));
		p.setAge(rs.getInt("age"));
		p.setGender(rs.getString("gender"));
		p.setInstitution(rs.getString("institution"));
		p.setCategory(rs.getString("category"));
		p.setTime(rs.getString("time"));
		p.setUsergroup(rs.getInt("usergroup"));
	}
	conn.close();
	return p;
	}

	//删除
	public void delete(long id) throws Exception {
		Connection conn = DBUtil.getConnection();
		PreparedStatement prep=conn.prepareStatement("delete from fmx_peixun where id=?");
		prep.setLong(1, id);
		prep.executeUpdate();
		conn.close();
	}

	//根据编号查找
	public Peixun findByUsername(String username) throws Exception {
		Connection conn=DBUtil.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("select * from fmx_peixun where username='"+username+"'");
		Peixun p = new Peixun();
		while(rs.next()){
			p.setUsername(rs.getString("username"));
		}
		conn.close();
		return p;
	   }
	
	//更新信息
	public void update(Peixun p) throws Exception {
		Connection conn=DBUtil.getConnection();
		PreparedStatement prep =conn.prepareStatement("update fmx_peixun set name=?,age=?,gender=?,institution=?,category=?,time=? where id=?");	
		prep.setString(1,p.getName());
		prep.setInt(2,p.getAge());
		prep.setString(3,p.getGender());
		prep.setString(4,p.getInstitution());
		prep.setString(5,p.getCategory());
		prep.setString(6,p.getTime());
		prep.setLong(7, p.getId());
		//执行update语句
		prep.executeUpdate();
		conn.close();
	}
}
