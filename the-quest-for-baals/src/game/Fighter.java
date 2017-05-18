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

public class Fighter extends Sprite {
    
    private ArrayList<BufferedImage> animate = new ArrayList<BufferedImage>();
    private ArrayList<Rectangle> currentList = new ArrayList<Rectangle>();
    private ArrayList<ArrayList<Point>> ArrayListOfArrayListOfPoints = new ArrayList<ArrayList<Point>>();
    private ArrayList<ArrayList<Rectangle>> mask = new ArrayList<ArrayList<Rectangle>>();
    BufferedImage sprite;
    boolean lastmove = true;
    int feet;
    
    static Collide collsionCheck = new Collide();
    
    public Fighter(int startx, int starty) {
        super(startx, starty);
        load();
    }
    
    @Override
    public void attack() {
        
    }
    
    @Override
    public void load() {
        try {
            /** 0-7 run right (0) */
            animate.add(ImageIO.read(new File("img/rightrun7.png")));
            
            animate.add(ImageIO.read(new File("img/rightrun6.png")));
            animate.add(ImageIO.read(new File("img/rightrun5.png")));
            animate.add(ImageIO.read(new File("img/rightrun4.png")));
            animate.add(ImageIO.read(new File("img/rightrun3.png")));
            animate.add(ImageIO.read(new File("img/rightrun2.png")));
            animate.add(ImageIO.read(new File("img/rightrun1.png")));
            animate.add(ImageIO.read(new File("img/rightrun0.png")));
            
            /** 8-15 run left (+8) */
            animate.add(ImageIO.read(new File("img/leftrun0.png")));
            animate.add(ImageIO.read(new File("img/leftrun1.png")));
            animate.add(ImageIO.read(new File("img/leftrun2.png")));
            animate.add(ImageIO.read(new File("img/leftrun3.png")));
            animate.add(ImageIO.read(new File("img/leftrun4.png")));
            animate.add(ImageIO.read(new File("img/leftrun5.png")));
            animate.add(ImageIO.read(new File("img/leftrun6.png")));
            animate.add(ImageIO.read(new File("img/leftrun7.png")));
            
            /** 16-23 crouch move right (+16) */
            animate.add(ImageIO.read(new File("img/a.png")));
            animate.add(ImageIO.read(new File("img/b.png")));
            animate.add(ImageIO.read(new File("img/c.png")));
            animate.add(ImageIO.read(new File("img/d.png")));
            animate.add(ImageIO.read(new File("img/e.png")));
            animate.add(ImageIO.read(new File("img/f.png")));
            animate.add(ImageIO.read(new File("img/g.png")));
            animate.add(ImageIO.read(new File("img/a.png")));
            
            /** 24-31 crouch move right (+24) */
            animate.add(ImageIO.read(new File("img/onedot.png")));
            animate.add(ImageIO.read(new File("img/twodot.png")));
            animate.add(ImageIO.read(new File("img/threedot.png")));
            animate.add(ImageIO.read(new File("img/fourdot.png")));
            animate.add(ImageIO.read(new File("img/fivedot.png")));
            animate.add(ImageIO.read(new File("img/sixdot.png")));
            animate.add(ImageIO.read(new File("img/sevendot.png")));
            animate.add(ImageIO.read(new File("img/onedot.png")));
            
            /** 32-39 jump right (+32) */
            animate.add(ImageIO.read(new File("img/one.png")));
            animate.add(ImageIO.read(new File("img/two.png")));
            animate.add(ImageIO.read(new File("img/three.png")));
            animate.add(ImageIO.read(new File("img/four.png")));
            animate.add(ImageIO.read(new File("img/five.png")));
            animate.add(ImageIO.read(new File("img/six.png")));
            animate.add(ImageIO.read(new File("img/seven.png")));
            animate.add(ImageIO.read(new File("img/one.png")));
            
            /** 40-47 jump left (+40) */
            animate.add(ImageIO.read(new File("img/one.png")));
            animate.add(ImageIO.read(new File("img/two.png")));
            animate.add(ImageIO.read(new File("img/three.png")));
            animate.add(ImageIO.read(new File("img/four.png")));
            animate.add(ImageIO.read(new File("img/five.png")));
            animate.add(ImageIO.read(new File("img/six.png")));
            animate.add(ImageIO.read(new File("img/seven.png")));
            animate.add(ImageIO.read(new File("img/one.png")));
            
            /** 48-49 fall right/left */
            animate.add(ImageIO.read(new File("img/ffallr.png")));
            animate.add(ImageIO.read(new File("img/ffalll.png")));
            
            /** 50-51 upswagger right/left */
            animate.add(ImageIO.read(new File("img/fusr.png")));
            animate.add(ImageIO.read(new File("img/fusl.png")));
            
            /** 52-53 downswagger right/left */
            animate.add(ImageIO.read(new File("img/fdsr.png")));
            animate.add(ImageIO.read(new File("img/fdsl.png")));
            
            /** 54-55 crouch up swagger right/left */
            animate.add(ImageIO.read(new File("img/red.png")));
            animate.add(ImageIO.read(new File("img/red.png")));
            
            /** 56-57 crouch down swagger right/left */
            animate.add(ImageIO.read(new File("img/red.png")));
            animate.add(ImageIO.read(new File("img/reddown.png")));

            for(BufferedImage img : animate){
                maskCreator(img);
            }
            
//            for(int i = 0; i<animate.size();i++) {
//                maskCreator(animate.get(animate.size()-1));
//            }
            
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
    
    public void run(int fastswagger, boolean right, boolean left) {
        if(right) {
            sprite = animate.get(fastswagger);
            lastmove = true;
            currentList = mask.get(fastswagger);
            
        }
        
        if(left) {
            sprite = animate.get(fastswagger + 8);
            currentList = mask.get(fastswagger + 8);
            
            lastmove = false;
        }
    }
    
    public void draw(Graphics g) {
        feet = Sprite.y + sprite.getHeight();
        g.drawImage(sprite, Sprite.x, Sprite.y, null);
    }
    
    public void swagger(boolean swagger) {
        if(lastmove)
            if(swagger) {
                sprite = animate.get(50);
                currentList = mask.get(50);
                
            }
            else {
                sprite = animate.get(52);
                currentList = mask.get(52);
                
            }
        else if(swagger) {
            sprite = animate.get(51);
            currentList = mask.get(51);
            
        }
        else {
            sprite = animate.get(53);
            currentList = mask.get(53);
            
        }
    }
    
    public void crouchSwag(boolean swagger) {
        if(lastmove)
            if(swagger) {
                sprite = animate.get(54);
                currentList = mask.get(54);
                
            }
            else {
                sprite = animate.get(55);
                currentList = mask.get(55);
                
            }
        else if(swagger) {
            sprite = animate.get(56);
            currentList = mask.get(56);
            
        }
        else {
            sprite = animate.get(57);
            currentList = mask.get(57);
            
        }
    }
    
    public void jumpSwag(int fastswagger) {
        if(lastmove) {
            currentList = mask.get(fastswagger + 32);
            
            sprite = animate.get(fastswagger + 32);
        }
        else {
            sprite = animate.get(fastswagger + 40);
            currentList = mask.get(fastswagger + 40);
            
        }
        if(fastswagger == 7) {
            
            game.jumpfin = true;
            game.fliptimer = 0;
        }
    }
    
    public void crouchRun(int fastswagger, boolean right, boolean left) {
        if(right)
            sprite = animate.get(fastswagger + 16);
        
        if(left) {
            sprite = animate.get(fastswagger + 24);
            currentList = mask.get(fastswagger + 24);
            
        }
    }
    
    public void fallSwag() {
        if(lastmove) {
            sprite = animate.get(48);
            currentList = mask.get(48);
            
        }
        else {
            sprite = animate.get(49);
            currentList = mask.get(49);
        }
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
                // g2.setColor(Color.GREEN);
                
                // g2.draw(mask.get(i));
            }
        }
        
    }
    
