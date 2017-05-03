package game;

import java.awt.Color;

public interface PixelPlan {

	/**
	 * constructor: creates a 10*10 color array (pixel) that is empty
	 * 
	 *&&
	 *
	 *creates a 10*10 color 2d color array with a specified color
	 */
	
	/**
	 * fills array with a single color value
	 */
	public void fill(Color color);
	
	/**
	 * @return current color value 
	 */
	public Color color();
	
	/**
	 * moves the pixel to a certain location
	 */
	public void set(int x, int y);
	
}