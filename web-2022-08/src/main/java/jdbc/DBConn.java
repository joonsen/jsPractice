package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
	String db = "classicmodels";
	String driver = "com.mysql.cj.jdbc.Driver";	//드라이버명 상수
	String path = "jdbc:mysql://localhost:3306/";
	String unicode ="?useUnicode=true&characterEncoding=utf-8";
	
	String user = "hong";
	String pwd = "1111";
	Connection conn;
	
	public Connection getConn() {
		try {
			conn = DriverManager.getConnection(path+db+unicode, user, pwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public DBConn(String db) {
		this();
		this.db = db;
	}
	
	public DBConn() {
		try {
			Class.forName(driver);
			
			//System.out.println("connection ok~");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		DBConn dbconn = new DBConn();
	}

}
