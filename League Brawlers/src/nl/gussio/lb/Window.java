package nl.gussio.lb;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;

public class Window extends JFrame {

	private static final long serialVersionUID = 1L;

	public Window(int width, int height, String title){
		setSize(new Dimension(width, height));
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		init();
	}
	
	public void init(){
		setLayout(new GridLayout(1, 1, 0, 0));
		Screen screen = new Screen();
		add(screen);
	}
	
}
