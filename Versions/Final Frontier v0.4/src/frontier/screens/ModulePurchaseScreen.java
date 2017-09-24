package frontier.screens;

import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.stream.IntStream;

import frontier.location.Location;
import frontier.main.Main;
import frontier.main.Panel;
import frontier.main.Player;
import frontier.module.Module;

public class ModulePurchaseScreen extends Screen {
	DecimalFormat df = new DecimalFormat("#.##");
	Random rand = new Random();

	public ModulePurchaseScreen() {
		super();
	}

	public Screen respondToInput(MouseEvent m) {
		//If the player clicks on a module in the shop screen...
		if (m.getID() == MouseEvent.MOUSE_CLICKED && m.getX() >= 380 && m.getX() <= 700 && m.getY() >= 80 && m.getY() <= 200) {
			int modulesInCantina = IntStream.of(Location.currentModulesAvailable()).sum();
			int whichThird = -1;
			int index = -1;

			//Determines which third of the screen module position is in
			if (m.getY() < 110) {
				whichThird = 1;
			}
			else if (m.getY() >= 125 && m.getY() < 155) {
				whichThird = 2;
			}
			else if (m.getY() >= 175) {
				whichThird = 3;
			}

			//If there is no module in that spot, do nothing
			if (whichThird == -1) {
				return this;
			}
			else if (modulesInCantina == 2 && whichThird == 3) {
				return this;
			}
			else if (modulesInCantina == 1 && whichThird == 3 || modulesInCantina == 1 && whichThird == 2) {
				return this;
			}
			//If there is a module in that spot...
			else {
				//Find index of the module in the master list
				int modNum = 0;
				for (int i=0; i<Module.numModules; i++) {
					if (Location.currentModulesAvailable()[i] == 1) {
						index = i;
						modNum++;
						if (modNum == whichThird) {
							break;
						}
					}
				}

				//If current ship has enough capacity, and the player has enough cash, purchase the module
				if (Player.playerCash() >= Main.moduleList.get(index).price() && IntStream.of(Player.playerModules()).sum() < Player.currentShip().maxModules()) {
					Player.playerModules()[index]++;
					Location.currentModulesAvailable()[index]--;
					Player.changePlayerCash(-Main.moduleList.get(index).price());
					
					//Apply module multiplier
					Player.currentShip().multiplyStat(Main.moduleList.get(index).type().toString(), Main.moduleList.get(index).multiplier());
				}

				return this;
			}
		}
		//If the player clicks on a module in the left side of their inventory...
		else if (m.getID() == MouseEvent.MOUSE_CLICKED && m.getX() >= 55 && m.getX() <= 330 && m.getY() >= 270 && m.getY() <= 380) {
			int index = -1;
			int whichThird = (m.getY()-240)/32;

			//Find index of the module in the master list
			int modNum = 0;
			for (int i=0; i<Module.numModules; i++) {
				if (Player.playerModules()[i] == 1) {
					index = i;
					modNum++;
					if (modNum == whichThird) {
						break;
					}
				}
			}
			//Do nothing if the player clicked on an empty space
			if (modNum != whichThird) {
				return this;
			}

			//Sell the module
			if (index != -1) {
				Player.playerModules()[index]--;
				Player.changePlayerCash(Main.moduleList.get(index).price());
				
				//Negate module multiplier
				Player.currentShip().multiplyStat(Main.moduleList.get(index).type().toString(), (1 / (Main.moduleList.get(index).multiplier())));
				
				//Discard excess supplies
				if (Player.currentShip().currentHull() > Player.currentShip().maxHull()) {
					Player.currentShip().changeCurrentHull(Player.currentShip().maxHull() - Player.currentShip().currentHull());
				}
				if (Player.currentShip().currentFuel() > Player.currentShip().maxFuel()) {
					Player.currentShip().changeCurrentFuel(Player.currentShip().maxFuel() - Player.currentShip().currentFuel());
				}
				if (Player.currentShip().currentFood() > Player.currentShip().maxFood()) {
					Player.currentShip().changeCurrentFood(Player.currentShip().maxFood() - Player.currentShip().currentFood());
				}
				while (IntStream.of(Player.playerCargo()).sum() > Player.currentShip().maxCargo()) {
					Player.playerCargo()[rand.nextInt(Player.playerCargo().length)]--;
				}
			}

			return this;
		}
		//If the player clicks on a module in the right side of their inventory...
		else if (m.getID() == MouseEvent.MOUSE_CLICKED && m.getX() >= 380 && m.getX() <= 655 && m.getY() >= 270 && m.getY() <= 380) {
			int index = -1;
			int whichThird = ((m.getY()-240)/32)+3;

			//Find index of the crew member in the master list
			int modNum = 0;
			for (int i=0; i<Module.numModules; i++) {
				if (Player.playerCrew()[i] == 1) {
					index = i;
					modNum++;
					if (modNum == whichThird) {
						break;
					}
				}
			}
			//Do nothing if the player clicked on an empty space
			if (modNum != whichThird) {
				return this;
			}

			//Sell the module
			if (index != -1) {
				Player.playerModules()[index]--;
				Player.changePlayerCash(Main.moduleList.get(index).price());
				
				//Negate module multiplier
				Player.currentShip().multiplyStat(Main.moduleList.get(index).type().toString(), (1 / (Main.moduleList.get(index).multiplier())));
				
				//Discard excess supplies
				if (Player.currentShip().currentHull() > Player.currentShip().maxHull()) {
					Player.currentShip().changeCurrentHull(Player.currentShip().maxHull() - Player.currentShip().currentHull());
				}
				if (Player.currentShip().currentFuel() > Player.currentShip().maxFuel()) {
					Player.currentShip().changeCurrentFuel(Player.currentShip().maxFuel() - Player.currentShip().currentFuel());
				}
				if (Player.currentShip().currentFood() > Player.currentShip().maxFood()) {
					Player.currentShip().changeCurrentFood(Player.currentShip().maxFood() - Player.currentShip().currentFood());
				}
				while (IntStream.of(Player.playerCargo()).sum() > Player.currentShip().maxCargo()) {
					Player.playerCargo()[rand.nextInt(Player.playerCargo().length)]--;
				}
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

		//Displays module names, multipliers, and prices
		int currentLine = 3;
		for (int i=0; i<Location.currentModulesAvailable().length; i++) {
			if (Location.currentModulesAvailable()[i] > 0) {
				terminal.write(Main.moduleList.get(i).name() + " Module " + "(" + df.format(Main.moduleList.get(i).multiplier()) + ")", 41, currentLine);
				terminal.write("$" + Main.moduleList.get(i).price(), 41, currentLine + 1);
				currentLine += 3;
			}
		}

		//Displays player modules
		currentLine = 15;
		for (int i=0; i<Player.playerModules().length; i++) {
			if (Player.playerModules()[i] > 0) {
				if (currentLine < 21) {
					terminal.write(Main.moduleList.get(i).name() + " Module " + "(" + df.format(Main.moduleList.get(i).multiplier()) + ")", 5, currentLine);
					terminal.write("$" + Main.moduleList.get(i).price(), 5, currentLine + 1);
				}
				else {
					terminal.write(Main.moduleList.get(i).name() + " " + "(" + df.format(Main.moduleList.get(i).multiplier()) + ")", 41, currentLine - 6);
					terminal.write("$" + Main.moduleList.get(i).price(), 42, currentLine - 5);
				}
				currentLine += 2;
			}
		}
	}
}