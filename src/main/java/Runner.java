import java.io.File;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Scanner;
import com.google.cloud.bigquery.BigQuery;

@SuppressWarnings("unused")
public class Runner
{

	public static void main(String[] args) throws IOException {

		Scanner in = new Scanner(System.in); 
		System.out.print("Enter Dataset Name ");
		String datasetName = in.nextLine(); 
        //System.out.println("Entered Dataset Name "+datasetName); 
		System.out.print("Enter Table Name ");
		String tableName = in.nextLine(); 
        //System.out.println("Entered Table Name "+tableName); 
		System.out.print("Enter Location \n");
		String location = in.nextLine(); 
        //System.out.println("Entered Table Name "+location); 
		
		//String datasetName = "test_orc"; 
		//String tableName = "orc_test_data";
		//String location = "US";
		 File orcfile = new File("D:\\Downloads\\GCP\\orc_files\\userdata1_orc");
	     String jsonPath = "D:\\Study\\TestProject-3229472ea4e9.json";
		 
	try {
		long outputRows = 0;
	   //to connect to bigquery to set service account key
		BigQuery bqObject=FunctionsBigquery.setServiceKey(jsonPath);
		 System.out.println("Authenticated Successfully.. \n");
		 System.out.println("Creating table....\n");
		outputRows = FunctionsBigquery.orcload(datasetName,location,tableName,orcfile,bqObject);
		System.out.println("\nTable created Successfully");
		System.out.println("Number of records written are : "+ outputRows);
		System.out.println("*************************************************************");
		System.out.println("\nSelecting records from table...\n");
		FunctionsBigquery.runQuery(datasetName, tableName,bqObject);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}

}
}
