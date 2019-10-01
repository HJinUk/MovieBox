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

public class MovieListDAO {

	
	Connection con;
	PreparedStatement ptmt;
	ResultSet rs;
	String sql;
	
	
	public MovieListDAO() {

		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource)init.lookup("java:/comp/env/mmm");
			con = ds.getConnection();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	public ArrayList<MovieListDTO> Nowlist(int start, int limit){
		ArrayList<MovieListDTO> res = new ArrayList<MovieListDTO>();
		
		try {
			
			sql = "select * from movielist where open <= sysdate() AND close = 0 limit ?, ?";
			
			ptmt = con.prepareStatement(sql);
			
			ptmt.setInt(1, start);
			ptmt.setInt(2, limit);
			
			rs = ptmt.executeQuery();
			
			while(rs.next()) {
				
				MovieListDTO dto = new MovieListDTO();
				
				dto.setMid(rs.getInt("mid"));
				dto.setName(rs.getString("name"));
				dto.setOpen(rs.getDate("open"));
				dto.setImgurl(rs.getString("imgurl"));
				dto.setGenre1(rs.getInt("genre1"));
				dto.setGenre2(rs.getInt("genre2"));
				dto.setGenre3(rs.getInt("genre3"));
				dto.setGenre4(rs.getInt("genre4"));
				dto.setYear(rs.getInt("year"));
				dto.setPlay(rs.getInt("play"));
				
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
	
	public ArrayList<MovieListDTO> Beforelist(int start, int limit){
		ArrayList<MovieListDTO> res = new ArrayList<MovieListDTO>();
		
		try {
			
			sql = "select * from movielist where open > sysdate() order by open asc limit ?, ?";
			
			ptmt = con.prepareStatement(sql);
			
			ptmt.setInt(1, start);
			ptmt.setInt(2, limit);
			
			rs = ptmt.executeQuery();
			
			while(rs.next()) {
				
				MovieListDTO dto = new MovieListDTO();
				
				dto.setMid(rs.getInt("mid"));
				dto.setName(rs.getString("name"));
				dto.setOpen(rs.getDate("open"));
				dto.setImgurl(rs.getString("imgurl"));
				dto.setGenre1(rs.getInt("genre1"));
				dto.setGenre2(rs.getInt("genre2"));
				dto.setGenre3(rs.getInt("genre3"));
				dto.setGenre4(rs.getInt("genre4"));
				dto.setYear(rs.getInt("year"));
				dto.setPlay(rs.getInt("play"));
				
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
	
	public MovieListDTO Detail(int mid) {
		MovieListDTO dto = null;
		try {
			sql = "select * from movielist where mid = ?";
			ptmt = con.prepareStatement(sql);
			ptmt.setInt(1, mid);
			rs = ptmt.executeQuery();
			
			while(rs.next()) {
				
				dto = new MovieListDTO();
				
				dto.setMid(rs.getInt("mid"));
				
				dto.setName(rs.getString("name"));
				dto.setStory(rs.getString("story"));
				
				dto.setOpen(rs.getDate("open"));
				
				dto.setMurl(rs.getString("murl"));
				dto.setImgurl(rs.getString("imgurl"));
				dto.setForeman(rs.getString("foreman"));
				dto.setActor(rs.getString("actor"));
				dto.setGenre1(rs.getInt("genre1"));
				dto.setGenre2(rs.getInt("genre2"));
				dto.setGenre3(rs.getInt("genre3"));
				dto.setGenre4(rs.getInt("genre4"));
				
				dto.setYear(rs.getInt("year"));
				dto.setPlay(rs.getInt("play"));
				
				dto.setCountry(rs.getString("country"));
								
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		
		return dto;
	}
	
	public void insert(MovieListDTO dto) {
		try {
			sql = "insert into center " 
					+ "(name, story, open, murl, imgurl, foreman,"
					+ " actor, genre, year, play, country) " +
					"values "+
					"(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, dto.name);
			ptmt.setString(2, dto.story);
			
			ptmt.setDate(3, (Date) dto.open);
			
			ptmt.setString(4, dto.murl);
			ptmt.setString(5, dto.imgurl);
			ptmt.setString(6, dto.foreman);
			ptmt.setString(7, dto.actor);
//			ptmt.setString(8, dto.genre);
			
			ptmt.setInt(9, dto.year);
			ptmt.setInt(10, dto.play);
			
			ptmt.setString(11, dto.country);
			
			rs = ptmt.executeQuery();
			
//			ptmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
	}
	
	public int Nowtotal(){
		int res =0;
		
		try {
			sql = "select count(*) from movielist where open <= sysdate() AND close = 0";
			ptmt = con.prepareStatement(sql);
			
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
	
	public int Beforetotal(){
		int res =0;
		
		try {
			sql = "select count(*) from movielist where open > sysdate()";
			ptmt = con.prepareStatement(sql);
			
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
