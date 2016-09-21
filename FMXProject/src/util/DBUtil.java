package util;
//这是一个工具类，用于获取与数据库的连接
import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	 public static Connection getConnection() {
		Connection conn = null;
		try {
		    Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection
			("jdbc:mysql://localhost:3306/fengminxia?","root","1111");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	 
	 //关闭连接
	 public static void close(Connection conn){
		 if(conn != null){
			 try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
		 }
	 }
	 
	 public static void main(String[] args) {
		System.out.println(DBUtil.getConnection());
	}
}
