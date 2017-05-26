package game;

import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;

public class Ground {

    
    static ArrayList<Block> all = new ArrayList<Block>();
	static ArrayList<Object> non = new ArrayList<Object>();
	static ArrayList<Enemy> enemy = new ArrayList<Enemy>();

    
    public Ground() {}
    
//    public static void add(Block block) {
//        all.add(block);
//    }
//    
//    public static void add(Enemy e) {
//        enemy.add(e);
//    }
    
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
    
    public static int removeAtPosition(int xPos, int y, int shift){
        for(int x = 0; x < all.size(); x++){
            if(all.get(x).getX()+shift==xPos&&all.get(x).getY()==y){
                all.remove(x);
                
            return x;
            }
        }
        return -1;
    }
    
}
