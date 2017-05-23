package game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Lava extends Block {
	
	int width;
	private ArrayList<BufferedImage> animate = new ArrayList<BufferedImage>();
	BufferedImage display;
	
	public void load() 
	{
		try {
			
			/** lava animate (+0) */
			animate.add(ImageIO.read(new File("img/stone1.png")));
			animate.add(ImageIO.read(new File("img/stone2.png")));
			animate.add(ImageIO.read(new File("img/stone3.png")));
			animate.add(ImageIO.read(new File("img/stone1.png")));
			animate.add(ImageIO.read(new File("img/stone2.png")));
			animate.add(ImageIO.read(new File("img/stone3.png")));
			animate.add(ImageIO.read(new File("img/stone1.png")));
			animate.add(ImageIO.read(new File("img/stone2.png")));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public Lava(int x, int y) 
	{
		super(x, y);
		load();
		display = animate.get(0);
        width = display.getWidth();
        ishurt = true;
	}
	
	
	public void draw(Graphics g) throws IOException 
	{	g.drawImage(display, x, y, null); }
	
	
	public int getMaxX() 
	{	return x + width; }
    
	
    public int getMaxY() 
    {	return y + width; }
	
    
    public void spooky(int fastswagger) 
    {	display = animate.get(fastswagger); }
    
    
}
