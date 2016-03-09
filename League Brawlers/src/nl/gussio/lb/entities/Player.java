package nl.gussio.lb.entities;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import nl.gussio.lb.Screen;
import nl.gussio.lb.map.MapObject;

public class Player extends Entity {

	public boolean left,right,jumping, jumpPressed, falling = false;
	
	public boolean topCollision = false;
	
	public boolean doubleJumpReady = false;
	
	public double jumpSpeed = 5;
	public double currentJumpSpeed = jumpSpeed;
	
	public double maxFallSpeed = 6;
	public double currentFallSpeed = 0.1;
	
	public int movementSpeed = 3;
	
	public BufferedImage img;
	
	public Player(int x, int y, int width, int height) {
		super(x, y, width, height);
		loadTextures();
	}

	@Override
	public void render(Graphics g) {
			g.drawImage(img, x, y, width, height, null);
	}

	@Override
	public void update() {
		detectCollision();
		if(left)
			x-= movementSpeed;
		if(right)
			x+= movementSpeed;
		
		if(jumping){
			currentFallSpeed = 0;
			y -= currentJumpSpeed;
			
			currentJumpSpeed -= .1;
			if(currentJumpSpeed < 0){
				currentJumpSpeed = jumpSpeed;
				jumping = false;
				falling = true;
			}
		}
		
		if(falling){
			y += currentFallSpeed;
			
			if(currentFallSpeed < maxFallSpeed){
				currentFallSpeed += .15;
			}
		}
		detectCollision();
	}
	
	public void detectCollision(){
		int iX = x;
		int iY = y;
		
		for(MapObject o : Screen.map.objects){
			//left
			if(collides(new Point(iX - 1, iY + 2), o)
					|| collides(new Point(iX - 1, iY + height - 1), o)){
				left = false;
			}
			
			//right
			if(collides(new Point(iX + width, iY+2), o)
					|| collides(new Point(iX + width, iY + height-1), o)){
				right = false;
			}
			
			//top
			if(collides(new Point(iX + 1, iY), o)
					|| collides(new Point(iX +width - 1, iY), o)){
				jumping = false;
				falling = true;
			}
			
			//bottom
			if(collides(new Point(iX + 2, iY+height + 1), o)
					|| collides(new Point(iX + width - 1, iY+height + 1), o)){
				y = o.getY() - height;
				falling = false;
				topCollision = true;
				doubleJumpReady = true;
			}else{
				if(!topCollision && !jumping){
					falling = true;
				}
			}
		}
		topCollision = false;
	}

	public void move(int d){
		switch(d){
			case 0:
				x-=movementSpeed;
				break;
			case 1:
				x+=movementSpeed;
				break;
			default:
				System.err.println("Tried to move "+this.toString()+", but received a integer that cannot be used.");
		}
	}
	
	public void loadTextures(){
		try {
			img = ImageIO.read(new File("res/Kennen.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
}
