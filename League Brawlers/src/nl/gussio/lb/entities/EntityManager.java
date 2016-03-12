package nl.gussio.lb.entities;

import java.awt.Graphics;
import java.util.ArrayList;

public class EntityManager {

	public ArrayList<Entity> entities = new ArrayList<Entity>();
	
	public void addEntity(Entity e){
		entities.add(e);
	}
	
	public void updateEntities(){
		for(Entity e : entities){
			e.update();
		}
	}
	
	public void renderEntities(Graphics g){
		for(Entity e : entities){
			e.render(g);
		}
	}
	
}
