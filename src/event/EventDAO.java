package event;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class EventDAO {

	
	Connection con;
	PreparedStatement ptmt;
	ResultSet rs;
	String sql;
	
	
	public EventDAO() {

		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource)init.lookup("java:/comp/env/mmm");
			con = ds.getConnection();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	public ArrayList<EventDTO> List(){
		
		ArrayList<EventDTO> res = new ArrayList<EventDTO>();
		
		try {
			sql = "select * from event WHERE date(finish_ev) >= DATE(SYSDATE()) AND date(start_ev) <= DATE(NOW())";
			
			ptmt = con.prepareStatement(sql);
			
			rs = ptmt.executeQuery();
			
			
			while (rs.next()) {
				EventDTO dto = new EventDTO();
				dto.setEid(rs.getInt("eid"));
				dto.setTitle(rs.getString("title"));
				dto.setTitle_img(rs.getString("title_img"));
				dto.setContent(rs.getString("content"));
				dto.setContent_img(rs.getString("content_img"));
				dto.setStart_ev(rs.getDate("start_ev"));
				dto.setFinish_ev(rs.getDate("finish_ev"));
				dto.setCoupon(rs.getInt("coupon"));
				dto.setPoint(rs.getInt("point"));
				
				res.add(dto);
				
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		
		return res;
		
		
	}
	
public ArrayList<EventDTO> FList(){
		
		ArrayList<EventDTO> res = new ArrayList<EventDTO>();
		
		try {
			sql = "select * from event WHERE date(finish_ev) < DATE(SYSDATE()) ";
			
			ptmt = con.prepareStatement(sql);
			
			rs = ptmt.executeQuery();
			
			
			while (rs.next()) {
				EventDTO dto = new EventDTO();
				dto.setEid(rs.getInt("eid"));
				dto.setTitle(rs.getString("title"));
				dto.setTitle_img(rs.getString("title_img"));
				dto.setContent(rs.getString("content"));
				dto.setContent_img(rs.getString("content_img"));
				dto.setStart_ev(rs.getDate("start_ev"));
				dto.setFinish_ev(rs.getDate("finish_ev"));
				dto.setCoupon(rs.getInt("coupon"));
				dto.setPoint(rs.getInt("point"));
				
				res.add(dto);
				
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		
		return res;
		
		
	}

public EventDTO detail(int eid){
	EventDTO dto = null;

	try {
		sql = "select * from event where eid = ?";
		ptmt = con.prepareStatement(sql);
		ptmt.setInt(1, eid);
		rs = ptmt.executeQuery();

		while(rs.next()) {
			dto = new EventDTO();
			
			dto.setEid(rs.getInt("eid"));
			dto.setTitle(rs.getString("title"));
			dto.setStart_ev(rs.getDate("start_ev"));
			dto.setFinish_ev(rs.getDate("finish_ev"));
			dto.setCoupon(rs.getInt("coupon"));
			dto.setContent_img(rs.getString("content_img"));

		}


	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		close();
	}


	return dto;
}

public int update(MemberDTO dto){
	 
	int res = 0;
	try {

		///수정
		sql = "update member set coupon = ? where id = ?";
				        
		ptmt = con.prepareStatement(sql);
		
		ptmt.setInt(1, dto.coupon);
		
		ptmt.setString(2, dto.id);
		
		res = ptmt.executeUpdate();
		
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		close();
	}
	
	return res;
}


	
	
	
	void close() {	
		if(rs!=null)try {rs.close();} catch (SQLException e) {}
		if(ptmt!=null)try {ptmt.close();} catch (SQLException e) {}
		if(con!=null)try {con.close();} catch (SQLException e) {}
	}
	
	
	
}
