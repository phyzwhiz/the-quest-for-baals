package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import javax.imageio.ImageIO;

public abstract class Block {
    
    // private int type;
    
   
	static int lastspeed = 0;

    
    public abstract void load();
        
    
    int x = 0;
    int y = 0;
    boolean ishurt;
    
    public Block(int x, int y) {
        Random rand = new Random();
       
        this.x = x;
        this.y = y;
        
    }
    
    public abstract void draw(Graphics g) throws IOException;
    	//g.fillRect(x, y, 10, 10);
       
        // g.fillRect(x, y, width, width);
    public abstract void spooky(int fastswagger);
   
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public void moveX() {
        x--;
    }
    
    public abstract int getMaxX();
    
    public abstract int getMaxY();
    
    public void right(boolean ha, boolean level){
//    	lastspeed += Sprite.speed;
//    	if (level)
//    		if (lastspeed%100 == 0)
//    		{
//    			lastspeed = 0;
//    			x-= 100;
//    		}else{}
//    	else
    	if (ha){
    		x-=Sprite.speed / 4;
            game.initialPosition.setLocation(game.initialPosition.getX()-Sprite.speed/4, game.initialPosition.getY());

    	}
    	else {
    		x-=Sprite.speed;
    		game.initialPosition.setLocation(game.initialPosition.getX()-Sprite.speed, game.initialPosition.getY());
    	}
    }
     
    public void left(boolean ha, boolean level){
//    	lastspeed += Sprite.speed;
//    	if (level)
//    		if (lastspeed%100 == 0)
//    		{
//    			lastspeed = 0;
//    			x+= 100;
//    		}
//    		else{}	
//    			
//    	else
    	if (ha){
    		x+=Sprite.speed / 4;
            game.initialPosition.setLocation(game.initialPosition.getX()-Sprite.speed/4, game.initialPosition.getY());

    	}
    	else {
    		x+=Sprite.speed;
            game.initialPosition.setLocation(game.initialPosition.getX()-Sprite.speed, game.initialPosition.getY());

    	}
    }
    
}
