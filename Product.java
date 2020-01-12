/**
 * Used for attributes of a product
 * @author Harshit
 *
 */
public class Product 
{
	private String Pname;
	private int Pquantity;
	private int Pprice;
	private int Pid;

	Product(int Pidd,String Pnamee,int Pquantityy,int Ppricee)
	{
		this.Pname=Pnamee;
		this.Pquantity=Pquantityy;
		this.Pprice=Ppricee;
		this.Pid=Pidd;
		
	}
	/**
	 * Used to set quantity of a product
	 * @param quantity represents quantity of a product
	 */
	public void setPquantity(int quantity)
	{
		Pquantity=quantity;
	}
	/**
	 * used to get the product name	
	 * @return the name of the product
	 */
	public String getPname()
	{
		return Pname;
	}
	/**
	 * used to get the quantity of a product
	 * @return the quantity of a product
	 */
	public int getPquantity()
	{
		return Pquantity;
	}
	/**
	 * used to get the price of a product
	 * @return the price of a product
	 */
	public int getPprice()
	{
		return Pprice;
	}
	/**
	 * Used to give back the product id
	 * @return the product id
	 */
	public int getPid()
	{
		return Pid;
	}
	

}
