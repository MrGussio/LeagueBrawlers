package nl.gussio.brawl.map;

import java.awt.Rectangle;

public abstract class MapObject {
	protected int x, y, width, height;
	protected Rectangle collision;
	
	public MapObject(int x, int y,int width,int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		collision = new Rectangle(x, y, width, height);
	}
	
	public abstract void update();
	public abstract void render();
	
	public Rectangle collision(){
		return collision;
	}

	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
}
