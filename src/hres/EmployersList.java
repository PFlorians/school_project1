package hres;
import human.Clovek;
import java.util.ArrayList;

public class EmployersList {
	
	private ArrayList<Clovek> employers;
	private int i;//pocet objektov v poli
	
	EmployersList()//musi existovat, kvoli konceptu pridavania zamestnancov
	{
		this.employers=new ArrayList<Clovek>(10);
		this.i=0;
	}
	EmployersList(int n)//user defined
	{
		this.employers=new ArrayList<Clovek>(n);
		this.i=0;
	}
	
	public void add(Clovek c)
	{
		this.employers.add(c);
	}
	public void remove(int i)
	{
		this.employers.remove(i);//ak i==2 vymaze a[2]==3 element
	}
	public int size()
	{
		return this.employers.size();
	}
	public Clovek get(int n)
	{
		return this.employers.get(n);
	}
}
