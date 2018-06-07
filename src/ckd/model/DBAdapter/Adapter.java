package ckd.model.DBAdapter;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import ckd.model.MedicalRecord;
import ckd.model.MedicalRecordSelected;
import ckd.model.PersonalInfo;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

public class Adapter {
	private static Connection con;

	public Adapter() {
		con = DBConnection.getConnection();

	}

	public ArrayList<MedicalRecordSelected> getMedicalRecord(int id) throws SQLException {
		ArrayList<MedicalRecordSelected> rs_med = new ArrayList<>();
		String sql = "SELECT * from medical_record WHERE id= " + id + " ";
		ResultSet rs = con.createStatement().executeQuery(sql);
		while (rs.next()) {
			rs_med.add(new MedicalRecordSelected(rs.getInt("id"), rs.getString("sg"), rs.getString("sc"),
					rs.getString("hemo"), rs.getString("dm"), rs.getString("pe"), rs.getString("diagnostic_recommendation"), rs.getString("physican_recommendation")));
		}

		return rs_med;
	}

	public ArrayList<MedicalRecord> getMedicalRecord(String id) throws SQLException {
		ArrayList<MedicalRecord> rs_med = new ArrayList<>();
		String sql = "SELECT * from medical_record WHERE id= " + id + " ";
		ResultSet rs = con.createStatement().executeQuery(sql);
		while (rs.next()) {
			rs_med.add(new MedicalRecord(rs.getInt("id"), rs.getString("sg"), rs.getString("sc"), rs.getString("hemo"),
					rs.getString("dm"), rs.getString("pe")));
		}

		return rs_med;
	}

	public ArrayList<PersonalInfo> getPatientInfo() throws SQLException {
		ArrayList<PersonalInfo> patient_list = new ArrayList<>();
		String sql = "SELECT DISTINCT * from personal_info INNER JOIN medical_record ON personal_info.id=medical_record.id";
		ResultSet rs = con.createStatement().executeQuery(sql);
		while (rs.next()) {
			patient_list.add(new PersonalInfo(rs.getInt("id"), rs.getString("full_name"), rs.getString("gender"),
					rs.getString("age"), rs.getString("diagnostic_recommendation"), rs.getString("physican_recommendation")));
		}

		return patient_list;
	}

	public void insertRecResult(MedicalRecord med, String CKD_rs1, String CKD_rs2) throws SQLException {
		String sql = "UPDATE medical_record SET diagnostic_recommendation='" + CKD_rs1 + "',physican_recommendation='"+ CKD_rs2+"' WHERE id = "+med.getId()+";";
		Statement statement = con.createStatement();
		statement.executeUpdate(sql);
		System.out.println("Insert CKD result: " + CKD_rs1 + "," + CKD_rs2);
	}
	
	public int insertPatient(String name, String address, String city, String phone, String email, Date dob, String age, 
			String gender, String marriage, String blood, String height, String note ) throws SQLException {
//		String sql = "INSERT INTO `personal_info` (`id`, `full_name`, `address`, `city`, `phone`, `email`, `dob`, `age`, `gender`, `marriage`, `blood_type`, `height`, `note`) VALUES\r\n"
//				+ "('11' ,'" +  name + "', '" + address + "', '" + city	+ "', '" + phone + "', '" + email + "', '" + dob+ "', '"
//				+ age + "', '" + gender + "', '" + marriage+ "', '"	+ blood + "', '" + height + "', '"	+ note+ "')";
		
		int patientID = 10;
		String sql = "UPDATE personal_info SET full_name='"+ name +"', address='"+ address +"', city='"+ city 
				+"', phone='"+ phone+"', email='"+ email+"', dob='"+ dob +"', age='"+ age +"', gender='"+ gender 
				+"', marriage='"+ marriage +"', blood_type='"+ blood +"', height='"+ height +"', note='"+note
				+"' WHERE id = "+patientID+";";
//		System.out.println(sql);
		Statement statement = con.createStatement();
		statement.executeUpdate(sql);
		System.out.println("Insert Patient!");
		
		return patientID;
	}

}
