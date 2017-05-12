package game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Block {
	
	private int type;
	private boolean foreground;
	int x;
	int y;
	int x2;
	int y2;
	
	private ArrayList<BufferedImage> animate = new ArrayList<BufferedImage>();
	BufferedImage display;
	
	public void load()
	{
		try {
			/** 0 wood */
			animate.add(ImageIO.read(new File("img/imgres.png")));
			
			/** 1 stone */
			animate.add(ImageIO.read(new File("img/imgres.png")));
			
			/** 2 grass */
			animate.add(ImageIO.read(new File("img/imgres.png")));

			/** 3 background wood */
			animate.add(ImageIO.read(new File("img/imgres.png")));
			
			/** 4 background stone */
			animate.add(ImageIO.read(new File("img/imgres.png")));
			
			/** 5 background grass */
			animate.add(ImageIO.read(new File("img/imgres.png")));
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

	public Block(int i, boolean fore, int startx, int starty)
	{
		load();
		type = i;
		foreground = fore;
		x = startx;
		y = starty;
		print(i);
		x2 = x+display.getWidth();
		y2 = y+display.getHeight();
		Ground.add(this);
	}
	
	public boolean isCollide()
	{	return foreground; }
	
	public void print(int i)
	{
		if (i == 0)
			display = animate.get(0);
		else if (i == 1)
			display = animate.get(0);
		else if (i == 2)
			display = animate.get(0);
		else if (i == 3)
			display = animate.get(0);
		else if (i == 4)
			display = animate.get(0);
		else if (i == 5)
			display = animate.get(0);
	}
	
	public void draw(Graphics g)
	{
		g.drawImage(display, x, y, null);
	}
	
	
	
}
