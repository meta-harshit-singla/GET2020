import java.util.*;
/**
 * This class is used to execute the main function only
 * @author Harshit
 *
 */
public class ShoppingCart 
{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MenuList.addProductToMenu();
		CustCartMethods cart=new  CustCartMethods();
		Scanner s=new Scanner(System.in);
		char prodId;
		do
		{
			System.out.println("1.Menu");
			System.out.println("2.Add item to cart");
			System.out.println("3.Update quantity of item in cart");
			System.out.println("4.Delete item in cart");
			System.out.println("5.Generate a bill");
			System.out.println("\nEnter your choice:");
			prodId=s.next().charAt(0);
			switch(prodId)
			{
			case '1':
			{
				MenuList.showMenu();
				break;
			}
			case '2':
			{
				MenuList.showMenu();
				System.out.println("\n\n\n"+"Your Cart");
				cart.showCart();
				System.out.println("Enter the id of the item you want to add with quantity:");
				boolean flag=false;
				int productId=s.nextInt();
				int productQuantity=s.nextInt();
				try
				{
					flag=cart.additems(productId,productQuantity);
				}
				catch(ArrayIndexOutOfBoundsException e)
				{
					System.out.println("Product not Available");
					break;
				}
				if(flag)
					System.out.println("Product Added");
			
				break;
			}
			case '3':
			{
				System.out.println("\n\n\n"+"Your Cart");
				cart.showCart();
				System.out.println("Enter the item id with updated quantity");
				int productsId=s.nextInt();
				int productsQuantity=s.nextInt();
				boolean flag;
				try
				{
					flag=cart.updateCart(productsId, productsQuantity);
				}
				catch(ArrayIndexOutOfBoundsException e)
				{
					System.out.println("Product Not in your cart");
					break;
				}
				if(flag)
				{
					System.out.println("Updated!!!!");
					break;
				}
			}
			case '4':
			{
				System.out.println("\n\n\n"+"Your Cart\n\n");
				cart.showCart();
				System.out.println("Enter the id which you want to delete from the cart");
				int productsId=s.nextInt();
				boolean flag=true;
				try
				{
					flag=cart.removeitems(productsId);
				}
				catch(ArrayIndexOutOfBoundsException e)
				{
					System.out.println("Product Not in your cart");
					break;
				}
				if(flag)
				{
					System.out.println("Product removed");
					break;	
				}
			}
			case '5':
			{
				cart.generateBill();
				break;
			}
			default:
			{
				System.out.println("Wrong choice");
				break;
			}
			}
			System.out.println("Enter y if you want to continue:");
			prodId=s.next().charAt(0);
		}while(prodId=='y' || prodId=='Y');
		s.close();
		System.out.println("Thank you for shopping!!!");
	}

}
