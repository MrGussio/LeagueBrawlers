package nl.gussio.brawl.entities;

import java.awt.Point;
import java.awt.Rectangle;


import nl.gussio.brawl.map.MapObject;

public abstract class Entity {
	
	

	public Entity(int x, int y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		collision = new Rectangle(x, y, width, height);
	}
	
	protected int x,y,width,height;
	
	public abstract void render();
	public abstract void update();
	protected Rectangle collision;
	
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public boolean collides(Point p, MapObject o){
		return o.collision().contains(p);
	}
	
	
}
