package nl.gussio.brawl;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glTranslatef;
import static org.lwjgl.opengl.GL11.glVertex2f;

import java.io.IOException;
import java.io.InputStream;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class GFX {
	
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
	
	public static void drawSquare(float x, float y, float width, float height){
		glBegin(GL_QUADS);
		GL11.glColor3f(1, 0, 0);
		glVertex2f(x, y); // Top left corner
		glVertex2f(x + width, y); // Top right corner
		glVertex2f(x + width, y + height); // Bottom right corner
		glVertex2f(x, y + height); // Bottom left corner
		glEnd();
	}
	
	public static void drawSquare(Texture tex, float x, float y, float width, float height){
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glColor3f(1, 1, 1);
		tex.bind();
		glTranslatef(x, y, 0);
		glBegin(GL_QUADS);
		glTexCoord2f(0,0);
		glVertex2f(0, 0);
		glTexCoord2f(1, 0);
		glVertex2f(width, 0);
		glTexCoord2f(1, 1);
		glVertex2f(width, height);
		glTexCoord2f(0, 1);
		glVertex2f(0, height);
		glEnd();
		glLoadIdentity();
		GL11.glDisable(GL11.GL_TEXTURE_2D);
	}
}
