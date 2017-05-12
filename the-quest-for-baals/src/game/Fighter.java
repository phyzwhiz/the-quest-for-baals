package game;

import static game.Sprite.x;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Fighter extends Sprite {

	private ArrayList<BufferedImage> animate = new ArrayList<BufferedImage>();
	BufferedImage sprite;
	boolean lastmove = true;

	public Fighter(int startx, int starty) {
		super(startx, starty);
		load();
	}

	@Override
	public void attack() {
		
	}

	@Override
	public void load() 
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
				animate.add(ImageIO.read(new File("img/leftrun0.png")));
				animate.add(ImageIO.read(new File("img/leftrun1.png")));
				animate.add(ImageIO.read(new File("img/leftrun2.png")));
				animate.add(ImageIO.read(new File("img/leftrun3.png")));
				animate.add(ImageIO.read(new File("img/leftrun4.png")));
				animate.add(ImageIO.read(new File("img/leftrun5.png")));
				animate.add(ImageIO.read(new File("img/leftrun6.png")));
				animate.add(ImageIO.read(new File("img/leftrun7.png")));
				
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
				
				/** 41-42 upswagger right/left */
				animate.add(ImageIO.read(new File("img/fusr.png")));
				animate.add(ImageIO.read(new File("img/fusl.png")));
				
				/** 43-44 downswagger right/left */
				animate.add(ImageIO.read(new File("img/fdsr.png")));
				animate.add(ImageIO.read(new File("img/fdsl.png")));

				/** 45-46 crouch up swagger right/left */
				animate.add(ImageIO.read(new File("img/red.png")));
				animate.add(ImageIO.read(new File("img/red.png")));

				/** 47-48 crouch down swagger right/left */
				animate.add(ImageIO.read(new File("img/reddown.png")));
				animate.add(ImageIO.read(new File("img/reddown.png")));
				
				

		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void run(int fastswagger, boolean right, boolean left) 
	{	
		if (right)
		{
			sprite = animate.get(fastswagger);
			lastmove = true;
		}
		
		if (left)
		{
			sprite = animate.get(fastswagger+8);
			lastmove = false;
		}
	}
	
	public void draw(Graphics g) {		
		g.drawImage(sprite, Sprite.x, Sprite.y, null);
	}

	public void swagger(boolean swagger, boolean right, boolean left) 
	{
		if (lastmove)
			if (swagger && !right && !left)
				sprite = animate.get(41);
			else 
				sprite = animate.get(43);
	else 
		if (swagger && !right && !left)
			sprite = animate.get(42);
		else 
			sprite = animate.get(44);
	}
	
	public void crouchSwag(boolean swagger, boolean right, boolean left) 
	{
		if (lastmove)
				if (swagger && !right && !left)
					sprite = animate.get(45);
				else 
					sprite = animate.get(47);
		else 
			if (swagger && !right && !left)
				sprite = animate.get(46);
			else 
				sprite = animate.get(48);
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

	public void fallSwag() 
	{	sprite = animate.get(40); }

}
