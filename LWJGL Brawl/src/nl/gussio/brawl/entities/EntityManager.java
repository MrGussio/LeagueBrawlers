package nl.gussio.brawl.entities;

import java.util.ArrayList;

public class EntityManager {

	public static ArrayList<Entity> entities = new ArrayList<Entity>();
	
	public void addEntity(Entity e){
		entities.add(e);
	}
	
	public void removeEntity(Entity e){
		for(Entity x : entities){
			if(x.equals(e))
				entities.remove(e);
		}
	}
	
	public void updateEntities(){
		for(Entity e : entities){
			e.update();
			e.render();
		}
	}
}
