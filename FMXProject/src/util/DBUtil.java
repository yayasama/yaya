package util;
//����һ�������࣬���ڻ�ȡ�����ݿ������
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
	 
	 //�ر�����
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
