package mvc.model;

import java.sql.Timestamp;

public class TestDTO {
	
	private String id;
	private String pw;
	private String name;
	private int age;
	private Timestamp reg;
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setReg(Timestamp reg) {
		this.reg = reg;
	}
	
	
	
	public String getId() {
		return id;
	}

	public String getPw() {
		return pw;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public Timestamp getReg() {
		return reg;
	}
	
}
