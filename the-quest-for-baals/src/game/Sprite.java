package game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprite {
	
	private int speed = 10;
	private static int x;
	static int y;
	BufferedImage sprite;
	private boolean halfspeed = false;	
	

	public Sprite(int startx, int starty)  {
		x = startx;
		y = starty;
		try {
			sprite = ImageIO.read(new File("img/imgres.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void crouch() 
	{	
		halfspeed = true; 
		try {
			sprite = ImageIO.read(new File("img/aaaaa.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void stand() 
	{	
		halfspeed = false; 
		try {
			sprite = ImageIO.read(new File("img/imgres.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

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
	
	public boolean isTouch()
	{
		if (y < 400 && y > 300)
			return true;
		return false;
	}
	
	public void run (boolean fastswagger, boolean right, boolean left) 
	{	
		if (right)
			if (fastswagger)
				try {
					sprite = ImageIO.read(new File("img/rightup.png"));
				} catch (IOException e) {
					e.printStackTrace();
				}
			else
				try {
					sprite = ImageIO.read(new File("img/rightdown.png"));
				} catch (IOException e) {
					e.printStackTrace();
				}
		
		if (left)
			if (fastswagger)
				try {
					sprite = ImageIO.read(new File("img/leftup.png"));
				} catch (IOException e) {
					e.printStackTrace();
				}
			else
				try {
					sprite = ImageIO.read(new File("img/leftdown.png"));
				} catch (IOException e) {
					e.printStackTrace();
				}
				
	}
	
	public void draw(Graphics g) {		
		g.drawImage(sprite, x, y, null);
	}

	public void swagger(boolean swagger, boolean right, boolean left) 
	{
			if (swagger && !right && !left)
				try {
					sprite = ImageIO.read(new File("img/blue.png"));
				} catch (IOException e) {
					e.printStackTrace();
				}
			else 
				try {
					sprite = ImageIO.read(new File("img/bluedown.png"));
				} catch (IOException e) {
					e.printStackTrace();
				}
	}
	
	public void crouchSwag(boolean swagger, boolean right, boolean left) 
	{
			if (swagger && !right && !left)
				try {
					sprite = ImageIO.read(new File("img/red.png"));
				} catch (IOException e) {
					e.printStackTrace();
				}
			else
				try {
					sprite = ImageIO.read(new File("img/reddown.png"));
				} catch (IOException e) {
					e.printStackTrace();
				}
	}
	
	public void jumpSwag()
	{
			try {
				sprite = ImageIO.read(new File("img/imgres.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
	}

	public void crouchRun(boolean fastswagger, boolean right, boolean left) {
		
	}

	public void fallSwag() {
		try {
			sprite = ImageIO.read(new File("img/aaaaa.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
