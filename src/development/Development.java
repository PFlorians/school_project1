package development;
import human.*;
import hres.EmployersList;

import java.util.Scanner;
import depts.Department;
import company.Resources;
public class Development extends Department 
{
	private Clovek boss;
	//task descr
	private String type=null;
	private int quantity=0;
	private Scanner s;
	private EmployersList devel;
	private Resources r;
	private Clovek eboss;
	
	
	public Development(Scanner s)
	{
		this.boss=new DevelopmentManager(this);
		this.s=s;
		this.r=new Resources();
	}
	
	public void updateTask(String type, int quantity)
	{
		this.type=type;
		this.quantity=quantity;
	}
	public void updateList(EmployersList devel)
	{
		this.devel=devel;
	}
	public EmployersList getList()
	{
		return this.devel;
	}
	public Clovek getBoss()
	{
		return this.boss;
	}
	public void updateEconomBoss(Clovek c)
	{
		this.eboss=c;
		this.boss.c=c;
	}
	public Clovek getEBoss()
	{
		return this.eboss;
	}
	public Scanner getScanner()
	{
		return this.s;
	}
	public String getType() {
		return type;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public Resources getRes()
	{
		return this.r;
	}
	/*public void bossChange()
	{
		String name, lname;
		int age;
		
		System.out.println("Name");
		this.s.nextLine();
		name=this.s.nextLine();
		System.out.println("Lastname");
		lname=this.s.nextLine();
		System.out.println("Age");
		age=this.s.nextInt();
		this.boss=new DevelopmentManager(name, lname, age, 'M', this);
	}*/
}
