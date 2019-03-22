package human;
import market.*;
import company.Resources;

import java.util.Scanner;
import machines.Product;

public class Trader extends Clovek{
		String meno, przv;
		public int vek;
		public char g;
		private Init i;
		private Scanner s;
		public Trader()
		{
			this.meno=this.name;
			this.przv=this.lastname;
			this.vek=this.age;
			this.g=this.gender;
			this.i=new Init();
		}
		public Trader(String meno, String przv)
		{
			this.meno=meno;
			this.przv=przv;
			this.vek=(int)(Math.ceil(Math.random()*60));
			this.g=this.gender;
			this.i=new Init();
		}
		public Trader(String meno, String przv, int vek, char g)
		{
			this.meno=meno;
			this.przv=przv;
			this.vek=vek;
			this.g=g;
			this.i=new Init();
		}
		
		public void identity()
		{
			System.out.println(this.meno);
			System.out.println(this.przv);
			System.out.println(this.energia);
		}
		
		public int[] getPrices()
		{
			int a[]=new int[5];
			if(this.tired==false)
			{
				a[0]=i.getMetal();
				a[1]=i.getSiliconium();
				a[2]=i.getTransistors();
				a[3]=i.getRaw();
				this.energia-=10;
				this.statusUpdate();
				return a;
			}
			else
			{
				this.rest();
				a[0]=i.getMetal();
				a[1]=i.getSiliconium();
				a[2]=i.getTransistors();
				a[3]=i.getRaw();
				this.energia-=10;
				this.statusUpdate();
				return a;
			}
		}
		public int[] getQuantities()
		{
			int a[]=new int[5];
			if(this.tired==false)
			{
				a[0]=i.getR().getMetal();
				a[1]=i.getR().getRaw();
				a[2]=i.getR().getSiliconium();
				a[3]=i.getR().getTransistors();
				this.energia-=10;
				this.statusUpdate();
				return a;
			}
			else
			{
				this.rest();
				a[0]=i.getR().getMetal();
				a[1]=i.getR().getRaw();
				a[2]=i.getR().getSiliconium();
				a[3]=i.getR().getTransistors();
				this.energia-=10;
				this.statusUpdate();
				return a;
			}
		}
		public void buyMaterials(Resources res, Scanner s, int nres[])//sem pride company.res
		{
			market.Resources r=this.i.getR();
			Buy b=new Buy();
			int c=0, d;
			int price[]=new int[5];
			int qmat[]=new int[5];
			this.s=s;
			price=this.getPrices();
			qmat=this.getQuantities();
			
			System.out.println("Following resources are avalible: (press number)");
			System.out.println("1)Metal: " + qmat[0] + " pieces " + price[0] + "$ per piece");
			System.out.println("2)Seiliconium: " + qmat[1] + " pieces " + price[1] + "$ per piece");
			System.out.println("3)Transistors: " + qmat[2] + " pieces " + price[2] + "$ per piece");
			System.out.println("4)Raw materials: " + qmat[3] + " pieces " + price[3] + "$ per piece");
			c=this.s.nextInt();
			if(!(c>=1 && c<=4))
			{
				while(!(c>=1 && c<=4))
				{
					System.out.println("Following resources are avalible: (press number)");
					System.out.println("1)Metal: " + qmat[0] + " pieces " + price[0] + "$ per piece");
					System.out.println("2)Seiliconium: " + qmat[1] + " pieces " + price[1] + "$ per piece");
					System.out.println("3)Transistors: " + qmat[2] + " pieces " + price[2] + "$ per piece");
					System.out.println("4)Raw materials: " + qmat[3] + " pieces " + price[3] + "$ per piece");
					c=this.s.nextInt();
				}
			}
			System.out.println("How much do you want to buy?" + qmat[c-1] + "max");
			d=c;
			c=0;
			if(!(c>0 && c<=qmat[d-1]))
			{
				while(!(c>0 && c<=qmat[d-1]))
				{
					System.out.println("(enter number)");
					c=this.s.nextInt();
				}
			}
			if(d==1)
			{
				b.buyMetal(c, r);
				res.setMetal(res.getMetal()+c);
				res.setCash(res.getCash()-(price[0]*c));
				nres[0]=nres[0]-c;
				//System.out.println(res.getMetal() + " " + res.getCash() + " needed " + nres[0] );
			}
			else if(d==2)
			{
				b.buySiliconium(c, r);
				res.setSiliconium(res.getSiliconium()+c);
				res.setCash(res.getCash()-(price[0]*c));
				nres[1]=nres[1]-c;

			}
			else if(d==3)
			{
				b.buyTransistors(c, r);
				res.setTransistors((int)res.getTransistors()+c);
				res.setCash(res.getCash()-(price[0]*c));
				nres[2]=nres[2]-c;
			}
			else if(d==4)
			{
				b.buyRaw(c, r);
				res.setRaw(res.getRaw()+c);
				res.setCash(res.getCash()-(price[0]*c));
				nres[3]=nres[3]-c;
			}
		}
		public void sellProduct(Resources res, int nres[], Scanner s)
		{
			char c='-';
			Sell trade=new Sell();
			System.out.println("Do you want so sell products?[Y/N]");
			if(c=='Y' || c=='y')
			{
				trade.sellProducts(res, res.getProducts(), nres);
				System.out.println("Trade successfull");
				this.energia-=10;
				this.statusUpdate();
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
