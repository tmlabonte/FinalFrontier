package frontier.screens;

import java.awt.event.MouseEvent;
import java.util.stream.IntStream;

import frontier.Main;
import frontier.Panel;
import frontier.Player;
import frontier.Location;

//Class to represent the shop screen
public class ShopScreen extends Screen {
	public ShopScreen() {
		super();
	}

	public Screen respondToInput(MouseEvent m) {		
		//If the player clicks on an item in the shop screen...
		if (m.getID() == MouseEvent.MOUSE_CLICKED && m.getX() >= 380 && m.getX() <= 620 && m.getY() >= 65 && m.getY() < 215) {
			int positiveValueGoal = 1 + (m.getY()-65)/15;
			int positiveValueNum = 0;
			int indexInArray = 0;
			
			//Finds index of the desired nonzero value in the list and assigns its index to indexInArray
			for (int i=0; i<Location.currentInventory().length; i++) {
				if (Location.currentInventory()[i] != 0) {
					positiveValueNum++;
				}
				if (positiveValueNum == positiveValueGoal) {
					indexInArray = i;
					break;
				}
			}			
			
			//If the value is nonzero, current ship has enough capacity, and the player has enough cash, purchase the item
			if (Location.currentInventory()[indexInArray] > 0 && Player.playerCash() >= Main.commodityList[indexInArray].basePrice() && IntStream.of(Player.playerInventory()).sum() < Player.currentShip().commodityCapacity()) {
				Player.playerInventory()[indexInArray]++;
				Location.currentInventory()[indexInArray]--;
				Player.changePlayerCash(-Main.commodityList[indexInArray].price(Location.currentLocation()));
			}

			return this;
		}
		//If the player clicks "Return to star menu"
		else if (m.getID() == MouseEvent.MOUSE_CLICKED && m.getX() >= 460 && m.getX() <= 625 && m.getY() >= 240 && m.getY() < 250) {
			//Return to star menu
			return new StarScreen();
		}
		//If the player clicks on an item in the left side of their inventory...
		else if (m.getID() == MouseEvent.MOUSE_CLICKED && m.getX() >= 50 && m.getX() <= 250 && m.getY() >= 290 && m.getY() < 365) {
			int index = (m.getY()-290)/15;
			
			//Sell the item
			if (Player.playerInventory()[index] > 0) {
				Location.currentInventory()[index]++;
				Player.playerInventory()[index]--;
				Player.changePlayerCash(Main.commodityList[index].price(Location.currentLocation()));
			}
			
			return this;
		}
		//If the player clicks on an item in the right side of their inventory...
		else if (m.getID() == MouseEvent.MOUSE_CLICKED && m.getX() >= 375 && m.getX() <= 575 && m.getY() >= 290 && m.getY() < 365) {
			int index = 5 + (m.getY()-290)/15;
			
			//Sell the item
			if (Player.playerInventory()[index] > 0) {
				Location.currentInventory()[index]++;
				Player.playerInventory()[index]--;
				Player.changePlayerCash(Main.commodityList[index].price(Location.currentLocation()));
			}
			
			return this;
		}
		//If the player clicks "Return to map"...
		else if (m.getID() == MouseEvent.MOUSE_CLICKED && m.getX() >= 125 && m.getX() <= 255 && m.getY() >= 200 && m.getY() < 230) {
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
		
		int currentLine = 2;
		for (int i=0; i<Location.currentInventory().length; i++) {
			if (Location.currentInventory()[i] > 0) {
				terminal.write(Main.commodityList[i].name(), 41, currentLine);
				terminal.write("" + Location.currentInventory()[i], 67, currentLine);
				terminal.write("$" + Main.commodityList[i].price(Location.currentLocation()), 72, currentLine);
				currentLine++;
			}
		}
		terminal.write("Return to star menu", 50, 13);

		for (int i=0; i<10; i++) {
			if (i<5) {
				if (Player.playerInventory()[i] > 0) {
					terminal.write(Main.commodityList[i].name(), 5, 16 + i);
					terminal.write("" + Player.playerInventory()[i], 31, 16 + i);
					terminal.write("$" + Main.commodityList[i].price(Location.currentLocation()), 35, 16 + i);
				}
			}
			else {
				if (Player.playerInventory()[i] > 0) {
					terminal.write(Main.commodityList[i].name(), 41, 11 + i);
					terminal.write("" + Player.playerInventory()[i], 68, 11 + i);
					terminal.write("$" + Main.commodityList[i].price(Location.currentLocation()), 72, 11 + i);
				}
			}
		}
	}
}