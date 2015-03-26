%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%
%       PB130 - Introduction to Digital Image Processing, Spring 2015
%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%
% Exercise 6 - Image gradient and difference operators
% 
% prepared by:
% 
% Martin Maska <xmaska@fi.muni.cz>
% Petr Matula <pem@fi.muni.cz>
%
% Aim: - To get familiar with image gradient and basic difference operators
%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

Built-in difference operators in ImageJ
=======================================

- Open an 8-bit grayscale image from the "images" folder (e.g., "ramp.tif" or "chessboard.jpg") 
- Via "Process -> Filters -> Convolve", try to apply different difference operators on the opened image and its flipped version
- Why are the edges detected in one direction only? 


Implementation of ImageJ plugins
================================

- Copy all plugins (i.e., *.java and *.class files) from the previous exercise to the "plugins/PB130/Done" folder
- Copy all *.java files from the "06-incomplete.zip" archive to the "plugins/PB130" folder
- Compile each inidividual file via "Plugins -> Compile and Run"
- Refresh the content of menus via "Help -> Refresh Menus"
- Open the java files in your favourite text editor and complete the "run()" methods in the following order: 
	- My_GradientX (approximate the gradient in the x direction using central differences)
	- My_GradientY (approximate the gradient in the y direction using central differences)
	- My_GradientMagnitude (approximate the gradient magnitude using central differences)
	- My_GradientOrientation (approximate the gradient orientation using central differences)
	- My_Laplacian (approximate the Laplacian of a given 8-bit grayscale image)
- Study how the implemented routines behave on images in the "images" folder


Documentation
=============
- Online documentation is available at:
	- http://rsbweb.nih.gov/ij/developer/api/  
	- http://imagingbook.files.wordpress.com/2013/06/burgerburgeen20071104_ijreference_letter.pdf

- Focus especially on the following methods of the "ij.process.ImageProcessor" class:
	- getWidth(), getHeight(), getf(), setf()


Java and mathematics
====================
- Online documentation of the "Math" class is available at http://docs.oracle.com/javase/6/docs/api/java/lang/Math.html

- Focus especially on the following methods of the "Math" class: 
	- double Math.sqrt(double a)  
	- double Math.atan2(double y, double x)
	- double Math.toDegrees(double a)

