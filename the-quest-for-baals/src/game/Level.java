package game;

import java.util.ArrayList;

public class Level {
    
    public Level(int i) {
        Ground.clear();
        if(i == 1)
            constructOne();
        //Ground.enemy.add(new Melee(500, 500));
    }
    
    public void constructOne() {
    
    }
    
    public ArrayList<Block> getGroundList() {
        return Ground.getGroundList();
    }
    
}
