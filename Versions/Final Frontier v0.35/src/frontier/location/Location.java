package frontier.location;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import frontier.Main;
import frontier.Panel;
import frontier.Player;
import frontier.commodity.Commodity;
import frontier.crew.Crew;
import frontier.module.Module;
import frontier.screens.Screen;

//Class to represent the different locations in the game
public class Location {
	public static final int numLocations = 12; //MUST BE 0 % 4
	private String name;
	private int[] locationInventory;
	private int[] crewAvailable;
	private int[] modulesAvailable;
	private static Location currentLocation;
	private Commodity exports;
	private Commodity imports;
	private double exportMultiplier;
	private double importMultiplier;
	private int xPos;
	private int yPos;
	Random rand = new Random();

	//Creates a new location with a random import/export multiplier and inventory
	public Location(String name, Commodity[] commodityList) {
		this.name = name;
		this.locationInventory = new int[Commodity.numCommodities];
		this.crewAvailable = new int[Crew.numCrew];
		this.modulesAvailable = new int[Module.numModules];

		//Sets commodity availability
		for (int i=0; i<10; i++) {
			locationInventory[i] = rand.nextInt(19) + 1;
		}

		//Sets multipliers and unique exports/imports
		exportMultiplier = ThreadLocalRandom.current().nextDouble(0.7, 0.86);
		importMultiplier = ThreadLocalRandom.current().nextDouble(1.15, 1.31);
		exports = Main.commodityList[rand.nextInt(Main.commodityList.length)];
		imports = Main.commodityList[rand.nextInt(Main.commodityList.length)];
		while (exports == imports) {
			imports = Main.commodityList[rand.nextInt(Main.commodityList.length)];
		}

		//Selects unique crew available
		int firstIndex = ThreadLocalRandom.current().nextInt(0, Crew.numCrew);
		int secondIndex = ThreadLocalRandom.current().nextInt(0, Crew.numCrew);
		int thirdIndex =  ThreadLocalRandom.current().nextInt(0, Crew.numCrew);
		while (firstIndex == secondIndex || firstIndex == thirdIndex || secondIndex == thirdIndex) {
			firstIndex = ThreadLocalRandom.current().nextInt(0, Crew.numCrew);
			secondIndex = ThreadLocalRandom.current().nextInt(0, Crew.numCrew);
			thirdIndex =  ThreadLocalRandom.current().nextInt(0, Crew.numCrew);
		}
		crewAvailable[firstIndex] = crewAvailable[secondIndex] = crewAvailable[thirdIndex] = 1;

		//Selects unique modules available
		firstIndex = ThreadLocalRandom.current().nextInt(0, Module.numModules);
		secondIndex = ThreadLocalRandom.current().nextInt(0, Module.numModules);
		thirdIndex =  ThreadLocalRandom.current().nextInt(0, Module.numModules);
		while (firstIndex == secondIndex || firstIndex == thirdIndex || secondIndex == thirdIndex) {
			firstIndex = ThreadLocalRandom.current().nextInt(0, Module.numModules);
			secondIndex = ThreadLocalRandom.current().nextInt(0, Module.numModules);
			thirdIndex =  ThreadLocalRandom.current().nextInt(0, Module.numModules);
		}
		modulesAvailable[firstIndex] = modulesAvailable[secondIndex] = modulesAvailable[thirdIndex] = 1;
	}

	public String name() {
		return name;
	}

	public int[] locationInventory() {
		return locationInventory;
	}

	public int[] crewAvailable() {
		return crewAvailable;
	}
	
	public int[] modulesAvailable() {
		return modulesAvailable;
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

	public static int[] currentCrewAvailable() {
		return currentLocation.crewAvailable;
	}
	
	public static int[] currentModulesAvailable() {
		return currentLocation.modulesAvailable;
	}

	public int distanceTo(Location destination) {
		return (int)Math.sqrt(Math.pow(this.xPos() - destination.xPos(), 2) + Math.pow(this.yPos() - destination.yPos(), 2));
	}

	public static void moveTo(Location destination) {
		currentLocation = destination;
	}

	//Displays the basic location screen
	public void displayLocation(Panel terminal) {
		Screen.drawBorder(terminal);
		terminal.writeColumn("|", 39, 2, 13);
		terminal.writeCenter("----------------------------------------------------------------------------", 14);

		terminal.write("Welcome to " + this.name + "!", 4, 2);
		terminal.write("Star exports: " + this.exports.name(), 4, 4);
		terminal.write("Star imports: " + this.imports.name(), 4, 5);
		terminal.write("Cash: $" + Player.playerCash(), 4, 7);
		terminal.write("Cargo: " + IntStream.of(Player.playerInventory()).sum() + "/" + Player.currentShip().maxCommodities(), 4, 8);
		terminal.write("Crew: " + IntStream.of(Player.playerCrew()).sum() + "/" + Player.currentShip().maxCrew(), 4, 9);
		terminal.write("Modules: " + IntStream.of(Player.playerModules()).sum() + "/" + Player.currentShip().maxModules(), 4, 10);
		terminal.write("Food: " + Player.currentShip().currentFood() + "/" + Player.currentShip().maxFood(), 20, 7);
		terminal.write("Fuel: " + Player.currentShip().currentFuel() + "/" + Player.currentShip().maxFuel(), 20, 8);
		terminal.write("Hull: " + Player.currentShip().currentHull() + "/" + Player.currentShip().maxHull(), 20, 9);
		terminal.write("Oxygen: " + Player.currentShip().oxygenPercentage() + "%", 20, 10);

		terminal.write("---------------", 13, 11);
		terminal.write("---------------", 13, 13);
		terminal.writeColumn("|", 12, 11, 13);
		terminal.writeColumn("|", 28, 11, 13);
		terminal.write("Return to map", 14, 12);	
	}
}