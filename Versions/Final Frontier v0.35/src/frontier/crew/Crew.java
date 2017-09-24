package frontier.crew;

import java.util.concurrent.ThreadLocalRandom;

import frontier.location.Location;

import java.util.Random;

//Class to represent the different crew members in the game
public class Crew {
	public static final int numCrew = Location.numLocations * 6;
	private String name;
	private Specialty specialty;
	private double multiplier;
	private double specialtyMultiplier;
	private int signingFee;
	private int salary;
	
	//List of possible specialties:
	//	WEAPONS boosts weaponry
	//  SHIELDS boosts durability
	//  HULL boosts maxHull
	//	ENGINES boosts travelSpeed
	public enum Specialty {
		WEAPONS("Weapons"), SHIELDS("Shields"), HULL("Hull"), ENGINES("Engines");
		
		private String name;
		Specialty(String name) {this.name = name;}

		public String toString() {
			return name;
		}
	}
	private static final Specialty[] VALUES = Specialty.values();
	private static final int SIZE = VALUES.length;
	private static final Random RANDOM = new Random();
	
	//Creates a new crew member with a random name, specialty, and multipliers
	public Crew(String name, Specialty specialty){
		this.name = name;
		this.specialty = specialty;
		
		//Sets multipliers
		multiplier = ThreadLocalRandom.current().nextDouble(1.05, 1.16);
		specialtyMultiplier = ThreadLocalRandom.current().nextDouble(1.2, 1.36);
		
		//Sets signing fee and salary
		signingFee = ThreadLocalRandom.current().nextInt(10, 31);
		salary = ThreadLocalRandom.current().nextInt(5, 11);
	}
	
	public static Specialty randomSpecialty() {
		return VALUES[RANDOM.nextInt(SIZE)];
	}
	
	public String name() {
		return name;
	}
	
	public Specialty specialty() {
		return specialty;
	}
	
	public double multiplier() {
		return multiplier;
	}
	
	public double specialtyMultiplier() {
		return specialtyMultiplier;
	}
	
	public int signingFee() {
		return signingFee;
	}
	
	public int salary() {
		return salary;
	}
}