package game;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class Baal {
    private int x;
    private int y;
    private int dy;
    Random ranx = new Random();
    private int dx;
    int id;
    
    public Baal(int id) {
        this.id = id;
        x = ranx.nextInt(600);
        y = ranx.nextInt(600);
        int w = ranx.nextInt(5) + 1;
        int u = ranx.nextInt(5) + 1;
        if(w % 2 == 0) {
            dx = w;
        }
        else {
            dx = -w;
        }
        if(u % 2 == 0) {
            dy = -u;
        }
        else {
            dy = u;
        }
        
    }
    
    public void increment() {
        x += dx;
        y += dy;
    }
    
    public void checkHit(ArrayList<Baal> b) {
        for(Baal ball : b) {
            for(Baal ball2 : b) {
                if(ball.getID()!=ball2.getID()){
                if(ball.calculateDistance(ball2)<=15&&ball.calculateDistance(ball2)>0){
                    this.baal2BaalHit();
                    ball2.baal2BaalHit();
                }
                }
            }
        }
    }
    
    public void setDir(int width, int height) {
        if(x >= width)
            dx *= -1;
        
        if(y >= height)
            dy *= -1;
        
        if(x <= 0)
            dx *= -1;
        
        if(y <= 0)
            dy *= -1;
    }
    
    public void baal2BaalHit() {
        
        dx *= -1;
        
        dy *= -1;
        
    }
    
    public void draw(Graphics g) {
        // g.setColor(new Color(ranx.nextInt(255), ranx.nextInt(255),
        // ranx.nextInt(255)));
        g.fillOval(x, y, 15, 15);
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public double calculateDistance(Baal other) {
        return Math.sqrt(Math.pow((this.getX() - other.getX()), 2) + Math.pow((this.getY() - other.getY()), 2));
    }
    
    public int getID(){
        return id;
    }
}
