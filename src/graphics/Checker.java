package graphics;

import java.awt.event.WindowEvent;

import human.Clovek;
public class Checker {
	public boolean success=false;
	
	synchronized public void check(String u, String p, Main_win m)
	{
		if(this.success==true)
		{
			try
			{
				wait();
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		if(u.equals("root") && p.equals("toor"))
		{
			this.success=true;
			System.out.println("Success");
			notify();
			m.dispatchEvent(new WindowEvent(m, WindowEvent.WINDOW_CLOSING));
		}
		else
		{
			this.success=false;
			System.out.println("Failure");
			//notify();
		}
	}
	synchronized public void ready(Clovek c)
	{
		if(this.success==false)
		{
			try
			{
				wait();
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		this.success=false;
		c.tasks();
		notify();
	}
}
