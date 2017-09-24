package frontier.modules;

import frontier.location.Location;

//Class to provide structure to all modules
public enum Module {
	WEAPONS, SHIELDS, HULL, ENGINES, CARGO, STORES; 
	
	public static final int numModules = Location.numLocations * 6;

}
