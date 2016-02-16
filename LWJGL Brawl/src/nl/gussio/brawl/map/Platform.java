package nl.gussio.brawl.map;

import nl.gussio.brawl.GFX;

public class Platform extends MapObject {

	public Platform(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	@Override
	public void update() {
		
	}

	@Override
	public void render() {
		
		GFX.drawSquare(x, y, width, height);
	}

}
