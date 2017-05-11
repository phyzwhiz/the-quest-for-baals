package game;

import java.awt.Graphics;

public abstract class Sprite {
	
	private int speed = 12;
	static int x;
	static int y;
	private boolean halfspeed = false;
	
	
	public Sprite(int startx, int starty)  {
		x = startx;
		y = starty;
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
	
	public boolean isTouch()
	{
		if (y < 400 && y > 300)
			return true;
		return false;
	}
	
	public abstract void run (int fastswagger, boolean right, boolean left);
	
	public abstract void draw(Graphics g); 

	public abstract void swagger(boolean swagger, boolean right, boolean left);
	
	public abstract void crouchSwag(boolean swagger, boolean right, boolean left);
	
	public abstract void jumpSwag(int fastswagger);

	public abstract void crouchRun(int fastswagger, boolean right, boolean left);

	public abstract void fallSwag(); 
	
	public abstract void attack();
	
	public abstract void load();

}
