package frontier.starships;

import frontier.main.Panel;

//Class to provide structure to all starships
public class Starship {
	private String name;
	
	private double maxHull;
	private int currentHull;
	private double weaponry;
	private double shields;
	
	private double travelSpeed; //5 is average
	private int maxCrew; //maximum 6
	private int maxModules; //maximum 6
	private double maxCargo;
	private double maxFuel;
	private int currentFuel;
	private double maxFood;
	private int currentFood;
	private int oxygenPercentage; //maximum 100
	private int shipRank;
	private int price;
	
	public Starship(String name, double maxHull, double weaponry, double shields, double travelSpeed, int maxCrew,
					int maxModules, double maxCargo, double maxFuel, double maxFood, int shipRank, int price) {
		this.name = name;
		
		this.maxHull = maxHull;
		this.currentHull = (int) maxHull;
		this.weaponry = weaponry;
		this.shields = shields;
		
		this.travelSpeed = travelSpeed;
		this.maxCrew = maxCrew;
		this.maxModules = maxModules;
		this.maxCargo = maxCargo;
		this.maxFuel = maxFuel;
		this.currentFuel = (int) maxFuel;
		this.maxFood = maxFood;
		this.currentFood = (int) maxFood;
		this.oxygenPercentage = 100;
		this.shipRank = shipRank;
		this.price = price;
	}
	
	public String name() {
		return name;
	}
	
	public int maxHull() {
		return (int) maxHull;
	}
	
	public void multiplyMaxHull(double multiplier) {
		this.maxHull = this.maxHull * multiplier;
	}
	
	public int currentHull() {
		return currentHull;
	}
	
	public void changeCurrentHull(int amount) {
		this.currentHull += amount;
	}
	
	public int weaponry() {
		return (int) weaponry;
	}
	 
	public void multiplyWeaponry(double multiplier) {
		this.weaponry = this.weaponry * multiplier;
	}
	
	public int shields() {
		return (int) shields;
	}
	
	public void multiplyShields(double multiplier) {
		this.shields = this.shields * multiplier;
	}
	
	public int travelSpeedInt() {
		return (int) travelSpeed;
	}
	
	public double travelSpeedDouble() {
		return travelSpeed;
	}
	
	public void multiplyTravelSpeed(double multiplier) {
		this.travelSpeed = this.travelSpeed * multiplier;
	}
	
	public int maxCrew() {
		return maxCrew;
	}
	
	public int maxModules() {
		return maxModules;
	}
	
	public int maxCargo() {
		return (int) maxCargo;
	}
	
	public void multiplyMaxCargo(double multiplier) {
		this.maxCargo = this.maxCargo * multiplier;
	}
	
	public int maxFuel() {
		return (int) maxFuel;
	}
	
	public void multiplyMaxFuel(double multiplier) {
		this.maxFuel = this.maxFuel * multiplier;
	}
	
	public int currentFuel() {
		return currentFuel;
	}
	
	public void changeCurrentFuel(int amount) {
		this.currentFuel += amount;
	}
	
	public int maxFood() {
		return (int) maxFood;
	}
	
	public void multiplyMaxFood(double multiplier) {
		this.maxFood = this.maxFood * multiplier;
	}
	
	public int currentFood() {
		return currentFood;
	}
	
	public void changeCurrentFood(int amount) {
		this.currentFood += amount;
	}
	
	public int oxygenPercentage() {
		return oxygenPercentage;
	}
	
	public void changeOxygen(int amount) {
		this.oxygenPercentage += amount;
	}
	
	public int shipRank() {
		return shipRank;
	}
	
	public int price() {
		return price;
	}
	
	public void multiplyStat(String stat, double multiplier) {
		if (stat.equals("Weapons")) {
			multiplyWeaponry(multiplier);
		}
		else if (stat.equals("Shields")) {
			multiplyShields(multiplier);
		}
		else if (stat.equals("Hull")) {
			multiplyMaxHull(multiplier);
		}
		else if (stat.equals("Engines")) {
			multiplyTravelSpeed(multiplier);
		}
		else if (stat.equals("Cargo")) {
			multiplyMaxCargo(multiplier);
		}
		else if (stat.equals("Supplies")) {
			multiplyMaxFuel(multiplier);
			multiplyMaxFood(multiplier);
		}
	}
	
	public void displayShip(Panel terminal, int xCenter, int yCenter) {
	}
}