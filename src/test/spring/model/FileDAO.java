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
	//���� �ֱٿ� ���ε��� ������ num���� ������
	public int getMaxNum() {
		int max = 0;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select max(num) from filesave");
				//filesave ���̺��� num�� max���� �˻��Ѵ�.
			rs = pstmt.executeQuery(); 
			if(rs.next()) {
				max = rs.getInt(1); //�˻� ���� �� ù��° ��
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
		return max; //�ִ� max�� return
	}
	
	
	//���Ͼ��ε�
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
	
	//���Ϻҷ�����
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
	
	//���ϻ���
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
