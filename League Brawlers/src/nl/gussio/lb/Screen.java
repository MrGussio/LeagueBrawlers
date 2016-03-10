package nl.gussio.lb;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import nl.gussio.lb.entities.EntityManager;
import nl.gussio.lb.entities.Player;
import nl.gussio.lb.entities.champions.Kennen;
import nl.gussio.lb.map.Map;
import nl.gussio.lb.map.Platform;

public class Screen extends JPanel implements Runnable{
	
	private static final long serialVersionUID = 1L;
	public boolean running = false;
	
	public Thread game;
	
	public int fps = 60;
	
	public EntityManager em;
	public static Map map;
	public Player p;
	
	public BufferedImage bg;
	public Screen(){
		try {
			bg = ImageIO.read(new File("res/background.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		setBackground(Color.BLACK);
		em = new EntityManager();
		map = new Map();
		map.addObject(new Platform(300,400,400,25));
		p = new Kennen(400, 0, 48, 72);
		em.addEntity(p);
		game = new Thread(this);
		game.start();	
		running = true;
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(bg, 0, 0, 1280, 720, null);
		em.updateEntities();
		em.renderEntities(g);
		map.updateObjects();
		map.renderObjects(g);
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
			game.sleep(1000/fps);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
