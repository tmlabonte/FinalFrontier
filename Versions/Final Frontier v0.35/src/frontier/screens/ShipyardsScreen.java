package frontier.screens;

import java.awt.event.MouseEvent;

import frontier.location.Location;
import frontier.Panel;
import frontier.Player;

//Class to represent the shipyards screen
public class ShipyardsScreen extends Screen {
	private int foodNeeded;
	private int fuelNeeded;

	public ShipyardsScreen() {
		super();
		foodNeeded = Player.currentShip().maxFood() - Player.currentShip().currentFood();
		fuelNeeded = Player.currentShip().maxFuel() - Player.currentShip().currentFuel();
	}

	public Screen respondToInput(MouseEvent m) {
		//If the player clicks "Replenish Food"
		if (m.getID() == MouseEvent.MOUSE_CLICKED && m.getX() >= 460 && m.getX() <= 580 && m.getY() >= 65 && m.getY() <= 75) {
			//Purchase as much food as able
			if (Player.playerCash() >= 2 * foodNeeded) {
				Player.currentShip().changeFood(foodNeeded);
				Player.changePlayerCash(2 * foodNeeded);
			}
			else {
				int foodPurchasable = Player.playerCash() / 2;
				Player.currentShip().changeFood(foodPurchasable);
				Player.changePlayerCash(2 * foodPurchasable);
			}

			return new ShipyardsScreen();
		}
		//If the player clicks "Replenish Fuel"
		else if (m.getID() == MouseEvent.MOUSE_CLICKED && m.getX() >= 460 && m.getX() <= 580 && m.getY() >= 80 && m.getY() <= 90) {
			//Purchase as much fuel as able
			if (Player.playerCash() >= 2 * fuelNeeded) {
				Player.currentShip().changeFuel(fuelNeeded);
				Player.changePlayerCash(-2 * fuelNeeded);
			}
			else {
				int fuelPurchasable = Player.playerCash() / 2;
				Player.currentShip().changeFuel(fuelPurchasable);
				Player.changePlayerCash(-2 * fuelPurchasable);
			}

			return new ShipyardsScreen();
		}
		//If the player clicks "Ships"
		else if (m.getID() == MouseEvent.MOUSE_CLICKED && m.getX() >= 500 && m.getX() <= 590 && m.getY() >= 115 && m.getY() < 150) {
			//Load the ship purchase screen
			return new ShipPurchaseScreen();
		}
		//If the player clicks "Modules"
		else if (m.getID() == MouseEvent.MOUSE_CLICKED && m.getX() >= 500 && m.getX() <= 590 && m.getY() >= 180 && m.getY() < 215) {
			//Load the module purchase screen
			return new ModulePurchaseScreen();
		}
		//If the player clicks "Return to star menu"
		else if (m.getID() == MouseEvent.MOUSE_CLICKED && m.getX() >= 460 && m.getX() <= 625 && m.getY() >= 240 && m.getY() <= 250) {
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

	public void displayOutput(Panel terminal) {
		Location.currentLocation().displayLocation(terminal);
		terminal.write("Return to star menu", 50, 13);

		//Displays options to replenish food and fuel
		terminal.write("Replenish Food", 50, 2);
		terminal.write("$" + 2 * foodNeeded, 67, 2);
		terminal.write("Replenish Fuel", 50, 3);
		terminal.write("$" + 2 * fuelNeeded, 67, 3);

		//Displays options to purchase a ship or modules
		terminal.write("---------", 55, 5);
		terminal.write("---------", 55, 7);
		terminal.writeColumn("|", 54, 5, 7);
		terminal.writeColumn("|", 64, 5, 7);
		terminal.write("Ships", 57, 6);

		terminal.write("---------", 55, 9);
		terminal.write("---------", 55, 11);
		terminal.writeColumn("|", 54, 9, 11);
		terminal.writeColumn("|", 64, 9, 11);
		terminal.write("Modules", 56, 10);
	}
}