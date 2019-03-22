package requests;

/*
 * atributy poziadaviek:
 * typ, mnozstvo
 */

public class Request {
	private String type;
	private int quantity;
	
	Request()
	{
		randomize();
	}
	private final void randomize()
	{
		int typ;
		typ=(int)Math.ceil(Math.random()*4);//1-4
		this.quantity=(int)Math.ceil(Math.random()*10000);//1-10000
		if(typ==1)
		{
			this.type=new String("Processors");
		}
		else if(typ==2)
		{
			this.type=new String("Graphic cards");
		}
		else if(typ==3)
		{
			this.type=new String("Sound cards");
		}
		else if(typ==4)
		{
			this.type=new String("Co-processors");
		}
	}
	
	//getters & setters
	public String getType()
	{
		return this.type;
	}
	public int getQuantity()
	{
		return this.quantity;
	}
}