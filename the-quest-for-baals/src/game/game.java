package game;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class game extends JPanel implements ActionListener, KeyListener, MouseListener, MouseMotionListener {
    
    public static void main(String[] args) throws IOException {
        stone = ImageIO.read(new File("img/stone1.png"));
        
        @SuppressWarnings("unused")
        game run = new game("Game");
    }
    
    private static final long serialVersionUID = 1L;
    static int shift = 0;
    static int delay = 20;
    protected Timer timer;
    Sprite player;
    static int xN = 0;
    static int yN = 0;
    static boolean draw = false;

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
    static int mouseX = 0;
    static int mouseY = 0;
    static BufferedImage stone;
    String Blocks = "";
    static Point initialPosition = new Point();
    
    public game(String s) throws IOException {
        JFrame frame = new JFrame(s);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //game start screen
        //determines player class and levelbuilderness
        
        
        game bp = new game();
        frame.add(bp);
        frame.addKeyListener(this);
        frame.addMouseListener(this);
        frame.addMouseMotionListener(this);
        frame.setSize(1366, 738);
        frame.setVisible(true);
        
        
       
       


    }
    
    public game() {
       

        level = new Level(1);
        timer = new Timer(delay, this);
        timer.start();

        player = new Fighter(1366/2, 0, true);

        
        

        
    }
    
    @Override
    public synchronized void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            
            case KeyEvent.VK_L:
                draw ^= true;
               
                break;
            
            
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
            
            case KeyEvent.VK_Z:
                if(Sprite.level){
                if(Ground.all.size() > 0){
                	Ground.all.remove(Ground.all.size() - 1);
                	ArrayList<Integer> indexes = new ArrayList<Integer>();
                	for(int i = 0; i<Blocks.length();i++){
                	    if(Blocks.charAt(i)==' ')
                	        indexes.add(i);
                	}
                	Blocks = Blocks.substring(0, indexes.get(indexes.size()-2));
                }
                }
                
                
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
            case KeyEvent.VK_T:
              Sprite.level ^= true;
              if( Sprite.speed==100){
                  Sprite.speed=10;
                  while(Ground.all.get(0).getX()%mouseX!=0)
                      for(Block b : Ground.all){
                              b.x--;
                     
                  }
              }
              else{
                  Sprite.speed = 100;
                  
                  while(Ground.all.get(0).getX()%mouseX!=0)
                  for(Block b : Ground.all){
                          b.x--;
                      
                  }
              }
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
            
            case KeyEvent.VK_ENTER:
                if(Sprite.level){
                Ground.add(new Block(0, mouseX, mouseY - 25));
                Blocks += " Ground.add(new Block(0," + mouseX + "," + mouseY + "-25));";
               
                }
                
                break;
            
            case KeyEvent.VK_G:
                System.out.println(Blocks);
                
                break;
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
    
    @SuppressWarnings("static-access")
    public void paintComponent(Graphics g) {
        
      
        
       
        System.out.println(shift);
      
     if(right)
         shift+=Sprite.speed;
         if(left)
             shift-=Sprite.speed;
        
        
        
         if(!Sprite.level){
        if(!player.awwDidYouHitAWallToYourRight())
            right = false;
        
        if(!player.awwDidYouHitAWallToYourLeft())
            left = false;
        
        if(!player.awwDidYouHitAWallWithHead()) {
            player.fall();
            jumpcount = 0;
        }
         }

     
             
             
         
        if(Sprite.level)
            g.drawImage(stone, mouseX, mouseY - 25, null);

        
        Ground.draw(g);
        // if(player.areYouInsideABlock_QuestionMark()){
        // Sprite.x-=2;
        // player.updateMask();
        // if(!player.isStand())
        // player.fall();
        // }
        //
        player.updateMask();
        // player.drawMask(g);
        
        if(player.y == 900) {
            player.y = 0;
            player.x = getWidth() / 2;
            
        }
        
        counter++;
        
        playerActions();
        
        enemyActions(g);
        
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
    
    private void enemyActions(Graphics g) {
    	for (Enemy enemy: Ground.enemy)
    	{
    		if (!enemy.isStand())
    			enemy.fall();
    		else 
    			enemy.move(player.x);
    		enemy.run(fastswagger);
    		
    		enemy.draw(g);
    	}
    		
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if(Sprite.level){
        Ground.add(new Block(0, mouseX, mouseY - 25));
        int num = mouseX + shift;
        Blocks += " Ground.add(new Block(0," + num + "," + mouseY + "-25));";
        }
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        
    }
    
    @Override
    public void mouseReleased(MouseEvent e) {
        
    }
    
    @Override
    public void mouseEntered(MouseEvent e) {
        
    }
    
    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
    @Override
    public void mouseDragged(MouseEvent e) {
        
    }
    
    @Override
    public void mouseMoved(MouseEvent e) {
        
        int x = ((e.getX() + 99) / 100) * 100;
        int y = ((e.getY() + 99) / 100) * 100;
        
        
        mouseX = x - 50;
        mouseY = y - 50;
        
    }
    
}
