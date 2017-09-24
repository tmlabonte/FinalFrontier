package frontier.screens;

import java.util.Random;
import java.util.stream.IntStream;
import java.awt.event.MouseEvent;

import frontier.location.Location;
import frontier.main.Main;
import frontier.main.Panel;
import frontier.main.Player;

//Class to represent the map screen
public class MapScreen extends Screen {
	Random rand = new Random();
	int index, x, y, foodCheck, fuelCheck, foodToSubtract, fuelToSubtract;
	
	public MapScreen () {
		super();
		index = -1;
	}
	
	public Screen respondToInput(MouseEvent m) {
		foodCheck = fuelCheck = 1;
		
		//If this is the first time a player clicked on a certain location, set index to the location's position in locationList
		if (index == -1 && m.getID() == MouseEvent.MOUSE_CLICKED && m.getY() < 340) {
			x = m.getX() / 9 - 1;
			y = m.getY() / 16 - 2;
			for (Location location : Main.locationList) {
				if (location.xPos() == x && location.yPos() == y) {
					index = Main.locationList.indexOf(location);
				}
			}
			return this;
		}
		//If the player clicks "Player Info"
		if (index == -1 && m.getID() == MouseEvent.MOUSE_CLICKED && m.getX() >= 310 && m.getX() <= 435 && m.getY() >= 340 && m.getY() <= 370) {
			return new InfoScreen();
		}
		//If this is the second time a player clicked on a certain location...
		else if (index != -1 && m.getID() == MouseEvent.MOUSE_CLICKED) {
			int indexCheck = -1;
			
			x = m.getX() / 9 - 1;
			y = (m.getY() - 32) / 16;
			for (Location location : Main.locationList) {
				if (location.xPos() == x && location.yPos() == y) {
					indexCheck = Main.locationList.indexOf(location);
				}
			}
			
			//If the player clicked twice on the same location, move to that location
			if (indexCheck == index) {
				foodToSubtract = Location.currentLocation().distanceTo(Main.locationList.get(index)) == 0 ? 0 : (IntStream.of(Player.playerCrew()).sum() + 1) * Location.currentLocation().distanceTo(Main.locationList.get(index));
				fuelToSubtract = Location.currentLocation().distanceTo(Main.locationList.get(index)) == 0 ? 0 : (int)((IntStream.of(Player.playerCargo()).sum() + 5) / 5) + (int)(1.5 * Location.currentLocation().distanceTo(Main.locationList.get(index)));
				
				//Check if player has enough food and fuel
				if (foodToSubtract > Player.currentShip().currentFood() && fuelToSubtract > Player.currentShip().currentFuel()) {	
					foodCheck = fuelCheck = -1;
					return this;
				}
				else if (foodToSubtract > Player.currentShip().currentFood()) {
					foodCheck = -1;
					return this;
				}
				else if (fuelToSubtract > Player.currentShip().currentFuel()) {
					fuelCheck = -1;
					return this;
				}
				else {
					//Subtract food and fuel
					Player.currentShip().changeCurrentFood(-foodToSubtract);
					Player.currentShip().changeCurrentFuel(-fuelToSubtract);
					
					//Replenish inventories, change location, and display new screen
					Location.replenish(Location.currentLocation().distanceTo(Main.locationList.get(index)));
					Location.moveTo(Main.locationList.get(index));
					return new StarScreen();
				}
			}
			//If the player clicked on a different location, set index to the location's position in locationList
			else {
				index = indexCheck;
				return this;
			}	
		}
		else {
			System.out.println(m.getPoint());
			return this;
		}
	}
	
	public void displayOutput(Panel terminal) {
		//Draws ASCII border
		Screen.drawBorder(terminal);
		
		//Draws locations
		for (int i=0; i<Location.numLocations; i++) {
			terminal.write("@", Main.locationList.get(i).xPos(), Main.locationList.get(i).yPos());
			if (Main.locationList.get(i) == Location.currentLocation()) {
				terminal.write("!", Main.locationList.get(i).xPos() + 1, Main.locationList.get(i).yPos());
				terminal.write("!", Main.locationList.get(i).xPos() - 1, Main.locationList.get(i).yPos());
				terminal.write("!", Main.locationList.get(i).xPos(), Main.locationList.get(i).yPos() + 1);
				terminal.write("!", Main.locationList.get(i).xPos(), Main.locationList.get(i).yPos() - 1);
			}
		}
		
		//If a check is failed, display what happened
		if (foodCheck == -1 && fuelCheck == -1) {
			terminal.write("Need " + (foodToSubtract - Player.currentShip().currentFood()) + " more food and " + (fuelToSubtract - Player.currentShip().currentFuel()) + " more fuel", 27, 20);
		}
		else if (foodCheck == -1) {
			terminal.write("Need " + (foodToSubtract - Player.currentShip().currentFood()) + " more food", 27, 20);
		}
		else if (fuelCheck == -1) {
			terminal.write("Need " + (fuelToSubtract - Player.currentShip().currentFuel()) + " more fuel", 27, 20);
		}
		//If player clicks a location, displays name
		else if (index != -1) {
			terminal.write("Star selected: " + Main.locationList.get(index).name(), 27, 19);
			terminal.write("Distance: " + Location.currentLocation().distanceTo(Main.locationList.get(index)) + " ly", 27, 20);
			terminal.write("Click again to travel", 27, 21);
		}
		else {
			terminal.write("-------------", 34, 19);
			terminal.write("-------------", 34, 21);
			terminal.writeColumn("|", 33, 19, 21);
			terminal.writeColumn("|", 47, 19, 21);
			terminal.write("Player Info", 35, 20);
		}
	}
}