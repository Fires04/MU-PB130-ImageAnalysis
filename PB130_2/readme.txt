%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%
%       PB130 - Introduction to Digital Image Processing, Spring 2015
%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%
% Exercise 2 - Intensity histograms
% 
% prepared by:
% 
% Martin Maska <xmaska@fi.muni.cz>
% Petr Matula <pem@fi.muni.cz>
%
% Aim: - To get familiar with intensity histograms
%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

Built-in intensity histograms in ImageJ
=======================================

- Open an 8-bit grayscale image (e.g., Boats, Bridge, or Tree Rings)
- Display its intensity histogram (Ctrl+H) in different modes
- Is the intensity histogram unique representation of an image? Analyze the intensity histograms of "chessboard.jpg" and "ramp.tif" from the "images" folder
- Study how different operations over an opened image modify its intensity histogram:
	- Adding the additive Gaussian noise with different standard deviations (via "Process -> Noise -> Add Specified Noise")
	- Adding the impulse noise (via "Process -> Noise -> Salt and Pepper")
	- Adding/Subtracting a constant to/from every pixel (via "Process -> Math -> Add"/"Process -> Math -> Subtract") 	
- What operation over two general images of the same size and bit depth corresponds to the summation of their intensity histograms? 


Implementation of ImageJ plugins
================================

- Create folder "Done" under "plugins/PB130" and copy all plugins (i.e., *.java and *.class files) from the previous exercise there 
- Copy all *.java files from the "02-incomplete.zip" archive to the "plugins/PB130" folder
- Compile each inidividual file via "Plugins -> Compile and Run"
- Refresh the content of menus via "Help -> Refresh Menus"
- Open the java files in your favourite text editor and complete the "run()" methods in the following order: 
	- My_Histogram (compute the intensity histogram of a given 8-bit grayscale image and check whether the image is underexposed/overexposed)
	- My_CumulativeHistogram (compute the cumulative histogram of a given 8-bit grayscale image)
	- My_BinnedHistogram (compute the intensity histogram of a given 16-bit grayscale image (e.g., "lena16b.tif" from the "images" folder), 
	  which consists of 512 bins)
	- My_GaussianNoise (add the additive Gaussian noise to a given 8-bit grayscale image; Warning: beware of image data type overflows)


Documentation
=============
- Online documentation is available at:
	- http://rsbweb.nih.gov/ij/developer/api/  
	- http://imagingbook.files.wordpress.com/2013/06/burgerburgeen20071104_ijreference_letter.pdf

- Focus especially on the following methods of the "ij.process.ImageProcessor" class:
	- getWidth(), getHeight(), getPixelCount(), get(), getPixel(), set(), putPixel()


Java and mathematics
====================
- Online documentation of the "Math" class is available at http://docs.oracle.com/javase/6/docs/api/java/lang/Math.html

- Focus especially on the following methods of the "Math" class: 
	- double Math.floor(double a) - get the largest double value that is less than or equal to a and is equal to a mathematical integer

- Typecasting: 
	- To convert a double value a to the largest integer value that is less than or equal to a, call (int) Math.floor(a)
	  
	  For example:

		double a = 9.2;
		int b = (int) Math.floor(a); // b is 9 		


Java and generators of pseudorandom numbers
===========================================
- Online documentation of the "Random" class is available at http://docs.oracle.com/javase/6/docs/api/java/util/Random.html

- Focus especially on the following methods of the "Random" class: 
	- double Random.nextGaussian() - get the next pseudorandom number in a normal distribution with the zero mean and the standard deviation equal to 1