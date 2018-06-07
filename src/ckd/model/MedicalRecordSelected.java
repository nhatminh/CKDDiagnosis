package ckd.model;

public class MedicalRecordSelected {
	int id;
	String sg, sc, hemo, dm, pe, diagRec, physRec;

	public MedicalRecordSelected(int id, String sg, String sc, String hemo, String dm, String pe, String diagRec, String physRec) {
		super();
		this.id = id;
		this.sg = sg;
		this.sc = sc;
		this.hemo = hemo;
		this.dm = dm;
		this.pe = pe;
		this.diagRec = diagRec;
		this.physRec = physRec;
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
