package frontier.module;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import frontier.location.Location;

//Class to provide structure to all modules
public class Module {
	public static final int numModules = Location.numLocations * 6;
	private Type type;
	private String name;
	private double multiplier;
	private int price;
	
	//List of possible module types:
	//	WEAPONS boosts weaponry
	//  SHIELDS boosts durability
	//  HULL boosts maxHull
	//	ENGINES boosts travelSpeed
	//	CARGO boosts maxCommodities
	//	STORES boosts maxFuel and maxFood
	public enum Type {
		WEAPONS("Weapons"), SHIELDS("Shields"), HULL("Hull"), ENGINES("Engines"), CARGO("Cargo"), SUPPLIES("Supplies"); 
		
		private String name;
		Type(String name) {this.name = name;}
		
		public String toString() {
			return name;
		}
	}
	private static final Type[] VALUES = Type.values();
	private static final int SIZE = VALUES.length;
	private static final Random RANDOM = new Random();
	
	public Module(Type type) {
		this.type = type;
		this.name = type.toString();
		
		multiplier = ThreadLocalRandom.current().nextDouble(1.2, 1.36);
		price = ThreadLocalRandom.current().nextInt(15, 41);
	}
	
	public static Type randomType() {
		return VALUES[RANDOM.nextInt(SIZE)];
	}
	
	public String name() {
		return name;
	}
	
	public Type type() {
		return type;
	}
	
	public double multiplier() {
		return multiplier;
	}
	
	public int price() {
		return price;
	}
}