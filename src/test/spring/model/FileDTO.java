package test.spring.model;

import java.sql.Timestamp;

public class FileDTO {
	private int num;
	private String writer;
	private String orgname;
	private String sysname;
	private Timestamp reg;
	
	
	public void setNum(int num) {
		this.num = num;
	}
	
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}
	
	public void setSysname(String sysname) {
		this.sysname = sysname;
	}
	
	public void setReg(Timestamp reg) {
		this.reg = reg;
	}
	
	public int getNum() {
		return num;
	}

	public String getWriter() {
		return writer;
	}

	public String getOrgname() {
		return orgname;
	}

	public String getSysname() {
		return sysname;
	}

	public Timestamp getReg() {
		return reg;
	}	
	
}
