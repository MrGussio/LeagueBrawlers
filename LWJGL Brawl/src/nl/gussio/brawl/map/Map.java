package nl.gussio.brawl.map;

import java.util.ArrayList;

public class Map {

	public ArrayList<MapObject> objects = new ArrayList<MapObject>();
	
	public void addObject(MapObject o){
		objects.add(o);
	}
	
	public void removeObject(MapObject o){
		for(MapObject x : objects){
			if(x.equals(o))
				objects.remove(o);
		}
	}
	
	public void updateObjects(){
		for(MapObject o : objects){
			o.update();
			o.render();
		}
	}
}
