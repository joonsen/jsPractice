package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;

public class InsertMember {
	
	public InsertMember() {
		Connection conn = new DBConn("mydb").getConn();
		try {
			String sql = "{call InsertMember(?,?,?,?,?)}";
			CallableStatement cstmt = conn.prepareCall(sql);
			cstmt.setString(1, "d001");
			cstmt.setString(2, "kang");
			cstmt.setString(3, "female");
			cstmt.setString(4, "010-1231");
			cstmt.setString(5, "none");
			cstmt.executeQuery();
			
			cstmt.close();
			conn.close();
			
		} catch(Exception ex) {ex.printStackTrace();}
	}
	public static void main(String[] args) {
		new InsertMember();
	}
}
