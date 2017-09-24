package frontier.starships;

import frontier.main.Panel;

//Class to represent the "beginner" ship
public class APieceOfShip extends Starship {
	public APieceOfShip() {
		super("A Piece of Ship", 50, 10, 10, 3, 1, 0, 20, 20, 20, 0, 250);
	}
	
	public void displayShip(Panel terminal, int xCenter, int yCenter) {
		terminal.write("-\\--\\\\-,", xCenter - 5, yCenter - 2);
		terminal.write("=     -- )", xCenter - 5, yCenter - 1);
		terminal.write("=     -- )", xCenter - 5, yCenter);
		terminal.write("-/--//-'", xCenter - 5, yCenter + 1);
	}
}