package review;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ReviewDAO {

	
	Connection con;
	PreparedStatement ptmt;
	ResultSet rs;
	String sql;
	
	
	public ReviewDAO() {

		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource)init.lookup("java:/comp/env/mmm");
			con = ds.getConnection();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	public ArrayList<ReviewDTO> Reviewlist(int mid){
		ArrayList<ReviewDTO> res = new ArrayList<ReviewDTO>();
		
		try {
			
			sql = "SELECT * FROM member me, review re WHERE re.mcode = me.mcode and re.mid = ?";
			
			ptmt = con.prepareStatement(sql);
			
			ptmt.setInt(1, mid);
	
			rs = ptmt.executeQuery();
			
			while(rs.next()) {
					
				ReviewDTO dto = new ReviewDTO();
				
				dto.setMid(rs.getInt("mid"));
				dto.setMcode(rs.getInt("mcode"));
				
				dto.setText(rs.getString("text"));
				
				dto.setTat(rs.getInt("tat"));
				
				dto.setDate(rs.getDate("date"));
				
				dto.setReco(rs.getInt("reco"));
				
				res.add(dto);
				
			} 
			if(res.size()==0)
				res=null;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		
		return res; 
		
	}
	
	public ArrayList<ReviewDTO> Reviewlist(ArrayList<Integer> mm){
		ArrayList<ReviewDTO> res = new ArrayList<ReviewDTO>();
		
		
		try {
			sql = "SELECT * FROM member me, review re WHERE re.mcode = me.mcode and re.mid = ?";
			
			
			for (int dd : mm) {
				sql = "SELECT *, sum(re.tat), COUNT(re.tat) FROM movielist mo, review re\r\n" + 
						"WHERE\r\n" + 
						"re.mid = mo.mid  AND re.mid=?";
				
				ptmt = con.prepareStatement(sql);
				ptmt.setInt(1, dd);
				
				rs = ptmt.executeQuery();
			
				while(rs.next()) {
					
					ReviewDTO dto = new ReviewDTO();
					
					dto.setMid(rs.getInt("mid"));
					dto.setMcode(rs.getInt("mcode"));
					
					dto.setText(rs.getString("text"));
					
					dto.setTat(rs.getInt("sum(re.tat)"));
					
					dto.setDate(rs.getDate("date"));
					
					dto.setReco(rs.getInt("reco"));
					
					res.add(dto);
					System.out.println("tat: "+dto.getTat());
				}

				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		
		return res; 
		
	}
	
	public ArrayList<ReviewDTO> Reviewlist(int mid, int start, int limit){
		ArrayList<ReviewDTO> res = new ArrayList<ReviewDTO>();
		
		try {
			
			sql = "SELECT * FROM member me, review re WHERE re.mcode = me.mcode and re.mid = ? order by re.date desc limit ?, ?";
			
			ptmt = con.prepareStatement(sql);
			
			ptmt.setInt(1, mid);
			ptmt.setInt(2, start);
			ptmt.setInt(3, limit);
			
			rs = ptmt.executeQuery();
			
			while(rs.next()) {
					
				ReviewDTO dto = new ReviewDTO();
				
				dto.setMid(rs.getInt("mid"));
				dto.setMcode(rs.getInt("mcode"));
				
				dto.setId(rs.getString("id"));
				
				dto.setText(rs.getString("text"));
				
				dto.setTat(rs.getInt("tat"));
				
				dto.setDate(rs.getDate("date"));
				
				dto.setReco(rs.getInt("reco"));
				
				res.add(dto);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		
		return res; 
		
	}
	
	public ArrayList<ReviewDTO> username(int mcode){
		ArrayList<ReviewDTO> res = new ArrayList<ReviewDTO>();
		try {
			
			sql = "select * from member where mcode = ?";
			ptmt = con.prepareStatement(sql);
			
			ptmt.setInt(1, mcode);
			
			rs = ptmt.executeQuery();
			
			while(rs.next()) {
				
				ReviewDTO dto = new ReviewDTO();
				
				dto.setId(rs.getString("id"));
				
				res.add(dto);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		
		return res;
	}
	
	
	public int total(int mid){
		int res =0;
		
		try {
			sql = "select count(*) from review where mid = ?";
			ptmt = con.prepareStatement(sql);
			
			ptmt.setInt(1, mid);
			
			rs = ptmt.executeQuery();
			
			rs.next();
			
			res = rs.getInt(1);
			
			
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
