package frontier.screens;

import java.awt.event.MouseEvent;

import frontier.Location;
import frontier.Panel;

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