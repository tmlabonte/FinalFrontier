package frontier.screens;

import java.awt.event.MouseEvent;

import frontier.location.Location;
import frontier.main.Panel;
import frontier.main.Player;
import frontier.starships.*;

public class ShipPurchaseScreen extends Screen {
	Starship shipForSale;
	
	public ShipPurchaseScreen() {
		super();
		
		if (Player.currentShip().shipRank() == 0) {
			this.shipForSale = new Whitewing();
		}
		else if (Player.currentShip().shipRank() == 1) {
			this.shipForSale = new CenturyFalcon();
		}
		else {
			this.shipForSale = new APieceOfShip();
		}
	}

	public Screen respondToInput(MouseEvent m) {
		//If the player clicks the ship for sale
		if (m.getID() == MouseEvent.MOUSE_CLICKED && m.getX() >= 380 && m.getX() <= 670 && m.getY() >= 95 && m.getY() <= 190) {
			//If the player has enough cash, buy the ship
			if (Player.playerCash() >= shipForSale.price()) {
				int tempFood = Player.currentShip().currentFood();
				int tempFuel = Player.currentShip().currentFuel();
				Player.changeShip(shipForSale);
				Player.changePlayerCash(-shipForSale.price());
				shipForSale = null;
				Player.currentShip().changeCurrentFood(-(Player.currentShip().maxFood() - tempFood));
				Player.currentShip().changeCurrentFuel(-(Player.currentShip().maxFuel() - tempFuel));
			}
			return this;
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
		
		terminal.write(Player.currentShip().name(), 5, 16);
		terminal.write("Rank: " + Player.currentShip().shipRank(), 5, 17);
		terminal.write("Engines: " + Player.currentShip().travelSpeedInt(), 5, 18);
		terminal.write("Weaponry: " + Player.currentShip().weaponry(), 25, 17);
		terminal.write("Shields: " + Player.currentShip().shields(), 25, 18);
		
		if (shipForSale != null) {
			//Display ship for sale
			terminal.write(shipForSale.name() + " $" + shipForSale.price(), 41, 4);
			terminal.write("Rank: " + shipForSale.shipRank(), 41, 5);
			terminal.write("Engines: " + shipForSale.travelSpeedInt(), 41, 6);
			terminal.write("Weaponry: " + shipForSale.weaponry(), 61, 5);
			terminal.write("Shields: " + shipForSale.shields(), 61, 6);
			terminal.write("Max cargo: " + shipForSale.maxCargo(), 41, 7);
			terminal.write("Max crew: " + shipForSale.maxCrew(), 41, 8);
			terminal.write("Max modules: " + shipForSale.maxModules(), 41, 9);
			terminal.write("Max food: " + shipForSale.maxFood(), 61, 7);
			terminal.write("Max fuel: " + shipForSale.maxFuel(), 61, 8);
			terminal.write("Max hull: " + shipForSale.maxHull(), 61, 9);
		}
	}
}