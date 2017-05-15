package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import javax.imageio.ImageIO;

public class Block {
	
	private int type;
	
	private ArrayList<BufferedImage> animate = new ArrayList<BufferedImage>();
	BufferedImage display;
	
	public void load()
	{
		try {
			/** 0 wood */
			animate.add(ImageIO.read(new File("img/imgres.png")));
			
			/** 1 stone */
			animate.add(ImageIO.read(new File("img/imgres.png")));
			
			/** 2 grass */
			animate.add(ImageIO.read(new File("img/imgres.png")));

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
    private int id;
     
    public Block(int i, int x, int y) {
        load();
        display = animate.get(i);
        this.x = x;
        this.y = y;
        width = display.getWidth();        
        load();
         
    }
     
    public String toString() {
        return " id = " + id;
    }
     
    public void draw(Graphics g) throws IOException {
 
        g.setColor(Color.RED);
        g.drawImage(display, x, y, null);
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
