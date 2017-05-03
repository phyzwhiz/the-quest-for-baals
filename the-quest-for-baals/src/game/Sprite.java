package game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprite {
	
	private int speed = 100;
	private int x;
	private int y;
	BufferedImage sprite;
	
	

	public Sprite(int startx, int starty)  {
		x = startx;
		y = starty;
		try {
			sprite = ImageIO.read(new File("/Users/90307015/Desktop/imgres.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void draw(Graphics g) {
		g.drawImage(sprite, x, y, null);
	}

	public void crouch(boolean right, boolean left) {
		if (right) 
			x -= 100;
		if (left)
			x += 100;
		
	}

	public void jump() {
		
	}

	public void left() {
		x -= 100;
	}

	public void right() {
		x += 100;
	}
	
}
