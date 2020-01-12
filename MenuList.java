import java.util.*;
/**
 * This class is used to display the items available in the store
 * @author Harshit
 *
 */
public class MenuList {

	public static List<Product> menul=new ArrayList<Product>();
	public static void add()
	{
		menul=new ArrayList<Product>();
		menul.add(new Product(1,"Apple",20,80));
		menul.add(new Product(2,"Banana",10,30));
		menul.add(new Product(3,"Kiwi",20,50));
		menul.add(new Product(4,"UNO playing cards",20,20));
		menul.add(new Product(5,"Soft toy(Teddy bear)",30,400));
		menul.add(new Product(6,"Towel",50,200));
		menul.add(new Product(7,"Racing Car",40,1000));
	}
	/**
	 * Displays the available items in the store
	 */
	public static void show()
	{
		System.out.println("Product Id"+"\r\t\t"+"Name"+"\r\t\t\t\t\t\t"+"Price"+"\r\t\t\t\t\t\t\t\t"+"Available Quantity");
		for(Product menu1:menul)
		{
			System.out.println(menu1.getPid()+"\r\t"+menu1.getPname()+"\r\t\t\t\t\t  "+menu1.getPprice()+"\r\t\t\t\t\t\t\t  "+menu1.getPquantity());
		}
	}
	/**
	 * Used to update the remaining quantity of items in the store
	 * @param pid indicates product id
	 * @param pquantity indicates product quantity after updation of cart
	 */
	public static void updatedQuantity(int pid,int pquantity)
	{
		int availablequan=menul.get(getIndexMenu(pid)).getPquantity()-pquantity;
		menul.get(getIndexMenu(pid)).setPquantity(availablequan);
		if(availablequan==0)
			menul.remove(getIndexMenu(pid));
	}
	/**
	 * Used to get the Index of the specified product id
	 * @param id indicates product id
	 * @return return the index at which product id is found 
	 * otherwise returns -1 with a message
	 */
	public static int getIndexMenu(int pid)
	{
		for (int i = 0; i < MenuList.menul.size(); i++)
		{
			Product index = (Product) MenuList.menul.get(i);
			if (pid == index.getPid()) 
			{
				return i;
			}
		}
		return -1;
	}
}
