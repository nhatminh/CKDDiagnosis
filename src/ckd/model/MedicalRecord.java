package ckd.model;

public class MedicalRecord {
	int id;
	String sg, sc, hemo, dm, pe;

	public MedicalRecord(int id, String sg, String sc, String hemo, String dm, String pe) {
		super();
		this.id = id;
		this.sg = sg;
		this.sc = sc;
		this.hemo = hemo;
		this.dm = dm;
		this.pe = pe;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSg() {
		return sg;
	}

	public void setSg(String sg) {
		this.sg = sg;
	}

	public String getSc() {
		return sc;
	}

	public void setSc(String sc) {
		this.sc = sc;
	}

	public String getHemo() {
		return hemo;
	}

	public void setHemo(String hemo) {
		this.hemo = hemo;
	}

	public String getDm() {
		return dm;
	}

	public void setDm(String dm) {
		this.dm = dm;
	}

	public String getPe() {
		return pe;
	}

	public void setPe(String pe) {
		this.pe = pe;
	}

}
