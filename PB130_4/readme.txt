%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%
%       PB130 - Introduction to Digital Image Processing, Spring 2015
%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%
% Exercise 4 - Linear filters and convolution
% 
% prepared by:
% 
% Martin Maska <xmaska@fi.muni.cz>
% Petr Matula <pem@fi.muni.cz>
%
% Aim: - To get familiar with basic linear filters
%      - To get familiar with the convolution operator and different boundary conditions
%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

Built-in linear filters in ImageJ
=================================

- Open an 8-bit grayscale image (e.g., Boats, Bridge, or Tree Rings)
- Via "Process -> Filters -> Convolve", apply basic linear filters on an opened image. The kernels of several common filters (e.g., box, Gaussian,   Laplacian, or sharpening filter) can be found in the "kernels" folder. 
- What is the reason for using normalized kernels?
- Several linear filters can also be called directly, without explicitly specifying their kernels:
	- Box filter ("Process -> Filters -> Mean")
	- Gaussian filter ("Process -> Filters -> Gaussian Blur")
	- sharpening filter ("Process -> Filters -> Unsharp Mask")  	

Convolution
===========

To better understand and practice the computation of convolution, convolve a matrix A = [-2 0 1; 0 4 3; 2 1 -1] with a matrix B = [-1 0 1; 0 3 2] by hand. What is the size of the final matrix?


Implementation of ImageJ plugins
================================

- Copy all plugins (i.e., *.java and *.class files) from the previous exercise to the "plugins/PB130/Done" folder
- Copy all *.java files from the "04-incomplete.zip" archive to the "plugins/PB130" folder
- Compile each individual file via "Plugins -> Compile and Run"
- Refresh the content of menus via "Help -> Refresh Menus"
- Open the java files in your favourite text editor and complete the "getPixel()", "putPixel()", and "doConvolution()" methods in the following order:
	- My_Convolution (convolution of two integer matrices with zero boundary conditions; Warning: indexing outside the matrix domain results in a runtime error)
	- My_CyclicConvolution (convolution of two integer matrices with periodic boundary conditions; Warning: indexing outside the matrix domain results in a runtime error)

Documentation
=============
- Online documentation is available at:
	- http://rsbweb.nih.gov/ij/developer/api/  
	- http://imagingbook.files.wordpress.com/2013/06/burgerburgeen20071104_ijreference_letter.pdf
