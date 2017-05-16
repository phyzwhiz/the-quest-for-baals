package game;

import java.awt.Graphics;

public abstract class Sprite {

    private int speed = 10;
	static int x;
	static int y;
	private boolean halfspeed = false;
	
	
	public Sprite(int startx, int starty)  {
		x = startx;
		y = starty;
	}
	
	public int getY(){
	    return y;
	}

	public void crouch()
	{	halfspeed = true; }
	
	public void stand()
	{	halfspeed = false; }

	public void jump(int i) 
	{	
		if (i > 0)
			y -= 25;
		else 
			fall();
	}
	
	public void fall() {
		if (!isStand())
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
	
	public void setY(int u) {
       y = u;
    }
	
	public abstract boolean isStand();
	
	public abstract void run (int fastswagger, boolean right, boolean left);
	
	public abstract void draw(Graphics g); 

	public abstract void swagger(boolean swagger);
	
	public abstract void crouchSwag(boolean swagger);
	
	public abstract void jumpSwag(int fastswagger);

	public abstract void crouchRun(int fastswagger, boolean right, boolean left);
	
	public abstract void drawMask(Graphics g);

	public abstract void fallSwag(); 
	
    public abstract void updateMask();

	
	public abstract void attack();
	
	public abstract void load();
	


}
