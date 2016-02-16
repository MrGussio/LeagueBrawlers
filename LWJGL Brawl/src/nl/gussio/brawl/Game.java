package nl.gussio.brawl;

import nl.gussio.brawl.entities.EntityManager;
import nl.gussio.brawl.entities.Player;
import nl.gussio.brawl.map.Map;
import nl.gussio.brawl.map.Platform;

public class Game {

	EntityManager em;
	private static Map map;
	
	public Game(){
		em = new EntityManager();
		map = new Map();
		map.addObject(new Platform(Boot.WIDTH/2-(500/*width of platform*//2), 500, 500, 50));
		em.addEntity(new Player(600, 300));
	}
	
	public void update(){
		em.updateEntities();
		map.updateObjects();
	}
	
	public static Map getMap(){
		return map;
	}
	
}
