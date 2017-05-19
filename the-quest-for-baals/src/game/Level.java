package game;

import java.util.ArrayList;

public class Level {
    
    public Level(int i) {
        Ground.clear();
        if(i == 1)
            constructOne();
    }
    
    public void constructOne() {
<<<<<<< HEAD
        Ground.add(new Block(0, 100, 600));
        Ground.add(new Block(0, 200, 600));
        Ground.add(new Block(0, 300, 600));
        Ground.add(new Block(0, 300, 500));
        Ground.add(new Block(0, 400, 600));
        Ground.add(new Block(0, 500, 600));
        Ground.add(new Block(0, 600, 600));
        Ground.add(new Block(0, 700, 600));
        Ground.add(new Block(0, 1000, 600));
        Ground.add(new Block(0, 900, 400));
        Ground.add(new Block(0, 500, 200));
        Ground.enemy.add(new Melee(100, 100));
=======
>>>>>>> master
        
    }
    
    public ArrayList<Block> getGroundList() {
        return Ground.getGroundList();
    }
    
}
