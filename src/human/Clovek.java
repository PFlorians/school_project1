package human;
import java.util.Scanner;
import depts.Department;
public abstract class Clovek implements Identity {
	String name, lastname;
	public int age;
	public char gender;
	int energia;
	boolean tired=false;
	public Clovek c;
	public Clovek()
	{
		this.energia=100;
		this.age=30;
		this.gender='M';
		this.name="Jeremiah";
		this.lastname="Johnsson";
	}
	public Clovek(String name, String lname)
	{
		this.name=name;
		this.lastname=lname;
		this.age=35;
		this.gender='F';
		this.energia=100;
	}
	public Clovek(String name, String lastname, int age, Department d)
	{
		this.name=name;
		this.lastname=lastname;
		this.age=age;
		//dane automaticky.
		this.gender='M';
		this.energia=100;
	}
	public void identity()
	{
		System.out.println(this.name);
		System.out.println(this.lastname);
	}
	
	public void tasks()
	{
		Scanner s=new Scanner(System.in);
		char c='0';
		while(c!='e')
		{
			System.out.println("r -rest");
			System.out.println("f -eat");
			System.out.println("w -walk");
			System.out.println("s -run");
			System.out.println("e -exit");
			if(this.energia<0)
			{
				System.out.println("I'm too tired I shall take some rest.");
				this.tired=true;
				this.rest();
			}
			c=s.nextLine().charAt(0);
			
			if(c=='r')
			{
				this.rest();
			}
			else if(c=='f' && this.energia>=0)
			{
				this.eat();
			}
			else if(c=='w' && this.energia>0)
			{
				this.walk();
			}
			else if(c=='s' && this.energia>0)
			{
				this.run();
			}
			else
			{
				this.rest();
			}
		}
		s.close();
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
		System.out.println("My energy is : " + this.energia);
	}
	public void eat()
	{
		this.energia+=25;
	}
	public void run()
	{
		this.energia-=20;
	}
	public void walk()
	{
		this.energia-=10;
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
	public void setName(String name)
	{
		this.name=name;
	}
	public void setLname(String name)
	{
		this.lastname=name;
	}
	public void setAge(int n)
	{
		this.age=n;
	}
	public void identifyAll()
	{
		
	}
}
