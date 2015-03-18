package PB130_3;

import ij.IJ;
import ij.ImagePlus;
import ij.plugin.filter.PlugInFilter;
import ij.process.ImageProcessor;

/** This plugin applies the linear stretch on a given 8-bit grayscale image. */
public class My_LinearStretch implements PlugInFilter 
{
	public int setup(String arg, ImagePlus im) 
	{
		// this plugin accepts 8-bit grayscale images
		return DOES_8G; 
	}

	public void run(ImageProcessor ip) 
	{
            int width = ip.getWidth();
            int height = ip.getHeight();
   
            int lowValue = Integer.MAX_VALUE;
            int highValue = Integer.MIN_VALUE;
            for(int x = 0; x < width; x++){
                for(int y = 0; y < height; y++){
                   if(ip.getPixel(x, y) > highValue){
                       highValue = ip.getPixel(x, y);
                   }
                   if(ip.getPixel(x, y) < lowValue){
                       lowValue = ip.getPixel(x, y);
                   }
                }
            }
            int val2 = (ip.getPixel(127, 127)-lowValue)*((255-0)/(highValue-lowValue))+0;
            for(int x = 0; x < width; x++){
                for(int y = 0; y < height; y++){
                    int val = (ip.getPixel(x, y)-lowValue)*((255-0)/(highValue-lowValue))+0;
                    ip.putPixel(x, y, val);
                }
            }
	}

}
