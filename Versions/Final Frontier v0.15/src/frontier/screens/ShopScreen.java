package frontier.screens;

import java.awt.event.MouseEvent;
import frontier.Main;
import frontier.Panel;
import frontier.Player;
import frontier.Location;

//Class to represent the main play screen
public class ShopScreen extends Screen {
	public ShopScreen() {
		super();
	}

	public Screen respondToInput(MouseEvent m) {	
		//If the player clicks on an item in the shop screen...
		if (m.getID() == MouseEvent.MOUSE_CLICKED && m.getX() >= 380 && m.getX() <= 620 && m.getY() >= 80 && m.getY() < 80 + 15*Location.currentInventory().length) {
			int positiveValueGoal = 1 + (m.getY()-80)/15;
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
			
			//If the value is nonzero and the player has enough dough, purchase the item
			if (Location.currentInventory()[indexInArray] > 0 && Player.playerCash() >= Main.commodityList[indexInArray].basePrice()) {
				Player.playerInventory()[indexInArray]++;
				Location.currentInventory()[indexInArray]--;
				Player.changePlayerCash(-Main.commodityList[indexInArray].price(Location.currentLocation()));
			}

			return this;
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
		else if (m.getID() == MouseEvent.MOUSE_CLICKED && m.getX() >= 125 && m.getX() <= 255 && m.getY() >= 200 && m.getY() < 230){
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
	}
}