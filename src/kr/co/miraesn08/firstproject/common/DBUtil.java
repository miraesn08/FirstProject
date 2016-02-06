package kr.co.miraesn08.firstproject.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
	Singleton Pattern (http://www.journaldev.com/1377/java-singleton-design-pattern-best-practices-with-examples)
	- Private constructor to restrict instantiation of the class from other classes.
	- Private static variable of the same class that is the only instance of the class.
	- Public static method that returns the instance of the class, 
		this is the global access point for outer world 
		to get the instance of the singleton class.
*/
public class DBUtil {

	private DBUtil() { }
	
	private static class SingletonHelper{
        private static final DBUtil INSTANCE = new DBUtil();
    }
     
    public static DBUtil getInstance(){
        return SingletonHelper.INSTANCE;
    }
    
	public static Connection getConnection() throws Exception {
		return getConnection(true);
	}

	public static Connection getConnection(boolean isAutoCommit) throws Exception {
		String url = DBConnection.url;	
		String user = DBConnection.user;
		String password = DBConnection.password;
		Connection conn = getConnection(url, user, password, isAutoCommit);
		return conn;
	}

	public static Connection getConnection(String url, String user, String password, boolean isAutoCommit) throws Exception  {
		Class.forName(DBConnection.driver);
		Connection conn = DriverManager.getConnection(url, user, password);
		conn.setAutoCommit(isAutoCommit);
		return conn;
	}
	
	public static void close(Connection conn, PreparedStatement ps) {
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}				
		}		
	}
	
	public static void close(Connection conn, PreparedStatement ps, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		close(conn, ps);
	}

}
