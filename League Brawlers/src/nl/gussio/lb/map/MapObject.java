package nl.gussio.lb.map;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class MapObject {

	Rectangle collision;
	protected int x, y, width, height;
	
	public MapObject(int x, int y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		collision = new Rectangle(x,y,width,height);
	}
	
	public abstract void update();
	public abstract void render(Graphics g);
	
	public Rectangle collision(){
		return collision;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
}
