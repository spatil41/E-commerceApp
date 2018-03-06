package Controller;


import java.util.Comparator;

import model.Product;

public class PriceComparator implements Comparator<Product>
{
	public int compare(Product P1, Product P2) //For comparing 2 records I've created 2 BankRecords objects.
	{		
		Double Price1 = new Double(P1.getUnitPrice()); //Object 1 is fetching income entry & storing it in Income1
		Double Price2 = new Double(P2.getUnitPrice()); //Object 2 is fetching income entry & storing it in Income2
		int compareresult=Price1.compareTo(Price2);  //Here, I am comparing the above 2 income entries.
		return compareresult; 
	}
	
}

