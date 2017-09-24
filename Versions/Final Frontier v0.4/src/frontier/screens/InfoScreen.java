package frontier.screens;

import java.awt.event.MouseEvent;
import java.util.stream.IntStream;

import frontier.main.Panel;
import frontier.main.Player;

//Class to represent the info screen
public class InfoScreen extends Screen {
	public InfoScreen() {
		super();
	}

	public Screen respondToInput(MouseEvent m) {
		//If the player clicks "Return to map"...
		if (m.getID() == MouseEvent.MOUSE_CLICKED && m.getX() >= 125 && m.getX() <= 255 && m.getY() >= 215 && m.getY() <= 245) {
			//Load the map
			return new MapScreen();
		}
		//If the player clicks somewhere else...
		else {
			System.out.println(m.getPoint());
			return this;
		}
	}

	public void displayOutput(Panel terminal) {
		Screen.drawBorder(terminal);
		terminal.writeColumn("|", 39, 2, 13);
		terminal.writeCenter("----------------------------------------------------------------------------", 14);

		terminal.write(Player.currentShip().name(), 4, 3);
		terminal.write("Rank: " + Player.currentShip().shipRank(), 4, 4);
		terminal.write("Engines: " + Player.currentShip().travelSpeedInt(), 4, 5);
		terminal.write("Weaponry: " + Player.currentShip().weaponry(), 20, 4);
		terminal.write("Shields: " + Player.currentShip().shields(), 20, 5);
		terminal.write("Cash: $" + Player.playerCash(), 4, 7);
		terminal.write("Cargo: " + IntStream.of(Player.playerCargo()).sum() + "/" + Player.currentShip().maxCargo(), 4, 8);
		terminal.write("Crew: " + IntStream.of(Player.playerCrew()).sum() + "/" + Player.currentShip().maxCrew(), 4, 9);
		terminal.write("Modules: " + IntStream.of(Player.playerModules()).sum() + "/" + Player.currentShip().maxModules(), 4, 10);
		terminal.write("Food: " + Player.currentShip().currentFood() + "/" + Player.currentShip().maxFood(), 20, 7);
		terminal.write("Fuel: " + Player.currentShip().currentFuel() + "/" + Player.currentShip().maxFuel(), 20, 8);
		terminal.write("Hull: " + Player.currentShip().currentHull() + "/" + Player.currentShip().maxHull(), 20, 9);
		terminal.write("Oxygen: " + Player.currentShip().oxygenPercentage() + "%", 20, 10);

		terminal.write("---------------", 13, 11);
		terminal.write("---------------", 13, 13);
		terminal.writeColumn("|", 12, 11, 13);
		terminal.writeColumn("|", 28, 11, 13);
		terminal.write("Return to map", 14, 12);

		Player.currentShip().displayShip(terminal, 60, 8);
	}
}