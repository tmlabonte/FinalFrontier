package frontier.location;

import java.util.Random;
import frontier.commodity.Commodity;
import java.util.ArrayList;

//Class to generate master list of locations during initialization
public class LocationGenerator {
	public LocationGenerator() {
	}
	
	//Returns an ArrayList of unique Locations with unique inventories
	public ArrayList<Location> generateLocations(Commodity[] commodityList) {
		Random rand = new Random();
		String name;
		Location newLocation;
		ArrayList<Location> list = new ArrayList<Location>(Location.numLocations);
		
		//Pool of possible names
		String[] star = {"Alpha", "Bersari", "Canteco", "Deriva", "Epsilon", "Fermi", "Georgia", "Hiaasen",
						 "Indigo", "Jacobi", "Kel", "Leve", "Mashir", "Naeve", "Olmont", "Porto", "Quast",
						 "Reach", "Sokovitch", "Triopta", "Undror", "Ved", "Weam", "Xen", "Yorgon", "Zant"};
		String[] num = {"127-4", "98001", "513-22", "655-8", "7336", "45", "044", "7727", "6126", "54-881",
						"809-3", "7633-31", "8989", "314159", "8736-6A", "782-B", "12", "4", "3241A", "988F", 
						"322-0", "542X", "368C", "8345", "325-33", "134-2B"};
		
		//Creates a new Location with a randomized Inventory and adds it to the list if it is unique
		for (int i=0; i<Location.numLocations; i++) {
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
		
		//Sets positions of every location uniquely
		ArrayList<String> positions = new ArrayList<String>(Location.numLocations);
		for (int i=0; i<Location.numLocations; i++) {
			for (Location location : list) {
				positions.add("" + location.xPos() + location.yPos());
			}
			
			//Sets location by quadrant
			if (i < Location.numLocations / 4) {
				list.get(i).setPos(rand.nextInt(36) + 4, rand.nextInt(8) + 3);
			}
			else if (i >= Location.numLocations / 4 && i < Location.numLocations / 2) {
				list.get(i).setPos(rand.nextInt(36) + 4, rand.nextInt(7) + 11);
			}
			else if (i >= Location.numLocations / 2 && i < Location.numLocations * 3 / 4) {
				list.get(i).setPos(rand.nextInt(36) + 40, rand.nextInt(8) + 3);
			}
			else {
				list.get(i).setPos(rand.nextInt(36) + 40, rand.nextInt(7) + 11);
			}
			
			//Checks for duplicates on or around a point
			while (positions.contains("" + list.get(i).xPos() + list.get(i).yPos()) ||
				   positions.contains("" + (list.get(i).xPos() + 1) + (list.get(i).yPos() + 1)) ||
				   positions.contains("" + (list.get(i).xPos() + 1) + list.get(i).yPos()) ||
				   positions.contains("" + list.get(i).xPos() + (list.get(i).yPos() + 1)) ||
				   positions.contains("" + (list.get(i).xPos() - 1) + list.get(i).yPos()) ||
				   positions.contains("" + (list.get(i).xPos() - 1) + (list.get(i).yPos() - 1)) ||
				   positions.contains("" + (list.get(i).xPos() + 1) + (list.get(i).yPos() - 1)) ||
				   positions.contains("" + (list.get(i).xPos() - 1) + (list.get(i).yPos() + 1)) ||
				   positions.contains("" + list.get(i).xPos() + (list.get(i).yPos() - 1))) {
				if (i < Location.numLocations / 4) {
					list.get(i).setPos(rand.nextInt(37) + 4, rand.nextInt(8) + 3);
				}
				else if (i >= Location.numLocations / 4 && i < Location.numLocations / 2) {
					list.get(i).setPos(rand.nextInt(37) + 4, rand.nextInt(8) + 10);
				}
				else if (i >= Location.numLocations / 2 && i < Location.numLocations * 3 / 4) {
					list.get(i).setPos(rand.nextInt(36) + 40, rand.nextInt(8) + 3);
				}
				else {
					list.get(i).setPos(rand.nextInt(36) + 40, rand.nextInt(8) + 10);
				}
			}	
			positions.clear();
		}
		return list;
	}
}