package frontier;

import asciiPanel.AsciiPanel;

//Class to serve as an AsciiPanel with updated methods
public class Panel extends AsciiPanel {
	private static final long serialVersionUID = -8818864401221566740L;

	public Panel() {
		super();
	}
	
	//Writes in a column straight down
	public void writeColumn(String data, int x, int y0, int y1) {
		for (int i=y0;i<=y1;i++) {
			super.write(data, x, i);
		}
	}
	
}