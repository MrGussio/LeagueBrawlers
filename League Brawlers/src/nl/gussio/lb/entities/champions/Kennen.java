package nl.gussio.lb.entities.champions;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import nl.gussio.lb.entities.Player;

public class Kennen extends Player{

	public Kennen(int x, int y, int width, int height) {
		super(x, y, width, height);
		
	}

	@Override
	public void loadTextures(){
		try {
			img = ImageIO.read(new File("res/kennen/normal.png"));
			img_kick = ImageIO.read(new File("res/kennen/kick.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
