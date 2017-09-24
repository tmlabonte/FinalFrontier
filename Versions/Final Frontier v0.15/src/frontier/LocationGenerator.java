package frontier;

import java.util.Random;
import java.util.ArrayList;

//Class to generate master list of locations during initialization
public class LocationGenerator {
	public LocationGenerator() {
	}
	
	//Returns an ArrayList of unique Locations with unique inventories
	public ArrayList<Location> generateLocations(int amount, Commodity[] commodityList) {
		Random rand = new Random();
		String name;
		Location newLocation;
		ArrayList<Location> list = new ArrayList<Location>(amount);
		
		//Pool of possible names
		String[] star = {"Alpha", "Bersari", "Canteco", "Deriva", "Epsilon", "Fermi", "Georgia", "Hiaasen",
						 "Indigo", "Jacobi", "Kel", "Leve", "Mashir", "Naeve", "Olmont", "Porto", "Quast",
						 "Reach", "Sokovitch", "Triopta", "Undror", "Ved", "Weam", "Xandr", "Yorgon", "Zant"};
		String[] num = {"127-4", "98001", "513-22", "655-8", "7336", "45", "044", "7727", "6126", "54-881",
						"809-3", "7633-31", "8989", "314159", "8736-6A", "782-B", "12", "4", "3241A", "988F", 
						"322-0", "542X", "368C", "8345", "325-33", "134-2B"};
		
		//Creates a new Location with a randomized Inventory and adds it to the list if it is unique
		for (int i=0; i<amount; i++) {
			//Creates a random name from the pool
			name = star[rand.nextInt(star.length)] + " " + num[rand.nextInt(num.length)];
			
			//Creates a new Location with the designated name and Inventory
			newLocation = new Location(name, commodityList);
			
			//Checks for repeats by iteration; if the Location is not unique, the iterator i decreases
			int matches = 0;
			for (int j=0; j<list.size(); j++) {
				if (newLocation.name().equals(list.get(j).name())) {
					matches++;
				}
			}
			
			if (matches == 0) {
				list.add(newLocation);
			}
			else {
				i--;
			}
		}
		
		return list;
	}
}