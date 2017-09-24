package frontier.screens;

import java.awt.event.MouseEvent;

import frontier.Panel;

public class ShipPurchaseScreen extends Screen {
	public ShipPurchaseScreen() {
		super();
	}

	@Override
	public Screen respondToInput(MouseEvent m) {
		//If the player clicks "Return to star menu"
		if (m.getID() == MouseEvent.MOUSE_CLICKED && m.getX() >= 460 && m.getX() <= 625 && m.getY() >= 240 && m.getY() <= 250) {
			//Return to star menu
			return new StarScreen();
		}
		//If the player clicks "Return to map"...
		else if (m.getID() == MouseEvent.MOUSE_CLICKED && m.getX() >= 125 && m.getX() <= 255 && m.getY() >= 215 && m.getY() <= 245) {
			//Load the map
			return new MapScreen();
		}
		//If the player clicks somewhere else...
		else {
			System.out.println(m.getPoint());
			return this;
		}
	}

	@Override
	public void displayOutput(Panel terminal) {
		// TODO Auto-generated method stub
	}
}