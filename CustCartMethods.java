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
	 * @param pId represents product id
	 * @param pQuantity represents product quantity
	 * @return whether the product was added or not
	 */
	boolean add(int pId,int pQuantity) 
	{
		

		if(MenuList.menul.get(MenuList.getIndexMenu(pId)).getPid()==pId && MenuList.menul.get(MenuList.getIndexMenu(pId)).getPquantity()>=pQuantity)
		{
			cartvals.add(new Product(pId,MenuList.menul.get(MenuList.getIndexMenu(pId)).getPname(),pQuantity,MenuList.menul.get(MenuList.getIndexMenu(pId)).getPprice()));
			MenuList.updatedQuantity(pId, pQuantity);
			
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
	 * @param pId indicates product id
	 * @return return whether the item is removed or not
	 */
	boolean remove(int pId)
	{
		if(cartvals.get(this.cartIndex(pId)).getPid()==pId)
		{
			int previousQuantity=cartvals.get(cartIndex(pId)).getPquantity();
			int newQuantity=MenuList.menul.get(MenuList.getIndexMenu(pId)).getPquantity()+previousQuantity;
			MenuList.updatedQuantity(pId, newQuantity);
			cartvals.remove(cartIndex(pId));
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
	 * @param pId represents the product id
	 * @param pQuantity represents the updated quantity 
	 * @return whether the quantity has been changed or not
	 */
	boolean update(int pId,int pQuantity)
	{
		if(cartvals.get(this.cartIndex(pId)).getPid()==pId  && MenuList.menul.get(MenuList.getIndexMenu(pId)).getPquantity()>=pQuantity)
		{
			int previousquantity=cartvals.get(cartIndex(pId)).getPquantity();
			int newquantity=pQuantity-previousquantity;
			cartvals.get(cartIndex(pId)).setPquantity(pQuantity);
			MenuList.updatedQuantity(pId, newquantity);
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
		System.out.println("Product Id"+"\r\t\t  "+"Name"+"\r\t\t\t\t\t\t"+"Quantity"+"\r\t\t\t\t\t\t\t\t"+"Price(per Product)");
		for(Product cartvalue:cartvals)
		{
			System.out.println(cartvalue.getPid()+"\r\t\t"+cartvalue.getPname()+"\r\t\t\t\t\t  "+cartvalue.getPquantity()+"\r\t\t\t\t\t\t\t  "+cartvalue.getPprice());
		}
		System.out.println("\n\nTotal Price=Rs "+total());
	}
	/**
	 * Used to calculate the total amount of items in cart
	 * @return total price other items in the cart
	 */
	int total()
	{
		int tprice=0;
		for(Product cartvalue:cartvals)
		{
			tprice+=cartvalue.getPprice()*cartvalue.getPquantity();
		}
		return tprice;
	}
	/**
	 * Used to calculate the index of items in cart
	 * @param id represents product id
	 * @return the index at which product id is found 
	 * otherwise returns -1 with a message
	 */

	public  int cartIndex(int pid) 
	{
		for (int i = 0; i < cartvals.size(); i++) 
		{
	        Product index = (Product) cartvals.get(i);
	        if (pid == index.getPid()) 
	        {
	            return i;
	        }
	    }
	    return -1;
	}
	void showcart()
	{
		System.out.println("Product Id"+"\r\t\t"+"Name"+"\r\t\t\t\t\t\t"+"Quantity"+"\r\t\t\t\t\t\t\t\t"+"Price");
		for(Product cartvalue:cartvals)
		{
			System.out.println(cartvalue.getPid()+"\r\t  "+cartvalue.getPname()+"\r\t\t\t\t\t  "+cartvalue.getPquantity()+"\r\t\t\t\t\t\t\t  "+cartvalue.getPprice());
		}
	}
	
}
