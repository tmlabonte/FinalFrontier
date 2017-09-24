package frontier.screens;

import java.awt.event.MouseEvent;
import frontier.location.Location;
import frontier.Panel;

//Class to represent the base location screen
public class StarScreen extends Screen {
	public StarScreen() {
		super();
	}

	public Screen respondToInput(MouseEvent m) {
		if (m.getID() == MouseEvent.MOUSE_CLICKED && m.getX() >= 470 && m.getX() <= 590 && m.getY() >= 85 && m.getY() < 115) {
			return new WarehouseScreen();
		}
		else if (m.getID() == MouseEvent.MOUSE_CLICKED && m.getX() >= 470 && m.getX() <= 590 && m.getY() >= 150 && m.getY() < 180) {
			return new ShipyardsScreen();
		}
		else if (m.getID() == MouseEvent.MOUSE_CLICKED && m.getX() >= 470 && m.getX() <= 590 && m.getY() >= 215 && m.getY() < 245) {
			return new CantinaScreen();
		}
		//If the player clicks "Return to map"...
		else if (m.getID() == MouseEvent.MOUSE_CLICKED && m.getX() >= 125 && m.getX() <= 255 && m.getY() >= 215 && m.getY() < 245) {
			//Load the map
			return new MapScreen();
		}
		else {
			System.out.println(m.getPoint());
			return this;
		}
	}

	public void displayOutput(Panel terminal) {
		Location.currentLocation().displayLocation(terminal);
		
		terminal.write("-------------", 52, 3);
		terminal.write("-------------", 52, 5);
		terminal.writeColumn("|", 51, 3, 5);
		terminal.writeColumn("|", 64, 3, 5);
		terminal.write("Warehouse", 54, 4);
		
		terminal.write("-------------", 52, 7);
		terminal.write("-------------", 52, 9);
		terminal.writeColumn("|", 51, 7, 9);
		terminal.writeColumn("|", 64, 7, 9);
		terminal.write("Shipyards", 54, 8);
		
		terminal.write("-------------", 52, 11);
		terminal.write("-------------", 52, 13);
		terminal.writeColumn("|", 51, 11, 13);
		terminal.writeColumn("|", 64, 11, 13);
		terminal.write("Cantina", 55, 12);
	}
}