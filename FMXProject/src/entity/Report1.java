package entity;

public class Report1 {
	private long id;
	private String username;
	private String sname;
	private String title;
	private String guidetea;
	private String progress;
	private String gain;
	private String result;
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
	public String getProgress() {
		return progress;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGuidetea() {
		return guidetea;
	}
	public void setGuidetea(String guidetea) {
		this.guidetea = guidetea;
	}
	public void setProgress(String progress) {
		this.progress = progress;
	}
	public String getGain() {
		return gain;
	}
	public void setGain(String gain) {
		this.gain = gain;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
}
