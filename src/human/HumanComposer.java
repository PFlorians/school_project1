package human;
import human.Clovek;
import hres.EmployersList;
import economics.Economics;

//zatial len automaticke
public class HumanComposer {
	public void economicComposer(String names[], String lnames[], EmployersList econom, int max)
	{
		//boss uz je v tomto momente vygenerovany
		
		int i;
		int num;
		for(i=0;i<max;i++)
		{
			num=(int)Math.floor(Math.random()*15);
			if(names[num]==null)
			{
				while(names[num]==null || lnames[num]==null)
				{
					num=(int)Math.floor(Math.random()*15);
				}
			}
			econom.add(new Economist(names[num], lnames[num]));
		}
		
	}
	public Clovek addRandEconom(String names[], String lnames[])//jednotlivec
	{
		Clovek c;
		int num=(int)Math.ceil(Math.random()*16);
		c=new Economist(names[num], lnames[num]);//default
		return c;
	}
	public Clovek addEconomBoss(String names[], String lnames[], Economics e)
	{
		Clovek c;
		int num=(int)Math.ceil(Math.random()*16);
		c=new EconomicChief(names[num], lnames[num], e);
		return c;
	}
	public Clovek addCustomEconom(String name, String lname)
	{
		return new Economist(name, lname);
	}
	
	public void develComposer(String names[], String lnames[], EmployersList devel, int max)
	{
		
		int i;
		int num;
		for(i=0;i<max/2;i++)
		{
			for(i=0;i<max;i++)
			{
				num=(int)Math.floor(Math.random()*15);
				if(names[num]==null)
				{
					while(names[num]==null || lnames[num]==null)
					{
						num=(int)Math.floor(Math.random()*15);
					}
				}
			devel.add(new Mathematician(names[num], lnames[num]));
			}
		}
		num=(int)Math.floor(Math.random()*15);
		devel.add(new Planner(names[num], lnames[num]));
		num=(int)Math.floor(Math.random()*15);
		devel.add(new Trader(names[num], lnames[num]));
	}
	public Clovek addRandDevel(String names[], String lnames[])
	{
		Clovek c;
		int n=(int)Math.floor(Math.random()*3);
		int num=(int)Math.ceil(Math.random()*16);
		if(n==0)
		{
			c=new Mathematician(names[num], lnames[num]);//default
		}
		else if(n==1)
		{
			c=new Planner(names[num], lnames[num]);//default
		}
		else
		{
			c=new Trader(names[num], lnames[num]);//default
		}
		return c;
	}
	public Clovek addCustomDevel(String name, String lname)
	{
		return new Mathematician(name, lname);
	}
}
