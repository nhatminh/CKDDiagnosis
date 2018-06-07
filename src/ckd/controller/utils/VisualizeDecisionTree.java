package ckd.controller.utils;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.swing.JFrame;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import ckd.model.MedicalRecord;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import weka.classifiers.Classifier;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class VisualizeDecisionTree {
	
	private static String rootPath = new File("").getAbsolutePath()+ "\\DTRule";
	
//	public VisualizeDecisionTree(String imgName) {
//		String imagePath = rootPath + imgName;
//		JFrame frame = new JFrame();
//		ImageIcon icon = new ImageIcon(imagePath);
//		JLabel label = new JLabel(icon);
//		
//		frame.add(label);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.pack();
//		frame.setVisible(true);
//	}
	
	public static void main(String[] args) throws Exception {
		testDecisionTree();
        
	}
	
	public static Image testDecisionTree() throws Exception{
		// Read attributes
		BufferedReader reader = new BufferedReader(new FileReader(rootPath+"\\newRecord.txt"));
        String toWrite = ""; // 1.025,0.6,15.9,no,no,? <=> sg, sc, hemo, dm, pe, class
        String line = null;
        while ((line = reader.readLine()) != null) {
        	toWrite += line;	
        }
        
        // Split attributes individually
        String[] attArray = toWrite.split(",");
        double sg = Double.parseDouble(attArray[0]);
        double sc = Double.parseDouble(attArray[1]);
        double hemo = Double.parseDouble(attArray[2]);
        String dm = attArray[3];
        System.out.println(detectCKD(toWrite));
        return DTRunner(sc,hemo, dm, sg);
	}
	
	public static boolean testDecisionTree1() throws Exception{
		// Read attributes
		BufferedReader reader = new BufferedReader(new FileReader(rootPath+"\\newRecord.txt"));
        String toWrite = ""; // 1.025,0.6,15.9,no,no,? <=> sg, sc, hemo, dm, pe, class
        String line = null;
        while ((line = reader.readLine()) != null) {
        	toWrite += line;	
        }
        
        return detectCKD(toWrite);
	}
	
	public static Image DTRunner(MedicalRecord med) throws NumberFormatException, IOException {
		return DTRunner(Double.parseDouble(med.getSc()), Double.parseDouble(med.getHemo()), med.getDm(), Double.parseDouble(med.getSg()));
	}
	
	public static Image DTRunner(double sc, double hemo, String dm,  double sg) throws IOException{
		// Display branch of decision tree in each specific case
        String imgName = null;
        if (sc > 1.2) {
        	imgName = "\\DT_sc_ckd.png";
        } else {
        	if (hemo <= 12.9) {
        		imgName = "\\DT_sc_hemo_ckd.png";
        	} else {
        		if (dm == "yes") {
        			imgName = "\\DT_sc_hemo_dm_ckd.png";
        		} else {
        			if (sg == 1.005) {
        				imgName = "\\DT_sc_hemo_dm_sg_1005_notckd.png";
        			}
        			else if (sg == 1.010) {
        				imgName = "\\DT_sc_hemo_dm_sg_1010_notckd.png";
        			}
        			else if (sg == 1.015) {
        				imgName = "\\DT_sc_hemo_dm_sg_1015_notckd.png";
        			}
        			else if (sg == 1.020) {
        				imgName = "\\DT_sc_hemo_dm_sg_1020_notckd.png";
        			}
        			else if (sg == 1.025) {
        				imgName = "\\DT_sc_hemo_dm_sg_1025_notckd.png";
        			}
        		}
        	}
        }
//        new VisualizeDecisionTree(imgName);
        BufferedImage bimg = ImageIO.read(new File(rootPath+imgName));
        return SwingFXUtils.toFXImage(bimg, null);
	}
	
    public static boolean detectCKD(String toWrite) throws Exception {
    	// Load model
        Classifier cls = (Classifier) weka.core.SerializationHelper.read(rootPath+"\\DecisionTree_Model_5att.model");

    	FileWriter fw = new FileWriter(rootPath+"\\test_5att.arff", true);
        fw.write("\n");
        fw.write(toWrite);
        fw.close();
        
        // Load test repository
        DataSource source = new DataSource(rootPath+"\\test_5att.arff");
        Instances patientRecord = source.getDataSet();
        patientRecord.setClassIndex(patientRecord.numAttributes() - 1);
        
        // Perform prediction
        double prediction = cls.classifyInstance(patientRecord.instance(patientRecord.numInstances()-1));

        // Retrieve label of test instance
        String diagnosis = patientRecord.classAttribute().value((int) prediction); 
        if (diagnosis.equals("ckd")) {
        	return true;
        } else {
        	return false;
        }
        // Print results
        // System.out.println("Diagnosis Result " + ": " + diagnosis);
        
    }
}
