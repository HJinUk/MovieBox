package calculate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import movielist.MovieListDTO;
import reserve.ReserveDTO;

public class CalculateDAO {

	Connection con;
	PreparedStatement ptmt;
	ResultSet rs;
	String sql;

	public CalculateDAO() {

		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource)init.lookup("java:/comp/env/mmm");
			con = ds.getConnection();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public ArrayList<ReserveDTO> CalYear(int start, int finish, String movieNum,
			String theaterNum){
		ArrayList<ReserveDTO> res = new ArrayList<ReserveDTO>();

		try {
			String mn = " and mid ='"+movieNum+"'";
			String tn = " and tid ='"+theaterNum+"'";
			String sql="";
		
			if(mn!=null && mn=="전체") {
				sql+=mn;
			}
			if(tn!=null && tn=="전체") {
				sql+=tn;
			}

			for (int i = start; i <= finish; i++) {

				rs = ptmt.executeQuery("SELECT COUNT(rid) AS 'rid' ,SUM(sum) AS 'sum',SUM(dsum) AS 'dsum'"
						+ " FROM reserve"+ " WHERE date between '"+i+"-01-01' AND '"+i+"-12-31'"+sql);
				
			while (rs.next()) {
				ReserveDTO dto = new ReserveDTO();

				dto.rid = rs.getInt("rid");
				dto.sum = rs.getInt("sum");

				res.add(dto);
			} 
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	
	public ArrayList<ReserveDTO> CalMonth(int ystart,int yfinish, int start, int finish, String movieNum,
			String theaterNum){
		ArrayList<ReserveDTO> res = new ArrayList<ReserveDTO>();

		try {
			String mn = " and mid ='"+movieNum+"'";
			String tn = " and tid ='"+theaterNum+"'";
			String sql="";
		
			if(mn!=null && mn=="전체") {
				sql+=mn;
			}
			if(tn!=null && tn=="전체") {
				sql+=tn;
			}
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
			Date nowDate = new Date();
			Date select = new Date();
			Calendar calen = Calendar.getInstance();
			nowDate = new SimpleDateFormat("yyyy-MM").parse(ystart+"-"+start);
			select = new SimpleDateFormat("yyyy-MM").parse(yfinish+"-"+finish);
			calen.setTime(nowDate);
			int month = (select.getYear() * 12 + select.getMonth()) - (nowDate.getYear() * 12 + nowDate.getMonth());

			for (int i = 0; i <= month; i++) {

				rs = ptmt.executeQuery("SELECT COUNT(rid) AS 'rid' ,SUM(sum) AS 'sum',SUM(dsum) AS 'dsum'"+ " timestamp(DATE) AS 'date'"+
				" FROM reserve"+" WHERE date between '"+sdf.format(calen.getTime())+"-01' AND '"+sdf.format(calen.getTime())+"-31'"+sql);
				
			while (rs.next()) {
				ReserveDTO dto = new ReserveDTO();

				dto.rid = rs.getInt("rid");
				dto.sum = rs.getInt("sum");

				res.add(dto);
			} 
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	
	public ArrayList<ReserveDTO> CalDate(int ystart, int mstart,int yfinish, int mfinish, int start, int finish, String movieNum,
			String theaterNum){
		ArrayList<ReserveDTO> res = new ArrayList<ReserveDTO>();

		try {
			String mn = " and mid ='"+movieNum+"'";
			String tn = " and tid ='"+theaterNum+"'";
			
			String sql="";
		
			if(mn!=null && mn=="전체") {
				sql+=mn;
			}
			if(tn!=null && tn=="전체") {
				sql+=tn;
			}
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date nowDate = new Date();
			Date select = new Date();
			Calendar calen = Calendar.getInstance();
			Calendar calen2 = Calendar.getInstance();
			nowDate = new SimpleDateFormat("yyyy-MM-dd").parse(ystart+"-"+mstart+"-"+start);
			select = new SimpleDateFormat("yyyy-MM-dd").parse(yfinish+"-"+mfinish+"-"+finish);
			calen.setTime(nowDate);
			calen2.setTime(select);
			int day = (select.getYear() * 12 + select.getMonth() + select.getDate()) - 
							(nowDate.getYear() * 12 + nowDate.getMonth() + nowDate.getDate());

			for (int i = 0; i <= day; i++) {

				rs = ptmt.executeQuery("SELECT COUNT(rid) AS 'rid' ,SUM(sum) AS 'sum',SUM(dsum) AS 'dsum'"+ " timestamp(DATE) AS 'date'"+
						" FROM reserve"+" WHERE date between '"+sdf.format(calen.getTime())+"-01' AND '"+sdf.format(calen2.getTime())+"-31'"+sql);

			while (rs.next()) {
				ReserveDTO dto = new ReserveDTO();

				dto.rid = rs.getInt("rid");
				dto.sum = rs.getInt("sum");

				res.add(dto);
			}
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	
	public ArrayList<MovieListDTO> list(){
		ArrayList<MovieListDTO> res = new ArrayList<MovieListDTO>();
		
		try {
			
			sql = "select * from movielist ";
			
			ptmt = con.prepareStatement(sql);
			
			rs = ptmt.executeQuery();
			
			while(rs.next()) {
				
				MovieListDTO dto = new MovieListDTO();
				
				dto.setMid(rs.getInt("mid"));
				dto.setName(rs.getString("name"));
				dto.setYear(rs.getInt("year"));
				
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
