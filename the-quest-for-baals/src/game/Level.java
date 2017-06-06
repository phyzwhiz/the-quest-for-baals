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
       
        
        Ground.all.add(new Stone(100,0)); Ground.all.add(new Stone(100,100)); Ground.all.add(new Stone(100,200)); Ground.all.add(new Stone(100,300)); Ground.all.add(new Stone(100,400)); Ground.all.add(new Stone(100,600)); Ground.all.add(new Stone(100,500)); Ground.all.add(new Stone(200,600)); Ground.all.add(new Stone(300,600)); Ground.all.add(new Stone(400,600)); Ground.all.add(new Stone(500,600)); Ground.all.add(new Stone(600,600)); Ground.all.add(new Stone(700,600)); Ground.all.add(new Stone(800,600)); Ground.all.add(new Stone(900,600)); Ground.all.add(new Stone(1000,600)); Ground.all.add(new Stone(1100,600)); Ground.all.add(new Stone(1200,600)); Ground.all.add(new Stone(1100,600)); Ground.all.add(new Stone(1000,600)); Ground.all.add(new Stone(900,600)); Ground.all.add(new Stone(800,600)); Ground.all.add(new Stone(700,600)); Ground.all.add(new Stone(700,400)); Ground.all.add(new Stone(700,400));

        
        
        Ground.enemy.add(new Melee(200, -100));
    }
    
    public ArrayList<Block> getGroundList() {
        return Ground.getGroundList();
    }
    
}
