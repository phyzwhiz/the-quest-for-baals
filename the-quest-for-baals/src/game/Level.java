package game;

import java.util.ArrayList;

public class Level {
    
    public Level(int i) {
        Ground.clear();
        if(i == 1)
            constructOne();
        // Ground.enemy.add(new Melee(500, 500));
    }
    
    public void constructOne() {
        Ground.all.add(new Lava(100, 600));
        Ground.all.add(new Lava(200, 600));
        Ground.all.add(new Lava(300, 600));
        Ground.all.add(new Lava(400, 600));
        Ground.all.add(new Lava(500, 600));
        Ground.all.add(new Lava(600, 600));
        Ground.all.add(new Lava(800, 600));
        Ground.all.add(new Lava(700, 600));
        Ground.all.add(new Lava(900, 600));
        Ground.all.add(new Lava(1000, 600));
        Ground.all.add(new Lava(1100, 600));
        Ground.all.add(new Lava(1200, 600));
        
        Ground.all.add(new Lava( 800, 400));
        
        Ground.enemy.add(new Melee(200, -100));
    }
    
    public ArrayList<Block> getGroundList() {
        return Ground.getGroundList();
    }
    
}
