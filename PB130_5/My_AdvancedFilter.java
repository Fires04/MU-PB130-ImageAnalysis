package PB130_5;

import ij.IJ;
import ij.ImagePlus;
import ij.plugin.filter.PlugInFilter;
import ij.process.ImageProcessor;
import java.util.ArrayList;
import java.util.Collections;

/**
 * This plugin reconstruct a given 8-bit grayscale image in a way that the
 * Google image search engine automatically recognize the person depicted in the
 * image.
 */
public class My_AdvancedFilter implements PlugInFilter {

    public int setup(String arg, ImagePlus im) {
        // this plugin accepts 8-bit grayscale images
        return DOES_8G;
    }

    public void run(ImageProcessor ip) {
        

        // initialize a list for storing values in the 3x3 neighborhood
        ArrayList<Integer> neighbors = new ArrayList<Integer>();

        // go through the image 'tmp' and compute the median value in the 3x3 neighborhood of each pixel
        // do not forget to skip the values outside the image domain
        int width = ip.getWidth();
        int height = ip.getHeight();
        int radius = 1;
        int repeats = 4;

        for (int i = 0; i < repeats; i++) {
            ImageProcessor tmp = ip.duplicate();
            radius = radius + i;
            
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    //okoli pixelu
                    for (int xt = x -radius; xt <= x + radius; xt++) {
                        for (int yt = y - radius; yt <= y + radius; yt++) {
                            if ((xt > 0) && (xt < width) && (yt > 0) && (yt < height)) {
                                neighbors.add(tmp.getPixel(xt, yt));
                            }
                        }
                    }
                    Collections.sort(neighbors);
                    //vypocet medianu
                    double median = 0;
                    if (neighbors.size() % 2 == 0) {
                        try {
                            median = (neighbors.get((neighbors.size() / 2)) + neighbors.get(((neighbors.size() / 2) - 1))) / 2;
                        } catch (Exception e) {
                            IJ.showMessage(String.format("x = %d , y= %d, index = %d", x, y, neighbors.get(neighbors.size() / 2)));
                        }
                    } else {
                        median = neighbors.get(((neighbors.size() + 1) / 2) - 1); // some magic is here
                    }
                    //zkusime jestli se pixel odlisuje od sveho okoli, pokud ano predpokladame ze se jedna o sum
                    if((tmp.getPixel(x, y) == 0) || (tmp.getPixel(x, y) == 255)){
                        ip.putPixel(x, y, (int) median);
                    }
                    
                    neighbors.clear();
                }
            }
        }

    }

}
