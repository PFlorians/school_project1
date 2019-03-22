package hres;

import human.Clovek;
import human.Secretary;
import economics.Economics;
import development.Development;
import java.util.Scanner;
//ludske zdroje, oddelenie podlieha priamo vedeniu
import depts.Department;
public class Hresources extends Department{
	public Clovek jane;
	private EmployersList economic;
	private EmployersList development;
	private Hire h1;
	private Economics o2;
	private Development o3;
	private Scanner s;
	
	public Hresources(Economics o2, Development o3, Scanner s)
	{
		this.jane=new Secretary(this);
		this.economic=new EmployersList();
		this.development=new EmployersList();
		this.h1=new Hire(s);
		this.o2=o2;
		this.o3=o3;
		this.s=s;
	}
	
	public EmployersList getEconomList()
	{
		if(this.economic!=null)
		{
			return this.economic;
		}
		else
		{
			return null;
		}
	}
	public void updateEconomList(EmployersList e)
	{
		this.o2.updateList(e);
	}
	
	public EmployersList getDevelList()
	{
		if(this.development!=null)
		{
			return this.development;
		}
		else
		{
			return null;
		}
	}
	public void updateDevelList(EmployersList d)
	{
		this.o3.updateList(d);
	}
	
	public Hire getH()
	{
		if(this.h1!=null)
		{
			return this.h1;
		}
		else
		{
			return null;
		}
	}
	
	public Economics getO2()
	{
		return this.o2;
	}
	public Development getO3()
	{
		return this.o3;
	}
	
	public void updateTask(String type, int quantity)
	{
		this.o2.updateTask(type, quantity);
		this.o3.updateTask(type, quantity);
	}
	public Scanner getScanner()
	{
		return this.s;
	}
}
