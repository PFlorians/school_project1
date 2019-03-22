package market;
import company.Resources;
import machines.Product;

public class Sell {
	public void sellProducts(Resources res, Product[] p, int nres[])
	{
		res.setProducts(null);
		res.setCash(res.getCash()+nres[4]);
	}
}
