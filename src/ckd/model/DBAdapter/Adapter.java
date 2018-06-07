package ckd.model.DBAdapter;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ckd.model.MedicalRecord;
import ckd.model.MedicalRecordSelected;
import ckd.model.PersonalInfo;

public class Adapter {
	private static Connection con;
	public Adapter(){
		con = DBConnection.getConnection();
		
	}
	
	public ArrayList<MedicalRecordSelected> getMedicalRecord(int id) throws SQLException{
		ArrayList<MedicalRecordSelected> rs_med = new ArrayList<>();
		String sql = "SELECT * from medical_record WHERE id= " + id + " ";
		ResultSet rs = con.createStatement().executeQuery(sql);
		while (rs.next()) {
			rs_med.add(new MedicalRecordSelected(rs.getInt("id"), rs.getString("sg"), rs.getString("sc"),
					rs.getString("hemo"), rs.getString("dm"), rs.getString("pe"), rs.getString("is_ckd")));
		}
		
		return rs_med;
	}
	
	public ArrayList<MedicalRecord> getMedicalRecord(String id) throws SQLException{
		ArrayList<MedicalRecord> rs_med = new ArrayList<>();
		String sql = "SELECT * from medical_record WHERE id= " + id + " ";
		ResultSet rs = con.createStatement().executeQuery(sql);
		while (rs.next()) {
			rs_med.add(new MedicalRecord(rs.getInt("id"), rs.getString("sg"), rs.getString("sc"),
					rs.getString("hemo"), rs.getString("dm"), rs.getString("pe")));
		}
		
		return rs_med;
	}
	
	public ArrayList<PersonalInfo> getPatientInfo() throws SQLException{
		ArrayList<PersonalInfo> patient_list = new ArrayList<>();
		String sql = "SELECT DISTINCT * from personal_info INNER JOIN medical_record ON personal_info.id=medical_record.id";
		ResultSet rs = con.createStatement().executeQuery(sql);
		while (rs.next()) {
			patient_list.add(new PersonalInfo(rs.getInt("id"), rs.getString("full_name"), rs.getString("gender"),
					rs.getString("age"), rs.getString("is_ckd")));
		}
		
		return patient_list;
	}
	
}
