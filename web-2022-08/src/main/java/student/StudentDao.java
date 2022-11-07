package student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jdbc.DBConn;

public class StudentDao {
   Connection conn;
   
   
   public StudentDao() {
      try {
         conn = new DBConn("mydb").getConn();
      }catch(Exception e){
         e.printStackTrace();
      }
   }
   
   
   public boolean insert(StudentVo vo) {
      boolean b = false;
      String sql = "insert into student(id, name, phone, pwd, address,address2, zipcode, gender, email)"
            + " values(?,?,?,?,?,?,?,?,?)";
      try {
         conn.setAutoCommit(false);
         PreparedStatement ps = conn.prepareStatement(sql);
         ps.setString(1, vo.getId());
         ps.setString(2, vo.getName());
         ps.setString(3, vo.getPhone());
         ps.setString(4, vo.getPwd());
         ps.setString(5, vo.getAddress());
         ps.setString(6, vo.getAddress2());
         ps.setString(7, vo.getZipcode());
         ps.setString(8, vo.getGender());
         ps.setString(9, vo.getEmail());
         
         int cnt = ps.executeUpdate();
         if(cnt>0) {
            conn.commit();
            b=true;
         }
         
      }catch(Exception ex) {
         ex.printStackTrace();
      }
      return b;
   }
   public List<StudentVo> select(Page pageVo){
	   List<StudentVo> list = new ArrayList<StudentVo>();
	   String sql = "";
	   PreparedStatement ps = null;
	   ResultSet rs = null;			//sql, ps, rs 두번씩 써야해서 위로 빼놓음.
	   //검색된 전체 건수
	   try {
		   sql = "select count(id) totSize from student "
				   + " where id like ? "
				   + " or 	name like ? "
				   + " or 	phone like ? "
				   + " or 	address like ? "
				   + " or 	address2 like ? "
				   + " or   email like ? ";
		   ps = conn.prepareStatement(sql);
		   ps.setString(1, "%" + pageVo.getFindStr() + "%");
		   ps.setString(2, "%" + pageVo.getFindStr() + "%");
		   ps.setString(3, "%" + pageVo.getFindStr() + "%");
		   ps.setString(4, "%" + pageVo.getFindStr() + "%");
		   ps.setString(5, "%" + pageVo.getFindStr() + "%");
		   ps.setString(6, "%" + pageVo.getFindStr() + "%");
		   
		   rs = ps.executeQuery();
		   rs.next();
		   int totSize = rs.getInt("totSize");		//totSize를 가져오는 query
		   pageVo.setTotSize(totSize);		//totSize를 sql에서 count된 값으로 setting
		   pageVo.compute();
		   
		   sql = "select * from student "
				   + " where id like ? "
				   + " or 	name like ? "
				   + " or 	phone like ? "
				   + " or 	address like ? "
				   + " or 	address2 like ? "
				   + " or   email like ? "
				   + " order by name asc "
				   + " limit ? , ? ";		//limit 때문에 data가 20건만 나옴. 페이징 분리
	   
		   ps = conn.prepareStatement(sql);
		   ps.setString(1, "%" + pageVo.getFindStr() + "%");
		   ps.setString(2, "%" + pageVo.getFindStr() + "%");
		   ps.setString(3, "%" + pageVo.getFindStr() + "%");
		   ps.setString(4, "%" + pageVo.getFindStr() + "%");
		   ps.setString(5, "%" + pageVo.getFindStr() + "%");
		   ps.setString(6, "%" + pageVo.getFindStr() + "%");
		   ps.setInt(7, pageVo.getStartNo());
		   ps.setInt(8, pageVo.getListSize());
		   //myBatis가 적용되면 이녀석들 싹 사라집니다
		   
		   rs = ps.executeQuery();
		   
		   while(rs.next()) {
			   StudentVo vo = new StudentVo();		//자동화시키는 코드는 myBatis에서 ~~
			   vo.setId(rs.getString("id"));
			   vo.setName(rs.getString("name"));
			   vo.setPhone(rs.getString("phone"));
			   vo.setZipcode(rs.getString("zipcode"));
			   vo.setAddress(rs.getString("address"));
			   vo.setAddress2(rs.getString("address2"));
			   vo.setGender(rs.getString("gender"));
			   vo.setEmail(rs.getString("email"));
			   
			   list.add(vo);
		   }
		   ps.close();
		   conn.close();
		   
	   }catch(Exception ex) {
		   ex.printStackTrace();
	   }
		   
	   return list;
   }
   
   public StudentVo view(String id) {
	 StudentVo vo = new StudentVo();
	 String sql = "select * from student where id=? ";
	 try {
		 PreparedStatement ps = conn.prepareStatement(sql);
		 ps.setString(1,id);
		 ResultSet rs = ps.executeQuery();
		 if(rs.next()) {
			   vo.setId(rs.getString("id"));
			   vo.setName(rs.getString("name"));
			   vo.setPhone(rs.getString("phone"));
			   vo.setZipcode(rs.getString("zipcode"));
			   vo.setAddress(rs.getString("address"));
			   vo.setAddress2(rs.getString("address2"));
			   vo.setGender(rs.getString("gender"));
			   vo.setEmail(rs.getString("email"));
		 }
		 
	 }catch(Exception ex) {
		 ex.printStackTrace();
	 }
	 
	 return vo;
   }
   
   public boolean modify(StudentVo vo) {
	   boolean b = false;
	   String sql = "update student set name=?, gender=?, phone=?, zipcode=?, "
			   		+ " address=?, address2=?, email=? "
			   		+ " where id=? and pwd=? ";
	   try {
		   conn.setAutoCommit(false);
		   PreparedStatement ps = conn.prepareStatement(sql);
		   ps.setString(1, vo.getName());
		   ps.setString(2, vo.getGender());
		   ps.setString(3, vo.getPhone());
		   ps.setString(4, vo.getZipcode());
		   ps.setString(5, vo.getAddress());
		   ps.setString(6, vo.getAddress2());
		   ps.setString(7, vo.getEmail());
		   ps.setString(8, vo.getId());
		   ps.setString(9, vo.getPwd());
		   
		   int cnt = ps.executeUpdate();
		   if(cnt>0) {
			   b=true;
			   conn.commit();
		   }else {
			   conn.rollback();
		   }
		   ps.close();
		   conn.close();
		   
	   }catch(Exception ex) {
		   ex.printStackTrace();
	   }
	   
	   return b;
   }
   
   public boolean delete(StudentVo vo) {
	   boolean b = false;
	   String sql = "delete from student where id=? and pwd=? ";
	   try {
		   conn.setAutoCommit(false);
		   PreparedStatement ps = conn.prepareStatement(sql);
		   ps.setString(1, vo.getId());
		   ps.setString(2, vo.getPwd());
		  
		   int cnt = ps.executeUpdate();
		   if(cnt>0) {
			   b=true;
			   conn.commit();
		   }else {
			   conn.rollback();
		   }
		   ps.close();
		   conn.close();
		   
	   }catch(Exception ex) {
		   ex.printStackTrace();
	   }
	   return b;
   }
   
}













