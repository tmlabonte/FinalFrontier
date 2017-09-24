package frontier.screens;

import java.awt.event.MouseEvent;

import frontier.main.Panel;

//Class to provide structure to all display screens
public abstract class Screen {
	public Screen() {
	}
	
	public static void drawBorder(Panel terminal) {
		terminal.writeCenter("////////////////////////////////////////////////////////////////////////////", 1);
		terminal.writeCenter("////////////////////////////////////////////////////////////////////////////", 22);
		terminal.writeColumn("|", 2, 2, 21);
		terminal.writeColumn("|", 77, 2, 21);
	}
	
	abstract public Screen respondToInput(MouseEvent m);
	abstract public void displayOutput(Panel terminal);
}