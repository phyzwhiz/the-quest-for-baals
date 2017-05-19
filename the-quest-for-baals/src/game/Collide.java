package game;

import java.awt.Rectangle;
import java.util.ArrayList;

import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Collide extends game {
    
    static int blockId;
    
    public boolean shouldPlayerFall_QuestionMark(ArrayList<Rectangle> rect) {
        int shift = 20;
        for(Rectangle Sprite11 : rect) {
            for(Block block : Ground.all) {
                if(((Sprite11.x >= block.getX()) && Sprite11.x < block.getMaxX() && Sprite11.y + shift > block.getY()
                        && Sprite11.y + shift < block.getMaxY())) {
                    blockId = block.getID();
                    
                    if(game.left)
                        Sprite.y = block.getY() - 100;
                    
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
                    blockId = block.getID();
                    
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
                    blockId = block.getID();
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
                    blockId = block.getID();
                    return true;
                }
                
            }
        }
        
        return false;
    }
    
    public int getID() {
        return blockId;
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
    
}
