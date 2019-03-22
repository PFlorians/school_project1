package company;

import hres.Hresources;
import development.Development;
import economics.Economics;
import graphics.*;
import java.util.Scanner;

/*
 * Username: root
 * Password: toor
 * 
 */
public class Main {
	 
	public static void main(String args[])
	{
		Scanner s=new Scanner(System.in);
		Hresources o1;
		Economics o2;
		Development o3;

		//o=oddelenie
		o2=new Economics(s);
		o3=new Development(s);
		o1=new Hresources(o2, o3, s);
		
		o2.updateDevelBossLink(o3.getBoss());
		o3.updateEconomBoss(o2.getBoss());
		//TMasterClovek t[]=new TMasterClovek[30];
		Checker c=new Checker();
		
		Main_win m=new Main_win(c);
		m.setVisible(true);
		//Thread t0=new Thread(m, "Login");
		//t0.start();
		
		new Catalyst(c, o1.jane);
		//Thread t1=new Thread(cm, "Catalyst");
		
		//t1.start();
		//s.close();
	}
	
}
