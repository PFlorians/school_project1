package market;

//tvorenie cien a signal pre uskladnenie

import java.math.*;

public class Init {
	//unit prices
	
	private int metal;
	private int siliconium;
	private int transistors;
	private int raw;
	private Resources r;
	
	public Init()
	{
		this.setPrices();
		this.r=new Resources();
	}
	
	//jednotkova cena na kg
	private void setPrices()
	{
		this.metal=(int)Math.ceil(Math.random()*10);
		this.siliconium=(int)Math.ceil(Math.random()*5);
		this.transistors=(int)Math.ceil(Math.random()*5);
		this.raw=(int)Math.ceil(Math.random()*3);
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

	public int getTransistors() {
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

	public Resources getR() {
		return r;
	}

}
