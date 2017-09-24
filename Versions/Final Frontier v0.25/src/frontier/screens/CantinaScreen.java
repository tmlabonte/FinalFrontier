package frontier.screens;

import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.stream.IntStream;

import frontier.location.Location;
import frontier.Main;
import frontier.Panel;
import frontier.Player;
import frontier.crew.Crew;

//Class to represent the cantina screen
public class CantinaScreen extends Screen {
	DecimalFormat df = new DecimalFormat("#.##");

	public CantinaScreen() {
		super();
	}

	public Screen respondToInput(MouseEvent m) {
		//If the player clicks on a crew member in the shop screen...
		if (m.getID() == MouseEvent.MOUSE_CLICKED && m.getX() >= 380 && m.getX() <= 700 && m.getY() >= 80 && m.getY() <= 200) {
			int crewInCantina = IntStream.of(Location.currentCrewAvailable()).sum();
			int whichThird = -1;
			int index = -1;

			//Determines which third of the screen crew position is in
			if (m.getY() < 110) {
				whichThird = 1;
			}
			else if (m.getY() >= 125 && m.getY() < 155) {
				whichThird = 2;
			}
			else if (m.getY() >= 175){
				whichThird = 3;
			}

			//If there is no crew member in that spot, do nothing
			if (whichThird == -1) {
				return this;
			}
			else if (crewInCantina == 2 && whichThird == 3) {
				return this;
			}
			else if (crewInCantina == 1 && whichThird == 3 || crewInCantina == 1 && whichThird == 2) {
				return this;
			}
			//If there is a crew member in that spot...
			else {
				//Find index of the crew member in the master list
				int crewNum = 0;
				for (int i=0; i<Crew.numCrew; i++) {
					if (Location.currentCrewAvailable()[i] == 1) {
						index = i;
						crewNum++;
						if (crewNum == whichThird) {
							break;
						}
					}
				}

				//If current ship has enough capacity, and the player has enough cash, hire the crew member
				if (Player.playerCash() >= Main.crewList.get(index).signingFee() && IntStream.of(Player.playerCrew()).sum() < Player.currentShip().crewCapacity()) {
					Player.playerCrew()[index]++;
					Location.currentCrewAvailable()[index]--;
					Player.changePlayerCash(-Main.crewList.get(index).signingFee());
				}

				return this;
			}
		}
		//If the player clicks on a crew member in the left side of their inventory...
		else if (m.getID() == MouseEvent.MOUSE_CLICKED && m.getX() >= 55 && m.getX() <= 330 && m.getY() >= 270 && m.getY() <= 380) {
			int index = -1;
			int whichThird = (m.getY()-240)/32;

			//Find index of the crew member in the master list
			int crewNum = 0;
			for (int i=0; i<Crew.numCrew; i++) {
				if (Player.playerCrew()[i] == 1) {
					index = i;
					crewNum++;
					if (crewNum == whichThird) {
						break;
					}
				}
			}
			//Do nothing if the player clicked on an empty space
			if (crewNum != whichThird) {
				return this;
			}

			//Release the crew member
			if (index != -1) {
				Player.playerCrew()[index]--;
			}

			return this;
		}
		//If the player clicks on a crew member in the right side of their inventory...
		else if (m.getID() == MouseEvent.MOUSE_CLICKED && m.getX() >= 380 && m.getX() <= 655 && m.getY() >= 270 && m.getY() <= 380) {
			int index = -1;
			int whichThird = ((m.getY()-240)/32)+3;

			//Find index of the crew member in the master list
			int crewNum = 0;
			for (int i=0; i<Crew.numCrew; i++) {
				if (Player.playerCrew()[i] == 1) {
					index = i;
					crewNum++;
					if (crewNum == whichThird) {
						break;
					}
				}
			}
			//Do nothing if the player clicked on an empty space
			if (crewNum != whichThird) {
				return this;
			}

			//Release the crew member
			if (index != -1) {
				Player.playerCrew()[index]--;
			}

			return this;
		}
		//If the player clicks "Return to star menu"
		else if (m.getID() == MouseEvent.MOUSE_CLICKED && m.getX() >= 460 && m.getX() <= 625 && m.getY() >= 240 && m.getY() < 250) {
			//Return to star menu
			return new StarScreen();
		}
		//If the player clicks "Return to map"...
		else if (m.getID() == MouseEvent.MOUSE_CLICKED && m.getX() >= 125 && m.getX() <= 255 && m.getY() >= 215 && m.getY() < 245) {
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

		//Displays crew names, specialties, fees, and salaries
		int currentLine = 3;
		for (int i=0; i<Location.currentCrewAvailable().length; i++) {
			if (Location.currentCrewAvailable()[i] > 0) {
				terminal.write(Main.crewList.get(i).name() + ": " + Main.crewList.get(i).specialty().toString() + " " + "(" + df.format(Main.crewList.get(i).multiplier()) + ", " + df.format(Main.crewList.get(i).specialtyMultiplier()) + ")", 41, currentLine);
				terminal.write("Fee: $" + Main.crewList.get(i).signingFee() + " Salary: $" + Main.crewList.get(i).salary() + "/ly", 41, currentLine + 1);
				currentLine += 3;
			}
		}
		terminal.write("Return to star menu", 50, 13);

		//Displays player crew
		currentLine = 15;
		for (int i=0; i<Player.playerCrew().length; i++) {
			if (Player.playerCrew()[i] > 0) {
				if (currentLine < 21) {
					terminal.write(Main.crewList.get(i).name() + ": " + Main.crewList.get(i).specialty().toString() + " " + "(" + df.format(Main.crewList.get(i).multiplier()) + ", " + df.format(Main.crewList.get(i).specialtyMultiplier()) + ")", 5, currentLine);
					terminal.write("Salary: $" + Main.crewList.get(i).salary() + "/ly", 5, currentLine + 1);
				}
				else {
					terminal.write(Main.crewList.get(i).name() + ": " + Main.crewList.get(i).specialty().toString() + " " + "(" + df.format(Main.crewList.get(i).multiplier()) + ", " + df.format(Main.crewList.get(i).specialtyMultiplier()) + ")", 42, currentLine - 6);
					terminal.write("Salary: $" + Main.crewList.get(i).salary() + "/ly", 42, currentLine - 5);
				}
				currentLine += 2;
			}
		}
	}
}