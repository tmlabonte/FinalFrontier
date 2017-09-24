package frontier;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import frontier.Main;
import frontier.Panel;
import frontier.screens.Screen;

//Class to represent the different locations in the game
public class Location {
	private String name;
	private int[] locationInventory;
	private static Location currentLocation;
	private Commodity exports;
	private Commodity imports;
	private double exportMultiplier;
	private double importMultiplier;
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
	
	public Commodity exports() {
		return exports;
	}
	
	public Commodity imports() {
		return imports;
	}
	
	public double exportMultiplier() {
		return exportMultiplier;
	}
	
	public double importMultiplier () {
		return importMultiplier;
	}
	
	public int[] locationInventory() {
		return locationInventory;
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
		terminal.write("Welcome to " + name + "!", 3, 3);
		terminal.write("Star exports: " + exports.name(), 3, 4);
		terminal.write("Star imports: " + imports.name(), 3, 5);
		terminal.write("Player cash: $" + Player.playerCash(), 5, 7);
		terminal.write("-------------", 14, 10);
		terminal.write("-------------", 14, 12);
		terminal.writeColumn("|", 13, 10, 12);
		terminal.writeColumn("|", 27, 10, 12);
		terminal.write("Return to map", 14, 11);

		int currentLine = 3;
		for (int i=0; i<currentInventory().length; i++) {
			if (currentInventory()[i] > 0) {
				terminal.write(Main.commodityList[i].name(), 41, currentLine);
				terminal.write("" + currentInventory()[i], 67, currentLine);
				terminal.write("$" + Main.commodityList[i].price(this), 72, currentLine);
				currentLine++;
			}
		}

		for (int i=0; i<10; i++) {
			if (i<5) {
				if (Player.playerInventory()[i] > 0) {
					terminal.write(Main.commodityList[i].name(), 5, 16 + i);
					terminal.write("" + Player.playerInventory()[i], 31, 16 + i);
					terminal.write("$" + Main.commodityList[i].price(this), 35, 16 + i);
				}
			}
			else {
				if (Player.playerInventory()[i] > 0) {
					terminal.write(Main.commodityList[i].name(), 41, 11 + i);
					terminal.write("" + Player.playerInventory()[i], 68, 11 + i);
					terminal.write("$" + Main.commodityList[i].price(this), 72, 11 + i);
				}
			}
		}	
	}
}