package company;

import graphics.*;
import human.Clovek;
public class Catalyst implements Runnable{
	Checker c;
	Clovek jane;
	Catalyst(Checker c, Clovek jane)
	{
		this.c=c;
		this.jane=jane;
		new Thread(this, "Catalyst").start();
	}
	public void run()
	{
		//while(this.c.success==true)
		//{
			this.c.ready(this.jane);
		//}
	}
}
