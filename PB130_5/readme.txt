%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%
%       PB130 - Introduction to Digital Image Processing, Spring 2015
%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%
% Exercise 5 - Nonlinear filters
% 
% prepared by:
% 
% Martin Maska <xmaska@fi.muni.cz>
% Petr Matula <pem@fi.muni.cz>
%
% Aim: - To get familiar with basic nonlinear filters
%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

Built-in nonlinear filters in ImageJ
====================================

- Open "nuts_bolts.tif" from the "images" folder
- Via "Process -> Filters -> Minimum/Maximum", apply minimum or/and maximum filters to fill the holes inside nuts
- Open an 8-bit grayscale image (e.g., "chessboard.jpg" from the "images" folder) and degrade it with a salt and pepper noise
- Via "Process -> Filters -> Median", apply a median filter and compare the result with that of a Gaussian filter
- open "space.tif" from the "images" folder and correct it for uneven illumination using a median filter
- You may find useful the following menu commands:
	- "Image -> Duplicate" - duplicate a given image
	- "Process -> Image Calculator"	- basic arithmetical operations over images
- Does a change in the order of applied nonlinear filters influence the result? 
- Does a change in the order of applied linear and nonlinear filters influence the result?


Implementation of ImageJ plugins
================================

- Copy all plugins (i.e., *.java and *.class files) from the previous exercise to the "plugins/PB130/Done" folder
- Copy all *.java files from the "05-incomplete.zip" archive to the "plugins/PB130" folder
- Compile each inidividual file via "Plugins -> Compile and Run"
- Refresh the content of menus via "Help -> Refresh Menus"
- Open the java files in your favourite text editor and complete the "run()" methods in the following order: 
	- My_Median3x3 (apply the 3x3 median filter on a given 8-bit grayscale image; assure that only the pixels within the original image domain are used)
	- My_AdvancedFilter (reconstruct the "whoamI.tif" image from the "images" folder in a way that the Google image search engine automatically recognizes the person depicted in the image)


Documentation
=============
- Online documentation is available at:
	- http://rsbweb.nih.gov/ij/developer/api/  
	- http://imagingbook.files.wordpress.com/2013/06/burgerburgeen20071104_ijreference_letter.pdf

- Focus especially on the following methods of the "ij.process.ImageProcessor" class:
	- getWidth(), getHeight(), get(), set()


ArrayList
=========
- Online documentation of the "ArrayList" class is available at http://docs.oracle.com/javase/6/docs/api/java/util/ArrayList.html

- Focus especially on the following methods of the "ArrayList" class: 
	- add(), get(), clear()
