package game;

import java.awt.Graphics;
import java.util.ArrayList;

public class Ground {
	
	static ArrayList<Block> all = new ArrayList<Block>();
	
	public Ground()
	{}
	
	public static void add(Block block)
	{	all.add(block); }
	
	public static void clear()
	{	all.clear(); }
	
	public static void draw(Graphics g)
	{
		for(Block block : all)
			block.draw(g);
	}
	
}
