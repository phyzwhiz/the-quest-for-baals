package brickBreaker;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Ball extends JPanel implements ActionListener, KeyListener {
	static int x = 0;//hello
	static int y = 0;
	static int speed = 150;

	public static void main(String args[]) {

		Ball a = new Ball("");

	}

	public Ball(String s) {

		JFrame frame = new JFrame("Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Ball bp = new Ball();
		new Ball();
		frame.addKeyListener(this);
		frame.add(bp);
		frame.setSize(1366, 738);
		frame.setVisible(true);

	}

	private static final long serialVersionUID = 1L;
	private static int delay = 2;
	protected Timer timer;

	public Ball() {
		timer = new Timer(delay, this);
		timer.start();
	}

	public void paintComponent(Graphics g) {
		g.setColor(Color.blue);
		g.fillRoundRect(x, y, 50, 70,10,10);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		repaint();

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()){
		case KeyEvent.VK_DOWN:
			y += speed;
			break;
			
		case KeyEvent.VK_UP:		
			y -= speed;
			break;
			
		case KeyEvent.VK_LEFT:			
			x -= speed;
			break;
			
		case KeyEvent.VK_RIGHT:
			
			x += speed;
			break;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
	
			

}
}
