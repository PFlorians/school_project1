package human;

import company.Resources;

public class Planner extends Clovek{
		String meno, przv;
		public int vek;
		public char g;
		private boolean planok=false;
		public Planner()
		{
			this.meno=this.name;
			this.przv=this.lastname;
			this.vek=this.age;
			this.g=this.gender;
		}
		public Planner(String meno, String przv)
		{
			this.meno=meno;
			this.przv=przv;
			this.vek=(int)(Math.ceil(Math.random()*60));
			this.g=this.gender;
		}
		public Planner(String meno, String przv, int vek, char g)
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
		
		public boolean checkPlan(int []nres, Resources res)
		{
			Resources r=res;
			System.out.println("We have: ");
			
			System.out.println("Metal: " + r.getMetal());
			System.out.println("Seiliconium: " + r.getSiliconium());
			System.out.println("Transistors: " + r.getTransistors());
			System.out.println("Raw materials: " + r.getRaw());
			System.out.println("Cash: " + r.getCash());
			
			System.out.println("We need: ");
			
			System.out.println("Metal: " + nres[0]);
			System.out.println("Seiliconium: " + nres[1]);
			System.out.println("Transistors: " + nres[2]);
			System.out.println("Raw materials: " + nres[3]);
			System.out.println("Cash: " + nres[4]);
			
			if(r.getMetal()>=nres[0] && r.getSiliconium()>=nres[1] && r.getTransistors()>=nres[2] && r.getRaw()>=nres[3])
			{
				this.energia-=30;
				this.statusUpdate();
				return true;
			}
			else
			{
				this.energia-=30;
				this.statusUpdate();
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
