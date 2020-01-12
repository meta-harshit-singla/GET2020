import java.util.ArrayList;
import java.util.List;
/*
 *Used to execute all the functions performed in a cart 
 * 
 */
public class CustCartMethods
{
	public List<Product> cartvals=new ArrayList<Product>();
	/**
	 * Used to add items in the cart
	 * @param productid represents product id
	 * @param productquantity represents product quantity
	 * @return whether the product was added or not
	 */
	boolean add(int productid,int productquantity) 
	{
		
		if(MenuList.menul.get(MenuList.getIndexMenu(productid)).getProductid()==productid && MenuList.menul.get(MenuList.getIndexMenu(productid)).getProductquantity()>=productquantity)
		{
			cartvals.add(new Product(productid,MenuList.menul.get(MenuList.getIndexMenu(productid)).getProductname(),productquantity,MenuList.menul.get(MenuList.getIndexMenu(productid)).getProductprice()));
			MenuList.updatedQuantity(productid, productquantity);
			
			return true;
		}
		else
			try
		{
			throw new ArrayIndexOutOfBoundsException(-1);
		}
			catch(ArrayIndexOutOfBoundsException e)
		{
				throw e;
		}
	}
	/**
	 * Used to remove the items from the cart
	 * @param productid indicates product id
	 * @return return whether the item is removed or not
	 */
	boolean remove(int productid)
	{
		if(cartvals.get(this.cartIndex(productid)).getProductid()==productid)
		{
			int previousQuantity=cartvals.get(cartIndex(productid)).getProductquantity();
			int newQuantity=MenuList.menul.get(MenuList.getIndexMenu(productid)).getProductquantity()+previousQuantity;
			MenuList.updatedQuantity(productid, newQuantity);
			cartvals.remove(cartIndex(productid));
			return true;
		}
		else
			try
		{
			throw new ArrayIndexOutOfBoundsException(-1);
		}
			catch(ArrayIndexOutOfBoundsException e)
		{
				throw e;
		}
	}
	/**
	 * Used to update the quantity of the item in the cart
	 * @param productid represents the product id
	 * @param productquantity represents the updated quantity 
	 * @return whether the quantity has been changed or not
	 */
	boolean update(int productid,int productquantity)
	{
		if(cartvals.get(this.cartIndex(productid)).getProductid()==productid  && MenuList.menul.get(MenuList.getIndexMenu(productid)).getProductquantity()>=productquantity)
		{
			int previousquantity=cartvals.get(cartIndex(productid)).getProductquantity();
			int newquantity=productquantity-previousquantity;
			cartvals.get(cartIndex(productid)).setProductquantity(productquantity);
			MenuList.updatedQuantity(productid, newquantity);
			return true;
		}
		else
			try
		{
			throw new ArrayIndexOutOfBoundsException(-1);
		}
			catch(ArrayIndexOutOfBoundsException e)
		{
				throw e;
		}
			
	}
	/**
	 * Used to generate bill
	 */
	void generate()
	{
	    System.out.println("Product Id"+"\t\t"+"Name"+"\t\t\t\t\t\t"+"Quantity"+"\t\t"+"Price");
		for(Product cartvalue:cartvals)
		{
			System.out.println(cartvalue.getProductid()+"\t\t\t"+cartvalue.getProductname()+"\t\t\t\t\t"+cartvalue.getProductquantity()+"\t\t\t"+cartvalue.getProductprice());
		}
		System.out.println("\n\nTotal Price=Rs "+total());
	}
	/**
	 * Used to calculate the total amount of items in cart
	 * @return total price other items in the cart
	 */
	int total()
	{
		int totalprice=0;
		for(Product cartvalue:cartvals)
		{
			totalprice+=cartvalue.getProductprice()*cartvalue.getProductquantity();
		}
		return totalprice;
	}
	/**
	 * Used to calculate the index of items in cart
	 * @param productid represents product id
	 * @return the index at which product id is found 
	 * otherwise returns -1
	 */

	public  int cartIndex(int productid) 
	{
		for (int i = 0; i < cartvals.size(); i++) 
		{
	        Product index = (Product) cartvals.get(i);
	        if (productid == index.getProductid()) 
	        {
	            return i;
	        }
	    }
	    return -1;
	}
	void showcart()
	{
		System.out.println("Product Id"+"\t\t"+"Name"+"\t\t\t\t\t\t"+"Quantity"+"\t\t"+"Price");
		for(Product cartvalue:cartvals)
		{
			System.out.println(cartvalue.getProductid()+"\t\t\t"+cartvalue.getProductname()+"\t\t\t\t\t"+cartvalue.getProductquantity()+"\t\t\t"+cartvalue.getProductprice());
		}
	}
	
}
