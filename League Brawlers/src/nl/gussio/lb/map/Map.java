package nl.gussio.lb.map;

import java.awt.Graphics;
import java.util.ArrayList;

public class Map {
	
	public ArrayList<MapObject> objects = new ArrayList<MapObject>();
	
	public void addObject(MapObject o){
		objects.add(o);
	}
	
	public void renderObjects(Graphics g){
		for(MapObject o : objects){
			o.render(g);
		}
	}
	
	public void updateObjects(){
		for(MapObject o : objects){
			o.update();
		}
	}
	
}