    public boolean isStand() {
        return collsionCheck.shouldPlayerFall_QuestionMark(currentList);
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
                    
                     if((i+1<100 && img.getRGB(i+1, j) == 0 )|| (i-1>=0&&
                     img.getRGB(i-1, j) == 0)
                    
                    
                     || ((i+1<100&&j+1<100)&&img.getRGB(i+1, j+1) == 0)
                    
                     || ((i-1>=0&&j-1>=0)&&img.getRGB(i-1, j-1) == 0)
                    
                     || (i==99||i==0||j==0||j==99)
                    
                     ){
                    
                        // if(j>90){
                    temporaryALRectangle.add(new Rectangle(i, j, 1, 1));
                    
                    temporaryALPoint.add(new Point(i, j));
                     //    }
                }
            }
        
         }
       
        mask.add(temporaryALRectangle);
        ArrayListOfArrayListOfPoints.add(temporaryALPoint);
    }
    
    @Override
    public boolean awwDidYouHitAWallToYourRight() {
        
        return !collsionCheck.shouldPlayerKeepGoingRight_QuestionMark(currentList);
    }
    
    @Override
    public boolean areYouInsideABlock_QuestionMark() {
        return collsionCheck.areYouInsideABlock_QuestionMark(currentList);
    }

    @Override
    public boolean awwDidYouHitAWallWithHead() {
        return !collsionCheck.shouldPlayerKeepGoingUp_QuestionMark(currentList);
    }

    @Override
    public boolean awwDidYouHitAWallToYourLeft() {
        return !collsionCheck.shouldPlayerKeepGoingLeft_QuestionMark(currentList);

    }
    
}
