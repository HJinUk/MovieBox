package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import member.MemberDTO;

public class MemberDAO {

	
	Connection con;
	PreparedStatement ptmt;
	ResultSet rs;
	String sql;
	
	
	public MemberDAO() {

		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource)init.lookup("java:/comp/env/mmm");
			con = ds.getConnection();
			
			

			
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	public MemberDTO loginChk(String id, String pw){
		MemberDTO dto = null;
		
		sql = "select * from member where id = ? and pw = ?";
		try {
			System.out.println(sql);
			ptmt = con.prepareStatement(sql);
			
			ptmt.setString(1,id);
			ptmt.setString(2,pw);
			
			rs = ptmt.executeQuery();
			
			if(rs.next()) {
				dto = new MemberDTO();
				
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setName(rs.getString("name"));
				dto.setJumin(rs.getString("jumin"));
				dto.setEmail(rs.getString("email"));
				dto.setTel(rs.getString("tel"));

			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		
		return dto;
	}
	
	public void insertJoin(MemberDTO dto){
	     
	      
	      try {
	         //id의 가장 큰값 가져와 +1 하여 id 구하기
	         sql = "select max(mcode) from member";
	         ptmt = con.prepareStatement(sql);
	         rs = ptmt.executeQuery();
	         
	         rs.next();
	         dto.setMcode(rs.getInt(1)+1);
	         dto.setLev(1);
	         dto.setCoupon(1);
	         
	         ///저장
	         sql = "insert into member (mcode,id,pw,name,lev,tel,email,jumin,genre,coupon,startdate) "
	                        + "values (  ?    ,? ,?  ,? , ?,  ? ,   ?  ,   ?,    ? ,  ?,   sysdate()) ";
	         ptmt = con.prepareStatement(sql);
	         
	         ptmt.setInt(1, dto.getMcode());	//회원고유번호
	         ptmt.setString(2, dto.getId());	//아이디 
	         ptmt.setString(3, dto.getPw());
	         ptmt.setString(4, dto.getName());
	         ptmt.setInt(5,dto.getLev());
	         ptmt.setString(6, dto.getTel());
	         ptmt.setString(7, dto.getEmail());
	         ptmt.setString(8, dto.getJumin());
	         ptmt.setString(9, dto.getGenre());
	         ptmt.setInt(10, dto.getCoupon());
	         //ptmt.setDate(12, dto.getStartDate());
	      
	         
	         
	         ptmt.executeUpdate();
	         
	         
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }finally {
	         close();
	      }
	      
	      
	   }
	
	


	void close() {	
		if(rs!=null)try {rs.close();} catch (SQLException e) {}
		if(ptmt!=null)try {ptmt.close();} catch (SQLException e) {}
		if(con!=null)try {con.close();} catch (SQLException e) {}
	}
	
	
	
}
