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
		MenuList.add();
		CustCartMethods cart=new  CustCartMethods();
		Scanner s=new Scanner(System.in);
		char id;
		do
		{
			System.out.println("1.Menu");
			System.out.println("2.Add item to cart");
			System.out.println("3.Update quantity of item in cart");
			System.out.println("4.Delete item in cart");
			System.out.println("5.Generate a bill");
			System.out.println("\nEnter your choice:");
			id=s.next().charAt(0);
			switch(id)
			{
			case '1':
			{
				MenuList.show();
				break;
			}
			case '2':
			{
				MenuList.show();
				System.out.println("\n\n\n"+"Your Cart");
				cart.showcart();
				System.out.println("Enter the id of the item you want to add with quantity:");
				boolean flag=false;
				int prodId=s.nextInt();
				int prodQuantity=s.nextInt();
				try
				{
					flag=cart.add(prodId,prodQuantity);
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
				cart.showcart();
				System.out.println("Enter the item id with updated quantity");
				int pid=s.nextInt();
				int pquantity=s.nextInt();
				boolean flag;
				try
				{
					flag=cart.update(pid, pquantity);
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
				cart.showcart();
				System.out.println("Enter the id which you want to delete from the cart");
				int pid=s.nextInt();
				boolean flag=true;
				try
				{
					flag=cart.remove(pid);
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
				cart.generate();
				break;
			}
			default:
			{
				System.out.println("Wrong choice");
				break;
			}
			}
			System.out.println("Enter y if you want to continue:");
			id=s.next().charAt(0);
		}while(id=='y' || id=='Y');
		s.close();
		System.out.println("Thank you for shopping!!!");
	}

}
