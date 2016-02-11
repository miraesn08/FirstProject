package kr.co.miraesn08.firstproject.common;

public class DBConnectionTemplate {
	private static final String serverName = "";
	private static final String portNumber = "";
	
	public static final String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	public static final String user = "";
	public static final String password = "";
	public static final String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + user;	
}
