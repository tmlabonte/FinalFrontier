package frontier;

import frontier.starships.*;

public class Player {
	private static int playerCash;
	private static int[] playerInventory;
	private static Starship currentShip;
	
	public Player() {
		playerCash = 500;
		playerInventory = new int[10];
		currentShip = new APieceOfShip();
	}
	
	public static int playerCash() {
		return playerCash;
	}
	
	public static void changePlayerCash(int amount) {
		playerCash += amount;
	}
	
	public static int[] playerInventory() {
		return playerInventory;
	}
	
	public static Starship currentShip() {
		return currentShip;
	}
	
	public static void changeShip(Starship newShip) {
		currentShip = newShip;
	}
}