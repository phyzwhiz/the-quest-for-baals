package game;

import java.awt.Rectangle;
import java.util.ArrayList;

import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Collide{
    
    
    public boolean shouldPlayerFall_QuestionMark(ArrayList<Rectangle> rect, Object obs) {
        int shift = 20;
        for(Rectangle Sprite11 : rect) {
            for(Block block : Ground.all) {
                if(((Sprite11.x >= block.getX()) && Sprite11.x < block.getMaxX() && Sprite11.y + shift > block.getY()
                        && Sprite11.y + shift < block.getMaxY())) {    
                   // if(game.left)
                     //   Sprite.y = block.getY() - 100;
                   
                    
                    return true;
                }
                
            }
        }
        
        return false;
    }
    
    public boolean shouldPlayerKeepGoingRight_QuestionMark(ArrayList<Rectangle> rect) {
        
        for(Rectangle Sprite1 : rect) {
            for(Block block : Ground.all) {
                
                if((Sprite1.getY() < block.getMaxY() && Sprite1.getY() > block.getY())
                        && (Sprite1.getX() + 20 > block.getX() && Sprite1.getX() + 20 < block.getMaxX())) {
                    
                    return true;
                }
                
            }
        }
        
        return false;
    }
    
    public boolean shouldPlayerKeepGoingUp_QuestionMark(ArrayList<Rectangle> rect) {
        
        for(Rectangle Sprite1 : rect) {
            for(Block block : Ground.all) {
                
                if(((Sprite1.x > block.getX() && Sprite1.x < block.getMaxX()) && Sprite1.y - 40 < block.getMaxY()
                        && Sprite1.y >= block.getY())) {
                    return true;
                }
                
            }
        }
        
        return false;
    }
    
    public boolean shouldPlayerKeepGoingLeft_QuestionMark(ArrayList<Rectangle> rect) {
        
        for(Rectangle Sprite1 : rect) {
            for(Block block : Ground.all) {
                
                if((Sprite1.getY() < block.getMaxY() && Sprite1.getY() > block.getY())
                        && (Sprite1.getX() - 15 > block.getX() && Sprite1.getX() - 15 < block.getMaxX())) {
                    return true;
                }
                
            }
        }
        
        return false;
    }
    
    public boolean areYouInsideABlock_QuestionMark(ArrayList<Rectangle> rect) {
        for(Rectangle Sprite1 : rect) {
            for(Block block : Ground.all) {
                
                if(Sprite1.getX() + 5 > block.getX() && Sprite1.getX() + 5 < block.getMaxX()
                        && Sprite1.getY() > block.getY() && Sprite1.getY() < block.getMaxY())
                    return true;
                
            }
            
        }
        return false;
    }
    
//    public boolean areYouHurt()
//    {
//    	for(/**all objects in game*/)
//    	{
//    		if (/**object is stabby stabby*/)
//    		{
//    			if (/**object does a touch*/)
//    			{
//    				return true;
//    			}
//    		}
//    	}
//    	
//    	return false;
//    }
    
}
