package game;

import java.awt.Color;
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
		game run = new game("Game");
	}
	
	private static final long serialVersionUID = 1L;
	private static int delay = 15;
	protected Timer timer;
	Sprite player = new Sprite(100, 100);
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
		timer = new Timer(delay, this);
		timer.start();
		player = new Sprite (100, 100);
	}
	
	@Override
	public synchronized void keyPressed(KeyEvent e) {
		
		switch(e.getKeyCode()){
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
		
		switch(e.getKeyCode()){
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
	public void actionPerformed(ActionEvent e) 
	{	repaint(); }
	
	public void paintComponent(Graphics g) 
	{
		if (right)
			player.right();
		if (left)
			player.left();
		if (jump && player.isTouch()) {
			fliptimer = 0;
			jumpcount = 20;
			jumpfin = false;
		}
		if (crouch)
			player.crouch();
		else
			player.stand();
		
		counter++;
		
		
			if (counter%60 == 0) 
				if (swagger)
					swagger = false;
				else 
					swagger = true;
			
			if (counter%5 == 0) {
				fastswagger++;
			}
			
			if (fastswagger == 7)
				fastswagger = 0;
			
			if (counter%5 == 0 && !jumpfin)
				fliptimer++;
				
			if (!jumpfin)
				player.jumpSwag(fliptimer);
			else if (!player.isTouch())
				player.fallSwag();
			else if (crouch)
				if (right || left)
					player.crouchRun(fastswagger, right, left);
				else
					player.crouchSwag(swagger, right, left);
			else
				if (right || left)
					player.run(fastswagger, right, left); 
				else
					player.swagger(swagger, right, left);

			
			if (jumpcount > 0) {
				jumpcount--;
				player.jump(jumpcount);
			}
			else
				if (!(player.isTouch()))
					player.jump(jumpcount);	
		
		player.draw(g);
	}
	
		
}
