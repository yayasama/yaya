package entity;

public class Teacher {
	private long id;
	private String username;
	private String tname;
	private int tage;
	private String pwd;
	private String tgender;
	private String tschool;
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
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public int getTage() {
		return tage;
	}
	public void setTage(int tage) {
		this.tage = tage;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getTgender() {
		return tgender;
	}
	public void setTgender(String tgender) {
		this.tgender = tgender;
	}
	public String getTschool() {
		return tschool;
	}
	public void setTschool(String tschool) {
		this.tschool = tschool;
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
