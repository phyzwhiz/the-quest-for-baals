package game;

import java.awt.Rectangle;
import java.util.ArrayList;

public class Collide extends game{
    
    static int blockId;
    
    public boolean shouldPlayerFall_QuestionMark(ArrayList<Rectangle> rect) {
        int shift = 20;
        for(Rectangle Sprite : rect) {
            for(Block block : Ground.all) {
                if(((Sprite.x >= block.getX()) && Sprite.x < block.getMaxX() && Sprite.y + shift > block.getY()
                        && Sprite.y + shift < block.getMaxY())) {
                    blockId = block.getID();
                    return true;
                }
                
            }
        }
        
        return false;
    }
    
    public boolean shouldPlayerKeepGoingRight_QuestionMark(ArrayList<Rectangle> rect) {
        
        for(Rectangle Sprite : rect) {
            for(Block block : Ground.all) {
                
                if((Sprite.getY() < block.getMaxY() && Sprite.getY() > block.getY())
                        && (Sprite.getX() +20  > block.getX() && Sprite.getX() +20 < block.getMaxX())) {
                    blockId = block.getID();
                    return true;
                }
                
            }
        }
        
        return false;
    }
    
   public boolean shouldPlayerKeepGoingUp_QuestionMark(ArrayList<Rectangle> rect) {
        
        for(Rectangle Sprite : rect) {
            for(Block block : Ground.all) {
                
                if(((Sprite.x >= block.getX() && Sprite.x < block.getMaxX()) && Sprite.y -40 < block.getMaxY() && Sprite.y >= block.getY()
                       )) {
                    blockId = block.getID();
                    return true;
                }
                
            
                
            }
        }
        
        return false;
    }
   
   public boolean shouldPlayerKeepGoingLeft_QuestionMark(ArrayList<Rectangle> rect) {
       
       for(Rectangle Sprite : rect) {
           for(Block block : Ground.all) {
               
               if((Sprite.getY() < block.getMaxY() && Sprite.getY() > block.getY())
                       && (Sprite.getX() - 15  > block.getX() && Sprite.getX() - 15  < block.getMaxX())) {
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
        for(Rectangle Sprite : rect) {
            for(Block block : Ground.all) {
                
                if(Sprite.getX() + 5 > block.getX() && Sprite.getX() + 5 < block.getMaxX()
                        && Sprite.getY() > block.getY() && Sprite.getY() < block.getMaxY())
                    return true;
                
            }
            
        }
        return false;
    }
    
}
