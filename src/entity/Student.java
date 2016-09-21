package entity;

public class Student {
	private long id;
	private String username;
	private String sname;
	private int sage;
	private String sclass;
	private String pwd;
	private String sgender;
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
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getSage() {
		return sage;
	}
	public void setSage(int sage) {
		this.sage = sage;
	}
	public String getSclass() {
		return sclass;
	}
	public void setSclass(String sclass) {
		this.sclass = sclass;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getSgender() {
		return sgender;
	}
	public void setSgender(String sgender) {
		this.sgender = sgender;
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
