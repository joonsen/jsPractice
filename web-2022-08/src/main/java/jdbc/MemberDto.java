package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class MemberDto {
	Connection conn;
	
	public int insert(MemberVo vo) {
		int cnt = 0;
		// connection 생성
		conn = new DBConn("mydb").getConn();
		// transaction 수동
		try {
			conn.setAutoCommit(false);
			// sql 문장
			String sql = "insert into member(id,name,gender,phone,picture,mdate)" 
					+ "values(?,?,?,?,?, now())";
			// statement 생성
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,  vo.getId());
			ps.setString(2, vo.getIrum());
			ps.setString(3, vo.getGender());
			ps.setString(4, vo.getPhone());
			ps.setString(5,  vo.getPicture());
			
			// 저장(실행)
			cnt = ps.executeUpdate();
			if(cnt>0) conn.commit();
			else	  conn.rollback();
			
			//close
			ps.close();
			conn.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return cnt;
	}
	public int update(MemberVo vo) {
		int cnt = 0;
		try {
			conn = new DBConn().getConn();
			conn.setAutoCommit(false);
			String sql = "update member set name=? , gender=?, phone=?, picture=?"
					+ " where id=? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getIrum());
			ps.setString(2, vo.getGender());
			ps.setString(3, vo.getPhone());
			ps.setString(4,  vo.getPhone());
			ps.setString(5, vo.getId());
			
			cnt = ps.executeUpdate();
			if(cnt>0) conn.commit();
			else conn.rollback();
			
			ps.close();
			conn.close();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return cnt;
	}
	public int delete(String id) {
		int cnt = 0;
		try {
			conn = new DBConn("mydb").getConn();
			conn.setAutoCommit(false);
			
			String sql = "delete from member where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,id);
			cnt = ps.executeUpdate();
			if(cnt>0) conn.commit();
			else	  conn.rollback();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		
		return cnt;
	}	
	public Vector<Vector> select(String findStr) {
	      Vector<Vector> list = new Vector<Vector>();
	      
	      try {
	    	  conn = new DBConn("mydb").getConn();
	    	  String sql = "select * from member "
	    	  		+ "where id   like ? "		//문장을 한줄 내려 쓸때는 공백을 꼭 만들어라
	    	  		+ "or	name  like ? "
	    	  		+ "or 	phone like ? ";
	    	  PreparedStatement ps = conn.prepareStatement(sql);
	    	  ps.setString(1, "%"+findStr+"%");
	    	  ps.setString(2, "%"+findStr+"%");
	    	  ps.setString(3, "%"+findStr+"%");
	    	  
	    	  ResultSet rs = ps.executeQuery();
	    	  while(rs.next()) {
	    		  Vector v = new Vector();
	    		  v.add(rs.getString("id"));
	    		  v.add(rs.getString("name"));
	    		  v.add(rs.getString("gender"));
	    		  v.add(rs.getString("phone"));
	    		  v.add(rs.getString("mdate"));
	    		  list.add(v);		
	    	  }
	    	  
	      }catch(Exception ex) {
	    	  ex.printStackTrace();
	      }
	      
	      
	      return list;
	   }
	   
	public MemberVo selectOne(String id) {
		MemberVo vo = new MemberVo();
		try {
			String sql = "select * from member where id=?";
			conn = new DBConn("mydb").getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				vo.setId(rs.getString("id"));
				vo.setIrum(rs.getString("name"));
				vo.setGender(rs.getString("gender"));
				vo.setPhone(rs.getString("phone"));
				vo.setPicture(rs.getString("picture"));
				vo.setmDate(rs.getString("mdate"));
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return vo;
	}
}	  
	
	
	
	
	
