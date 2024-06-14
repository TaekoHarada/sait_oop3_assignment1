package assignment1;

import java.util.*;
import java.nio.file.*;
import java.io.IOException;
import java.time.LocalTime;
import java.time.Duration;

import shapes.*;
//import assignment1.Utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
* TestDriver class is a test driver.
*/
public class TestDriver {

	/**
	 * The main method for the application. It reads input arguments for file name,
	 * sort type, and sort algorithm, processes a file containing 3D shapes, sorts
	 * the shapes based on sort type and sort algorithm, and outputs the sorted result to
	 * a log files in 'output' folder.
	 *
	 * <p>Expected command-line arguments:</p>
	 * <ul>
	 *   <li><code>-f&lt;fileName&gt;</code>: specifies the file name of the input data.</li>
	 *   <li><code>-t&lt;sortType&gt;</code>: specifies the type of sorting (e.g., by volume, height).</li>
	 *   <li><code>-s&lt;sortAlgorithm&gt;</code>: specifies the sorting algorithm to use.</li>
	 * </ul>
	 *
	 * <p>The input file should contain data in the following format:</p>
	 * <pre>
	 *     numberOfShapes shapeType1 height1 baseArea1 shapeType2 height2 baseArea2 ...
	 * </pre>
	 *
	 * <p>The output file will be named based on the input file name, sort type, and sort algorithm.
	 * (e.g. 'polyfor1aq.txt' input file name: polyfor1, sort type: a, sort algorithm: q)</p>
	 *
	 * @param args the command line arguments for specifying the input file, sort type, and sort algorithm.
	 */
	public static void main(String[] args) {
		

		// java -jar sort.jar -ftestData/polyfor1.txt -tv -sb
		String fileName = null;
        String sortType = null;
        String sortAlgorithm = null;
        
        for (String arg : args) {
        	if(arg.substring(0, 2).equals("-f") || arg.substring(0, 2).equals("-F")) {
        		fileName = arg.substring(2);
        	}else if(arg.substring(0, 2).equals("-t") || arg.substring(0, 2).equals("-T")) {
        		sortType = arg.substring(2);
        	}else if(arg.substring(0, 2).equals("-s") || arg.substring(0, 2).equals("-S")) {
        		sortAlgorithm = arg.substring(2);
        	}
        }        

		// Array of shapes
        ThreeDShape[] shapes;
        
        try {

        	String content = new String(Files.readAllBytes(Paths.get(fileName)));
            String[] parts = content.split(" ");
            
            int numberOfShapes = Integer.parseInt(parts[0].trim());    
            
            // Array of shapes
            shapes = new ThreeDShape[numberOfShapes];
            
            for(int positionOfShape = 1; positionOfShape <= numberOfShapes; positionOfShape++ ) {
            	String shapeType = parts[(positionOfShape-1)*3+1];
            	double height = Double.parseDouble(parts[(positionOfShape-1)*3+2]);
            	double radiusOrEageLength = Double.parseDouble(parts[(positionOfShape-1)*3+3]);
            	
            	// Add shape objects to the array
            	if(shapeType.equals("Cylinder")) {
            		shapes[positionOfShape - 1] = new Cylinder(height, radiusOrEageLength);
//                    System.out.println("Cylinder: "+ shapes[positionOfShape - 1].getVolume());
            	} else if(shapeType.equals("Cone")){
            		shapes[positionOfShape - 1] = new Cone(height, radiusOrEageLength);
//                    System.out.println("Cone: "+ shapes[positionOfShape - 1].getVolume());
            	} else if(shapeType.equals("Pyramid")){
            		shapes[positionOfShape - 1] = new Pyramid(height, radiusOrEageLength);
//                    System.out.println("Pyramid: "+ shapes[positionOfShape - 1].getVolume());
            	} else if(shapeType.equals("SquarePrism")){
            		shapes[positionOfShape - 1] = new SquarePrism(height, radiusOrEageLength);
//                    System.out.println("SquarePrism: "+ shapes[positionOfShape - 1].getVolume());
            	} else if(shapeType.equals("TriangularPrism")){
            		shapes[positionOfShape - 1] = new TrianglarPrism(height, radiusOrEageLength);
//                    System.out.println("TriangularPrism: "+ shapes[positionOfShape - 1].getVolume());
            	} else if(shapeType.equals("PentagonalPrism")){
            		shapes[positionOfShape - 1] = new PentagonalPrism(height, radiusOrEageLength);
//                    System.out.println("PentagonalPrism: "+ shapes[positionOfShape - 1].getVolume());
            	} else if(shapeType.equals("OctagonalPrism")){
            		shapes[positionOfShape - 1] = new OctagonalPrism(height, radiusOrEageLength);
//                    System.out.println("OctagonalPrism: "+ shapes[positionOfShape - 1].getVolume());
            	}else {
            		System.out.println("!! --------ELSE--------- !!  ");
            	}
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return;
        }
      
		// Set up logging to a file
        int dotIndex = fileName.lastIndexOf('.');
        int slashIndex = fileName.lastIndexOf('/');

        // The directory for log files
        String outputDir = "output";
        // Create output directory if it does not exist
        new File(outputDir).mkdirs(); 

        String outputFileName = outputDir + "/" + fileName.substring(slashIndex+1, dotIndex) + sortType + sortAlgorithm + ".txt";
        System.out.println("outputFileName: "+ outputFileName);

        // Output the result to a file
        try (PrintStream fileOut = new PrintStream(outputFileName)){
            System.setOut(fileOut);
            
            System.out.println("------------------------");
            LocalTime startTime = LocalTime.now();
            System.out.println("Start Sorting: " + startTime);
            
            // Sorting        
            System.out.println("Type: " + sortType);
            System.out.println("Algorithm: " + sortAlgorithm);
            Comparator<ThreeDShape> comparator = ShapeComparator.getComparator(sortType);
            Utility.sort(sortAlgorithm, shapes, comparator);
            
            LocalTime endTime = LocalTime.now();
            System.out.println("End Sorting: " + endTime);

            Duration duration = Duration.between(startTime, endTime);

            // Convert duration to milliseconds
            long millis = duration.toMillis();
            System.out.println("Sorting time (milliseconds): " + millis);
         
            System.out.println("------------------------");

            // The program should also print the first sorted value and last sorted value, 
            // and every thousandth value in between.

            // First value
            System.out.println("First sorted value: ");  
            System.out.println("Volume: " + shapes[0].getVolume());  
            System.out.println("Height: " + shapes[0].getHeight());  
            System.out.println("BaseArea: " + shapes[0].getBaseArea());  
         
            // Last value
            System.out.println("Last sorted value: ");
            System.out.println("Volume: " + shapes[shapes.length-1].getVolume());
            System.out.println("Height: " + shapes[shapes.length-1].getHeight());  
            System.out.println("BaseArea: " + shapes[shapes.length-1].getBaseArea());  
         
            // every thousandth values
            for(int i = 1; i < shapes.length; i++) {
            	if(i%1000==0) {
            		System.out.println(i + " value: ");
            		System.out.println("Volume: " + shapes[i].getVolume());
            		System.out.println("Height: " + shapes[i].getHeight());  
            		System.out.println("BaseArea: " + shapes[i].getBaseArea());      		 
            	}
            }

        } catch (FileNotFoundException e) {
            System.err.println("Error creating output file: " + e.getMessage());
            return;
        }     
             

	}
}
