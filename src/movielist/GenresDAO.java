package movielist;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class GenresDAO {

	
	Connection con;
	PreparedStatement ptmt;
	ResultSet rs;
	String sql;
	
	
	public GenresDAO() {

		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource)init.lookup("java:/comp/env/mmm");
			con = ds.getConnection();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	public ArrayList<GenresDTO> Genlist(int gcode1, int gcode2, int gcode3, int gcode4){
		ArrayList<GenresDTO> res = new ArrayList<GenresDTO>();
		
		try {
			
			sql = "select * from genres where gcode = ? or gcode = ? or gcode = ? or gcode = ?";
											//gcode1       gcode2       gcode3       gcode4
			ptmt = con.prepareStatement(sql);
			
			ptmt.setInt(1, gcode1);
			ptmt.setInt(2, gcode2);
			ptmt.setInt(3, gcode3);
			ptmt.setInt(4, gcode4);
			
			rs = ptmt.executeQuery();
			
			while(rs.next()) {
				
				GenresDTO dto = new GenresDTO();
				
				dto.setGenre(rs.getString("genre"));
				
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
	public ArrayList<GenresDTO> list(){
        ArrayList<GenresDTO> res = new ArrayList<GenresDTO>();
        
        try {
           
           sql = "select * from genres";
                        
           ptmt = con.prepareStatement(sql);
          
       
           
           rs = ptmt.executeQuery();
           
           while(rs.next()) {
              
              GenresDTO dto = new GenresDTO();
              
              dto.setGcode(rs.getInt("gcode"));
              dto.setGenre(rs.getString("genre"));
              
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
	void close() {	
		if(rs!=null)try {rs.close();} catch (SQLException e) {}
		if(ptmt!=null)try {ptmt.close();} catch (SQLException e) {}
		if(con!=null)try {con.close();} catch (SQLException e) {}
	}
	
	
	
}
