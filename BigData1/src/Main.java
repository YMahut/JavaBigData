import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class Main {

	public static void main(String[] args) {
		CSVFile ratingFile = new CSVFile("dataSet/u1.base");
	
		if(ratingFile.csvFile.exists()){
			System.out.println("rating csv file created");
		}else{
			System.out.println("rating csv file not created");
		}
		
				
		List testRead = ratingFile.readFile(ratingFile.csvFile);

		System.out.println("CSV File Size : " + testRead.size());
		
		List<String[]> dataParsed =  ratingFile.parseTab(testRead);
		
				
		int proportion1 = ratingFile.getProportion("5", dataParsed);
		System.out.println("Proportion de 5 étoile : " + proportion1);
		
		
	}
	
	
}
