import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class PatternGenerator {

	public static void main (String[] args ) {

		Scanner scanner = new Scanner(System.in);
		Functions functions = new Functions();

		//Function for the input data validation
		int [] referenceArray = functions.dataValidateReferencepattern();
		
		System.out.println("");

		//Shows the user the pattern in the console log
		int[][] matrixArray = functions.matrixGenerator(referenceArray);
		
		//Converts the matrix to rgb form
		int[][] rgbMatrixArray = functions.rbgMatrixConverter(matrixArray);
	
		//Creates a BufferedImage so that it can be rendered/written to a file
		int height = rgbMatrixArray.length;
		int width = rgbMatrixArray[0].length;
		BufferedImage image = new BufferedImage(width,height, BufferedImage.TYPE_BYTE_GRAY);
		    
		for(int i=0; i<rgbMatrixArray.length; i++) {
		    for(int j=0; j<rgbMatrixArray[i].length; j++) {
		        int a = rgbMatrixArray[i][j];
		        Color newColor = new Color(a,a,a);
		        image.setRGB(j,i,newColor.getRGB());
		    }
		}
		
		//Let the user decide the file name
		System.out.println("What do you want to name the file?");
		String fileName = scanner.next();
		File output = new File(fileName + ".png");
		
		//File is written
		try {
			ImageIO.write(image, "png", output);
		} catch (IOException e) {
			//e.printStackTrace();
		}
	
		scanner.close();
		System.out.println("Done");
		
	}
	
}
