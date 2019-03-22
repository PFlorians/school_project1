package human;
import java.util.Scanner;
import java.io.*;

import hres.*;
import requests.*;


public class Secretary extends Clovek{
	String name, lastname;
	private Hresources h;
	
	private Scanner s;
	public Secretary(Hresources h)//nastaveny automaticky
	{
		this.name="Janette";
		this.lastname="Brown";
		
		this.age=24;
		this.gender='F';
		this.h=h;
	}
	public Secretary(String f, String l, Hresources h)
	{
		this.name=new String(f);
		this.lastname=new String(l);
		
		this.age=24;
		this.gender='F';
	}
	
	//methods
	public void identity()
	{
		System.out.println("Hello my name is: " + this.name);
		this.tasks();
	}
	public void tasks()
	{
		EmployersList econom=this.h.getEconomList();
		EmployersList devel=this.h.getDevelList();
		Hire hr=this.h.getH(); 
		char c=0;
		ChooseReq r=null;//sucasna uloha
		
		
		this.s=this.h.getScanner();
		System.out.println("***How may I assist you sir?***");
		
		
		while(c!='e' && this.energia>=1)//kym energia viac ako 0
		{	
			System.out.println("a -count all employers");
			System.out.println("h -hire a new employer/employees");
			System.out.println("m -show current market requests");
			System.out.println("c -economic department");
			System.out.println("d -development department");
			System.out.println("r -go get some rest");
			System.out.println("s -how are you feeling?");
			System.out.println("i -identities of all");
			System.out.println("e -exit");
			
			c=this.s.next().charAt(0);
			
			if(c=='a' && this.tired==false)
			{
				System.out.println("We have " + econom.size() + " economic employees working for us");
				System.out.println("We have " + devel.size() + " workers in development");
				System.out.println("All together we have " + (econom.size()+devel.size()) + " employees");
				this.energia-=5;
				this.statusUpdate();
			}
			else if(c=='h' && this.tired==false)
			{
				hr.init(econom, devel);//obe struktury pre dalsiu pracu
				
				this.h.updateEconomList(econom);
				this.h.updateDevelList(devel);
				
				this.energia=this.energia-15;
				this.statusUpdate();
			}
			else if(c=='c' && this.tired==false)
			{
				this.h.getO2().getBoss().tasks();
				this.energia=this.energia-5;
				this.statusUpdate();
			}
			else if(c=='d' && this.tired==false)
			{
				this.h.getO3().getBoss().tasks();
				this.energia=this.energia-5;
				this.statusUpdate();
			}
			else if(c=='m' && this.tired==false)//ziskaj request tu
			{
					this.energia=this.energia-5;
					r=new ChooseReq(new ReqList().getList(), this.s);
					
					System.out.println("Our new assignement is: ");
					System.out.println("create " + r.getQuantity() + " " + r.getType());
					//this.chosenTask=true;
					this.h.updateTask(r.getType(), r.getQuantity());
					this.statusUpdate();
					/*try
					{
						System.out.println("case2");
						System.out.println(System.in.available());
					}
					catch(IOException e)
					{
						System.out.println("case2");
						e.printStackTrace();
					}*/
				
				
			}
			else if(c=='i' && this.tired==false)
			{
				this.h.getO2().getBoss().identifyAll();
				this.h.getO3().getBoss().identifyAll();
			}
			else if(c=='r' || this.tired==true)
			{
				rest();
			}
			else if(c=='s')
			{
				status();
			}
			else if(c=='e')
			{
				System.exit(0);
			}
			else//najma ak nesplna this.tired==false
			{
				rest();
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
	public void status()
	{
		if(this.energia>50)
		{
			System.out.println("I'm fine thank you.");
			System.out.println("My energy is : " + this.energia);
		}
		else if(this.energia<50 && this.energia>25)
		{
			System.out.println("I'm a little tired");
			System.out.println("My energy is : " + this.energia);
		}
		else if(this.energia<25)
		{
			System.out.println("I'm exhausted.");
			System.out.println("My energy is : " + this.energia);
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
