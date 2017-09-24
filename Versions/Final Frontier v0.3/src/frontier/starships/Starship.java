package frontier.starships;

import frontier.Panel;

//Class to provide structure to all starships
public class Starship {
	private String name;
	
	private int maxHull;
	private int currentHull;
	private int weaponry;
	private int durability;
	
	private int travelSpeed;
	private int crewCapacity; //maximum 6
	private int moduleCapacity; //maximum 6
	private int commodityCapacity;
	private int fuelCapacity;
	private int currentFuel;
	private int foodCapacity;
	private int currentFood;
	private int oxygenPercentage; //maximum 100
	
	public Starship(String name, int maxHull, int weaponry, int durability, int travelSpeed, int crewCapacity,
					int moduleCapacity, int commodityCapacity, int fuelCapacity, int foodCapacity) {
		this.name = name;
		
		this.maxHull = maxHull;
		this.currentHull = maxHull;
		this.weaponry = weaponry;
		this.durability = durability;
		
		this.travelSpeed = travelSpeed;
		this.crewCapacity = crewCapacity;
		this.moduleCapacity = moduleCapacity;
		this.commodityCapacity = commodityCapacity;
		this.fuelCapacity = fuelCapacity;
		this.currentFuel = fuelCapacity;
		this.foodCapacity = foodCapacity;
		this.currentFood = foodCapacity;
		this.oxygenPercentage = 100;
	}
	
	public String name() {
		return name;
	}
	
	public int maxHull() {
		return maxHull;
	}
	
	public int currentHull() {
		return currentHull;
	}
	
	public void changeHull(int amount) {
		this.currentHull += amount;
	}
	
	public int weaponry() {
		return weaponry;
	}
	 
	public void changeWeaponry(int amount) {
		this.weaponry += amount;
	}
	
	public int durability() {
		return durability;
	}
	
	public void changeDurability(int amount) {
		this.durability += amount;
	}
	
	public int travelSpeed() {
		return travelSpeed;
	}
	
	public void changeTravelSpeed(int amount) {
		this.travelSpeed += amount;
	}
	
	public int crewCapacity() {
		return crewCapacity;
	}
	
	public int modCapacity() {
		return moduleCapacity;
	}
	
	public int commodityCapacity() {
		return commodityCapacity;
	}
	
	public int fuelCapacity() {
		return fuelCapacity;
	}
	
	public int currentFuel() {
		return currentFuel;
	}
	
	public void changeFuel(int amount) {
		this.currentFuel += amount;
	}
	
	public int foodCapacity() {
		return foodCapacity;
	}
	
	public void changeFood(int amount) {
		this.currentFood += amount;
	}
	
	public int currentFood() {
		return currentFood;
	}
	
	public int oxygenPercentage() {
		return oxygenPercentage;
	}
	
	public void changeOxygen(int amount) {
		this.oxygenPercentage += amount;
	}
	
	public void displayShip(Panel terminal, int x0, int y0) {
	}
}