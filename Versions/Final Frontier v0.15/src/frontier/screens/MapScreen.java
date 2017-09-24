package frontier.screens;

import java.util.Random;
import java.awt.event.MouseEvent;
import frontier.Main;
import frontier.Location;
import frontier.Panel;

public class MapScreen extends Screen {
	Random rand = new Random();
	int index;
	
	public MapScreen () {
		super();
		index = -1;
	}
	
	private void drawLocation(Panel terminal, int xCenter, int yCenter) {
		terminal.write("@", xCenter, yCenter);
	}
	
	public Screen respondToInput(MouseEvent m) {
		if (index == -1 && m.getID() == MouseEvent.MOUSE_CLICKED && m.getX() >= 145 && m.getX() < 595 && m.getY() >= 75 && m.getY() <= 335) {
			index = (m.getX()-145)/90;
			index = m.getY() <= 205 ? index : index + 5;
			return this;
		}
		else if (index != -1 && m.getID() == MouseEvent.MOUSE_CLICKED && m.getX() >= 145 && m.getX() < 595 && m.getY() >= 75 && m.getY() <= 335) {
			int indexCheck = (m.getX()-145)/90;
			indexCheck = m.getY() <= 205 ? indexCheck : indexCheck + 5;
			
			if (indexCheck == index) {
				Location.currentLocation();
				Location.moveTo(Main.locationList.get(index));
				return new ShopScreen();
			}
			else {
				index = (m.getX()-145)/90;
				index = m.getY() <= 205 ? index : index + 5;
				return this;
			}	
		}
		else {
			System.out.println(m.getPoint());
			return this;
		}
	}
	
	public void displayOutput(Panel terminal) {
		Screen.drawBorder(terminal);
		for (int i=0; i<5; i++) {
			drawLocation(terminal, 20 + 10*i, 5);
			drawLocation(terminal, 20 + 10*i, 16);
		}
		if (index != -1) {
			terminal.write("Star selected: " + Main.locationList.get(index).name(), 25, 10);
			terminal.write("Click again to travel", 25, 11);
		}
	}
}