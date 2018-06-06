package ckd.view.physician;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import ckd.Main;
import ckd.controller.utils.VisualizeDecisionTree;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.IndexedCell;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import weka.gui.beans.TextViewer;

public class PhysicianController implements Initializable{
	public class Patient{
		private final SimpleStringProperty id;
	    private final SimpleStringProperty name;
	    private final SimpleStringProperty pclass;
	 
	    private Patient(String id, String name, String pclass) {
	        this.id = new SimpleStringProperty(id);
	        this.name = new SimpleStringProperty(name);
	        this.pclass = new SimpleStringProperty(pclass);
	    }
	 
	    public String getId() {
	        return id.get();
	    }
	    public void setId(String id) {
	    	this.id.set(id);
	    }
	        
	    public String getName() {
	        return name.get();
	    }
	    public void setName(String name) {
	    	this.name.set(name);
	    }
	    
	    public String getPclass() {
	        return pclass.get();
	    }
	    
	    public void setPclass(String pclass) {
	    	this.pclass.set(pclass);
	    }
	}
	
	private class RowSelectChangeListener implements ChangeListener<Number> {
		@Override
		public void changed(ObservableValue<? extends Number> ov, Number oldVal, Number newVal) {
			// TODO Auto-generated method stub
			int ix = newVal.intValue();

			if ((ix < 0) || (ix >= data.size())) {
	
				return; // invalid data
			}

			Patient p = data.get(ix);
			txtSelectedID.setText(p.getId());
		}
	}
	
	@FXML
	TableView tblPatientList;

	@FXML
	TableColumn<Patient,String> idCol;
	
	@FXML
    TableColumn<Patient,String> nameCol;
	
	@FXML
    TableColumn<Patient,String> classCol;
	
	@FXML
    TextField txtSelectedID;
	@FXML
    Button btnViewRec;
	@FXML
	Button btnViewMedicalRec;
	@FXML
	Button btnAgree;
	@FXML
	Button btnDisagree;
	@FXML
	Button btnPrint;
	@FXML
    Label lblCKDresult;
	
	@FXML
    ImageView imgDTRule;
	
	final ObservableList<Patient> data = FXCollections.observableArrayList(
		    new Patient("01", "Smith", "CKD"),
		    new Patient("02", "Johnson", "NotCKD"),
		    new Patient("03", "Williams", "Unkown"),
		    new Patient("04", "Jones", "CKD"),
		    new Patient("05", "Brown", "NotCKD")
		);
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		idCol = new TableColumn("ID");
		nameCol = new TableColumn("Name");
		classCol = new TableColumn("Class");
		
		setCellValueFactories();
			
//        TableColumn controlCol = new TableColumn("Control");
        tblPatientList.getColumns().addAll(idCol, nameCol, classCol);
        
        tblPatientList.getSelectionModel().selectedIndexProperty().addListener(new RowSelectChangeListener());
        
        tblPatientList.setItems(data);
//        tblPatientList.getSelectionModel().select(0);

	}
	
	private void setCellValueFactories() {
		idCol.setCellValueFactory(
        	    new PropertyValueFactory<Patient,String>("id")
        	);
        idCol.setMinWidth(120);
        nameCol.setCellValueFactory(
        	    new PropertyValueFactory<Patient,String>("name")
        	);
        nameCol.setMinWidth(120);
        classCol.setCellValueFactory(
        	    new PropertyValueFactory<Patient,String>("pclass")
        	);
        classCol.setMinWidth(120);
	}
	
	public void agree(ActionEvent actionEvent) {
		
	}
	
	public void disagree(ActionEvent actionEvent) {
		
	}
	
	public void print(ActionEvent actionEvent) {
		
	}
	
	public void viewRec(ActionEvent actionEvent) {
		try {
			
			boolean ckd_result = VisualizeDecisionTree.testDecisionTree1();
			System.out.println(ckd_result);
			if(ckd_result){
				lblCKDresult.setText("CKD");
			} else{
				lblCKDresult.setText("Not CKD");
			}
			
			Image img = VisualizeDecisionTree.testDecisionTree();
			imgDTRule.setImage(img);
			imgDTRule.setPreserveRatio(true);
			imgDTRule.setSmooth(true);
			imgDTRule.setCache(true);
			
			btnAgree.setDisable(false);
			btnDisagree.setDisable(false);
			btnPrint.setDisable(false);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void viewMedical(ActionEvent actionEvent) {
		
	}
    
}
