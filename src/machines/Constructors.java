package machines;

import company.Resources;

public class Constructors extends Robot{
	boolean working=false;//default nepracuje
	private Resources r;
	private int q;
	private String type;
	
	public Constructors(Resources r, int quantity, String type)
	{
		this.r=r;
		this.q=quantity;
		this.type=type;
	}
	public void status()
	{
		System.out.println("status report: ");
	}
	public void start()
	{
		this.working=true;
	}
	public void stop()
	{
		this.working=false;
	}
	public void createProducts()
	{
		if(this.working)
		{
			Product p[]=new Product[this.q];
			int i;
			for(i=0;i<this.q;i++)
			{
				p[i]=new Product(this.type);
			}
			r.setProducts(p);
			System.out.println("Report: Production finished");
		}
		else
		{
			System.out.println("Error: system not turned on");
		}
	}
}
