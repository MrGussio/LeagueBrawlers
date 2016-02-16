package nl.gussio.brawl;

import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

public class Boot {

	public static final int WIDTH = 1280, HEIGHT = 720;
	
	public static void main(String[] args){
		new Boot();
	}
	
	public Boot(){
		Display.setTitle("League Brawlers");
		try{
			Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
			Display.create();
		}catch(LWJGLException e){
			e.printStackTrace();
		}
		Game game = new Game();
		define();
		
		while(!Display.isCloseRequested()){
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
			game.update();
			Display.update();
			Display.sync(60);
		}
		
		Display.destroy();
	}
	
	public void define(){
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, Boot.WIDTH, Boot.HEIGHT, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
	}
	
}
