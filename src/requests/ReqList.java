package requests;
import java.util.ArrayList;

/*
 * list pripravenych requestov
 */
public class ReqList {
	protected ArrayList<Request> requests;
	
	public ReqList()
	{
		this.requests=new ArrayList<Request>(10);
		createRequests(10);
	}
	
	//methods
	private void createRequests(int n)
	{
		int i;
		for(i=0;i<n;i++)
		{
			this.requests.add(new Request());//nahodne vytvor n requestov
		}
	}
	
	//get & set
	public ArrayList<Request> getList()
	{
		return this.requests;
	}
}
