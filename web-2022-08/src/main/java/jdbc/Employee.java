package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class Employee {
	Connection conn;
	public Employee() {
		this.conn = new DBConn().getConn();
		
	}
	
	
	public void insert() throws Exception{
		conn.setAutoCommit(false);
		String sql = "insert into test(id, name) values(?,?)";	//물음표때문에 완성된문장이 아니다...values('e001,'나씨')로 컴파일
		PreparedStatement ps = conn.prepareStatement(sql);	//preparedStatement를 통해 문장완성
		ps.setString(1, "d001");
		ps.setString(2, "나씨");
		
		int cnt = ps.executeUpdate();	//preparedStatement를 실행시켜라
		if(cnt>0) conn.commit();
		else	  conn.rollback();
		
		ps.close();
		conn.close();
	}
	public void select() throws Exception{
		conn = new DBConn().getConn();
		
		String sql = "select * from test";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();	//명시적cursor라고 생각하시오
		while(rs.next()) {		//처음부터 순차적으로 data를 가져온다.
			String id = rs.getString("id");
			String name = rs.getString("name");
			System.out.printf("id:%s(%s)\n", id, name);
		}
		ps.close();
		conn.close();
	}
		
	public void update() throws Exception {
		conn = new DBConn().getConn();
		conn.setAutoCommit(false);//안해주면 큰일날수있삼
		String sql = "update test set name =? where id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, "아가씨");
		ps.setString(2, "e001");
		ps.setString(3, "아무거나");
		int cnt = ps.executeUpdate();
		if(cnt>0) conn.commit();	//검증코드가 들어가야!
		else conn.rollback();
		
		select();
		ps.close();		//connection pool?
		conn.close();	//반드시 쓰고 닫아줘야한다! 안하면 서버 터진다
	}
	public void delete() throws Exception {
		conn = new DBConn().getConn();
		conn.setAutoCommit(false);
		String sql = "delete from test where id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, "b001");
		int cnt = ps.executeUpdate();
		if(cnt>0) {
			System.out.println("정상삭제");
			conn.commit();
		}else {
			System.out.println("삭제할 자료 無");
			conn.rollback();
		}
		ps.close();
		conn.close();
		select();
	}
	
	public void metaTest() throws Exception {
		conn = new DBConn().getConn();
		String sql ="select * from payments";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		ResultSetMetaData meta =  rs.getMetaData();
				
		//select절에서 선택한 컬럼명
		for(int i=1; i<=meta.getColumnCount(); i++) {
			System.out.printf("%-20s", meta.getColumnName(i));
		}
		System.out.println();
		System.out.println("-".repeat(180));
		while(rs.next()) {
			for(int i=1; i<meta.getColumnCount();i++) {
				String cn = meta.getColumnName(i);
				System.out.printf("%-20s",rs.getString(cn));
			}
			System.out.println();
		}
				
	}
	
	public static void main(String[] args) {
		Employee e = new Employee();
		try {
			//e.insert();
			//e.select();
			//e.update();
			//e.delete();
			e.metaTest();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
}
