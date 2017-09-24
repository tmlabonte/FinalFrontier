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
	private int maxCrew; //maximum 6
	private int maxModules; //maximum 6
	private int maxCommodities;
	private int maxFuel;
	private int currentFuel;
	private int maxFood;
	private int currentFood;
	private int oxygenPercentage; //maximum 100
	
	public Starship(String name, int maxHull, int weaponry, int durability, int travelSpeed, int maxCrew,
					int maxModules, int maxCommodities, int maxFuel, int maxFood) {
		this.name = name;
		
		this.maxHull = maxHull;
		this.currentHull = maxHull;
		this.weaponry = weaponry;
		this.durability = durability;
		
		this.travelSpeed = travelSpeed;
		this.maxCrew = maxCrew;
		this.maxModules = maxModules;
		this.maxCommodities = maxCommodities;
		this.maxFuel = maxFuel;
		this.currentFuel = maxFuel;
		this.maxFood = maxFood;
		this.currentFood = maxFood;
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
	 
	public void multiplyWeaponry(double multiplier) {
		this.weaponry = (int)(this.weaponry * multiplier);
	}
	
	public int durability() {
		return durability;
	}
	
	public void multiplyDurability(double multiplier) {
		this.durability = (int)(this.durability * multiplier);
	}
	
	public int travelSpeed() {
		return travelSpeed;
	}
	
	public void multiplyTravelSpeed(double multiplier) {
		this.travelSpeed = (int)(this.travelSpeed * multiplier);
	}
	
	public int maxCrew() {
		return maxCrew;
	}
	
	public int maxModules() {
		return maxModules;
	}
	
	public int maxCommodities() {
		return maxCommodities;
	}
	
	public void multiplyMaxCommodities(double multiplier) {
		this.maxCommodities = (int)(this.maxCommodities * multiplier);
	}
	
	public int maxFuel() {
		return maxFuel;
	}
	
	public void multiplyMaxFuel(double multiplier) {
		this.maxFuel = (int)(this.maxFuel * multiplier);
	}
	
	public int currentFuel() {
		return currentFuel;
	}
	
	public void changeFuel(int amount) {
		this.currentFuel += amount;
	}
	
	public int maxFood() {
		return maxFood;
	}
	
	public void multiplyMaxFood(double multiplier) {
		this.maxFood = (int)(this.maxFood * multiplier);
	}
	
	public int currentFood() {
		return currentFood;
	}
	
	public void changeFood(int amount) {
		this.currentFood += amount;
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