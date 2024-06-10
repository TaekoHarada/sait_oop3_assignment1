package assignment1;

import java.util.*;
import java.nio.file.*;
import java.io.IOException;
import java.time.LocalTime;
import java.time.Duration;

import shapes.*;
//import assignment1.Utility;


public class TestDriver {

	public static void main(String[] args) {

		String fileName = "testData/polyfor1.txt";
        String sortType = "v";
        String sortAlgorithm = "q";

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
      
        
        LocalTime startTime = LocalTime.now();
        System.out.println("startTime time: " + startTime);
        
        // Sorting        
        Comparator<ThreeDShape> comparator = ShapeComparator.getComparator(sortType);
        Utility.sort(sortAlgorithm, shapes, comparator);
        
        LocalTime endTime = LocalTime.now();
        System.out.println("endTime time: " + endTime);

        Duration duration = Duration.between(startTime, endTime);

     // Convert duration to milliseconds
     long millis = duration.toMillis();

     System.out.println("Total time (milliseconds): " + millis);
     
     // The program should also print the first sorted value and last sorted value, 
     // and every thousandth value in between.
     // First value
     System.out.println("First sorted value: " + shapes[0].getVolume());  
     
     System.out.println("Last sorted value: " + shapes[shapes.length-1].getVolume());  
//
//        for (ThreeDShape shape : shapes) {
//        	if(shape == null) {
//        		System.out.println(shape);
//        	}
//            System.out.println(shape.getVolume());
//        }
        

	}

}
