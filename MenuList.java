import java.util.*;
/**
 * This class is used to display the items available in the store
 * @author Harshit
 *
 */
public class MenuList {

	public static List<Product> menul=new ArrayList<Product>();
	/**
	 * Used to Add products in the store list
	 */
	public static void addProductToMenu()
	{
		menul=new ArrayList<Product>();
		menul.add(new Product(1,"Apple        ",20,80));
		menul.add(new Product(2,"Banana       ",10,30));
		menul.add(new Product(3,"Kiwi         ",20,50));
		menul.add(new Product(4,"UNO card     ",20,20));
		menul.add(new Product(5,"Soft toy     ",30,400));
		menul.add(new Product(6,"Towel        ",50,200));
		menul.add(new Product(7,"Racing Car   ",40,1000));
	}
	/**
	 * Displays the available items in the store
	 */
	public static void showMenu()
	{
		System.out.println("Product Id"+"\t\t"+"Name"+"\t\t\t\t\t\t"+"Price"+"\t\t\t"+"Available Quantity");
		for(Product menu1:menul)
		{
			System.out.println(menu1.getProductid()+"\t\t  "+menu1.getProductname()+"\t\t\t\t\t\t"+menu1.getProductprice()+"\t\t\t"+menu1.getProductquantity());
		}
	}
	/**
	 * Used to update the remaining quantity of items in the store
	 * @param productid indicates product id
	 * @param productquantity indicates product quantity after updation of cart
	 */
	public static void updatedQuantity(int productid,int productquantity)
	{
		int availablequantity=menul.get(getIndexMenu(productid)).getProductquantity()-productquantity;
		menul.get(getIndexMenu(productid)).setProductquantity(availablequantity);
		if(availablequantity==0)
			menul.remove(getIndexMenu(productid));
	}
	/**
	 * Used to get the Index of the specified product id
	 * @param productid indicates product id
	 * @return return the index at which product id is found 
	 * otherwise returns -1 with a message
	 */
	public static int getIndexMenu(int productid)
	{
		for (int i = 0; i < MenuList.menul.size(); i++)
		{
			Product index = (Product) MenuList.menul.get(i);
			if (productid == index.getProductid()) 
			{
				return i;
			}
		}
		return -1;
	}
}
