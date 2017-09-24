package frontier;

//Class to represent commodities for buying and selling
public class Commodity {
	private String name;
	private int basePrice;
		
	public Commodity(String name) {
		this.name = name;
		this.basePrice = 1;
	}
	
	public Commodity(String name, int basePrice) {
		this.name = name;
		this.basePrice = basePrice;
	}
	
	public String name() {
		return name;
	}
	
	public int basePrice() {
		return basePrice;
	}
	
	public int price(Location location) {
		if (this.equals(location.exports())) {
			return (int)(this.basePrice()*location.exportMultiplier());
		}
		else if (this.equals(location.imports())) {
			return (int)(this.basePrice()*location.importMultiplier());
		}
		else {
			return this.basePrice();
		}
	}
}
