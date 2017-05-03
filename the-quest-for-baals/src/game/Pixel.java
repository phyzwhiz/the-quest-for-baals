package game;

import java.awt.Color;
import java.awt.Graphics;

public class Pixel implements PixelPlan {
	
	/**
	 * color 2d array that is displayed for pixels
	 */
	private Graphics meme;

	/**
	 * creates a 10*10 empty 'Pixel'
	 */
	public Pixel() 
	{	meme.fillRect(0, 0, 10, 10); }
	
	/**
	 * creates a 10*10 filled 'Pixel'
	 */
	public Pixel(Color color)
	{ 
		meme.setColor(color);
		meme.fillRect(0, 0, 10, 10);
	}
	
	public void fill(Color color)
	{	meme.setColor(color); }
	
	public Color color()
	{	return meme.getColor(); }
	
	public void set(int x, int y) 
	{	meme.translate(x, y); }
	
}
