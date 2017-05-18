package game;

import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;

public class Ground {
<<<<<<< HEAD
	
	static ArrayList<Block> all = new ArrayList<Block>();
	static ArrayList<Object> non = new ArrayList<Object>();
	
	public Ground()
	{}
	
	public static void add(Block block)
	{	all.add(block); }
	
	public static void clear()
	{	all.clear(); }
	
	public static void draw(Graphics g)
	{
		for(Block block : all)
			try {
				block.draw(g);
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
=======
    
    static ArrayList<Block> all = new ArrayList<Block>();
    
    public Ground() {}
    
    public static void add(Block block) {
        all.add(block);
    }
    
    public static void clear() {
        all.clear();
    }
    
    public static void draw(Graphics g) {
        for(Block block : all)
            try {
                block.draw(g);
            }
            catch(IOException e) {
                e.printStackTrace();
            }
    }
    
    public static ArrayList<Block> getGroundList() {
        return all;
    }
    
>>>>>>> master
}
