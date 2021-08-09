import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class ImportCSV {

	public static void main(String[] args)throws IOException {

	String path = "/Users/thompsonc/Desktop/iris-training-data.csv";
	try {
	//read csv into an array named "trainAttributes"....  write one method for 1D array and another for 2D array
		Scanner scan= new Scanner (new BufferedReader(new FileReader(path)));
	
	
	double [][] trainAttributes = new double [25][4];   //25x4 attribute data
		
	
	//read each line of csv, parsing from "line" String array into new 2D double array called trainAttributes
	while (scan.hasNextLine()) { // read text file line-by-line 
		String []line= scan.nextLine().split(",");    //insert commas between elements
		
		System.out.println (line);
		
	}
	scan.close();

	} finally {}
}
}
