package ckd.model;

public class PersonalInfo {
	int id;
	String full_name, gender, age, diagRec, physRec;

	public PersonalInfo(int id, String full_name, String gender, String age, String diagRec, String physRec) {
		super();
		this.id = id;
		this.full_name = full_name;
		this.gender = gender;
		this.age = age;
		this.diagRec = diagRec;
		this.physRec = physRec;
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

	public String getPhysRec() {
		return physRec;
	}

	public void setPhysRec(String physRec) {
		this.physRec = physRec;
	}
	
	public String getDiagRec() {
		return diagRec;
	}

	public void setDiagRec(String diagRec) {
		this.diagRec = diagRec;
	}


}