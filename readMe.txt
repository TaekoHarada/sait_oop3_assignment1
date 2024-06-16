readMe.txt: instructions on how to install and use your sorting program.

	Contents:
		> File an Folder structure 
		> How to run the program?
		> Note 
		

<< File an Folder structure >>

command.bat
command.sh
mySort.txt 
projectStatus.txt
readMe.txt
sort.jar

./bin:
	class files

./doc:
	Javadoc
	
./output:
	log files (e.g. polyfor1ab.txt)

./src:
	Sorce files
	./src/assignment1:
		TestDriver.java
		Utility.java

	./src/shapes:
		Cone.java
		Cylinder.java
		OctagonalPrism.java
		PentagonalPrism.java
		Prism.java
		Pyramid.java
		ShapeComparator.java
		SquarePrism.java
		ThreeDShape.java
		TrianglarPrism.java

./testData:
	polyfor1.txt
	polyfor3.txt
	polyfor5.txt



<< How to run the program? >>

1. Allocate Sort.jar, testData folder and command.bat file (for macOS command.sh) at the same directory.

For Windows:
	2. Open the terminal.
	
	3. Move to the sorting program directory.
	(e.g. % cd [the directory path])
		
	4. Run the command file. 
	(% command.bat) 


For MacOS:
	2. Open the terminal.
	
	3. Move to the sorting program directory.
	(e.g. % cd [the directory path])
	
	4. Make the command.sh executable.
	(% chmod +x command.sh) 
	
	5. Run the command file. 
	(% ./command.sh) 
	
<< Note >>
	
	Since the test data files contain big data, the program process will take a long time. 
	If you want to quit the process, press 'Ctrl + C'.
	
	