package test.spring.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FileDAO {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private Connection getConnection() throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@nullmaster.iptime.org:1521:orcl";
		return DriverManager.getConnection(url, "class11", "class11");
	}
	//가장 최근에 업로드한 파일의 num값을 가져옴
	public int getMaxNum() {
		int max = 0;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select max(num) from filesave");
				//filesave 테이블에서 num의 max값을 검색한다.
			rs = pstmt.executeQuery(); 
			if(rs.next()) {
				max = rs.getInt(1); //검색 내용 중 첫번째 줄
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			if(rs != null) {
				try {
					rs.close();
				}catch(SQLException e) {}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				}catch(SQLException e) {}
			}
			if(conn != null) {
				try {
					conn.close();
				}catch(SQLException e) {}
			}
		}
		return max; //최댓값 max를 return
	}
	
	
	//파일업로드
	public void fileInsert(FileDTO dto) {
		try {
			conn = getConnection();
			String sql = "insert into filesave values(filesave_seq.nextval,?,?,?,sysdate)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getOrgname());
			pstmt.setString(3, dto.getSysname());
			pstmt.executeQuery();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) {
				try {
					rs.close();
				}catch(SQLException e) {}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				}catch(SQLException e) {}
			}
			if(conn != null) {
				try {
					conn.close();
				}catch(SQLException e) {}
			}
		}
	}
	
	//파일불러오기
	public List<FileDTO> fileView() {
		List<FileDTO> list = null;
		try {
			conn = getConnection();
			String sql = "select * from filesave";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			list = new ArrayList<FileDTO>();
			while(rs.next()) {
				FileDTO dto = new FileDTO();
				dto.setNum(rs.getInt("num"));
				dto.setWriter(rs.getString("writer"));
				dto.setOrgname(rs.getString("orgname"));
				dto.setSysname(rs.getString("sysname"));
				dto.setReg(rs.getTimestamp("reg"));
				list.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) {
				try {
					rs.close();
				}catch(SQLException e) {}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				}catch(SQLException e) {}
			}
			if(conn != null) {
				try {
					conn.close();
				}catch(SQLException e) {}
			}
		}
		return list;
	}
	
	//파일삭제
	public String deleteFile(int num) {
		String sql = "";
		String sysname = "";
		try {
			conn = getConnection();
			sql = "select num, sysname from filesave where num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();					
			
			if(rs.next()) {
				sysname = rs.getString("sysname");				
				sql = "delete from filesave where num=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, num);
				pstmt.executeUpdate();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) {
				try {
					rs.close();
				}catch(SQLException e) {}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				}catch(SQLException e) {}
			}
			if(conn != null) {
				try {
					conn.close();
				}catch(SQLException e) {}
			}
		}
		return sysname;
	}	
}
