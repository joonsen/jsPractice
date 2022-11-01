package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;

public class GetEmailCall {

	public GetEmailCall() {
		Connection conn = new DBConn("classicmodels").getConn();
		try {
			String sql = "{call GetEmail(?,?,?)}";
			CallableStatement cstmt = conn.prepareCall(sql);
			cstmt.setString(1, "Murphy");
			cstmt.setString(2, "Diane");
			cstmt.registerOutParameter(3, java.sql.JDBCType.VARCHAR);
			
			cstmt.executeQuery();
			String email = cstmt.getString(3);
			System.out.println("email: " + email);
			cstmt.close();
			conn.close();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new GetEmailCall();
	}
	
}
