package game;

import java.awt.Graphics;
import java.awt.List;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Sprite {
	
	private int speed = 12;
	private static int x;
	static int y;
	BufferedImage sprite;
	private boolean halfspeed = false;
	private ArrayList<BufferedImage> animate = new ArrayList<BufferedImage>();
	
	private void loadImage() 
	{
		try
		{
				/**0-7 run right (0)*/
				animate.add(ImageIO.read(new File("img/rightrun0.png"))); 
				animate.add(ImageIO.read(new File("img/rightrun1.png"))); 
				animate.add(ImageIO.read(new File("img/rightrun2.png"))); 
				animate.add(ImageIO.read(new File("img/rightrun3.png"))); 
				animate.add(ImageIO.read(new File("img/rightrun4.png"))); 
				animate.add(ImageIO.read(new File("img/rightrun5.png"))); 
				animate.add(ImageIO.read(new File("img/rightrun6.png"))); 
				animate.add(ImageIO.read(new File("img/rightrun7.png"))); 
				
				/** 8-15 run left (+8)*/
				animate.add(ImageIO.read(new File("img/blue.png")));
				animate.add(ImageIO.read(new File("img/leftup.png")));
				animate.add(ImageIO.read(new File("img/leftdown.png")));
				animate.add(ImageIO.read(new File("img/bluedown.png")));
				animate.add(ImageIO.read(new File("img/reddown.png")));
				animate.add(ImageIO.read(new File("img/leftdown.png")));
				animate.add(ImageIO.read(new File("img/leftup.png")));
				animate.add(ImageIO.read(new File("img/red.png")));
				
				/** 16-23 crouch move right (+16) */
				animate.add(ImageIO.read(new File("img/a.png")));
				animate.add(ImageIO.read(new File("img/b.png")));
				animate.add(ImageIO.read(new File("img/c.png")));
				animate.add(ImageIO.read(new File("img/d.png")));
				animate.add(ImageIO.read(new File("img/e.png")));
				animate.add(ImageIO.read(new File("img/f.png")));
				animate.add(ImageIO.read(new File("img/g.png")));
				animate.add(ImageIO.read(new File("img/a.png")));
				
				/** 24-31 crouch move right (+24) */
				animate.add(ImageIO.read(new File("img/onedot.png")));
				animate.add(ImageIO.read(new File("img/twodot.png")));
				animate.add(ImageIO.read(new File("img/threedot.png")));
				animate.add(ImageIO.read(new File("img/fourdot.png")));
				animate.add(ImageIO.read(new File("img/fivedot.png")));
				animate.add(ImageIO.read(new File("img/sixdot.png")));
				animate.add(ImageIO.read(new File("img/sevendot.png")));
				animate.add(ImageIO.read(new File("img/onedot.png")));
				
				/** 32-39 jump (+32) */
				animate.add(ImageIO.read(new File("img/one.png")));
				animate.add(ImageIO.read(new File("img/two.png")));
				animate.add(ImageIO.read(new File("img/three.png")));
				animate.add(ImageIO.read(new File("img/four.png")));
				animate.add(ImageIO.read(new File("img/five.png")));
				animate.add(ImageIO.read(new File("img/six.png")));
				animate.add(ImageIO.read(new File("img/seven.png")));
				animate.add(ImageIO.read(new File("img/one.png")));
				
				/** 40 fall */
				animate.add(ImageIO.read(new File("img/aaaaa.png")));
				
				/** 41 upswagger */
				animate.add(ImageIO.read(new File("img/blue.png")));
				
				/** 42 downswagger */
				animate.add(ImageIO.read(new File("img/bluedown.png")));

				/** 43 crouch up swagger */
				animate.add(ImageIO.read(new File("img/red.png")));

				/** 44 crouch down swagger */
				animate.add(ImageIO.read(new File("img/reddown.png")));

		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	public Sprite(int startx, int starty)  {
		x = startx;
		y = starty;
		loadImage();
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
			sprite = animate.get(fastswagger);
		
		if (left)
			sprite = animate.get(fastswagger+8);
				
	}
	
	public void draw(Graphics g) {		
		g.drawImage(sprite, x, y, null);
	}

	public void swagger(boolean swagger, boolean right, boolean left) 
	{
			if (swagger && !right && !left)
				sprite = animate.get(41);
			else 
				sprite = animate.get(42);
	}
	
	public void crouchSwag(boolean swagger, boolean right, boolean left) 
	{
				if (swagger && !right && !left)
					sprite = animate.get(43);
				else 
					sprite = animate.get(44);
	}
	
	public void jumpSwag(int fastswagger)
	{
		sprite = animate.get(fastswagger+32);
		if (fastswagger == 7) {
			game.jumpfin = true;
			game.fliptimer = 0;
		}
	}

	public void crouchRun(int fastswagger, boolean right, boolean left) {
		if (right)
			sprite = animate.get(fastswagger+16);
		
		if (left)
			sprite = animate.get(fastswagger+24);
	}

	public void fallSwag() {
		sprite = animate.get(40);
	}

}
