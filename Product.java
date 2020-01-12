/**
 * Used for attributes of a product
 * @author Harshit
 *
 */
public class Product 
{
	private String productName;
	private int productQuantity;
	private int productPrice;
	private int productId;

	Product(int productsID,String productsName,int productsQuantityy,int productsPrices)
	{
		this.productName=productsName;
		this.productQuantity=productsQuantityy;
		this.productPrice=productsPrices;
		this.productId=productsID;
		
	}
	/**
	 * Used to set quantity of a product
	 * @param quantity represents quantity of a product
	 */
	public void setProductquantity(int quantity)
	{
		productQuantity=quantity;
	}
	/**
	 * used to get the product name	
	 * @return the name of the product
	 */
	public String getProductname()
	{
		return productName;
	}
	/**
	 * used to get the quantity of a product
	 * @return the quantity of a product
	 */
	public int getProductquantity()
	{
		return productQuantity;
	}
	/**
	 * used to get the price of a product
	 * @return the price of a product
	 */
	public int getProductprice()
	{
		return productPrice;
	}
	/**
	 * Used to give back the product id
	 * @return the product id
	 */
	public int getProductid()
	{
		return productId;
	}
	

}
