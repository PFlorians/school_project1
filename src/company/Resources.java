package company;
import machines.Product;
//zdroje firmy
public class Resources {
	private int cash;
	private int metal;
	private int siliconium;
	private int transistors;
	private int raw;
	private Product products[];
	
	public Resources()//default na zaciatku
	{
		this.cash=100000;
		this.metal=100000;
		this.siliconium=200000;
		this.transistors=1000000;
		this.raw=500000;
	}
	public int getCash() {
		return cash;
	}
	public void setCash(int cash) {//settery sa pouzivaju len po nakupe surovin cez market
		this.cash = cash;
	}
	public int getMetal() {
		return metal;
	}
	public void setMetal(int metal) {
		this.metal = metal;
	}
	public int getSiliconium() {
		return siliconium;
	}
	public void setSiliconium(int siliconium) {
		this.siliconium = siliconium;
	}
	public double getTransistors() {
		return transistors;
	}
	public void setTransistors(int transistors) {
		this.transistors = transistors;
	}
	public int getRaw() {
		return raw;
	}
	public void setRaw(int raw) {
		this.raw = raw;
	}
	public Product[] getProducts() {
		return this.products;
	}
	public void setProducts(Product products[]) {
		this.products = products;
	}
	
}
