import java.util.Scanner;

public class Functions {

	Scanner scanner = new Scanner(System.in);
	
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
			if(referenceArray.length < 2 || referenceArray.length > 401) {
				System.out.println("Please enter a reference pattern between 1 and 400 pixels " + "\n");
			}
			//Then we check if the row amount is also between 1 and 400
			else if(referenceArray[0] < 1 || referenceArray[0] > 400){
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
	
	
}
