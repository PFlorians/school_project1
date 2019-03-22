package human;

import economics.Economics;
import hres.EmployersList;

import java.util.Scanner;

public class EconomicChief extends Clovek{
	String meno, przv;
	public int vek;
	public char g;
	private Economics e;
	
	//spojenie s devel. boss, kvoli automatickej komunikacii
	//vyhne sa user inputu
	public Clovek dboss;
	private Scanner s;
	public int nres[];
	public EconomicChief(Economics e)
	{
		this.meno=this.name;
		this.przv=this.lastname;
		this.vek=this.age;
		this.g=this.gender;
		this.e=e;
		//this.updateDevelBoss(this.e.getDBoss());
	}
	public EconomicChief(String meno, String przv, Economics e)
	{
		this.meno=meno;
		this.przv=przv;
		this.vek=(int)(Math.ceil(Math.random()*60));
		this.g=this.gender;
		this.e=e;
		//this.updateDevelBoss(this.e.getDBoss());
	}
	public EconomicChief(String meno, String przv, int vek, char g, Economics e)
	{
		this.meno=meno;
		this.przv=przv;
		this.vek=vek;
		this.g=g;
		this.e=e;
		//this.updateDevelBoss(this.e.getDBoss());
	}
	public void identity()
	{
		System.out.println("Name: " + this.name);
		System.out.println("Lastname: " + this.lastname);
		System.out.println("Position: Chief of economic department");
		System.out.println("Age: " + this.vek);
		System.out.println(this.energia);
	}
	public void tasks()
	{
		this.s=this.e.getScanner();
		char c='-';
		int prices[];
		int emp=(int)Math.floor(Math.random()*2);
		this.dboss=this.c;
		
		System.out.println("Hello this is department of economics chief speaking");
		System.out.println("***************************************");
		System.out.println("c -calculate resources for current project");//economist+planner
		System.out.println("i -identify yourself");
		//System.out.println("h -hire a new boss for this department");//specialny pripad
		System.out.println("e -exit");
		while(c!='e' && this.energia>=1)
		{
			c=this.s.next().charAt(0);
			try
			{
				if(c=='c' && this.tired==false)
				{
					if(this.e.getType()!=null && this.e.getQuantity()!=0)
					{
						prices=this.calculations(emp);
						if(prices==null)
						{
							System.out.println("We are unable to continue due to lack"
									+ " of employees");
						}
						else
						{
							this.getMaterials(emp, prices);//vysledny odhad
							this.energia-=15;
							this.statusUpdate();
						}
					}
					else
					{
						System.out.println("No task has been chosen sir.");
					}
				}
				/*else if(c=='h' && this.tired==false)
				{
					this.e.bossChange();
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
				else if(this.e.getList().size()==0)
				{
					System.out.println("We do not have enought employees");
				}
				else
				{
					this.rest();
				}
			}
			catch(NullPointerException ex)
			{
				System.out.println("No economists have been hired");
			}
		}
	}
	private int[] calculations(int emp)
	{
		
		Economist e;
		DevelopmentManager d;
		int prices[]=new int[5];
		try
		{
			if(this.e.getList().get(emp) instanceof Economist)
			{
				e=(Economist)this.e.getList().get(emp);
				e.resCalc(this.e.getType(), this.e.getQuantity());
				if(e.needprices)
				{
					if(this.dboss instanceof DevelopmentManager)
					{
						d=(DevelopmentManager)this.dboss;
						prices=d.getPrices();
					}
					else
					{
						System.out.println("Not a boss " + this.dboss);
					}
				}
				else
				{
					System.out.println("Debug message unable to get prices");
					System.exit(1);
				}
			}
			else
			{
				System.out.println("No economic workers");
			}
		}
		catch(ArrayIndexOutOfBoundsException ex)
		{
			ex.printStackTrace();
		}
		catch(NullPointerException ex)
		{
			System.out.println(emp);
			ex.printStackTrace();
		}
		if(prices!=null)
		{
			return prices;
		}
		else
		{
			return null;
		}
	}
	public void getMaterials(int emp, int[] prices)
	{
		Economist e;
		try
		{
			if(this.e.getList().get(emp) instanceof Economist)
			{
				e=(Economist)this.e.getList().get(emp);
				this.nres=e.materials(prices);
			}
			else
			{
				System.out.println("Debug message no economic workers");
				System.exit(1);
			}
		}
		catch(ArrayIndexOutOfBoundsException ex)
		{
			ex.printStackTrace();
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
	public void updateDevelBoss(Clovek c)
	{
		this.dboss=c;
	}
	public void identifyAll()
	{
		int i;
		try
		{
			for(i=0;i<this.e.getList().size();i++)
			{
				this.e.getList().get(i).identity();
			}
		}
		catch(NullPointerException e)
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
