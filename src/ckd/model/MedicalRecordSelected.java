package ckd.model;

public class MedicalRecordSelected {
	int id;
	String sg, sc, hemo, dm, pe, is_ckd;

	public MedicalRecordSelected(int id, String sg, String sc, String hemo, String dm, String pe, String is_ckd) {
		super();
		this.id = id;
		this.sg = sg;
		this.sc = sc;
		this.hemo = hemo;
		this.dm = dm;
		this.pe = pe;
		this.is_ckd = is_ckd;
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

	public String getIs_ckd() {
		return is_ckd;
	}

	public void setIs_ckd(String is_ckd) {
		this.is_ckd = is_ckd;
	}

}
