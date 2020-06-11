package cn.com.dhc.bean;

public class User {
	private int id;
	private String name;
	private String pwd;
	private int sex;
	private String email;
	private int power;

	public User() {
		super();
	}

	public User(String name, String pwd, int sex, String email) {
		super();
		this.name = name;
		this.pwd = pwd;
		this.sex = sex;
		this.email = email;
	}

	public User(int id, String name, String pwd, int sex, String email, int power) {
		super();
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.sex = sex;
		this.email = email;
		this.power = power;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

}