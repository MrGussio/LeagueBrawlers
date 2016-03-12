package nl.gussio.lb.map;

import java.awt.Color;
import java.awt.Graphics;

public class Platform extends MapObject {

	public Platform(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	@Override
	public void update() {
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(x, y, width, height);
	}

}
