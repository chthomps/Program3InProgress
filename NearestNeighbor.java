
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class NearestNeighbor {

	// Class Variables- arrays where double data will be stored post-conversion from
	// input strings

	// Main Method
	public static void main(String[] args)throws IOException {

		double[][] trainAttributeArray;
		double[][] testAttributeArray;
		String[] trainClassLabelArray;
		String[] testClassLabelArray;

		//User interface- determining which csv file is passed
			
		System.out.println("Enter the name of the training file: ");
		Scanner scan = new Scanner(System.in);
		String inTrainFile = scan.nextLine();   //inTrainFile object passed to makeAttributeArray method
		
		
		//Call makeAttributeArray method and makeClassArray method on specified training file
		trainAttributeArray = makeAttributeArray(inTrainFile);
		trainClassLabelArray = makeClassArray(inTrainFile);
		
		
		
		System.out.println("Enter the name of the testing file: ");
			
		
		String inTestFile = scan.nextLine();   //inTestFile object passed to makeAttributeArray method
		scan.close();
		
		//Call makeAttributeArray method on specified import file
		testAttributeArray = makeAttributeArray(inTestFile);
		testClassLabelArray = makeClassArray(inTestFile);
		
		
		for (int index = 0; index >=testClassLabelArray.length-1; index++)
		System.out.println(testClassLabelArray[index]);
		
	}
	
	// 2D Array Loading Method (employed for both train & test).... static so that dot method can be employed in main
	public static double[][] makeAttributeArray(String inAttributes) {  // Data passed in from u.i. (as a string)
		
		File inFile = new File(inAttributes); // assigns inAttributes as "infile" for the purposes of parsing data below

		// Variables
		double[][] attributeArray = new double[75][4]; // sets output array
		String line = "";
		int row = 0;

		try {
			Scanner scan = new Scanner(new BufferedReader(new FileReader(inFile)));

			while (scan.hasNextLine()) { // reads csv file line-by-line

				line = scan.nextLine();
				String[] tempLine = line.split(","); // tempLine array, splitting each line of input file

				for (int col = 0; col < line.length() - 1; col++) { // process each line (element by element), parsing into attributeArray
					attributeArray[row][col] = Double.parseDouble(tempLine[col]);
				}
				row++; // iterate row

			}
			scan.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return attributeArray; // double array output.... how to then save as Train or Test??? 
								
	}
	
	
	
	// 1D Array Loading Method (employed for both train & test).... static so that dot method can be employed in main
	
	public static String [] makeClassArray(String inClass) {
	
	File inFile = new File(inClass); // assigns inClass as "infile" for the purposes of parsing data below

	// Variables
	String [] classArray = new String [75]; // sets output array
	String line = "";
	int row = 0;

	try {
		Scanner scan = new Scanner(new BufferedReader(new FileReader(inFile)));

		while (scan.hasNextLine()) { // reads single csv file line (should just be one line)

			line = scan.nextLine();
			String[] tempLine = scan.nextLine().split(","); // tempLine array, splitting each line of input file
															// try taking this out later... =1 line

			classArray[row]= tempLine[tempLine.length-1];
		}
		
		scan.close();
			
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}

		return classArray;

	}
// method for scanning in 1D array

// method for calculating distances (apply algorithm)

// method for classifying

// method determining accuracy

}


