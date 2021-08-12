
import java.io.*;
import java.util.Scanner;

public class NearestNeighbor {

	// Class Variables- arrays where double data will be stored post-conversion from
	// input strings

	// Main Method
	public static void main(String[] args) throws IOException {

		double[][] trainAttributeArray;
		double[][] testAttributeArray;
		String[] trainClassLabelArray;
		String[] testClassLabelArray;
		double[] distanceArray;

		// User interface- determining which csv file is passed

		Scanner scan = new Scanner(System.in);

		System.out.println("Enter the name of the training file: ");
		String inTrainFile = scan.nextLine(); // inTrainFile object passed to makeAttributeArray method
		inTrainFile = ("/Users/thompsonc/Desktop/" + inTrainFile); // update for GitHub path pre-submission

		// Call makeAttributeArray method and makeClassArray method on specified
		// training file
		trainAttributeArray = makeAttributeArray(inTrainFile);
		trainClassLabelArray = makeClassArray(inTrainFile);

		System.out.println("Enter the name of the testing file: ");
		String inTestFile = scan.nextLine(); // inTestFile object passed to makeAttributeArray method
		inTestFile = ("/Users/thompsonc/Desktop/" + inTestFile);
		scan.close();

		// Call makeAttributeArray method on specified import file
		testAttributeArray = makeAttributeArray(inTestFile);
		testClassLabelArray = makeClassArray(inTestFile);

		evalDistance(testAttributeArray, trainAttributeArray, testClassLabelArray, trainClassLabelArray);
	}

	// 2D Array Loading Method (employed for both train & test).... static so that
	// dot method can be employed in main
	public static double[][] makeAttributeArray(String inAttributes) { // Data passed in from u.i. (as a string)

		File inFile = new File(inAttributes); // assigns inAttributes as "infile" for the purposes of parsing data below

		// Variables
		double[][] attributeArray = new double[75][4]; // sets output array
		String line = "";
		int row = 0;

		try {
			Scanner scanFile = new Scanner(inFile);

			while (scanFile.hasNextLine()) { // reads csv file line-by-line

				line = scanFile.nextLine();
				String[] tempLine = line.split(","); // tempLine array, splitting each line of input file

				for (int col = 0; col < tempLine.length - 1; col++) { // process each line (element by element), parsing
																		// into attributeArray
					attributeArray[row][col] = Double.parseDouble(tempLine[col]);
				}
				row++; // iterate row

			}
			scanFile.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return attributeArray; // double array output.... how to then save as Train or Test???

	}

	// 1D Array Loading Method (employed for both train & test).... static so that
	// dot method can be employed in main

	public static String[] makeClassArray(String inClass) {

		File inFile = new File(inClass); // assigns inClass as "infile" for the purposes of parsing data below

		// Variables
		String[] classArray = new String[75]; // sets output array
		String line = "";
		int row = 0;

		try {
			Scanner scanFile = new Scanner(inFile);

			while (scanFile.hasNextLine()) { // reads single csv file line (should just be one line)

				line = scanFile.nextLine();
				String[] tempLine = line.split(","); // tempLine array, splitting each line of input file

				classArray[row] = tempLine[tempLine.length - 1];
				row++;
			}

			scanFile.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return classArray;

	}

	// Calculating Distances Method (apply NNN algorithm)
	public static double distanceCalc(double[] testA, double[] trainA) {

		double dist = 0;

		dist = Math.sqrt(Math.pow(testA[0] - trainA[0], 2) + Math.pow(testA[1] - trainA[1], 2)
				+ Math.pow(testA[2] - testA[2], 2) + Math.pow(testA[3] - testA[3], 2));

		return dist;
	}

	// Looping Method for calculating distance- looping through training file to find NNN (closest dist)
	public static void evalDistance(double[][] testAttributeArray, double[][] trainAttributeArray,
			String[] testClassLabelArray, String[] trainClassLabelArray) {

		String[] predictClass = new String[75];
		int count = 0;

		// taking one testing row (species) at a time- pitting against the entirety of
		// the training file, one row at a time
		for (int row = 0; row < 75; row++) {
			double currentMinDist = 0;
			int currentMinTrainRow = 0;

			// iterate through each row of training file and call distanceCalc method
			for (int trainRow = 0; trainRow < 75; trainRow++) {
				double currentDist = distanceCalc(testAttributeArray[row], trainAttributeArray[row]);
				if (currentDist < currentMinDist || currentMinDist == 0) {
					currentMinDist = currentDist;
					currentMinTrainRow = trainRow;
				}
			}

			// print test class name (true label) across from training class (predicted label)
			predictClass[row]= trainClassLabelArray[currentMinTrainRow];
			System.out.println((row+1)+ ":" + " " + testClassLabelArray[row] + " " + predictClass[row]);

			// number of matches- calls class compare method on test vs train
			if(classCompare(row, currentMinTrainRow, testClassLabelArray, trainClassLabelArray)) {
					count +=1;
				}
			}
			// % match
			System.out.println("ACCURACY: "+count/75);
		}


	// Class Compare method- compare class labels from testing file to class names in training file, seeking a match
	public static boolean classCompare(int testRow, int trainRow, String[] testClass, String[] trainClass) {
			
			if (testClass[testRow].equals(trainClass[trainRow])) {
				return true;
			} else {
				return false;
			}
				
		}

	

	
}


