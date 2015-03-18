package PB130_4;

import ij.IJ;
import ij.plugin.PlugIn;

/** A two-dimensional periodic matrix representation with the interface similar to the "ij.process.ImageProcessor" class. */
class MyPeriodicMatrix
{
	/** A two-dimensional array storing the matrix values. */	
	int[][] m_array;

	/** Constructor. */		
	public MyPeriodicMatrix(int[][] array)
	{
		m_array = array;
	}	

	/** Constructor. The matrix is initialized with zeros. */
	public MyPeriodicMatrix(int width, int height)
	{
		m_array = new int[height][width];
	}	

	/** Get the width of the matrix. */
	public int getWidth()
	{
		return m_array[0].length;
	}	

	/** Get the height of the matrix. */
	public int getHeight()
	{
		return m_array.length;
	}

	/** Get the value at the x-th column and y-th row. If the given position is outside the matrix domain, 
	    return the value based on periodic boundary conditions. */
	public int getPixel(int x, int y)
	{
		// check whether the given position is outside the matrix domain or not
		// WRITE YOUR CODE HERE
		return m_array[y][x];
	}

	/** Set the value at the x-th column and y-th row to the given value. If the given position is outside the matrix domain, do nothing. */
	public void putPixel(int x, int y, int value)
	{
		// check whether the given position is outside the matrix domain or not
		// WRITE YOUR CODE HERE
		m_array[y][x] = value;
	}

	/** Convert the matrix content to a string representation. */
	public String print()
	{
		String str = "";
		int w = getWidth();
		int h = getHeight();

		for (int y = 0; y < h; ++y)
		{
			str += "\n";

			for (int x = 0; x < w; ++x)
			{
				str += String.format("%5d ", m_array[y][x]);
			}
		}

		return str;
	}
}

/** This plugin convolves two integer matrices with periodic boundary conditions. */
public class My_CyclicConvolution implements PlugIn
{	
	public void run(String arg) 
	{	
		// input image
		int[][] imgArray = { {-2, 0, 1}, {0, 4, 3}, {2, 1, -1} }; 
		MyPeriodicMatrix image = new MyPeriodicMatrix(imgArray);

		// convolution kernel
		int[][] kerArray = { {-1, 0, 1}, {0, 3, 2} };
		MyPeriodicMatrix kernel = new MyPeriodicMatrix(kerArray);

		// convolve the input matrix with the convolution kernel
		MyPeriodicMatrix result = doConvolution(image, kernel);
		
		// display the result
		IJ.showMessage("Image:" + image.print() +  "\n \nKernel:" + kernel.print() + "\n \nResult:" + result.print());
	}

	private MyPeriodicMatrix doConvolution(MyPeriodicMatrix image, MyPeriodicMatrix kernel)
	{
		// size of the input image
		int imgW = image.getWidth();
		int imgH = image.getHeight();

		// size of the convolution kernel
		int kerW = kernel.getWidth();
		int kerH = kernel.getHeight();

		// size of the result
		int resW = imgW + kerW - 1;
		int resH = imgH + kerH - 1;

		// create the output image filled with zeros by default
		MyPeriodicMatrix result = new MyPeriodicMatrix(resW, resH);
				
		// convolve the input image with the convolution kernel
		// to obtain a value from or modify a value in a matrix 'm', call m.getPixel(x, y) or m.putPixel(x, y, value), respectively
		// WRITE YOUR CODE HERE
		IJ.showMessage("NOT IMPLEMENTED!");

		return result;
	}
	
}
