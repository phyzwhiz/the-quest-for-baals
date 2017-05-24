package game;

import java.awt.Graphics;

public abstract class Enemy {
	
	public Enemy()
	{	Ground.non.add(this); }
	
	public abstract void load();
	public abstract void move(int player);
	public abstract void run(int fastswagger);
	public abstract void fall();
	public abstract boolean isStand();
	public abstract void draw(Graphics g);
	
	
	
}