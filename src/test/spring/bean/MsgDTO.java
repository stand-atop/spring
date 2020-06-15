package test.spring.bean;

import java.sql.Timestamp;

public class MsgDTO {
	private int num;
	private String sendid;
	private String toid;
	private String msg;
	private int state;
	private Timestamp reg;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public void setSendid(String sendid) {
		this.sendid = sendid;
	}
	public void setToid(String toid) {
		this.toid = toid;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public void setState(int state) {
		this.state = state;
	}
	
	public String getSendid() {
		return sendid;
	}
	public void setReg(Timestamp reg) {
		this.reg = reg;
	}
	public String getToid() {
		return toid;
	}
	public String getMsg() {
		return msg;
	}
	public int getState() {
		return state;
	}
	public Timestamp getReg() {
		return reg;
	}
}
