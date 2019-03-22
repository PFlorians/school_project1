package human;


public class Economist extends Clovek{
	String meno, przv;
	public int vek;
	public char g;
	
	public boolean needprices=false; 
	
	private int nres[];
	public Economist()
	{
		this.meno=this.name;
		this.przv=this.lastname;
		this.vek=this.age;
		this.g=this.gender;
		this.nres=new int[5];
	}
	public Economist(String meno, String przv)
	{
		this.meno=meno;
		this.przv=przv;
		this.vek=(int)(Math.ceil(Math.random()*60));
		this.g=this.gender;
		this.nres=new int[5];
	}
	public Economist(String meno, String przv, int vek, char g)
	{
		this.meno=meno;
		this.przv=przv;
		this.vek=vek;
		this.g=g;
		this.nres=new int[5];
	}
	
	public void identity()
	{
		System.out.println(this.meno);
		System.out.println(this.przv);
		System.out.println(this.energia);
	}
	
	public void resCalc(String type, int quantity)//kalkulacia na jeden kus
	{
		if(this.tired==false)
		{
			this.energia=this.energia-20;
			if(type.equals("Processors"))//1ks=2m, 2s, 5t, 2r, 5$
			{
				this.nres[0]=2*quantity;
				this.nres[1]=2*quantity;
				this.nres[2]=5*quantity;
				this.nres[3]=2*quantity;
				this.nres[4]=5*quantity;//zisk, predajna cena produktu
				this.needprices=true;
			}
			else if(type.equals("Graphic cards"))//1ks=2m, 2s, 2t, 2r, 4$
			{
				this.nres[0]=2*quantity;
				this.nres[1]=2*quantity;
				this.nres[2]=2*quantity;
				this.nres[3]=2*quantity;
				this.nres[4]=4*quantity;//zisk
				this.needprices=true;
			}
			else if(type.equals("Sound cards"))//1m, 1s, 1t, 3r, 3$
			{
				this.nres[0]=1*quantity;
				this.nres[1]=1*quantity;
				this.nres[2]=1*quantity;
				this.nres[3]=3*quantity;
				this.nres[4]=3*quantity;
				this.needprices=true;
			}
			else if(type.equals("Co-processors"))//2m,2s,3t,2r, 3$
			{
				this.nres[0]=2*quantity;
				this.nres[1]=2*quantity;
				this.nres[2]=3*quantity;
				this.nres[3]=2*quantity;
				this.nres[4]=3*quantity;
				this.needprices=true;
			}
			this.statusUpdate();
		}
		else
		{
			this.rest();
		}
	}
	public int[] materials(int prices[])//vysledny odhad
	{
		System.out.println("For this project we will need following:");
		System.out.println("Metal " + this.nres[0] + "cost: " + (this.nres[0]*prices[0]));
		System.out.println("Siliconium " + this.nres[1] + "cost: " + (this.nres[1]*prices[1]));
		System.out.println("Transistors " + this.nres[2] + "cost: " + (this.nres[2]*prices[2]));
		System.out.println("Raw materials " + this.nres[3] + "cost: " + (this.nres[3]*prices[3]));
		System.out.println("Possible gain " + this.nres[4]);
		return this.nres;
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
