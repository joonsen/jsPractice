package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class ScoreDto {
	Connection conn;
	
	public int insert(ScoreVo vo) {
		int cnt = 0;
		conn = new DBConn("mydb").getConn();
		try {
			conn.setAutoCommit(false);
			String sql = "insert into score(serial, id, mdate, subject, score)"		//강사님은 mDate도 ? 처리하심. serial은 삭제
					+ " values(?,?,now(),?,?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, vo.getSerial());			//myBatis를 사용하게되면 이런 코드들이 사라질것이다
			ps.setString(2, vo.getId());
			//ps.setString(3, vo.getMdate());
			ps.setString(3,  vo.getSubject());
			ps.setInt(4, vo.getScore());
			
			cnt = ps.executeUpdate();
			if(cnt>0) conn.commit();
			else	  conn.rollback();
			
			ps.close();
			conn.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return cnt;
	}
	public int update(ScoreVo vo) {
		int cnt = 0;		// excecuteUpdate 수행할때 반영값 확인을 위한 변수
		try {
			conn = new DBConn("mydb").getConn();	//커넥션 연결
			conn.setAutoCommit(false);
			String sql = "update score set serial=?, mdate=?,"
					+" subject=?, score=? where id=?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, vo.getSerial());
			ps.setString(2, vo.getMdate());
			ps.setString(3, vo.getSubject());
			ps.setInt(4, vo.getScore());
			ps.setString(5, vo.getId());
			
			cnt = ps.executeUpdate();
			if(cnt>0) conn.commit();
			else conn.rollback();			//생산성에 집중하기보단 훈련 컨셉에 열심을..
			
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
			
			String sql = "delete from score where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
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
			String sql = "select * from score"
					+ " where id like ?"
					+ " or mdate like ?"
					+ " or subject like ?"
					+ " or score like ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+findStr.trim()+"%");
			ps.setString(2, "%"+findStr.trim()+"%");
			ps.setString(3, "%"+findStr.trim()+"%");
			ps.setString(4, "%"+findStr.trim()+"%");
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("Serial"));
				v.add(rs.getString("Id"));
				v.add(rs.getString("mdate"));
				v.add(rs.getString("subject"));
				v.add(rs.getString("score"));
				list.add(v);
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}
	
	public ScoreVo selectOne(String id) {
		ScoreVo vo = new ScoreVo();
		try {
			conn = new DBConn("mydb").getConn();
			String sql = "select * from score where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				vo.setSerial(rs.getInt("serial"));
				vo.setId(rs.getString("id"));
				vo.setMdate(rs.getString("mdate"));
				vo.setSubject(rs.getString("subject"));
				vo.setScore(rs.getInt("score"));
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return vo;
	}
}





















