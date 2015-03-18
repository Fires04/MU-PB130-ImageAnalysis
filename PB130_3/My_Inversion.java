package PB130_3;

import ij.IJ;
import ij.ImagePlus;
import ij.plugin.filter.PlugInFilter;
import ij.process.ImageProcessor;

/** This plugin inverts a given 8-bit grayscale image. */
public class My_Inversion implements PlugInFilter 
{
        static final int PIXMAXVALUE = 255;
	public int setup(String arg, ImagePlus im) 
	{
		// this plugin accepts 8-bit grayscale images
		return DOES_8G; 
	}

	public void run(ImageProcessor ip) 
	{
            
            int width = ip.getWidth();
            int height = ip.getHeight();
            
            for(int x = 0; x < width; x++){
                for(int y = 0; y < height; y++){
                    ip.putPixel(x, y, PIXMAXVALUE - ip.getPixel(x, y));
                }
            }
	}

}
