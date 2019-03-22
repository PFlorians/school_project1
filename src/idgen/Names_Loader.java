package idgen;

import java.io.*;
public class Names_Loader {
	private String names[]; 
	private String lnames[];
	private int n;
	public Names_Loader(int n)
	{
		this.n=n;
		this.names=new String[n];
		this.lnames=new String[n];
		this.load();
	}
	private void load()
	{
		int i=0, j;
		String names[]=new String[this.n];
		String lnames[]=new String[this.n];
		InputStreamReader isr=null;
		BufferedReader bf=null;
		FileInputStream is=null;//8 bit
		File f=null;
		
		
		try
		{
			
			bf=new BufferedReader(new FileReader("src/Names.txt"));//isr
			bf.mark(1);
			try
			{
				while((names[i]=bf.readLine())!=null)
				{
					//System.out.println(names[i]);
					i++;
				}
			}
			catch(ArrayIndexOutOfBoundsException e)
			{
				System.out.println("warning array names[] is out of bounds");					System.exit(1);
			}
			catch(NullPointerException e)
			{
				System.out.println("Couldn't read file bufferreader " + bf.readLine());					
				System.exit(1);
			}
			
			bf=new BufferedReader(new FileReader("src/Lastnames.txt"));//irs
			i=0;
				try
				{
					while((lnames[i]=bf.readLine())!=null)
					{
						//System.out.println(lnames[i]);
						i++;
					}
				}
				catch(ArrayIndexOutOfBoundsException e)
				{
					System.out.println("warning array lnames[] is out of bounds");
					System.exit(1);
				}
		}
		catch(IOException e)
		{
			System.out.println("IOException loading names");
			System.exit(1);
		}
		
		/*try
		{
			Thread.sleep(30000);
		}
		catch(InterruptedException e)
		{
			System.out.println("Interrrupt on thread went wrong");
			System.exit(2);
		}
		*/
		try
		{
			i--;
			for(j=0;j<i;j++)
			{
				//potencial vytvorenia metody na pocitanie riadkov
				this.names[j]=names[(int)Math.ceil(Math.random()*16)];
				this.lnames[j]=lnames[(int)Math.ceil(Math.random()*16)];
			}
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("arrays out of bounds");
			System.exit(1);
		}	
	}
	
	public String[] getNames()
	{
		return this.names;
	}
	public String[] getLnames()
	{
		return this.lnames;
	}
}
