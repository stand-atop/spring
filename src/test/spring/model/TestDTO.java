package test.spring.model;

import java.sql.Timestamp;


public class TestDTO {
	private String id;
	private String pw;
	private String name;
	private int age;
	private Timestamp reg;
	/* private Date day; */
	
	/*
	 * public TestDTO() { //�⺻ ������ id="guest"; pw="0000"; }
	 * 
	 * public TestDTO(String id) { //�Ű������� �ϳ��� ������ this.id = id; pw = "0000"; }
	 * 
	 * public TestDTO(String id, String pw) { //�Ű������� �ΰ��� ������ this.id = id; this.pw
	 * = pw; }
	 * 
	 * public TestDTO(String id, String pw, Date day) { //date ������ this.id = "java";
	 * this.pw = "0000"; this.day = day; //����Ÿ�� }
	 */
		
	//�°�
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
	/*
	 * public void setDay(Date day) { this.day = day; }
	 */
	

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
	/*
	 * public Date getDay() { return day; }
	 */
}
