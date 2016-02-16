package nl.gussio.brawl.entities;

import java.awt.Point;
import java.io.IOException;
import java.io.InputStream;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import nl.gussio.brawl.GFX;
import nl.gussio.brawl.Game;
import nl.gussio.brawl.map.MapObject;

public class Player extends Entity {

	
	public boolean left, right, jumping, jumpPressed, falling = false;
	public boolean topCollision = false;
	public boolean doubleJumpReady = true;
	
	public double jumpSpeed = 5;
	public double currentJumpSpeed = jumpSpeed;
	
	public double maxFallSpeed = 6;
	public double currentFallSpeed = 0.1;
	
	public int movementSpeed = 3;
	
	public Texture texture;
	
	public Player(int x, int y) {
		super(x, y, 100, 100);
		texture = loadTexture("Kennen");
		width = texture.getTextureWidth();
		height = texture.getTextureHeight();
	}

	@Override
	public void render() {
		GFX.drawSquare(texture, x, y, width, height);
		System.out.println("Width: "+width+" Height: "+height);
	}

	@Override
	public void update() {	
		controls();
		detectCollision();
		
		if(left)
			x -= movementSpeed;
		if(right)
			x += movementSpeed;
		
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
				currentFallSpeed += .1;
			}
		}
	}
	
	public void detectCollision(){
		int iX = x;
		int iY = y;
		
		for(MapObject o : Game.getMap().objects){
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
	
	public void controls(){
		//jump
		if(Keyboard.isKeyDown(Keyboard.KEY_W)){
				if(jumping || falling){
					if(doubleJumpReady &! jumpPressed){
						currentJumpSpeed = jumpSpeed;
						doubleJumpReady = false;
						falling = false;
					}
				}
				if(!falling){
					jumping = true;
					jumpPressed = true;
				}
		}else{
			jumpPressed = false;	
		}
		
		
		//left
		if(Keyboard.isKeyDown(Keyboard.KEY_A)){
			left = true;
		}else{
			left = false;
		}
		
		//right
		if(Keyboard.isKeyDown(Keyboard.KEY_D)){
			right = true;
		}else{
			right = false;
		}
	}
	
	public static Texture loadTexture(String path){
		Texture texture = null;
		InputStream in = ResourceLoader.getResourceAsStream("res/"+path+".png");
		try {
			texture = TextureLoader.getTexture("PNG", in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return texture;
	}

}
