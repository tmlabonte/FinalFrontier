package frontier.starships;

import frontier.Panel;

//Class to provide structure to all starships
public class Starship {
	private String name;
	
	private int maxHull;
	private int currentHull;
	private int weaponry;
	private int durability;
	
	private int travelSpeed; //maximum 10
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
		this.weaponry = weaponry;
		this.durability = durability;
		
		this.travelSpeed = travelSpeed;
		this.crewCapacity = crewCapacity;
		this.moduleCapacity = moduleCapacity;
		this.commodityCapacity = commodityCapacity;
		this.fuelCapacity = fuelCapacity;
		this.foodCapacity = foodCapacity;
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
	
	public int weaponry() {
		return weaponry;
	}
	
	public int durability() {
		return durability;
	}
	
	public int travelSpeed() {
		return travelSpeed;
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
	
	public int foodCapacity() {
		return foodCapacity;
	}
	
	public int currentFood() {
		return currentFood;
	}
	
	public int oxygenPercentage() {
		return oxygenPercentage;
	}
	
	public void displayShip(Panel terminal, int x0, int y0) {
	}
}