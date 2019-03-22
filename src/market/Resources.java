package market;

//triedy pre suroviny a zdroje

public class Resources {
	private int metal;
	private int siliconium;
	private int transistors;
	private int raw;
	
	Resources()
	{
		this.initResources();
	}
	private void initResources()
	{
		this.metal=(int)Math.ceil(Math.random()*10000);
		this.siliconium=(int)Math.ceil(Math.random()*10000);
		this.transistors=(int)Math.ceil(Math.random()*10000);
		this.raw=(int)Math.ceil(Math.random()*10000);
	}
	//get&set
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
}
