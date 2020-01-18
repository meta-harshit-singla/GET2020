import java.util.*;
/**
 * This class is used to execute the main function only
 * @author Harshit
 *
 */
public class ShoppingCart 
{
    public static void main(String[] args)
    {
        MenuList.addProductToMenu();
        CustCartMethods cart=new CustCartMethods();
        Scanner s=new Scanner(System.in);
        String producId;
        while(true)
        {
            System.out.println("1.Menu");
            System.out.println("2.Add item to cart");
            System.out.println("3.Update quantity of item in cart");
            System.out.println("4.Remove item in cart");
            System.out.println("5.Generate a bill");
            System.out.println("6.Exit");
            System.out.println("\nEnter your choice:");
            producId=s.nextLine();
            switch(producId)
            {
                case "1":
                {
                    MenuList.showMenu();
                    break;
                }
                case "2":
                {
                    MenuList.showMenu();
                    System.out.println("\n\n\n"+"Your Cart");
                    cart.showCart();
                    System.out.println("Enter the id of the item you want to add with quantity:");
                    boolean flag=false;
                    String productId=s.nextLine();
                    int productQuantity=Integer.parseInt(s.nextLine());
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
                case "3":
                {
                    System.out.println("\n\n\n"+"Your Cart");
                    cart.showCart();
                    System.out.println("Enter the item id with updated quantity");
                    String productsId=s.nextLine();
                    int productsQuantity=Integer.parseInt(s.nextLine());
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
                case "4":
                {
                    System.out.println("\n\n\n"+"Your Cart\n\n");
                    cart.showCart();
                    System.out.println("Enter the id which you want to delete from the cart");
                    String productsId=s.nextLine();
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
                case "5":
                {
                    cart.generateBill();
                    break;
                }
                case "6":
                    System.out.println("Thank you for shopping!!!");
                    System.exit(1);
                    break;
                default:
                {
                    System.out.println("Wrong choice");
                    break;
                }
            }
        }
    }
}
