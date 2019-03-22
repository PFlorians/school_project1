package human;
import java.util.Scanner;

import development.Development;
import hres.EmployersList;
import machines.Constructors;

public class DevelopmentManager extends Clovek{
	String meno, przv;
	public int vek;
	public char g;
	private Development d;
	
	//linka na econom chief zabezpecuje komunikaciu bez usera
	private Clovek eboss;
	private Scanner s;
	private boolean rtconstruct=false;//pripravenost na tvorbu produktu
	private Constructors mainframe;
	public DevelopmentManager(Development d)
	{
		this.meno=this.name;
		this.przv=this.lastname;
		this.vek=this.age;
		this.g=this.gender;
		this.d=d;
		//this.updateEconomBoss(this.d.getEBoss());
	}
	public DevelopmentManager(String meno, String przv, Development d)
	{
		this.meno=meno;
		this.przv=przv;
		this.vek=(int)(Math.ceil(Math.random()*60));
		this.g=this.gender;
		this.d=d;
		//this.updateEconomBoss(this.d.getEBoss());
	}
	public DevelopmentManager(String meno, String przv, int vek, char g, Development d)
	{
		this.meno=meno;
		this.przv=przv;
		this.vek=vek;
		this.g=g;
		this.d=d;
		//this.updateEconomBoss(this.d.getEBoss());
	}
	public void identity()
	{
		System.out.println("Name: " + this.name);
		System.out.println("Lastname: " + this.lastname);
		System.out.println("Position: Chief of development");
		System.out.println("Age: " + this.vek);
		System.out.println(this.energia);
	}
	public void tasks()
	{
		int i;
		int prices[]=new int[5];
		this.eboss=this.c;
		this.s=this.d.getScanner();
		char c='-';
		System.out.println("Hello this is department of development chief speaking");
		System.out.println("***************************************");
		System.out.println("c -check prices on market");//trader
		System.out.println("g -get resources");//trader
		System.out.println("p -sell product");//trader
		System.out.println("s -create build scheme");//mathematicians
		System.out.println("b -build it");//engineers, robots
		System.out.println("i -identify");
		//System.out.println("h -hire new development boss");
		System.out.println("e -exit");
		
		while(c!='e' && this.energia>=1)
		{
			c=this.s.next().charAt(0);
			if(c=='c' && this.tired==false && this.d.getList().size()!=0)
			{
				if(this.d.getType()!=null && this.d.getQuantity()!=0)
				{
					try
					{
						if(this.d.getList().size()!=0)
						{
							prices=this.getPrices();
							this.energia-=10;
							this.statusUpdate();
						}
						else
						{
							this.energia-=10;
							this.statusUpdate();
							System.out.println("No developers have been hired");
						}
					}
					catch(NullPointerException ex)
					{
						System.out.println("No traders or developers hired");
					}
					
				}
				else
				{
					System.out.println("No task has been chosen sir.");
				}
			}
			else if(c=='s' && this.tired==false)
			{
				try
				{
					if(this.d.getList().size()!=0)
					{
						if(this.plancontrol())
						{
							if(this.checkReadiness())
							{
								this.rtconstruct=true;
							}
							else
							{
								System.out.println("We're not ready");
								this.rtconstruct=false;
							}
						}
						else
						{
							System.out.println("We need to buy more resources");
						}
					}
					else
					{
						System.out.println("No developers have been hired");
					}
				}
				catch(NullPointerException ex)
				{
					System.out.println("No planners or developers hired");
				}
			}
			else if(c=='g' && this.tired==false)//kupovat suroviny
			{
				try
				{
					if(this.d.getList().size()!=0)
					{
						this.buyRes();
						this.energia-=15;
						this.statusUpdate();
					}
					else
					{
						System.out.println("No developers have been hired");
					}
				}
				catch(NullPointerException ex)
				{
					System.out.println("No planners or developers hired");
				}
			}
			else if(c=='b' && this.tired==false)//pojde len ak 's' bolo uspesne
			{
				if(this.rtconstruct)
				{
					this.mainframe=new Constructors(this.d.getRes(), this.d.getQuantity(), this.d.getType());
					this.mainframe.start();
					this.mainframe.createProducts();
					System.out.println(this.d.getRes().getProducts().length);
				}
			}
			else if(c=='p')
			{
				try
				{
					if(this.d.getList().size()!=0)
					{
						this.sellProduct();
						this.energia-=15;
						this.statusUpdate();
					}
					else
					{
						System.out.println("No developers have been hired");
					}
				}
				catch(NullPointerException ex)
				{
					System.out.println("No planners or developers hired");
				}
			}
			/*else if(c=='h')
			{
				this.d.bossChange();
			}*/
			else if(c=='i' && this.tired==false)
			{
				this.identity();
				this.energia-=5;
				this.statusUpdate();
			}
			else if(c=='e')
			{
				break;
			}
			else if(this.d.getList().size()==0)
			{
				System.out.println("We do not have enought employees");
			}
			else if(this.tired==true)
			{
				this.rest();
			}
			
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
	public void updateEconomBoss(Clovek c)
	{
		this.eboss=c;
	}
	
	public int[] getPrices()//moze pristupovat aj eboss
	{
		Trader t=null;
		EmployersList d=null;
		int i;
		
		try
		{
			if(this.d.getList().size()!=0)
			{
				d=this.d.getList();
				for(i=0;i<d.size();i++)
				{
					if(d.get(i) instanceof Trader)
					{
						t=(Trader)d.get(i);
					}
				}
				//t=(Trader)d.get(i);
				return t.getPrices();
			}
			else
			{
				System.out.println("No developers hired");
			}
		}
		catch(NullPointerException e)
		{
			System.out.println("No developers hired");
		}
		finally
		{
			return t.getPrices();
		}
		
	}
	public boolean plancontrol()
	{
		Planner p=null;
		EmployersList d=null;
		int i;
		EconomicChief tmp=null;
		//try
		//{
			if(this.d.getList().size()!=0)
			{
				d=this.d.getList();
				for(i=0;i<d.size();i++)
				{
					if(d.get(i) instanceof Planner)
					{
						p=(Planner)d.get(i);
					}
				}
				//p=(Planner)d.get(i);
				if(this.eboss instanceof EconomicChief)
				{
					tmp=(EconomicChief)this.eboss;
					if(tmp.nres!=null)
					{
						return p.checkPlan(tmp.nres, this.d.getRes());
					}
					else
					{
						System.out.println("We need some economic calculations to proceed");
						return false;
					}
				}
				else
				{
					System.out.println("wrong instance");
					return false;
				}
			}
			else
			{
				System.out.println("No developers hired");
				return false;
			}
		//}
		//catch(NullPointerException e)
		//{
		//	System.out.println("No developers hired");
		//}
		
	}
	public void buyRes()
	{
		Trader t=null;
		EmployersList d=null;
		int i;
		EconomicChief tmp=null;
		try
		{
			if(this.d.getList().size()!=0)
			{
				d=this.d.getList();
				for(i=0;i<d.size();i++)
				{
					if(d.get(i) instanceof Trader)
					{
						t=(Trader)d.get(i);
					}
				}
				if(this.eboss instanceof EconomicChief)
				{
					tmp=(EconomicChief)this.eboss;
					if(tmp.nres!=null)
					{
						t.buyMaterials(this.d.getRes(), this.s, tmp.nres);
					}
					else
					{
						System.out.println("We need some economic calculations to proceed");
					}
				}
				else
				{
					System.out.println("wrong instance buy");
				}
			}
			else
			{
				System.out.println("No developers hired");
			}
		}
		catch(NullPointerException e)
		{
			System.out.println("No developers hired");
		}
	}
	public boolean checkReadiness()
	{
		int num;
		Mathematician m=null;
		EmployersList d=null;
		int i, j;
		int sum=0;
		//try
		//{
			if(this.d.getList().size()!=0)
			{
				d=this.d.getList();
				for(i=0;i<d.size();i++)
				{
					if(d.get(i) instanceof Mathematician)
					{
						sum++;
					}
				}
				num=(int)Math.ceil(Math.random()*sum);
				for(i=0, j=1;j<num;i++)
				{
					if(d.get(i) instanceof Mathematician)
					{
						j++;
					}
				}
				if(d.get(i) instanceof Mathematician )
				{
					m=(Mathematician)d.get(i);
					return m.calculate(this.d.getType(), this.d.getQuantity());
				}
				else
				{
					System.out.println("Wrong index " + i);
					return false;
				}
			}
			else
			{
				System.out.println("No developers hired");
				return false;
			}
		//}
		//catch(NullPointerException e)
		//{
		//	System.out.println("No developers hired");
			
		//}
		
	}
	public void sellProduct()
	{
		Trader t=null;
		EmployersList d=null;
		int i;
		EconomicChief tmp=null;
		try
		{
			if(this.d.getList().size()!=0)
			{
				d=this.d.getList();
				for(i=0;i<d.size();i++)
				{
					if(d.get(i) instanceof Trader)
					{
						t=(Trader)d.get(i);
					}
				}
				if(this.eboss instanceof EconomicChief)
				{
					tmp=(EconomicChief)this.eboss;
					if(tmp.nres!=null)
					{
						t.sellProduct(this.d.getRes(), tmp.nres, this.s);
					}
					else
					{
						System.out.println("We need some economic calculations to proceed");
					}
				}
				else
				{
					System.out.println("Wrong instance");
				}
			}
			else
			{
				System.out.println("No developers hired");
			}
		}
		catch(NullPointerException e)
		{
			System.out.println("No developers hired");
		}
	}
	public void identifyAll()
	{
		int i;
		try
		{
			for(i=0;i<this.d.getList().size();i++)
			{
				this.d.getList().get(i).identity();
			}
		}
		catch(NullPointerException e)
		{
			System.out.println("No employees");
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
