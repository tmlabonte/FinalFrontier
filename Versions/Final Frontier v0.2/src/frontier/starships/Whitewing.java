package frontier.starships;

import frontier.Panel;

public class Whitewing extends Starship {
	public Whitewing() {
		super("Whitewing", 75, 15, 15, 4, 3, 3, 50, 50, 50);
	}
	
	public void displayShip(Panel terminal, int x0, int y0) {
		terminal.write("\\-----\\", x0, y0);
		terminal.write("\\ --- \\=", x0+1, y0+1);
		terminal.write("\\ ... \\", x0+2, y0+2);
		terminal.write("==   ... ---\\", x0, y0+3);
		terminal.write("==---   ----->", x0, y0+4);
		terminal.write("==   ... ---/", x0, y0+5);
		terminal.write("/ ... /", x0+2, y0+6);
		terminal.write("/ --- /=", x0+1, y0+7);
		terminal.write("/-----/", x0, y0+8);
	}
}