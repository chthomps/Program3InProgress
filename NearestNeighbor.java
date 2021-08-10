
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class NearestNeighbor {

	// Class Variables- arrays where double data will be stored post-conversion from input strings
	static double[][] trainAttributeArray;
	static double[][] testAttributeArray;
	static double[] trainClassArray;
	static double[] testClassArray;

	
	//Main Method
	public static void main(String[] args)throws IOException {

	
	//User interface- determining which csv file is passed
		
	System.out.println("Enter the name of the training file: ");
	Scanner scantrain = new Scanner(System.in);
	String inTrainFile = scantrain.nextLine();   //inTrainFile object passed to makeAttributeArray method
	
	
	//Call method on user-specified, import file
	trainAttributeArray = makeAttributeArray(inTrainFile);
	
	
	
	System.out.println("Enter the name of the testing file: ");
		
	Scanner scantest = new Scanner(System.in);
	String inTestFile = scantest.nextLine();   //inTestFile object passed to makeAttributeArray method
	
	
	//Call method on specified, imported file
	testAttributeArray = makeAttributeArray(inTestFile);
		
	
	//TRY MAKING A CLASS SCAN VARIABLE.... SHOULDN'T HAVE TO DUPLICATE (scantrain, scantest)
	
	
	
	
	//2D Array Loading Method (employed for both train & test).... static so that dot method can be employed in main 
		
	public static double [][] makeAttributeArray(String inAttributes) { //Data passed in from u.i. (as a string) 
		//How to allow String file to be either Train or Test?????
		//Method construction is fouled here....why is the program not recognizing this as a method w/a return?

		String attribueFile;
		File inFile = new File(inAttributes);  // assigns inAttributes as "infile" for the purposes of parsing data below
		
			//Variables
			double [][] attributeArray = new double [75][4];  //sets output array
			String line = "";
			int row = 0;
				
	try {
	
		Scanner scan= new Scanner (new BufferedReader(new FileReader(inFile)));   
		
		while (scan.hasNextLine()) { //reads csv file line-by-line 
		
			line = scan.nextLine();
			String [] tempLine= scan.nextLine().split(",");   //tempLine array, splitting each line of input file 
			
			for (int col=0; col< line.length()-1; col++) {  //process each line (element by element), parsing into attributeArray 
				attributeArray [row][col] = Double.parseDouble(tempLine[col]);
				}
			row++; //iterate row
		
		
		}
		scan.close();

	}catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	
	return attributeArray;  //double array output.... how to then save as Train or Test???  Thought this could be done in main
	}
		
	

	
	
	//method for scanning in 1D array
	
	
	//method for calculating distances (apply algorithm)
	
	
	//method for classifying
	

	//method determining accuracy

	}
}
