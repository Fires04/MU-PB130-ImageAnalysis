package PB130_5;

import ij.IJ;
import ij.ImagePlus;
import ij.plugin.filter.PlugInFilter;
import ij.process.ImageProcessor;

/** This plugin reconstruct a given 8-bit grayscale image in a way that the Google 
  * image search engine automatically recognize the person depicted in the image. */
public class My_AdvancedFilter implements PlugInFilter 
{
	public int setup(String arg, ImagePlus im) 
	{
		// this plugin accepts 8-bit grayscale images
		return DOES_8G; 
	}

	public void run(ImageProcessor ip) 
	{
		// WRITE YOUR CODE HERE
		IJ.showMessage("NOT IMPLEMENTED!");
	}

}
