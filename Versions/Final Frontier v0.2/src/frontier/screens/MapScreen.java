package frontier.screens;

import java.util.Random;
import java.awt.event.MouseEvent;
import frontier.Main;
import frontier.Location;
import frontier.Panel;

public class MapScreen extends Screen {
	Random rand = new Random();
	int index, x, y;
	
	public MapScreen () {
		super();
		index = -1;
	}
	
	public Screen respondToInput(MouseEvent m) {
		//If this is the first time a player clicked on a certain location, set index to the location's position in locationList
		if (index == -1 && m.getID() == MouseEvent.MOUSE_CLICKED) {
			x = m.getX() / 9 - 1;
			y = (m.getY() - 32) / 16;
			for (Location location : Main.locationList) {
				if (location.xPos() == x && location.yPos() == y) {
					index = Main.locationList.indexOf(location);
				}
			}
			return this;
		}
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
				Location.moveTo(Main.locationList.get(index));
				return new StarScreen();
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
		}
		
		//If player clicks a location, displays name
		if (index != -1) {
			terminal.write("Star selected: " + Main.locationList.get(index).name(), 27, 19);
			terminal.write("Click again to travel", 27, 20);
		} 
	}
}