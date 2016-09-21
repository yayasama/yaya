package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.User;
import util.DBUtil;

public class UserDao {
	public void save(User u){
		Connection conn=DBUtil.getConnection();
		PreparedStatement prep;
		try {
			//����
			prep = conn.prepareStatement("insert into fmx_user(username,pwd,usergroup) values(?,?,?)");
			//��sql����е������н��и�ֵ
			prep.setString(1, u.getUsername());
			prep.setString(2, u.getPwd());
			prep.setInt(3, u.getUsergroup());
			//ִ��sql
			prep.executeUpdate();
			DBUtil.close(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public User findByUsername(String username){
		User u = null;
		Connection conn = DBUtil.getConnection();
		PreparedStatement prep;
		try {
			//ѡȡ����
			prep = conn.prepareStatement("select * from fmx_user where username='"+username+"'");
			ResultSet  rs = prep.executeQuery();
			while(rs.next()){
				u = new User();
				u.setId(rs.getLong("id"));
				u.setUsername(rs.getString("username"));
				u.setPwd(rs.getString("pwd"));
				u.setSname("sname");
				u.setTname("tname");
				u.setUsergroup(rs.getInt("usergroup"));
			}
		} catch (SQLException e) {	
			e.printStackTrace();
		}
		return u;
	}
	
	public void updatePwd(User u) throws SQLException {	
		// ����
		Connection conn=DBUtil.getConnection();
		PreparedStatement prep=conn.prepareStatement("update fmx_user set pwd=? where username=?");
		prep.setString(1, u.getPwd());
		prep.setString(2, u.getUsername());
		//ִ��update��� 
		prep.executeUpdate();
	}
}
