package nl.gussio.lb;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import nl.gussio.lb.entities.EntityManager;
import nl.gussio.lb.entities.Player;

public class Screen extends JPanel implements Runnable{
	
	private static final long serialVersionUID = 1L;
	public boolean running = false;
	
	public Thread game;
	
	public int fps = 60;
	
	public EntityManager em;
	public Player p;
	
	public Screen(){
		setBackground(Color.BLACK);
		em = new EntityManager();
		p = new Player(0, 0, 24, 36);
		em.addEntity(p);
		game = new Thread(this);
		game.start();	
		running = true;
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		em.updateEntities(g);
	}

	@Override
	public void run() {
		while(running){
			
			fps();
			repaint();
		}
	}
	
	public void fps(){
		try{
			game.sleep(fps/1000);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
