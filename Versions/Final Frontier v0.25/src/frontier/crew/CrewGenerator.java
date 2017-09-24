package frontier.crew;

import java.util.Random;
import java.util.ArrayList;

//Class to generate master list of crew during initialization
public class CrewGenerator {
	public CrewGenerator() {
	}
	
	//Returns an ArrayList of unique crew members
	public ArrayList<Crew> generateCrew(int amount) {
		String name;
		ArrayList<Crew> list = new ArrayList<Crew>(amount);
		Random rand = new Random();
		
		//Pool of possible names
		String first[] = {"A.", "B.", "C.", "D.", "E.", "F.", "G.", "H.",
						  "I.", "J.", "K.", "L.", "M.", "N.", "O.",
						  "P.", "Q.", "R.", "S.", "T.", "U.", "V.",
						  "W.", "X.", "Y.", "Z."};
		String last[] = {"Alvarado", "Baetiong", "Cena", "Dre", "Euler", "Frost", "Gauss", "Hana",
						 "Ingram", "Jones", "King", "LaBonte", "Martin", "Nash", "O'Hare",
						 "Pickles", "Quick", "Riemann", "Shepard", "Tang", "Ulman", "Vickars",
						 "Wiggin", "Xavier", "Ying", "Zevos"};
		
		//Creates a new Crew and adds it to the list if it is unique
		for (int i=0; i<amount; i++) {
			//Creates a new Crew with a random name from the pool
			name = first[rand.nextInt(first.length)] + " " + last[rand.nextInt(last.length)];
			Crew newCrew = new Crew(name, Crew.randomSpecialty());
			
			//Checks for repeats by iteration; if the Crew is not unique, the iterator i decreases
			int matches = 0;
			for (int j=0; j<list.size(); j++) {
				if (newCrew.name().equals(list.get(j).name())) {
					matches++;
				}
			}
			if (matches == 0) {
				list.add(newCrew);
			}
			else {
				i--;
			}
		}
		return list;
	}
}