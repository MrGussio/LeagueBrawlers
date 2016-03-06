package nl.gussio.lb.entities;

import java.awt.Graphics;
import java.awt.Point;

import nl.gussio.lb.map.MapObject;

public abstract class Entity {

	protected int x, y, width, height;
	
	public Entity(int x, int y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public abstract void render(Graphics g);
	public abstract void update();
	
	public boolean collides(Point p, MapObject o){
		return o.collision().contains(p);
	}
	
}
