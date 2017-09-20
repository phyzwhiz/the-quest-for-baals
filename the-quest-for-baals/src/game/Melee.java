package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
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
    BufferedImage display;
    private ArrayList<Rectangle> currentList = new ArrayList<Rectangle>();
    private ArrayList<ArrayList<Point>> ArrayListOfArrayListOfPoints = new ArrayList<ArrayList<Point>>();
    private ArrayList<ArrayList<Rectangle>> mask = new ArrayList<ArrayList<Rectangle>>();
    private Collide collsionCheck = new Collide();
    private int feet;
    private boolean lastmove;
    static int jumpCount = 0;
    boolean dead;

    
    public Melee(int startx, int starty) {
        super();
        load();
        x = startx;
        y = starty;
        health = 3;
    }
    
    public void load() {
        try {
            /** 0-7 move right (0) */
            animate.add(ImageIO.read(new File("img/rightrun7.png")));
            animate.add(ImageIO.read(new File("img/rightrun6.png")));
            animate.add(ImageIO.read(new File("img/rightrun5.png")));
            animate.add(ImageIO.read(new File("img/rightrun4.png")));
            animate.add(ImageIO.read(new File("img/rightrun3.png")));
            animate.add(ImageIO.read(new File("img/rightrun2.png")));
            animate.add(ImageIO.read(new File("img/rightrun1.png")));
            animate.add(ImageIO.read(new File("img/rightrun0.png")));
            
            /** 8-15 move left (+8) */
            animate.add(ImageIO.read(new File("img/leftrun0.png")));
            animate.add(ImageIO.read(new File("img/leftrun1.png")));
            animate.add(ImageIO.read(new File("img/leftrun2.png")));
            animate.add(ImageIO.read(new File("img/leftrun3.png")));
            animate.add(ImageIO.read(new File("img/leftrun4.png")));
            animate.add(ImageIO.read(new File("img/leftrun5.png")));
            animate.add(ImageIO.read(new File("img/leftrun6.png")));
            animate.add(ImageIO.read(new File("img/leftrun7.png")));
            
            /** 16-23 attack (+16) */
            animate.add(ImageIO.read(new File("img/leftrun0.png")));
            animate.add(ImageIO.read(new File("img/leftrun1.png")));
            animate.add(ImageIO.read(new File("img/leftrun2.png")));
            animate.add(ImageIO.read(new File("img/leftrun3.png")));
            animate.add(ImageIO.read(new File("img/leftrun4.png")));
            animate.add(ImageIO.read(new File("img/leftrun5.png")));
            animate.add(ImageIO.read(new File("img/leftrun6.png")));
            animate.add(ImageIO.read(new File("img/leftrun7.png")));
            
            /** 24-25 fall right/left */
            animate.add(ImageIO.read(new File("img/ffallr.png")));
            animate.add(ImageIO.read(new File("img/ffalll.png")));
            
            for(BufferedImage img : animate) {
                maskCreator(img);
            }
            
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
    
    public void move(int player) {
        if(player < x)
            facing = false;
        else
            facing = true;
        if(!Sprite.level){
        if(facing) {
            if(awwDidYouHitAWallToYourRight())
                x += 5;
//            else
//                x -= 3;
        }
        else {
            if(awwDidYouHitAWallToYourLeft())
                x -= 5;
//            else
//                x += 3;
        }
     
     
        
        }
       
    }
    
    public void run(int fastswagger) {
        if(facing) {
            display = animate.get(fastswagger);
            lastmove = true;
            currentList = mask.get(fastswagger);
        }
        else {
            display = animate.get(fastswagger + 8);
            currentList = mask.get(fastswagger + 8);
            lastmove = false;
        }
        
    }
    
    public void fall() {
        if(!isStand() && jumpCount <= 0)
            y += 25;
       
    }
    
    public void jump() 
    {
//    	jumpCount = 12;
//    	if(awwDidYouHitAWallToYourRight() || awwDidYouHitAWallToYourLeft())
//    		if (jumpCount > 0)
//    		{
//    			y-=25;
//    			jumpCount--;
//    		}
    		
    		
    }
    
    public void updateMask() {
        for(int j = 0; j < mask.size(); j++) {
            for(int i = 0; i < mask.get(j).size(); i++) {
                for(Block block : Ground.all) {
                    if(!(mask.get(j).get(i).getX() + x > block.getX() && mask.get(j).get(i).getX() + x < block.getMaxX()
                            && mask.get(j).get(i).getY() + y > block.getY()
                            && mask.get(j).get(i).getY() + y < block.getMaxY()))
                        
                        mask.get(j).get(i).setBounds((int) ArrayListOfArrayListOfPoints.get(j).get(i).getX() + x,
                                (int) ArrayListOfArrayListOfPoints.get(j).get(i).getY() + y, 1, 1);
                }
               
            }
        }
        
    }
    
    public boolean isStand() {
        return collsionCheck.shouldPlayerFall_QuestionMark(currentList, this);
    }
    
    public void drawMask(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        int x = 0;
        for(Rectangle rekt : currentList) {
            g2.setColor(new Color(20, 20, 20));
            g2.draw(rekt);
        }
        
    }
    
    public void maskCreator(BufferedImage img) {
        ArrayList<Rectangle> temporaryALRectangle = new ArrayList<Rectangle>();
        ArrayList<Point> temporaryALPoint = new ArrayList<Point>();
        
        for(int i = 0; i < img.getWidth(); i++)
            for(int j = 0; j < img.getHeight(); j++) {
                if(img.getRGB(i, j) != 0) {
                    
                    if((i + 1 < 100 && img.getRGB(i + 1, j) == 0) || (i - 1 >= 0 && img.getRGB(i - 1, j) == 0)
                            
                            || ((i + 1 < 100 && j + 1 < 100) && img.getRGB(i + 1, j + 1) == 0)
                            
                            || ((i - 1 >= 0 && j - 1 >= 0) && img.getRGB(i - 1, j - 1) == 0)
                            
                            || (i == 99 || i == 0 || j == 0 || j == 99)
                    
                    ) {
                        
                        // if(j>90){
                        temporaryALRectangle.add(new Rectangle(i, j, 1, 1));
                        
                        temporaryALPoint.add(new Point(i, j));
                        // }
                    }
                }
                
            }
        
        mask.add(temporaryALRectangle);
        ArrayListOfArrayListOfPoints.add(temporaryALPoint);
    }
    

    
    public void draw(Graphics g) {
        feet = x + display.getHeight();
        g.drawImage(display, x, y, null);
    }
    
    public boolean awwDidYouHitAWallToYourRight() {
        
        return !collsionCheck.shouldPlayerKeepGoingRight_QuestionMark(currentList);
    }
    
    public boolean areYouInsideABlock_QuestionMark() {
        return collsionCheck.areYouInsideABlock_QuestionMark(currentList);
    }
    
    public boolean awwDidYouHitAWallWithHead() {
        return !collsionCheck.shouldPlayerKeepGoingUp_QuestionMark(currentList);
    }
    
    public boolean awwDidYouHitAWallToYourLeft() {
        return !collsionCheck.shouldPlayerKeepGoingLeft_QuestionMark(currentList);
        
    }
    
    @Override
    public void setX(int y) {
        x = y;
        
    }
    
    @Override
    public int getX() {
        return x;
        
    }
    
    public void damage()
    {
    	dead = true;
    }

	
    
}
