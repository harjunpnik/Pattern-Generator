

public class PatternGenerator {

	public static void main (String[] args ) {

		Functions functions = new Functions();

		//Function for the input data validation
		int [] referenceArray = functions.dataValidateReferencepattern();
		
		System.out.println("");
		
		int[][]matrixArray = functions.matrixGenerator(referenceArray);
		
		System.out.println("Done");
		
		
	}
	
}
