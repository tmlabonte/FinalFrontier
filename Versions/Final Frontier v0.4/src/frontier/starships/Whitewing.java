package frontier.starships;

import frontier.main.Panel;

//Class to represent the first "real" ship
public class Whitewing extends Starship {
	public Whitewing() {
		super("Whitewing", 75, 15, 15, 5, 2, 1, 35, 35, 35, 1, 750);
	}
	
	public void displayShip(Panel terminal, int xCenter, int yCenter) {
		terminal.write("\\-----\\", xCenter - 7, yCenter - 4);
		terminal.write("\\ --- \\=", xCenter - 7, yCenter - 3);
		terminal.write("\\ ... \\", xCenter - 7, yCenter - 2);
		terminal.write("==   ... ---\\", xCenter - 7, yCenter - 1);
		terminal.write("==---   ----->", xCenter - 7, yCenter);
		terminal.write("==   ... ---/", xCenter - 7, yCenter + 1);
		terminal.write("/ ... /", xCenter - 7, yCenter + 2);
		terminal.write("/ --- /=", xCenter - 7, yCenter + 3);
		terminal.write("/-----/", xCenter - 7, yCenter + 4);
	}
}