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
	
	//private int type;
    static AtomicInteger nextId = new AtomicInteger();
    private int id;
	
	private ArrayList<BufferedImage> animate = new ArrayList<BufferedImage>();
	BufferedImage display;
	
	public void load()
	{
		try {
			/** 0 wood */
			animate.add(ImageIO.read(new File("/Users/64009455/Desktop/stone3.png")));
			
			/** 1 stone */
			animate.add(ImageIO.read(new File("/Users/64009455/Desktop/stone2.png")));
			
			/** 2 grass */
			animate.add(ImageIO.read(new File("/Users/64009455/Desktop/stone1.png")));

			/** 3 background wood 
			*animate.add(ImageIO.read(new File("img/imgres.png")));
			*
			* 4 background stone 
			*animate.add(ImageIO.read(new File("img/imgres.png")));
			*
			* 5 background grass 
			*animate.add(ImageIO.read(new File("img/imgres.png")));
			*/
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	int x = 0;
    int y = 0;
    int width;
 
     
    public Block(int i, int x, int y) {
        Random rand = new Random();
        id = nextId.incrementAndGet();
        load();
        display = animate.get(rand.nextInt(animate.size()));
        this.x = x;
        this.y = y;
        
        width = display.getWidth();        
        load();
         
    }
     
    public String toString() {
        return " id = " + id;
    }
    
    public int getID(){
        return id;
    }
     
    public void draw(Graphics g) throws IOException {
 
        g.drawString(""+toString(), x, y);
       g.drawImage(display, x, y, null);
        //g.fillRect(x, y, width, width);
    }
     
    public int getX() {
        return x;
    }
     
    public int getY() {
        return y;
    }
     
    public void moveX(){
        x--;
    }
     
    public int getMaxX() {
        return x + width;
    }
     
    public int getMaxY() {
        return y + width;
    }
   
	
	
	
}
