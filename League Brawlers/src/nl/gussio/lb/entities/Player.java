package nl.gussio.lb.entities;

import java.awt.Color;
import java.awt.Graphics;

public class Player extends Entity {

	public Player(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(x, y, width, height);
	}

	@Override
	public void update() {
		
	}

	
}
