package nl.gussio.lb;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Window extends JFrame implements KeyListener{

	private static final long serialVersionUID = 1L;

	Screen screen;
	
	public Window(int width, int height, String title){
		setSize(new Dimension(width, height));
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		init();
		addKeyListener(this);
	}
	
	public void init(){
		setLayout(new GridLayout(1, 1, 0, 0));
		screen = new Screen();
		add(screen);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_A){
			screen.p.left = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_D){
			screen.p.right = true;			
		}
		if(e.getKeyCode() == KeyEvent.VK_W){
			if(screen.p.jumping || screen.p.falling){
				if(screen.p.doubleJumpReady &! screen.p.jumpPressed){
					screen.p.currentJumpSpeed = screen.p.jumpSpeed;
					screen.p.doubleJumpReady = false;
					screen.p.falling = false;
				}
			}
			if(!screen.p.falling){
				screen.p.jumping = true;
				screen.p.jumpPressed = true;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_A){
			screen.p.left = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_D){
			screen.p.right = false;			
		}
		if(e.getKeyCode() == KeyEvent.VK_W){
			screen.p.jumpPressed = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
