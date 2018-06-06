package ckd.model;

public class PersonalInfo {
	int id;
	String full_name, gender, age, is_ckd;

	public PersonalInfo(int id, String full_name, String gender, String age, String is_ckd) {
		super();
		this.id = id;
		this.full_name = full_name;
		this.gender = gender;
		this.age = age;
		this.is_ckd = is_ckd;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getIs_ckd() {
		return is_ckd;
	}

	public void setIs_ckd(String is_ckd) {
		this.is_ckd = is_ckd;
	}

}