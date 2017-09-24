package frontier.screens;

import java.awt.event.MouseEvent;
import frontier.Panel;

//Class to represent the title screen
public class TitleScreen extends Screen {
	public TitleScreen() {
		super();
	}
	
	public Screen respondToInput(MouseEvent m) {
        return m.getID() == MouseEvent.MOUSE_CLICKED ? new StarScreen() : this;
    }
	
	public void displayOutput(Panel terminal) {
        terminal.writeCenter("   ______  _____  _   _            _        ", 1);
        terminal.writeCenter("|  ____||_   _|| \\ | |    /\\    | |     ", 2);
        terminal.writeCenter("| |__     | |  |  \\| |   /  \\   | |     ", 3);
        terminal.writeCenter("|  __|    | |  | . ` |  / /\\ \\  | |     ", 4);
        terminal.writeCenter("| |      _| |_ | |\\  | / ____ \\ | |____ ", 5);
        terminal.writeCenter("|_|     |_____||_| \\_|/_/    \\_\\|______|", 6);
        terminal.writeCenter(" _____  ____    ___   _   _  _____  ___  _____  ____  ", 7);
        terminal.writeCenter("|  ___||  _ \\  / _ \\ | \\ | ||_   _||_ _|| ____||  _ \\ ", 8);
        terminal.writeCenter("| |_   | |_) || | | ||  \\| |  | |   | | |  _|  | |_) |", 9);
        terminal.writeCenter("|  _|  |  _ < | |_| || |\\  |  | |   | | | |___ |  _ < ", 10);
        terminal.writeCenter("|_|    |_| \\_\\ \\___/ |_| \\_|  |_|  |___||_____||_| \\_\\", 11);
        terminal.writeCenter("-- click to begin --", 18);
    }
	
}