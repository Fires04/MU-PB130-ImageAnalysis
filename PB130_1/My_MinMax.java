package PB130_1;

import ij.IJ;
import ij.ImagePlus;
import ij.plugin.filter.PlugInFilter;
import ij.process.ImageProcessor;

/** This plugin displays the minimum and maximum intensities within a given image. */
public class My_MinMax implements PlugInFilter 
{
	public int setup(String arg, ImagePlus im) 
	{
		// this plugin accepts only 8-bit grayscale images
		return DOES_8G + NO_CHANGES; 
	}

	public void run(ImageProcessor ip) 
	{
                int width = ip.getWidth();
                int height = ip.getHeight();
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
                for(int i = 0; i<(width*height); i++){
                    int intensity = ip.get(i);
                    if(intensity < min){
                        min = intensity;
                    }
                    if(intensity > max){
                        max = intensity;
                    }
                    
                }
                
		// display the minimum and maximum intensities
		IJ.showMessage(String.format("Min: %d Max: %d", min, max));
		//IJ.showMessage("NOT IMPLEMENTED!");	
	}

}
