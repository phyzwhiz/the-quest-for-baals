package game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprite {
	
	private int speed = 6;
	private static int x;
	static int y;
	BufferedImage sprite;
	private boolean halfspeed = false;	
	

	public Sprite(int startx, int starty)  {
		x = startx;
		y = starty;
		try {
			sprite = ImageIO.read(new File("/Users/90307015/Desktop/imgres.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void crouch() 
	{	halfspeed = true; }
	
	public void stand() 
	{	halfspeed = false; }

	public void jump(int i) 
	{	
		if (i > 4)
			y -= 25;
		else if (i > 2)
			y -= 15;
		else if (i > 0)
			y -= 5;
		else 
			fall(i);
	}
	
	public void fall(int i) {
		if (isTouch() == false)
			y += 25;
	}

	public void left() {
		if (halfspeed) 
			x -= speed/4;
		else 
			x -= speed;
	}

	public void right() {
		if (halfspeed) 
			x += speed/4;
		else 
			x += speed;
	}
	
	public boolean isTouch(){
		if (y < 400 && y > 300)
			return true;
		return false;
	}
	
	public void draw(Graphics g) {		
		g.drawImage(sprite, x, y, null);
	}

}
