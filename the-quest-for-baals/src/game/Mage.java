package game;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Mage extends Sprite {
    
    private ArrayList<BufferedImage> animate = new ArrayList<BufferedImage>();
    BufferedImage sprite;
    boolean lastmove = true;
    int feet;
    
    public Mage(int startx, int starty) {
        super(startx, starty, false);
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
            animate.add(ImageIO.read(new File("img/aaaaa.png")));
            animate.add(ImageIO.read(new File("img/aaaaa.png")));
            
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
            animate.add(ImageIO.read(new File("img/reddown.png")));
            animate.add(ImageIO.read(new File("img/reddown.png")));
            
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
    
    public void run(int fastswagger, boolean right, boolean left) {
        if(right) {
            sprite = animate.get(fastswagger);
            lastmove = true;
        }
        
        if(left) {
            sprite = animate.get(fastswagger + 8);
            lastmove = false;
        }
    }
    
    public void draw(Graphics g) {
        feet = Sprite.y + sprite.getHeight();
        g.drawImage(sprite, Sprite.x, Sprite.y, null);
    }
    
    public void swagger(boolean swagger) {
        if(lastmove)
            if(swagger)
                sprite = animate.get(50);
            else
                sprite = animate.get(52);
        else if(swagger)
            sprite = animate.get(51);
        else
            sprite = animate.get(53);
    }
    
    public void crouchSwag(boolean swagger) {
        if(lastmove)
            if(swagger)
                sprite = animate.get(54);
            else
                sprite = animate.get(55);
        else if(swagger)
            sprite = animate.get(56);
        else
            sprite = animate.get(57);
    }
    
    public void jumpSwag(int fastswagger) {
        if(lastmove)
            sprite = animate.get(fastswagger + 32);
        else
            sprite = animate.get(fastswagger + 40);
        if(fastswagger == 7) {
            game.jumpfin = true;
            game.fliptimer = 0;
        }
    }
    
    public void crouchRun(int fastswagger, boolean right, boolean left) {
        if(right)
            sprite = animate.get(fastswagger + 16);
        
        if(left)
            sprite = animate.get(fastswagger + 24);
    }
    
    public void fallSwag() {
        if(lastmove)
            sprite = animate.get(48);
        else
            sprite = animate.get(49);
    }
    
    public boolean isStand() {
        return false;
    }
    
    @Override
    public void drawMask(Graphics g) {
        // TODO Auto-generated method stub
        
    }
    
    @Override
    public void updateMask() {
        // TODO Auto-generated method stub
        
    }
    
    @Override
    public boolean awwDidYouHitAWallToYourRight() {
        // TODO Auto-generated method stub
        return false;
    }
    
    @Override
    public boolean areYouInsideABlock_QuestionMark() {
        // TODO Auto-generated method stub
        return false;
    }
    
    @Override
    public boolean awwDidYouHitAWallWithHead() {
        // TODO Auto-generated method stub
        return false;
    }
    
    @Override
    public boolean awwDidYouHitAWallToYourLeft() {
        // TODO Auto-generated method stub
        return false;
    }

	@Override
	public void damage() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isDead() {
		// TODO Auto-generated method stub
		return false;
	}
    
}
