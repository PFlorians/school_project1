package hres;


import idgen.*;

import java.util.*;

import human.HumanComposer;

public class Hire {
	//economics
	private int maxe;//economist
	
	//development
	private int maxm;//mathematics
	private int maxen;//engineers
	private int maxp;//planners
	private int maxt;//traders
	
	private Names_Loader l1;
	private int shown=0;
	private HumanComposer hc;//pre skladbu instancii cloveka, mena su vygenerovane
	private Scanner s;
	
	Hire(Scanner s)//default
	{
		this.maxe=6;
		
		this.maxm=2;
		this.maxen=2;
		this.maxp=1;
		this.maxt=1;
		
		this.l1=new Names_Loader(20);//pre zaciatok default
		this.hc=new HumanComposer();
		this.s=s;
	}
	
	public final void init(EmployersList econom, EmployersList devel)
	{
		char c='0';
		
		System.out.println("You may now hire new people");
		
		while(c!='e')
		{
			System.out.println("To hire economists press n");
			System.out.println("To hire developers press d");
			System.out.println("To fire economists press f");
			System.out.println("To fire developers press g");
			System.out.println("If you wish to exit press e");
			
			c=this.s.next().charAt(0);

			if(c=='n')
			{
				hireEconomists(econom);	
			}
			else if(c=='d')
			{
				hireDevelopers(devel);
			}
			else if(c=='f')
			{
				this.fireEconomists(econom);
			}
			else if(c=='g')
			{
				this.fireDevelopers(devel);
			}
			else if(c=='e')
			{
				break;
			}
		}
		//s.close();
		
	}
	
	private final void hireEconomists(EmployersList econom)
	{	
		String names[]=this.l1.getNames();//pre metody composera
		String lnames[]=this.l1.getLnames();
		
		char dialogue='-';
		int num;
		int i;
		
		String cname, clname;
			
		if(econom.size()==0)//toto nastane ak neboli este vytvoreni
		{
			try
			{
				this.hc.economicComposer(names, lnames, econom, 4);//4 len defaultne, pole pre 10
				
			}
			catch(NullPointerException e)
			{
				System.out.println(names[0] + " "  + lnames[0] + " " + econom);
				e.printStackTrace();
			}
		}
		else
		{
			System.out.println(this.maxe + " economic workers for hire(enter number)");
			num=this.s.nextInt();
			
			if(num>0 && num<this.maxe)
			{
				System.out.println("Randomize? [Y/N]");
				dialogue=this.s.next().charAt(0);
				if(dialogue=='Y' || dialogue=='y')
				{
					for(i=0;i<num;i++)
					{
						econom.add(this.hc.addRandEconom(names, lnames));
					}
				}
				else
				{
					for(i=0;i<num;i++)
					{
						System.out.println("Enter name");
						cname=this.s.next();
						System.out.println("Enter lastname");
						clname=this.s.next();
						econom.add(this.hc.addCustomEconom(cname, clname));
					}
				}
			}
			else
			{
				System.out.println(this.maxe + " is a limit number please enter number "
						+ "from interval <1;" + this.maxe + ">");
			}
			this.maxe=this.maxe-num;
		}
		
		//s.close();
	}
	private final void fireEconomists(EmployersList econom)
	{
		
		int num;
		int i;
		System.out.println("You have " + (econom.size()-1) + " economists working for you");
		System.out.println("How many do you want to fire?");
		num=this.s.nextInt();
		if(num>=0 && num<econom.size()-1)
		{
			for(i=0;i<num;i++)
			{
				econom.remove(econom.size()-1);//zmensi vzdy o jedno
			}
		}
		else
		{
			System.out.println("Wrong interval");
		}
		//s.close();
	}
	
	private final void hireDevelopers(EmployersList devel)
	{
		String names[]=this.l1.getNames();
		String lnames[]=this.l1.getLnames();
		
		
		char dialogue='-';
		int num;
		int i;
		
		String cname, clname;
			
		if(devel.size()==0)//toto nastane ak neboli este vytvoreni
		{
			this.hc.develComposer(names, lnames, devel, 4);//4 len defaultne, pole pre 10
		}
		else
		{
			System.out.println(this.maxe + " economic workers for hire(enter number)");
			num=this.s.nextInt();
			
			if(num>0 && num<this.maxe)
			{
				System.out.println("Randomize? [Y/N]");
				dialogue=this.s.next().charAt(0);
				if(dialogue=='Y' || dialogue=='y')
				{
					for(i=0;i<num;i++)
					{
						devel.add(this.hc.addRandDevel(names, lnames));
					}
				}
				else
				{
					for(i=0;i<num;i++)
					{
						System.out.println("Enter name");
						cname=this.s.next();
						System.out.println("Enter lastname");
						clname=this.s.next();
						devel.add(this.hc.addCustomDevel(cname, clname));
					}
				}
			}
			else
			{
				System.out.println(this.maxe + " is a limit number please enter number "
						+ "from interval <1;" + this.maxe + ">");
			}
			this.maxe=this.maxe-num;
		}
		
		//s.close();
	}
	private final void fireDevelopers(EmployersList devel)
	{
		
		int num;
		int i;
		System.out.println("You have " + (devel.size()-1) + " economists working for you");
		System.out.println("How many do you want to fire?");
		num=this.s.nextInt();
		if(num>=0 && num<devel.size()-1)
		{
			for(i=0;i<num;i++)
			{
				devel.remove(devel.size()-1);//zmensi vzdy o jedno
			}
		}
		else
		{
			System.out.println("Wrong interval");
		}
		//s.close();
	}
}
