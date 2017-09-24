package frontier.screens;

import java.awt.event.MouseEvent;

import frontier.location.Location;
import frontier.Panel;

//Class to represent the shipyard screen
public class ShipyardScreen extends Screen {
	public ShipyardScreen() {
		super();
	}
	
	public Screen respondToInput(MouseEvent m) {
		System.out.println(m.getPoint());
		return this;
	}

	public void displayOutput(Panel terminal) {
		Location.currentLocation().displayLocation(terminal);
	}
}