%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%
%       PB130 - Introduction to Digital Image Processing, Spring 2015
%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%
% Exercise 3 - Point transforms
% 
% prepared by:
% 
% Martin Maska <xmaska@fi.muni.cz>
% Petr Matula <pem@fi.muni.cz>
%
% Aim: - To get familiar with basic point transforms
%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

Built-in point transforms in ImageJ
===================================

- Open an 8-bit grayscale image (e.g., TEM Filter, Boats, or Tree Rings)
- Via "Process -> Math", increase/decrease the brightness (Add/Subtract) and contrast (Multiply/Divide) of an opened image
- Via "Process -> Math -> Gamma", apply a gamma correction to an opened image
- What happens with the intensity histogram after applying these transforms? Press Ctrl+H to open the histogram window
- Are the pointwise addition, multiplication, and minimum of two images point transforms? If so, are they position-dependent or position-independent?


Implementation of ImageJ plugins
================================

- Copy all plugins (i.e., *.java and *.class files) from the previous exercise to the "plugins/PB130/Done" folder
- Copy all *.java files from the "03-incomplete.zip" archive to the "plugins/PB130" folder
- Compile each inidividual file via "Plugins -> Compile and Run"
- Refresh the content of menus via "Help -> Refresh Menus"
- Open the java files in your favourite text editor and complete the "run()" methods in the following order: 
	- My_Inversion (invert a given 8-bit grayscale image)
	- My_IncreaseBrightness (increase the brightness of a given 8-bit grayscale image by 30; Warning: beware of image data type overflows)
	- My_IncreaseContrast (increase the contrast of a given 8-bit grayscale image by 50%; Warning: beware of image data type overflows)
	- My_LinearStretch (apply the linear stretch on a given 8-bit grayscale image; Warning: constant images)
	- My_GammaCorrection (apply a gamma correction to a given 8-bit grayscale image)
- Study how the implemented point transforms modify the intesity histogram of an image (e.g., TEM Filter, Bridge, or Tree Rings)


Documentation
=============
- Online documentation is available at:
	- http://rsbweb.nih.gov/ij/developer/api/  
	- http://imagingbook.files.wordpress.com/2013/06/burgerburgeen20071104_ijreference_letter.pdf

- Focus especially on the following methods of the "ij.process.ImageProcessor" class:
	- getWidth(), getHeight(), getPixelCount(), get(), set(), getPixel(), putPixel() 


Java and mathematics
====================
- Online documentation of the "Math" class is available at http://docs.oracle.com/javase/6/docs/api/java/lang/Math.html

- Focus especially on the following methods of the "Math" class: 
	- double Math.pow(double a, double b) - raise a to the power of b
	- double Math.floor(double a)         - get the largest double value that is less than or equal to a and is equal to a mathematical integer

- Typecasting: 
	- To convert a double value a to the largest integer value that is less than or equal to a, call (int) Math.floor(a)

	  For example:

		double a = 9.2;
		int b = (int) Math.floor(a); // b is 9 