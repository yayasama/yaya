package entity;

public class User {
	private long id;
	private String username;
	private String pwd;
	private String pwd1;
	private String pwd2;
	private String sname;
	private String tname;
	private int usergroup;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getPwd1() {
		return pwd1;
	}
	public void setPwd1(String pwd1) {
		this.pwd1 = pwd1;
	}
	public String getPwd2() {
		return pwd2;
	}
	public void setPwd2(String pwd2) {
		this.pwd2 = pwd2;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public int getUsergroup() {
		return usergroup;
	}
	public void setUsergroup(int usergroup) {
		this.usergroup = usergroup;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return username;
	}
}
