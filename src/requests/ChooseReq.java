package requests;

import java.util.ArrayList;
import java.util.Scanner;

public class ChooseReq {
	private ArrayList<Request> r;
	private String type;
	private int quantity;
	private Scanner s;
	public ChooseReq(ArrayList<Request> r, Scanner s)
	{
		this.r=r;
		this.s=s;
		this.init();
		
	}
	private void init()
	{
		
		int taskno=1;
		int i;
		System.out.println("Choose one of the following tasks(enter number)");
		for(i=0;i<this.r.size();i++)
		{
			System.out.println(i + ") " + this.r.get(i).getType() + " " + this.r.get(i).getQuantity());
		}
		
		taskno=this.s.nextInt();
		this.type=this.r.get(taskno).getType();
		this.quantity=this.r.get(taskno).getQuantity();
		//s.close();
	}
	
	
	public String getType()
	{
		return this.type;
	}
	public int getQuantity()
	{
		return this.quantity;
	}
}
