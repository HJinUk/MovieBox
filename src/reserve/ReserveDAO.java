package reserve;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ReserveDAO {

	
	Connection con;
	PreparedStatement ptmt;
	ResultSet rs;
	String sql;
	
	
	public ReserveDAO() {

		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource)init.lookup("java:/comp/env/mmm");
			con = ds.getConnection();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	
	public ArrayList<ReserveDTO> list() {
		ArrayList<ReserveDTO> res = new ArrayList<ReserveDTO>();
		
		sql="select * from movielist where open <= sysdate() and open >= subdate(sysdate(),interval 1 month) and close = 0";
		
		
		try {
			ptmt = con.prepareStatement(sql);
			
			
			rs = ptmt.executeQuery();
			
			while(rs.next()) {
				
				ReserveDTO dto = new ReserveDTO();
				
				dto.setName(rs.getString("name"));
				
				res.add(dto);
				
			}
		
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			close();
		}
		
		return res;
		
	}
	public ArrayList<ReserveDTO> theaterlist (int areacode){
	      ArrayList<ReserveDTO> res = new ArrayList<ReserveDTO>();
	      

	      try {
	         sql = "select * from theater where areacode = ?";
	         
	         ptmt =con.prepareStatement(sql);

	         ptmt.setInt(1, areacode);
	         
	         rs=ptmt.executeQuery();
	         
	         
	         while(rs.next()) {
	        	 ReserveDTO dto = new ReserveDTO();
	            
	            dto.setTid(rs.getInt("tid"));
	            dto.setAreacode(rs.getInt("areacode"));
	            dto.setName(rs.getString("name"));

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
	
	public ArrayList<ReserveDTO> thList() {
		 ArrayList<ReserveDTO> res = new ArrayList<ReserveDTO>();
		
		sql = "select * from theater ";
		
		try {
			ptmt = con.prepareStatement(sql);
			
			rs = ptmt.executeQuery();
			
			while(rs.next()) {
				
				ReserveDTO dto = new ReserveDTO();
				
				dto.setName(rs.getString("name"));
				
				res.add(dto);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
		
	} 
	
	public ArrayList<ReserveDTO> area() {
		 ArrayList<ReserveDTO> res = new ArrayList<ReserveDTO>();
		
		
		sql = "select * from areacode";
		
		try {
			ptmt = con.prepareStatement(sql);
			
			
			rs = ptmt.executeQuery();
			
			while(rs.next()) {
				
				ReserveDTO dto = new ReserveDTO();
				
				dto.setName(rs.getString("name"));
				dto.setAreacode(rs.getInt("areacode"));
				res.add(dto);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
		
	} 
	void close() {	
		if(rs!=null)try {rs.close();} catch (SQLException e) {}
		if(ptmt!=null)try {ptmt.close();} catch (SQLException e) {}
		if(con!=null)try {con.close();} catch (SQLException e) {}
	}
	
	
	
}
