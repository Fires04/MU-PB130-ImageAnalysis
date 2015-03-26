package PB130_6;

import ij.IJ;
import ij.ImagePlus;
import ij.plugin.filter.PlugInFilter;
import ij.process.ImageProcessor;
import ij.process.FloatProcessor;

/**
 * This plugin approximates the Laplacian of a given 8-bit grayscale image.
 */
public class My_Laplacian implements PlugInFilter {

    String title = null;

    public int setup(String arg, ImagePlus im) {
        if (im != null) {
            // store the short image title for future use
            title = im.getShortTitle();

            // this plugin accepts 8-bit grayscale images
            return DOES_8G + NO_CHANGES;
        } else {
            // no image is open
            IJ.noImage();
            return DONE;
        }
    }

    public void run(ImageProcessor ip) {
        // size of the input image
        int w = ip.getWidth();
        int h = ip.getHeight();

        // allocate the output image
        FloatProcessor out = new FloatProcessor(w, h);
        float[][] valX = new float[w][h];
        float[][] valY = new float[w][h];

		// go through the image 'ip' and compute the Laplacian at each pixel
        // skip pixels in which the operator looks outside the image domain
        // store the computed values into the image 'out'
        // to work with floating point values, use getf()/setf() methods of the 'ImageProcessor' class
        for (int y = 0; y < h; y++) {
            for (int x = 1; x < w - 1; x++) {
                //prochazime obrazek po ose x
                float value = 0.5f * (ip.getf(x + 1, y) - ip.getf(x - 1, y));
                valX[x][y] = value;
            }
        }
        //Y gradienty
        for (int y = 1; y < h - 1; y++) {
            for (int x = 0; x < w; x++) {
                //prochazime obrazek po ose x
                float value = 0.5f * (ip.getf(x, y + 1) - ip.getf(x, y - 1));
                valX[x][y] = value;
            }
        }
        //Nabla gradient 
        for (int x = 0; x < w; x++) {
            for (int y = 0; y < h; y++) {
                out.setf(x, y, (float) (Math.pow(valX[x][y], 2) + Math.pow(valY[x][y], 2)));
            }
        }

        // show the output image
        ImagePlus outImg = new ImagePlus("My Laplacian of " + title, out);
        outImg.show();
    }

}
