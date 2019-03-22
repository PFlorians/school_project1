package market;

public class Buy {
	public void buyMetal(int ks, Resources r)
	{
		r.setMetal(r.getMetal()-ks);
	}
	public void buySiliconium(int ks, Resources r)
	{
		r.setSiliconium(r.getSiliconium()-ks);
	}
	public void buyTransistors(int ks, Resources r)
	{
		r.setTransistors(r.getTransistors()-ks);
	}
	public void buyRaw(int ks, Resources r)
	{
		r.setRaw(r.getRaw()-ks);
	}
}
