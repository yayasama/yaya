package entity;

public class Peixun {
	private long id;
	private String username;
	private String name;
	private int age;
	private String gender;
	private String institution;
	private String category;
	private String time;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getInstitution() {
		return institution;
	}
	public void setInstitution(String institution) {
		this.institution = institution;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
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
