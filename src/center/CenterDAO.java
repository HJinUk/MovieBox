package center;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import center.CenterDTO;

public class CenterDAO {

	Connection con;
	PreparedStatement ptmt;
	ResultSet rs;
	String sql;	
	
	public CenterDAO() {		//moviebox DAO

		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource)init.lookup("java:/comp/env/mmm");
			con = ds.getConnection();
				} catch (Exception e) {
					e.printStackTrace();
				}		
			}
	
			public int total(){		//페이지
				int res =0;
				
				try {
					sql = "select count(*) from center";
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
			
			
			public void addCount(int id){	
				try {
					
					sql = "update center set cnt = cnt +1 where id = ?";
					
					ptmt = con.prepareStatement(sql);
					
					ptmt.setInt(1, id);
					
					ptmt.executeUpdate();
					
				} catch (Exception e) {
					e.printStackTrace();
				}finally {
					close();
				}
			}


			public ArrayList<CenterDTO> list(int start, int limit){ //notice
				ArrayList<CenterDTO> res = new ArrayList<CenterDTO>();
				
				try {
					sql = "select * from center "
							+ " order by mcode desc, seq "
							+ " limit ? , ?";
				
					ptmt = con.prepareStatement(sql);
					
					ptmt.setInt(1, start);
					ptmt.setInt(2, limit);
					
					rs = ptmt.executeQuery();
					
					while(rs.next()) {
						CenterDTO dto = new CenterDTO();
						dto.setCate(rs.getString("cate"));//카테고리
						dto.setTitle(rs.getString("title"));//제목	
						dto.setName(rs.getString("pname"));//(이름?)작성자
						dto.setSeq(rs.getInt("seq"));
						dto.setLev(rs.getInt("lev"));										
						dto.setRegdate(rs.getTimestamp("regdate"));//날짜
						dto.setCnt(rs.getInt("cnt")); //조회수
						
						
						res.add(dto);
					}
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}finally {
					close();
				}
				
				
				return res;
			}
			
			public CenterDTO detail(String id) {	//자세히 보기
				CenterDTO dto = null;

				sql = "select * from center where id = ?";
				try {
			
					ptmt = con.prepareStatement(sql);
					ptmt.setString(1, id);
					rs = ptmt.executeQuery();

					if (rs.next()) {
						dto = new CenterDTO();
						
						dto.setTitle(rs.getString("title"));
						dto.setCate(rs.getString("cate"));
						dto.setRegdate(rs.getDate("regdate"));
						dto.setContent(rs.getString("content"));
						dto.setCnt(rs.getInt("cnt"));
						dto.setFile(rs.getString("file"));
					}

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					close();
				}
				return dto;
			}
			
			
			public int insert(CenterDTO dto) { //글쓰기

				int res = -1;
				sql = "insert into center (" + "pname, title, cate, content, regdate,  file) " + "values " + "(?,?,?,?,?,?)";

				try {
					System.out.println(sql);

				
//					ptmt = con.prepareStatement(sql);
//
//					ptmt.setString(1, dto.getPname());
//					ptmt.setString(2, dto.getTitle());
//					ptmt.setString(3, dto.getCate());
//					ptmt.setString(4, dto.getContent());
//					ptmt.setTimestamp(5, new java.sql.Timestamp(System.currentTimeMillis()));
//					ptmt.setString(6, dto.getFile());
				
					rs = ptmt.executeQuery();
					sql = "select max(id) from center";

					System.out.println(sql);
					
					rs = ptmt.executeQuery(sql);
					rs.next();
					res = rs.getInt(1);

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					close();
				}

				return res;
			}
			
//			public int delete(CenterDTO dto){ 		//삭제
//				 
//				int res =0;
//				try {
//					
//					sql = "delete from center where id = ? and pw = ?";
//					ptmt = con.prepareStatement(sql);
//
//					ptmt.setInt(1, dto.ㅡㅊ);
//					ptmt.setString(2, dto.pw);
//					
//					res = ptmt.executeUpdate();
//					
//				} catch (Exception e) {
//					e.printStackTrace();
//				}finally {
//					close();
//				}
//				
//				return res;
//			}
			
			
	
	
	
	
	
	
	
	void close() {	
		if(rs!=null)try {rs.close();} catch (SQLException e) {}
		if(ptmt!=null)try {ptmt.close();} catch (SQLException e) {}
		if(con!=null)try {con.close();} catch (SQLException e) {}
	}
	
	
	
}
