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

import brickBreaker.Ball;

public class game extends JPanel implements ActionListener, KeyListener {


	
	
	public static void main(String[] args) throws IOException {
		game run = new game("The Quest For Baals");
	}
	
	private static final long serialVersionUID = 1L;
	private static int delay = 2;
	protected Timer timer;
	Sprite player = new Sprite(100, 100);
	private boolean right;
	private boolean left;

	
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
		player = new Sprite (50, 50);
	}
	
	@Override
	public synchronized void keyPressed(KeyEvent e) {
		
		right = false;
		left = false;
		switch(e.getKeyCode()){
		case KeyEvent.VK_DOWN:
			player.crouch(right, left);
			break;
			
		case KeyEvent.VK_UP:		
			player.jump();
			break;
			
		case KeyEvent.VK_LEFT:
			left = true;
			player.left();
			
			break;
			
		case KeyEvent.VK_RIGHT:
			right = true;
			player.right();
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
			
			break;
			
		case KeyEvent.VK_UP:	
			
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
	
	public void paintComponent(Graphics g) {
		player.draw(g);
	}
	
	
	
}
