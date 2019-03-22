package human;

public class Mathematician extends Clovek{
	String meno, przv;
	public int vek;
	public char g;
	private boolean calculation=false;
	public Mathematician()
	{
		this.meno=this.name;
		this.przv=this.lastname;
		this.vek=this.age;
		this.g=this.gender;
	}
	public Mathematician(String meno, String przv)
	{
		this.meno=meno;
		this.przv=przv;
		this.vek=(int)(Math.ceil(Math.random()*60));
		this.g=this.gender;
	}
	public Mathematician(String meno, String przv, int vek, char g)
	{
		this.meno=meno;
		this.przv=przv;
		this.vek=vek;
		this.g=g;
	}
	
	public void identity()
	{
		System.out.println(this.meno);
		System.out.println(this.przv);
		System.out.println(this.energia);
	}
	
	public boolean calculate(String type, int quantity)
	{
		
		if(type!=null && quantity!=0)
		{
			System.out.println("Creating blueprints");
			try
			{
				Thread.sleep(2000);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
			System.out.println("Blueprints ready");
			this.calculation=true;
			return this.calculation;
		}
		else
		{
			return false;
		}
	}
	
	public void rest()
	{
		try
		{
			Thread.sleep(10000);
			this.tired=false;
			this.energia=100;
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	
	private void statusUpdate()
	{
		if(this.energia<=25)
		{
			this.tired=true;
		}
		else
		{
			this.tired=false;
		}
	}
}
