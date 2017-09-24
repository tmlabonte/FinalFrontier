package frontier;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import frontier.Main;
import frontier.Panel;
import frontier.screens.Screen;

//Class to represent the different locations in the game
public class Location {
	private String name;
	private int[] locationInventory;
	public static int numLocations = 12; //MUST BE 0 % 4
	private static Location currentLocation;
	private Commodity exports;
	private Commodity imports;
	private double exportMultiplier;
	private double importMultiplier;
	private int xPos;
	private int yPos;
	Random rand = new Random();

	public Location(String name, Commodity[] commodityList) {
		this.name = name;
		this.locationInventory = new int[10];
		exportMultiplier = ThreadLocalRandom.current().nextDouble(0.7, 0.86);
		importMultiplier = ThreadLocalRandom.current().nextDouble(1.15, 1.31);
		
		for (int i=0; i<10; i++) {
			locationInventory[i] = rand.nextInt(19)+1;
		}
		
		exports = Main.commodityList[rand.nextInt(Main.commodityList.length)];
		imports = Main.commodityList[rand.nextInt(Main.commodityList.length)];
		while (exports == imports) {
			imports = Main.commodityList[rand.nextInt(Main.commodityList.length)];
		}
	}

	public String name() {
		return name;
	}
	
	public int[] locationInventory() {
		return locationInventory;
	}
	
	public Commodity exports() {
		return exports;
	}
	
	public Commodity imports() {
		return imports;
	}
	
	public double exportMultiplier() {
		return exportMultiplier;
	}
	
	public double importMultiplier() {
		return importMultiplier;
	}
	
	public int xPos() {
		return xPos;
	}
	
	public int yPos() {
		return yPos;
	}
	
	public void setPos(int newXPos, int newYPos) {
		xPos = newXPos;
		yPos = newYPos;
	}
	
	public static Location currentLocation() {
		return currentLocation;
	}

	public static int[] currentInventory() {
		return currentLocation.locationInventory();
	}

	public static void moveTo(Location destination) {
		currentLocation = destination;
	}

	public void displayLocation(Panel terminal) {
		Screen.drawBorder(terminal);
		terminal.writeColumn("|", 39, 2, 13);
		terminal.writeCenter("----------------------------------------------------------------------------", 14);
		
		terminal.write("Welcome to " + name + "!", 4, 2);
		terminal.write("Star exports: " + exports.name(), 4, 4);
		terminal.write("Star imports: " + imports.name(), 4, 5);
		terminal.write("Player cash: $" + Player.playerCash(), 4, 7);
		terminal.write("Cargo: " + IntStream.of(Player.playerInventory()).sum() + "/" + Player.currentShip().commodityCapacity(), 4, 8);
		
		terminal.write("---------------", 13, 10);
		terminal.write("---------------", 13, 12);
		terminal.writeColumn("|", 12, 10, 12);
		terminal.writeColumn("|", 28, 10, 12);
		terminal.write("Return to map", 14, 11);	
	}
}