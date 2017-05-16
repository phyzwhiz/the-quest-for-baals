package game;

import java.awt.Rectangle;
import java.util.ArrayList;

public class Collide {
    
   static int blockId;
    
    /**
     * methods needed
     * 
     * 
     * --make the names better than this pls kthx
     * 
     * is standing on -- for players and enemies that stand on ground
     * 
     * @param none
     * 
     *            ex. public boolean isStand() {} and public boolean isBonk() {}
     *            [ for hitting head on block]
     * 
     *            is hitting wall -- for players and enemies if they are hitting
     *            a wall
     * @param none
     *            ex. public boolean isWall(){}
     * 
     *            is hit -- for attacks if an enemy or player is hit by one
     * @param object
     *            for attack or player or some shit ex. public boolean
     *            isHit(Object threat) {}
     * 
     * 
     * 
     * 
     */
    
    public boolean shouldPlayerFall_QuestionMark(ArrayList<Rectangle> rect) {
        int shift = 10;
        for(Rectangle Sprite: rect){
        for(Block block : Ground.all) {
            if(((Sprite.x  >= block.getX()) && Sprite.x  < block.getMaxX() && Sprite.y +shift > block.getY()
                    && Sprite.y +shift < block.getMaxY())){
                blockId = block.getID();
                return true;
            }
            
        }
        }
        
        return false;
    }
    
    

    public boolean shouldPlayerKeepGoingRight_QuestionMark(ArrayList<Rectangle> rect) {
        int shift = 10;
        for(Rectangle Sprite: rect){
        for(Block block : Ground.all) {
            if(((Sprite.x  >= block.getX()) && Sprite.x  < block.getMaxX() && Sprite.y +shift > block.getY()
                    && Sprite.y +shift < block.getMaxY())){
                blockId = block.getID();
                return true;
            }
            
        }
        }
        
        return false;
    }
    
    
    public int getID(){
        return blockId;
    }
    
}
