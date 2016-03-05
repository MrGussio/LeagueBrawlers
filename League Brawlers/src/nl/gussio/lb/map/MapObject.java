package nl.gussio.lb.map;

import java.awt.Graphics;

public abstract class MapObject {

	protected int x, y, width, height;
	
	public MapObject(int x, int y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public abstract void update();
	public abstract void render(Graphics g);
	
}
