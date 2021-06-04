package game.viviGame.testGame;

import game.viviGame.testGame.display.Display;

public class Launcher {
	public static void main(String[] args) {
		Game game = new Game("Testing", 950, 650);
		game.start();
	}
}
