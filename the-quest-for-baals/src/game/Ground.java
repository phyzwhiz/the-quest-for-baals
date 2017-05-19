package game;

import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;

public class Ground {
    
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
    public static void moveRight(boolean half, boolean level){
    	for(Block b: all){
    		b.right(half, level);
    	}
    }
    public static void moveLeft(boolean half, boolean level){
    	for(Block b: all){
    		b.left(half, level);
    	}
    }
    
}
