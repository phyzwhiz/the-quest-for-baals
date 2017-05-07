package game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprite {
	
	private int speed = 12;
	private static int x;
	static int y;
	BufferedImage sprite;
	private boolean halfspeed = false;	
	

	public Sprite(int startx, int starty)  {
		x = startx;
		y = starty;
		setPic("img/imgres.png");
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
	
	public void run (int fastswagger, boolean right, boolean left) 
	{	
		if (right)
			if (fastswagger == 0)
				setPic("img/blue.png");
			else if (fastswagger == 1)
				setPic("img/rightup.png");
			else if (fastswagger == 2)
				setPic("img/rightdown.png");
			else if (fastswagger == 3)
				setPic("img/bluedown.png");
			else if (fastswagger == 4)
				setPic("img/reddown.png");
			else if (fastswagger == 5)
				setPic("img/rightdown.png");
			else
				setPic("img/rightup.png");
		
		if (left)
			if (fastswagger == 0)
				setPic("img/blue.png");
			else if (fastswagger == 1)
				setPic("img/leftup.png");
			else if (fastswagger == 2)
				setPic("img/leftdown.png");
			else if (fastswagger == 3)
				setPic("img/bluedown.png");
			else if (fastswagger == 4)
				setPic("img/reddown.png");
			else if (fastswagger == 5)
				setPic("img/leftdown.png");
			else
				setPic("img/leftup.png");
				
	}
	
	public void draw(Graphics g) {		
		g.drawImage(sprite, x, y, null);
	}

	public void swagger(boolean swagger, boolean right, boolean left) 
	{
			if (swagger && !right && !left)
				setPic("img/blue.png");
			else 
				setPic("img/bluedown.png");
	}
	
	public void crouchSwag(boolean swagger, boolean right, boolean left) 
	{
				if (swagger && !right && !left)
					setPic("img/red.png");
				else 
					setPic("img/reddown.png");
	}
	
	public void jumpSwag(int fastswagger)
	{
		if (fastswagger == 0)
			setPic("img/one.png");
		else if (fastswagger == 1)
			setPic("img/two.png");
		else if (fastswagger == 2)
			setPic("img/three.png");
		else if (fastswagger == 3)
			setPic("img/four.png");
		else if (fastswagger == 4)
			setPic("img/five.png");
		else if (fastswagger == 5)
			setPic("img/six.png");
		else {
			setPic("img/seven.png");
			game.jumpfin = true;
			game.fliptimer = 0;
		}
	}

	public void crouchRun(int fastswagger, boolean right, boolean left) {
		if (right)
			if (fastswagger == 0)
				setPic("img/a.png");
			else if (fastswagger == 1)
				setPic("img/b.png");
			else if (fastswagger == 2)
				setPic("img/c.png");
			else if (fastswagger == 3)
				setPic("img/d.png");
			else if (fastswagger == 4)
				setPic("img/e.png");
			else if (fastswagger == 5)
				setPic("img/f.png");
			else
				setPic("img/g.png");
		if (left)
			if (fastswagger == 0)
				setPic("img/onedot.png");
			else if (fastswagger == 1)
				setPic("img/twodot.png");
			else if (fastswagger == 2)
				setPic("img/threedot.png");
			else if (fastswagger == 3)
				setPic("img/fourdot.png");
			else if (fastswagger == 4)
				setPic("img/fivedot.png");
			else if (fastswagger == 5)
				setPic("img/sixdot.png");
			else
				setPic("img/sevendot.png");
	}

	public void fallSwag() {
		setPic("img/aaaaa.png");
	}
	
	private void setPic(String name)
	{	
		try {
			sprite = ImageIO.read(new File(name));
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}

}
