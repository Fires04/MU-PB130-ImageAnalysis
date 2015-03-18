package PB130_DU1;

import ij.IJ;
import ij.ImagePlus;
import ij.plugin.filter.PlugInFilter;
import ij.process.ImageProcessor;

/** Find the most frequent value of pixel and highlight them */
public class My_HistMax implements PlugInFilter 
{	
	String title = null;
	
	public int setup(String arg, ImagePlus im) 
	{
		if (im != null)
		{
			// store the short image title for future use
			title = im.getShortTitle();
			
			// this plugin accepts 8-bit grayscale images
			return DOES_8G + NO_CHANGES; 
		}
		else
		{
			// no image is open
			IJ.noImage();
			return DONE;
		}
	}

	public void run(ImageProcessor ip) 
	{
            
                int imgWidth = ip.getWidth();
                int imgHeight = ip.getHeight();
                int valueCount[] = new int[256];
		
                //projdeme pole a zapiseme si hodnoty a cetnost pixelu
                for(int x=0;x<imgWidth;x++){
                    for (int y = 0; y < imgHeight; y++) {
                        valueCount[ip.getPixel(x, y)]++;
                    }
                }
               	
                
                
                //najdeme maximalni vyskyt.
                int maxPosition = Integer.MIN_VALUE;
                int maxValue = Integer.MIN_VALUE;
                for(int i = 0;i<256;i++){
                    if(maxValue < valueCount[i]){
                        maxPosition = i;
                        maxValue = valueCount[i];
                    }
                }
                
                //projdeme obrazek a oznacime body s nejvetsi hodnotou (hodnotou 255)
                for(int x=0;x<imgWidth;x++){
                    for (int y = 0; y < imgHeight; y++) {
                        if(ip.getPixel(x, y) == maxPosition){
                            ip.putPixel(x, y, 255);
                        }
                    }
                }
                
                //vypiseme na vystup
		IJ.showMessage(String.format("Nejcastejsi hodnota pixelu je %d, celkem %d krat",maxPosition,valueCount[maxPosition]));
	}

}
