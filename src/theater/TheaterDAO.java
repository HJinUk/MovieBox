package theater;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class TheaterDAO {

	
	Connection con;
	PreparedStatement ptmt;
	ResultSet rs;
	String sql;
	
	
	public TheaterDAO() {

		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource)init.lookup("java:/comp/env/mmm");
			con = ds.getConnection();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	
	public ArrayList<TheaterDTO> list (){
		ArrayList<TheaterDTO> res = new ArrayList<TheaterDTO>();
		

		try {
			sql = "select * from areacode";
			
			ptmt =con.prepareStatement(sql);

			rs=ptmt.executeQuery();
			
			
			while(rs.next()) {
				TheaterDTO dto = new TheaterDTO();
				
				dto.setTid(rs.getInt("tid"));
				dto.setProject(rs.getInt("project"));
				dto.setAreacode(rs.getInt("areacode"));
				
				
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
	
	public ArrayList<TheaterDTO> arealist (){
		ArrayList<TheaterDTO> res = new ArrayList<TheaterDTO>();
		

		try {
			sql = "select * from areacode";
			
			ptmt =con.prepareStatement(sql);

			rs=ptmt.executeQuery();
			
			
			while(rs.next()) {
				TheaterDTO dto = new TheaterDTO();
				
			
				dto.setName(rs.getString("name"));
				dto.setAreacode(rs.getInt("areacode"));
				
				
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
	
	public ArrayList<TheaterDTO> theaterlist (int areacode){
		ArrayList<TheaterDTO> res = new ArrayList<TheaterDTO>();
		

		try {
			sql = "select * from theater where areacode = ?";
			
			ptmt =con.prepareStatement(sql);

			ptmt.setInt(1, areacode);
			
			rs=ptmt.executeQuery();
			
			
			while(rs.next()) {
				TheaterDTO dto = new TheaterDTO();
				
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
	
	
	
	
	void close() {	
		if(rs!=null)try {rs.close();} catch (SQLException e) {}
		if(ptmt!=null)try {ptmt.close();} catch (SQLException e) {}
		if(con!=null)try {con.close();} catch (SQLException e) {}
	}
	
	
	
}
