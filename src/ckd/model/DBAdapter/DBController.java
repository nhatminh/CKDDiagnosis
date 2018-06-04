package ckd.model.DBAdapter;

import javafx.event.ActionEvent;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DBController {

	public void button(ActionEvent actionEvent) throws SQLException {
		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();

		// String sql = "INSERT INTO ckd (`age`) VALUES ('22')";
		// Statement statement = connection.createStatement();
		// statement.executeUpdate(sql);

		// Test insert data to database
		String sql = "INSERT INTO `ckd` (`age`, `blood_pressure`, `specific_gravity`, `albumin`, `sugar`, `red_blood_cells`, `pus_cell`, `pus_cell_clumps`, `bacteria`, `blood_glucose_random`, `blood_urea`, `serum_creatinine`, `sodium`, `potassium`, `hemoglobin`, `packed_cell_volume`, `white_cell_count`, `red_blood_cell_count`, `hypertension`, `diabetes_mellitus`, `coronary_artery_disease`, `appetite`, `pedal_edema`, `anemia`, `class`) VALUES\r\n"
				+ "('48', '80', '1.02', '1', '0', '?', 'normal', 'notpresent', 'notpresent', '121', '36', '1.2', '?', '?', '15.', '44', '7800', '5.', 'yes', 'yes', 'no', 'good', 'no', 'no', 'ckd')";
		Statement statement = connection.createStatement();
		statement.executeUpdate(sql);
		System.out.println("Complete!");

	}

}
