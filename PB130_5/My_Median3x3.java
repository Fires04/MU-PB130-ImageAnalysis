package PB130_5;

import ij.IJ;
import ij.ImagePlus;
import ij.plugin.filter.PlugInFilter;
import ij.process.ImageProcessor;
import java.util.ArrayList;
import java.util.Collections;

/**
 * This plugin applies the 3x3 median filter on a given 8-bit grayscale image.
 */
public class My_Median3x3 implements PlugInFilter {

    public int setup(String arg, ImagePlus im) {
        // this plugin accepts 8-bit grayscale images
        return DOES_8G;
    }

    public void run(ImageProcessor ip) {
        // duplicate the image
        ImageProcessor tmp = ip.duplicate();

        // initialize a list for storing values in the 3x3 neighborhood
        ArrayList<Integer> neighbors = new ArrayList<Integer>();

		// go through the image 'tmp' and compute the median value in the 3x3 neighborhood of each pixel
        // do not forget to skip the values outside the image domain
        int width = ip.getWidth();
        int height = ip.getHeight();

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                //neighbors.add(ip.getPixel(x, y)); // central pixel
                for (int xt = x - 1; xt <= x + 1; xt++) {
                    for (int yt = y - 1; yt <= y + 1; yt++) {
                        if ((xt > 0) && (xt < width) && (yt > 0) && (yt < height)) {
                            neighbors.add(tmp.getPixel(xt, yt));
                        }
                    }
                }
                Collections.sort(neighbors);
                
                double median = 0;
                if (neighbors.size() % 2 == 0) {
                    try{
                        median = (neighbors.get((neighbors.size()/2)) + neighbors.get(((neighbors.size()/2)-1)))/2;
                    }catch(Exception e){
                        	IJ.showMessage(String.format("x = %d , y= %d, index = %d", x, y,neighbors.get(neighbors.size()/2)));
                    }
                } else {
                    median = neighbors.get(((neighbors.size()+1)/2)-1); // some magic is here
                }
                ip.putPixel(x, y, (int)median);
                neighbors.clear();
            }
        }
    
        // store the computed median values into the image 'ip'
        // to add an integer value 'i' to the list, call neighbors.add(i) 
        // to clear the list, call neighbors.clear()
        // to find the median value of the list, call getMedian(neighbors)
        // do not forget to complete the 'getMedian()' method in this file 	
        // WRITE YOUR CODE HERE
        //IJ.showMessage("NOT IMPLEMENETD!");
    }

//    /**
//     * Get the median value of a given list of integers.
//     */
//    private int getMedian(ArrayList<Integer> a) {
//        // sort the list 'a'
//        Collections.sort(a);
//
//        // the length of the list 'a'
//        int l = a.size();
//
//		// return the median value of the sorted list 'a'
//        // to get the i-th value in the list, call a.get(i)
//        // WRITE YOUR CODE HERE
//        return 0;
//    }

}
