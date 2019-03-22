package economics;
import human.*;
import company.Resources;
import hres.EmployersList;

import java.util.Scanner;
import depts.Department;
public class Economics extends Department{
	private Clovek boss;
	//task description
	private String type=null;
	private int quantity=0;
	//list
	private EmployersList econom;
	
	private Scanner s;
	private Clovek dboss;
	
	public Economics(Scanner s)//defaultne prvy
	{
		this.boss=new EconomicChief(this);
		this.s=s;
	}
	
	public void updateTask(String type, int quantity)
	{
		this.type=type;
		this.quantity=quantity;
	}
	public void updateList(EmployersList econom)
	{
		this.econom=econom;
	}
	public EmployersList getList()
	{
		return this.econom;
	}
	
	
	/*public void bossChange()
	{
		String name, lname;
		int age;
		
		System.out.println("Please enter: Name ");
		this.s.nextLine();
		name=this.s.nextLine();
		System.out.println("Please enter: Lastname ");
		this.s.nextLine();
		lname=this.s.nextLine();
		System.out.println("Please enter: Age");
		age=this.s.nextInt();
		this.boss=new EconomicChief(name, lname, age, 'M', this);
	}*/
	public Clovek getBoss()
	{
		return this.boss;
	}
	public void updateDevelBossLink(Clovek c)//spusta sa v main
	{
		this.dboss=c;
		this.boss.c=this.dboss;
	}
	public Clovek getDBoss()
	{
		return this.dboss;
	}
	
	public String getType() {
		return type;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public Scanner getScanner()
	{
		return this.s;
	}
}
