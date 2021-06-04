package game.viviGame.testGame;

import game.viviGame.testGame.display.Display;

// Add resources folder to build path by select Project folder. (for game to run everywhere)
// In nav bar, Project->Properties-> Add class folder-> apply. 

public class Launcher {
	public static void main(String[] args) {
		Game game = new Game("Testing", 950, 650);
		game.start();
	}
}
