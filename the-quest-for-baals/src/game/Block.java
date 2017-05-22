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

public class Block {
    
    // private int type;
    
    private ArrayList<BufferedImage> animate = new ArrayList<BufferedImage>();
    BufferedImage display;
	static int lastspeed = 0;

    
    public void load() {
        try {
            /** 0 wood */
            animate.add(ImageIO.read(new File("img/stone1.png")));
            
            /** 1 stone */
            animate.add(ImageIO.read(new File("img/stone2.png")));
            
            /** 2 grass */
            animate.add(ImageIO.read(new File("img/stone1.png")));
            
            
            animate.add(ImageIO.read(new File("img/lavaBlock3.png")));
            
            animate.add(ImageIO.read(new File("img/lavaBlock1.png")));
            
            animate.add(ImageIO.read(new File("img/spikes2.png")));


            
            /**
             * 3 background wood animate.add(ImageIO.read(new
             * File("img/imgres.png")));
             *
             * 4 background stone animate.add(ImageIO.read(new
             * File("img/imgres.png")));
             *
             * 5 background grass animate.add(ImageIO.read(new
             * File("img/imgres.png")));
             */
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
    
    int x = 0;
    int y = 0;
    int width;
    
    public Block(int i, int x, int y) {
        Random rand = new Random();
        load();
        display = animate.get(rand.nextInt(animate.size()));
        this.x = x;
        this.y = y;
        
        width = display.getWidth();
        load();
        
    }
    
    public void draw(Graphics g) throws IOException {
    	//g.fillRect(x, y, 10, 10);
        g.drawImage(display, x, y, null);
        // g.fillRect(x, y, width, width);
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public void moveX() {
        x--;
    }
    
    public int getMaxX() {
        return x + width;
    }
    
    public int getMaxY() {
        return y + width;
    }
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
