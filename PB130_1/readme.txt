%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%
%       PB130 - Introduction to Digital Image Processing, Spring 2015
%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%
% Exercise 1 - ImageJ and digital image representation
% 
% prepared by:
% 
% Martin Maska <xmaska@fi.muni.cz>
% Petr Matula <pem@fi.muni.cz>
%
% Aims: - To get familiar with the ImageJ environment
%	- To implement simple ImageJ plugins
%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

Installation of ImageJ and the first steps with this application
================================================================

- Unzip the "ImageJ.zip" archive and run the "ImageJ.exe" binary file
- Via "File -> Open Samples", open a few sample images in different file formats (e.g., Leaf, Lena, or Tree Rings)
- What is the size and bit-depth of these images?
- Via "Image -> Color -> Split Channels", extract individual channels from an RGB image
- Via "Image -> Type", convert an RGB image into a grayscale one
- Try other functions under the "Image" menu (e.g., zooming in/out, scaling, flipping) 


Implementation of the first simple ImageJ plugins
=================================================

- Create folder "PB130" under "ImageJ\plugins" and copy all *.java files from the "01-incomplete.zip" archive there
- Compile each inidividual file via "Plugins -> Compile and Run"
- Refresh the content of menus via "Help -> Refresh Menus"
- Open the java files in your favourite text editor and complete the "run()" methods in the following order: 
	- My_MinMax (find the minimum and maximum intensity within a given 8-bit grayscale image)
	- My_FlipX (flip a given image horizontally)
	- My_FlipY (flip a given image vertically)
	- My_FlipXY (flip a given image horizontally as well as vertically)

Documentation
=============
- Online documentation is available at:
	- http://rsbweb.nih.gov/ij/developer/api/  
	- http://imagingbook.files.wordpress.com/2013/06/burgerburgeen20071104_ijreference_letter.pdf

- Focus especially on the following methods of the "ij.process.ImageProcessor" class:
	- getWidth(), getHeight(), getPixelCount(), get(), set(), getPixel(), putPixel() 

