package frontier;

public class Player {
	private static int playerCash;
	private static int[] playerInventory;
	
	public Player() {
		playerCash = 500;
		playerInventory = new int[10];
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
}