package frontier;

import javax.swing.JFrame;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import frontier.Panel;
import frontier.screens.Screen;
import frontier.screens.TitleScreen;

//Class to run the Final Frontier game
public class Main extends JFrame implements MouseListener {
	private static final long serialVersionUID = 8834201773474496694L;
	private Panel terminal;
	private Screen screen;
	private CommodityGenerator commodityGenerator;
	private LocationGenerator locationGenerator;
	public static Commodity[] commodityList;
	public static ArrayList<Location> locationList;
	
	//Initializes the Final Frontier world
	public Main() {
		//Creates a new JFrame and associated Panel
		super();
		terminal = new Panel();
		add(terminal);
		pack();
		
		//Initializes master list of commodities
		commodityGenerator = new CommodityGenerator();
		commodityList = commodityGenerator.generateCommodities(10);
		
		//Initializes master list of locations
		locationGenerator = new LocationGenerator();
		locationList = locationGenerator.generateLocations(commodityList);
		Location.moveTo(locationList.get(0));
		
		//Instantiates player
		new Player();
		
		//Displays the title screen and initializes a MouseListener
		screen = new TitleScreen();
		addMouseListener(this);
		repaint();
	}
	
	//Allows output to be displayed on the screen
	public void repaint() {
		terminal.clear();
		screen.displayOutput(terminal);
		super.repaint();
	}
	
	//Changes current screen based on mouse click
	public void mouseClicked(MouseEvent m) {
		screen = screen.respondToInput(m);
		repaint();
	}
	
	//Needed to use interface
	public void mousePressed(MouseEvent m) { }
	public void mouseReleased(MouseEvent m) { }
	public void mouseEntered(MouseEvent m) { }
	public void mouseExited(MouseEvent m) { }
	
	//Initializes a new Main and begins the game
	public static void main(String[] args) {
		Main window = new Main();
		window.setDefaultCloseOperation(EXIT_ON_CLOSE);
		window.setVisible(true);
	}
}