package PB130_1;

import ij.IJ;
import ij.ImagePlus;
import ij.plugin.filter.PlugInFilter;
import ij.process.ImageProcessor;

/** This plugin flips a given image vertically. */
public class My_FlipY implements PlugInFilter 
{
	public int setup(String arg, ImagePlus im) 
	{
		// this plugin accepts all supported image types
		return DOES_ALL; 
	}

	public void run(ImageProcessor ip) 
	{
            ImageProcessor original = ip.duplicate();
            
            int width = ip.getWidth();
            int height = ip.getHeight();          

            for (int y = 0; y < height; y++) {
              for(int x = 0; x< width; x++){
                ip.putPixel(width-x,y, original.getPixel(x, y));
              }
            }
	}

}
