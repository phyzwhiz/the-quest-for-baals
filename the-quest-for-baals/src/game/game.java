package game;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class game extends JPanel implements ActionListener, KeyListener {
    
    public static void main(String[] args) throws IOException {
        @SuppressWarnings("unused")
        game run = new game("Game");
    }
    
    private static final long serialVersionUID = 1L;
    private static int delay = 30;
    protected Timer timer;
    Sprite player;
    static int xN = 0;
    static int yN = 0;
    static boolean right = false;
    static boolean left = false;
    static boolean crouch = false;
    static boolean jump = false;
    int jumpcount = 0;
    static int counter = 0;
    static boolean swagger = false;
    static int fastswagger = 0;
    static boolean jumpfin = true;
    static int fliptimer;
    Level level;
    int counter1 = 0;
    
    public game(String s) throws IOException {
        JFrame frame = new JFrame(s);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game bp = new game();
        frame.addKeyListener(this);
        frame.add(bp);
        frame.setSize(1366, 738);
        frame.setVisible(true);
    }
    
    public game() {
        
        level = new Level(1);
        timer = new Timer(delay, this);
        timer.start();
        player = new Fighter(300, 300);
        
    }
    
    @Override
    public synchronized void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_DOWN:
                crouch = true;
                jump = false;
                break;
            
            case KeyEvent.VK_UP:
                jump = true;
                break;
            
            case KeyEvent.VK_LEFT:
                left = true;
                break;
            
            case KeyEvent.VK_RIGHT:
               
                right = true;
                
                break;
        }
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }
    
    @Override
    public synchronized void keyReleased(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_DOWN:
                crouch = false;
                break;
            
            case KeyEvent.VK_UP:
                jump = false;
                break;
            
            case KeyEvent.VK_LEFT:
                left = false;
                break;
            
            case KeyEvent.VK_RIGHT:
                right = false;
                break;
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
    
    @SuppressWarnings("static-access")
    public void paintComponent(Graphics g) {
        
        if(!player.awwDidYouHitAWallToYourRight()) 
            right=false;
        
        if(!player.awwDidYouHitAWallToYourLeft()) 
            left=false;
        
        if(!player.awwDidYouHitAWallWithHead()) {
            player.fall();
            jumpcount = 0;
        }
        
        
        
        Ground.draw(g);
//         if(player.areYouInsideABlock_QuestionMark()){
//         Sprite.x-=2;
//         player.updateMask();
//         if(!player.isStand())
//         player.fall();
//         }
//        
        player.updateMask();
        //player.drawMask(g);
        if(player.y == 900) {
            player.y = 0;
            player.x = 300;
            
        }
        
        counter++;
        
        playerActions();
        
        enemyActions();
        
        player.draw(g);
        
    }
    
    private void playerActions() {
        
        /** movement */
        if(right)
            player.right();
        if(left)
            player.left();
        if(jump && player.isStand()) {
            fliptimer = 0;
            jumpcount = 20;
            jumpfin = false;
        }
        if(crouch)
            player.crouch();
        else
            player.stand();
        /** end movement */
        
        /** swagger */
        if(counter % 60 == 0)
            if(swagger)
                swagger = false;
            else
                swagger = true;
        /** fastswagger */
        if(counter % 5 == 0)
            fastswagger++;
        if(fastswagger == 8)
            fastswagger = 0;
        if(counter % 2 == 0 && !jumpfin)
            fliptimer++;
        
        /** run movement animations */
        if(!jumpfin)
            player.jumpSwag(fliptimer);
        else if(!player.isStand())
            player.fallSwag();
        else if(crouch)
            if(right || left)
                player.crouchRun(fastswagger, right, left);
            else
                player.crouchSwag(swagger);
        else if(right || left)
            player.run(fastswagger, right, left);
        else
            player.swagger(swagger);
        
        /** jump/fall movement */
        if(jumpcount > 0) {
            jumpcount--;
            player.jump(jumpcount);
        }
        else if(!(player.isStand()))
            player.jump(jumpcount);
    }
    
    private void enemyActions() {}
    
}
