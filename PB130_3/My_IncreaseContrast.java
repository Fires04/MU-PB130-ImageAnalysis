package PB130_3;

import ij.IJ;
import ij.ImagePlus;
import ij.plugin.filter.PlugInFilter;
import ij.process.ImageProcessor;

/** This plugin increases the contrast of a given 8-bit grayscale image by 50%. */
public class My_IncreaseContrast implements PlugInFilter 
{
	public int setup(String arg, ImagePlus im) 
	{
		// this plugin accepts 8-bit grayscale images
		return DOES_8G; 
	}

	public void run(ImageProcessor ip) 
	{
		// WRITE YOUR CODE HERE
            int width = ip.getWidth();
            int height = ip.getHeight();
            
            for(int x = 0; x < width; x++){
                for(int y = 0; y < height; y++){
                    int val = (ip.getPixel(x, y)) <= 127 ? ip.getPixel(x, y)*2 : 255;
                    ip.putPixel(x, y, val);
                }
            }
	}

}
