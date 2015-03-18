package PB130_2;

import ij.IJ;
import ij.ImagePlus;
import ij.plugin.filter.PlugInFilter;
import ij.process.ImageProcessor;
import ij.process.ByteProcessor;
import ij.gui.GenericDialog;
import java.util.Random;

/** This plugin adds the additive Gaussian noise to a given 8-bit grayscale image. */
public class My_GaussianNoise implements PlugInFilter 
{	
	/** The additive Gaussian noise standard deviation. */	
	static double sigma = 10;		
	
	public int setup(String arg, ImagePlus im) 
	{
		// this plugin accepts 8-bit grayscale images
		return DOES_8G; 
	}

	public void run(ImageProcessor ip) 
	{
		// show the dialog for setting the standard deviation	
		if (showDialog())
		{	
			// create a generator of pseudorandom numbers
			Random r = new Random();

			// add the additive Gaussian noise with the standard deviation 'sigma' given by the user
                        int width = ip.getWidth();
                        int height = ip.getHeight();

                        for (int y = 0; y < height; y++) {
                            for (int x = 0; x < width; x++) {
                                ip.putPixel(x, y,ip.getPixel(x, y)+r.nextInt((int) sigma));
                            }
                        }
                        
                        
			// WRITE YOUR CODE HERE
			//IJ.showMessage("NOT IMPLEMENTED!");
		}	
	}

	private boolean showDialog()
	{
		GenericDialog dlg = new GenericDialog("Additive Gaussian Noise");
		dlg.addNumericField("Standard deviation:", sigma, 2);
		dlg.showDialog();

		if (dlg.wasCanceled())
		{
			return false;
		}
		else
		{
			double tmp = dlg.getNextNumber();

			if (tmp > 0.0 && tmp <= 50.0)
			{
				sigma = tmp;
				return true;		
			}
			else
			{
				IJ.error("The standard deviation must be within the (0, 50] interval!");
				return false;	
			}
		}
	}

}
