package frontier.starships;

import frontier.main.Panel;

//Class to represent the second ranked ship
public class CenturyFalcon extends Starship {
	public CenturyFalcon() {
		super("Century Falcon", 100, 20, 20, 4, 3, 3, 50, 50, 50, 2, 1250);
	}
	
	public void displayShip(Panel terminal, int xCenter, int yCenter) {
		terminal.write("  -----+---===\\", xCenter - 10, yCenter - 4);
		terminal.write(" /     .      ===\\", xCenter - 10, yCenter - 3);
		terminal.write("/   '  .    )    ==\\", xCenter - 10, yCenter - 2);
		terminal.write("|  '  ..........|", xCenter - 10, yCenter - 1);
		terminal.write("\\   '  .    )    ==/", xCenter - 10, yCenter);
		terminal.write(" \\     .     ===/", xCenter - 10, yCenter + 1);
		terminal.write("  -----+-,   \\", xCenter - 10, yCenter + 2);
		terminal.write("         ----/", xCenter - 10, yCenter + 3);
	}
}