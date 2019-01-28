import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Functions {

	Scanner scanner = new Scanner(System.in);
	
	//FUNCTION TO VALIDATE INPUT DATA
	public int[] dataValidateReferencepattern(){
		boolean loopIsDone = false;
		String [] tempArray;
		int [] referenceArray;
		
		do {
			boolean done = false;
			
			//This will loop until we get an input that matches our standards
			do {	
				System.out.println("Please enter your reference pattern: ");
				String referencePattern = scanner.next();
				
				System.out.println(referencePattern);
				tempArray = referencePattern.split(";");
				
				referenceArray = new int[tempArray.length];
				//Try to convert the string input to an int array
				try {
					for(int i = 0; i < tempArray.length ; i++) {
						referenceArray[i] = Integer.parseInt(tempArray[i]);
					}
					done = true;
						
				}catch(NumberFormatException e) {
					System.out.println("Please enter numbers as your values." + "\n");
					
				}
			}while(!done);
			
			//We start by checking that the amount of pixels is between 1 and 400
			outerloop:
			if(referenceArray.length < 2 || referenceArray.length > 1001) {
				System.out.println("Please enter a reference pattern between 1 and 400 pixels " + "\n");
			}
			//Then we check if the row amount is also between 1 and 400
			else if(referenceArray[0] < 1 || referenceArray[0] > 1000){
				System.out.println("Please enter a row number between 1 and 400 rows." + "\n");
			}
			//else we check if all the pixel values are '1' and '0'
			else{
				int i = 1;
				while(i < referenceArray.length) {
					//if the pixel is not a 1 or a zero we break from the outerloop
					if(referenceArray[i] >1 || referenceArray[i] < 0) {
						System.out.print("Please enter the pixel values as '0' or '1' " + "\n");
						break outerloop;
					}
					i++;
				}
				loopIsDone = true;
			}
				
			
		}while(!loopIsDone);
		
		//Returns an Int array with the first position being the row count and the rest being pixel values
		return referenceArray;
	}
	
	//calculates the matrix with the reference values
	public int[][] matrixGenerator(int[] referenceArray){
		//Extract the rows
		int rows = referenceArray[0];
		//make new array with only the reference row
		int[] refrenceRowArray = Arrays.copyOfRange(referenceArray, 1, referenceArray.length);
		//Create new array with the row and length of the reference
		int[][] matrixArray = new int[rows][refrenceRowArray.length];

		//Calculate the first rows pixel values
		for (int i = 0; i < refrenceRowArray.length; i++) {
			matrixArray[0][i] = calculatePixel(refrenceRowArray , i);
			System.out.print(matrixArray[0][i] + " ");
		}
		
		System.out.println("");
		
		//Calculate the rest pixel values
		for (int i = 1; i < matrixArray.length; i++) {
			for (int j = 0; j < matrixArray[i].length; j++) {
				matrixArray[i][j] = calculatePixel(matrixArray[i-1] , j);
				System.out.print(matrixArray[i][j] + " ");
			}
			System.out.println("");
		}
		
		return matrixArray;
	}
	
	//Calculates the current pixel value
	public int calculatePixel(int[] array, int position) {
		int pixelValue = -1;
		int compare = array[position];
		double procent = 0;
		int totalNeighbours = 4;
		//Convert the array to an arraylist
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		for (int i : array)
		{
			arrayList.add(i);
		}
		
		//If there is a neighbour to the left, we compare. If there isn't, we remove one neighbour from the count
		try {
			if(arrayList.get(position-1) == compare) {
				procent++;
			}
		}catch(IndexOutOfBoundsException e) {totalNeighbours--;}
		//If there is a neighbour 2 spaces to the left, we compare. If there isn't, we remove one neighbour from the count
		try {			
			if(arrayList.get(position-2) == compare) {
				procent++;
			}
		}catch(IndexOutOfBoundsException e) {totalNeighbours--;}
		//If there is a neighbour to the right, we compare. If there isn't, we remove one neighbour from the count
		try {
			if(arrayList.get(position+1) == compare) {
				procent++;
			}
		}catch(IndexOutOfBoundsException e) {totalNeighbours--;}
		//If there is a neighbour 2 spaces to the right, we compare. If there isn't, we remove one neighbour from the count
		try {
			if(arrayList.get(position+2) == compare) {
				procent++;
			}
		}catch(IndexOutOfBoundsException e) {totalNeighbours--;}
		
		//calculate the percentage of neighbours
		procent = procent/totalNeighbours;

		//if percentage is 50% or more we change value of pixel
		if(procent >= 0.5) {
			if(compare == 1) {
				pixelValue = 0;
			}else {
				pixelValue = 1;
			}
		}else {
			pixelValue = compare;
		}
		
		return pixelValue;
		
	}
	
	//This method converts all the ones to 255 so that when it is in rgb form we get white
	public int[][] rbgMatrixConverter(int[][] matrix){
		int[][] rgbMatrix = matrix;
		
		for (int i = 1; i < rgbMatrix.length; i++) {
			for (int j = 0; j < rgbMatrix[i].length; j++) {
				if(rgbMatrix[i][j] == 1) rgbMatrix[i][j] = 255;
			}
		}
		
		return rgbMatrix;
	}
	
	
}
