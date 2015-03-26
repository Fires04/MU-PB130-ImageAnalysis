package PB130_6;

import ij.IJ;
import ij.ImagePlus;
import ij.plugin.filter.PlugInFilter;
import ij.process.ImageProcessor;
import ij.process.FloatProcessor;

/**
 * This plugin approximates the gradient magnitude using central differences.
 */
public class My_GradientMagnitude implements PlugInFilter {

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

        float[][] valX = new float[w][h];
        float[][] valY = new float[w][h];
        float[][] valNabla = new float[w][h];
        float[][] valDir = new float[w][h];

        // allocate the output image
        FloatProcessor out = new FloatProcessor(w, h);

		// go through the image 'ip' and compute the gradient magnitude at each pixel
        // skip pixels in which the operator looks outside the image domain
        // store the computed values into the image 'out'
        // to work with floating point values, use getf()/setf() methods of the 'ImageProcessor' class
        // to compute the square root of x, call Math.sqrt(x)
        //X gradienty
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
                out.setf(x, y,(float) Math.abs(Math.sqrt(Math.pow(valX[x][y], 2) + Math.pow(valY[x][y], 2))));
                //valNabla[x][y] = (float) Math.abs(Math.sqrt(Math.pow(valX[x][y], 2) + Math.pow(valY[x][y], 2)));
                //valDir[x][y] = (float) Math.atan2(valY[x][y],valX[x][y]);
            }
        }

		// NO CHANGES NEEDED AFTER THIS LINE
        // show the output image
        ImagePlus outImg = new ImagePlus("My gradient magnitude of " + title, out);
        outImg.show();
    }

}
