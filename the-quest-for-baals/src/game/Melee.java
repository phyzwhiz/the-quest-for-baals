package game;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Melee extends Enemy {
	
	int x;
	int y;
	int health;
	private ArrayList<BufferedImage> animate = new ArrayList<BufferedImage>();
	int attack;
	boolean facing;
	
	public Melee(int startx, int starty)
	{
		super();
		load();
		x = startx;
		y = starty;
		health = 3;
	}
	
	public void load()
	{
		try
		{
				/**0-7 move right (0)*/
				animate.add(ImageIO.read(new File("img/rightrun7.png"))); 
				animate.add(ImageIO.read(new File("img/rightrun6.png"))); 
				animate.add(ImageIO.read(new File("img/rightrun5.png"))); 
				animate.add(ImageIO.read(new File("img/rightrun4.png"))); 
				animate.add(ImageIO.read(new File("img/rightrun3.png"))); 
				animate.add(ImageIO.read(new File("img/rightrun2.png"))); 
				animate.add(ImageIO.read(new File("img/rightrun1.png"))); 
				animate.add(ImageIO.read(new File("img/rightrun0.png"))); 
				
				/** 8-15 move left (+8)*/
				animate.add(ImageIO.read(new File("img/leftrun0.png")));
				animate.add(ImageIO.read(new File("img/leftrun1.png")));
				animate.add(ImageIO.read(new File("img/leftrun2.png")));
				animate.add(ImageIO.read(new File("img/leftrun3.png")));
				animate.add(ImageIO.read(new File("img/leftrun4.png")));
				animate.add(ImageIO.read(new File("img/leftrun5.png")));
				animate.add(ImageIO.read(new File("img/leftrun6.png")));
				animate.add(ImageIO.read(new File("img/leftrun7.png")));
				
				/** 16-23 attack (+16)*/
				animate.add(ImageIO.read(new File("img/leftrun0.png")));
				animate.add(ImageIO.read(new File("img/leftrun1.png")));
				animate.add(ImageIO.read(new File("img/leftrun2.png")));
				animate.add(ImageIO.read(new File("img/leftrun3.png")));
				animate.add(ImageIO.read(new File("img/leftrun4.png")));
				animate.add(ImageIO.read(new File("img/leftrun5.png")));
				animate.add(ImageIO.read(new File("img/leftrun6.png")));
				animate.add(ImageIO.read(new File("img/leftrun7.png")));
				
				/** 24-25 fall right/left*/
				animate.add(ImageIO.read(new File("img/ffallr.png")));
				animate.add(ImageIO.read(new File("img/ffalll.png")));
				
				
				

		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void move(int player) 
	{
		if (player < x)
			facing = false;
		else 
			facing = true;
		
		if (facing)
			x += 15;
		else
			x -= 15;
			
	}
}
