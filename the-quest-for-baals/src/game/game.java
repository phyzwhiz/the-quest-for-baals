package game;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Robot;
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

import nikunj.classes.NewerSound;

public class game extends JPanel implements ActionListener, KeyListener, MouseListener, MouseMotionListener {
    
    public static void main(String[] args) throws IOException {
        stone = ImageIO.read(new File("img/stone1.png"));
        delete = ImageIO.read(new File("img/delete.png"));
        back = ImageIO.read(new File("img/back.png"));
        @SuppressWarnings("unused")
        game run = new game("Game");
    }
    
    private static final long serialVersionUID = 1L;
    static int shift = 0;
    static int counterE = 0;
    static int delay = 30;
    protected Timer timer;
    Sprite player;
    static int xN = 0;
    static int yN = 0;
    static boolean draw = false;
    static boolean deleteMode = false;
    static boolean right = false;
    static boolean left = false;
    static boolean crouch = false;
    static boolean jump = false;
    int jumpcount = 0;
    int enemyjump = 0;
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
    static BufferedImage delete;
    static BufferedImage back;
    static ArrayList<String> objects = new ArrayList<String>();
    static NewerSound music;
    JFrame frame;
    boolean checked = false;
    
    int offset;
    
    String Blocks = "";
    static Point initialPosition = new Point();
    
    public game(String s) throws IOException {
        frame = new JFrame(s);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // game start screen
        // determines player class and levelbuilderness
        
        music = new NewerSound("img/w_a_v_e.wav", true);
        music.play();
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
        
        player = new Fighter(600, 0, false);
        Ground.all.add(new Lava(0, 0));
        Ground.all.add(new Lava(0, 100));
        Ground.all.add(new Lava(0, 200));
        Ground.all.add(new Lava(0, 300));
        Ground.all.add(new Lava(0, 400));
        Ground.all.add(new Lava(0, 500));
        Ground.all.add(new Lava(0, 600));
        Ground.all.add(new Lava(0, 700));
        
        try {
            Robot robot = new Robot();
            robot.mouseMove(100, 100);
        }
        catch(AWTException e1) {
            e1.printStackTrace();
        }
        
    }
    
    public void endGame()
    {
    	if (!checked)
    	{
        	music.stop();
    		music = new NewerSound("img/bitty_two.wav", true);
    		music.play();
    		Ground.all.clear();
    		frame = new JFrame();
    		frame.setBackground(new Color(0, 0, 0));
    	}
    	
    }
    
    @Override
    public synchronized void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            
            case KeyEvent.VK_X:
                
                deleteMode ^= true;
                
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
                offset += 10;
                break;
            
            case KeyEvent.VK_RIGHT:
                offset += 10;
                
                right = true;
                
                break;
            
            case KeyEvent.VK_Z:
                if(Sprite.level) {
                    if(Ground.all.size() > 0) {
                        Ground.all.remove(Ground.all.size() - 1);
                        ArrayList<Integer> indexes = new ArrayList<Integer>();
                        for(int i = 0; i < Blocks.length(); i++) {
                            if(Blocks.charAt(i) == ' ')
                                indexes.add(i);
                        }
                        Blocks = Blocks.substring(0, indexes.get(indexes.size() - 2));
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
                if(Sprite.speed == 100) {
                    Sprite.speed = 10;
                    if (mouseX > 0)
                    while(Ground.all.get(0).getX() % mouseX != 0)
                        for(Block b : Ground.all) {
                            b.x--;
                            shift--;
                            
                        }
                    
                }
                else {
                    Sprite.speed = 100;
                    
                    if (mouseX > 0)
                    while(Ground.all.get(0).getX() % mouseX != 0)
                        for(Block b : Ground.all) {
                            b.x--;
                            shift--;
                            
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
                if(Sprite.level) {
                    Ground.all.add(new Lava(mouseX, mouseY));
                    objects.add(" Ground.add(new Block(0," + mouseX + "," + mouseY + "));");
                    
                }
                
                break;
            
            case KeyEvent.VK_G:
                for(String s : objects)
                    System.out.print(s);
                System.out.println();
                break;
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
    
    @SuppressWarnings("static-access")
    public void paintComponent(Graphics g) {
        
        g.setColor(new Color(30, 30, 30));
        
        g.drawImage(back, 0, 0, null);
        
      
        
        if(!Sprite.level) {
            if(!player.awwDidYouHitAWallToYourRight())
                right = false;
            
            if(!player.awwDidYouHitAWallToYourLeft())
                left = false;
            
            if(!player.awwDidYouHitAWallWithHead()) {
                player.fall();
                jumpcount = 0;
            }
        }
        
        if(right) {
            shift += Sprite.speed;
            for(Enemy e : Ground.enemy) {
               if(Sprite.halfspeed){ e.setX(e.getX() - (Sprite.speed)/4);}
            else{
                e.setX(e.getX() - (Sprite.speed));
            }
            }
        }
        if(left) {
            shift -= Sprite.speed;
            for(Enemy e : Ground.enemy) {
                if(Sprite.halfspeed){
                e.setX(e.getX() + (Sprite.speed) / 4);
                }
                else{
                    e.setX(e.getX() + (Sprite.speed));
                }
            }
        }
        
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
        if (!checked)
        {
        playerActions();
        
        enemyActions(g);
        
        blocks(g);
        
        player.draw(g);
        
        if(!deleteMode) {
            if(Sprite.level)
                g.drawImage(stone, mouseX, mouseY, null);
        }
        else
            g.drawImage(delete, mouseX, mouseY, null);
        }
    }
    
    private void playerActions() {
        
        /** movement */
        if(right)
            player.right();
        if(left)
            player.left();
        if(jump && player.isStand()) {
            fliptimer = 0;
            jumpcount = 12;
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
        
//        player.damage();
        
        if (player.isDead())
        {
        	endGame();
        	checked = true;
        }
        
    }
    
    private void enemyActions(Graphics g) {
        
       
        for(Enemy enemy : Ground.enemy) {
        
           
           

                if (enemy.awwDidYouHitAWallToYourRight() || enemy.awwDidYouHitAWallToYourLeft())
                	enemy.jump();
                enemy.fall();
            
           // else
          
                enemy.move(player.x);
            
           
            enemy.run(fastswagger);
            enemy.updateMask();
            enemy.draw(g);
            //enemy.drawMask(g);
        }
        counterE=1;
        }

        
    
    
    private void blocks(Graphics g) {
        for(Block block : Ground.all) {
            block.spooky(fastswagger);
            try {
                block.draw(g);
            }
            catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(!deleteMode) {
            if(Sprite.level) {
               Ground.all.add(new Lava(mouseX, mouseY));
              //  Ground.enemy.add(new Melee(mouseX, mouseY-800));

                int num = mouseX + shift;
                objects.add(" Ground.add(new Block(0," + mouseX + "," + mouseY + "));");
                
            }
        }
        else {
            int x = Ground.removeAtPosition(mouseX + shift, mouseY, shift);
            
            if(x != -1)
                objects.remove(0);
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
    public void mouseDragged(MouseEvent e) {}
    
    @Override
    public void mouseMoved(MouseEvent e) {
        int grid = 100;
        
        int x = (e.getX() / grid) * grid;
        int y = (e.getY() / grid) * grid;
        
        // int x = ((e.getX() + grid-1) / grid) * grid;
        // int y = ((e.getY() + grid-1) / grid) * grid;
        
        mouseX = x;
        mouseY = y;
        
    }
    
}
