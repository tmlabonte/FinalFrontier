package frontier.starships;

import frontier.Panel;

public class APieceOfShip extends Starship {
	public APieceOfShip() {
		super("A Piece of Ship", 50, 10, 10, 3, 1, 0, 20, 20, 20);
	}
	
	public void displayShip(Panel terminal, int x0, int y0) {
		terminal.write("-\\--\\\\-,", x0+1, y0);
		terminal.write("=     -- )", x0, y0+1);
		terminal.write("=     -- )", x0, y0+2);
		terminal.write("-/--//-'", x0+1, y0+3);
	}
}