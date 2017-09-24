package frontier;

import java.util.Random;

//Class to generate master list of commodities during initialization
public class CommodityGenerator {
	public CommodityGenerator() {
	}
	
	//Returns an Inventory of unique Commodities (all with quantity 1)
	public Commodity[] generateCommodities(int amount) {
		String name;
		int basePrice;
		Commodity newCommodity;
		Commodity[] list = new Commodity[amount];
		Random rand = new Random();
		
		//Pool of possible names
		String[] adj = {"Amazing", "Bioluminescent", "Crispy", "Dull", "Extreme", "Ferrous", "Gorgeous", "Horrible",
						"Illuminated", "Jazzy", "Heavy", "Keen", "Luscious", "Massive", "Nubile", "Orthographic",
						"Patchwork", "Quiet", "Reluctant", "Sensitive", "Trippy", "Undying", "Virtuous",
						"Watchful", "Xenomorphic", "Yiddish", "Zombified"};
		String[] noun = {"Abacus", "Bearskin", "Candle", "Diary", "Eolith", "Forearm", "Gavel", "Hardware",
						 "Ivory", "Jigsaw", "Knife", "Loincloth", "Miniskirt", "Necktie", "Ocarina",
						 "Parka", "Quiver", "Raspberry", "Soupcooker", "Tiara", "Ukulele", "Ventricle",
						 "Waffle", "Xylophone", "Yacht", "Zodiac"};
		
		//Creates a new Commodity and adds it to the list if it is unique
		for (int i=0; i<amount; i++) {
			//Creates a new Commodity with a random name from the pool and a random base price
			name = adj[rand.nextInt(adj.length)] + " " + noun[rand.nextInt(noun.length)];
			basePrice = rand.nextInt(30) + 1;
			newCommodity = new Commodity(name, basePrice);
			
			//Checks for repeats by iteration; if the Commodity is not unique, the iterator i decreases
			int matches = 0;
			for (int j=0; j<list.length; j++) {
				if (list[j] != null && name.equals(list[j].name())) {
					matches++;
				}
			}
			
			//If the Commodity is unique, add it to the list
			if (matches == 0) {
				list[i] = newCommodity;
			}
			else {
				i--;
			}
		}
		return list;
	}
}