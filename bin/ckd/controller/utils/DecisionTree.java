import weka.core.Instances;
import weka.classifiers.Classifier;
import weka.core.converters.ConverterUtils.DataSource;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;

public class DecisionTree 
{
	public static void main(String[] args) throws Exception
    {
		String rootPath = new File("").getAbsolutePath();
		
        // Load model
        Classifier cls = (Classifier) weka.core.SerializationHelper.read(rootPath+"\\DecisionTree_Model_5att.model");
		
        // Add test instance to repository, i.e. test.arff file
        BufferedReader reader = new BufferedReader(new FileReader(rootPath+"\\newRecord.txt"));
        String toWrite = "";
        String line = null;
        while ((line = reader.readLine()) != null) {
        	toWrite += line;
        }
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
        
        // Print results
        System.out.println("Diagnosis Result " + ": " + diagnosis);
    }
}
							
							
