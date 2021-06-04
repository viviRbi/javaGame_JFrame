package game.viviGame.testGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import game.viviGame.testGame.display.Display;
import game.viviGame.testGame.gfx.ImageLoader;

import java.awt.image.BufferedImage;

public class Game implements Runnable{
	
	private Display display;
	private int width,height;
	private String title;
	private Thread thread;
	private boolean running = false;
	
	// for render
	private BufferStrategy bs;
	private Graphics g;
	
	private BufferedImage testImage;
	
	
	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title= title;
	}
	
	private void init() {
		display = new Display(title, width, height);
		testImage = ImageLoader.loadImage("/sprite/fireball.png");
	}
	
	private void tick() {
		
	}
	
	private void render() {
		// buffer = a hidden computer screen within computer
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		// clear before draw
		g.clearRect(0, 0, width, height);
		// Draw
		// x:0 y:0 is top left of the screen
		//g.setColor(Color.green);
		g.drawImage(testImage,20, 20, null);
		
		// End draw
		bs.show();
		g.dispose();
	}
	
	public void run() {
		init();
		
		while(running) {
			tick();
			render();
		}
	}
	
	public synchronized void start() {
		if(running) return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop() {
		if(!running) return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
}
