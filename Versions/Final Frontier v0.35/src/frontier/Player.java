package frontier;

import frontier.commodity.Commodity;
import frontier.crew.Crew;
import frontier.module.Module;
import frontier.starships.*;

//Class to represent the player character
public class Player {
	private static int playerCash;
	private static int[] playerInventory;
	private static int[] playerCrew;
	private static int[] playerModules;
	private static Starship currentShip;

	public Player() {
		playerCash = 500;
		playerInventory = new int[Commodity.numCommodities];
		playerCrew = new int[Crew.numCrew];
		playerModules = new int[Module.numModules];
		currentShip = new Whitewing();
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
	
	public static int[] playerCrew() {
		return playerCrew;
	}
	
	public static int[] playerModules() {
		return playerModules;
	}
	
	public static Starship currentShip() {
		return currentShip;
	}
	
	public static void changeShip(Starship newShip) {
		currentShip = newShip;
	}
}