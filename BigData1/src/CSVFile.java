import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


public class CSVFile{

	File csvFile;	
	//------------------------------------------------------------------
	public CSVFile(String fileName){
		final String completeFileName = getResourcePath(fileName);
	    csvFile = new File(completeFileName);
	}

		
	public static String getResourcePath(String fileName) {
	       final File f = new File("");
	       final String dossierPath = f.getAbsolutePath() + File.separator + fileName;
	       return dossierPath;
	   }
	
	public File getCSVFile(){
		return csvFile;
	}
	
	public void setCSVFile(File newCSVFile){
		this.csvFile = newCSVFile;
	}
	

	//---------------------------------------------------------
	
	public static List<String> readFile(File file) {

        List<String> result = new ArrayList<String>();

        try{
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        for (String line = br.readLine(); line != null; line = br.readLine()) {
            result.add(line);
        }
  
        br.close();
        fr.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }
	
	//---------------------------------------------------------
	
	public List<String[]> parseTab( List<String> file){
		
		List<String[] > data;
		int i =0;
		
        data = new ArrayList<String[] > (file.size());
        String sep = ",";
        for (String line : file) {
            String[] oneData = line.split("\t");
            data.add(oneData);

            i++;
        }
		return (data);
	}
	
	//---------trouver les proportions d'étoiles de films------------------------
	
	public int getProportion(String nbEtoile, List<String[]> data){
		int res=0;
		int i = 1;
		
		for(String[] lines : data){
			for(String value : lines){	
				if(i%4 == 3){
					if (value.equals(nbEtoile)){
						res ++;
					}
				}
				i++;
			}
		}
		
		
		return res;
	}
	

}
