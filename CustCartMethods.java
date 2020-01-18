import java.util.HashMap;
import java.util.Iterator;
/*
 *Used to execute all the functions performed in a cart 
 * 
 */
public class CustCartMethods
{
    public HashMap<Integer,Integer> cartMapQuantity=new HashMap<Integer,Integer>();
    public HashMap<Integer,Integer> cartMapPrice=new HashMap<Integer,Integer>();
    public HashMap<Integer,String> cartMapProductName=new HashMap<Integer,String>();
    /**
     * Used to add items in the cart
     * @param productId represents product id
     * @param productQuantity represents product quantity
     * @return whether the product was added or not
     */
    boolean additems(int productId,int productQuantity) 
    {
        if(MenuList.temporaryMenuPrice.containsKey(productId) && MenuList.temporaryMenuQuantity.get(productId)>=productQuantity)
        {
            cartMapQuantity.put(productId,productQuantity);
            cartMapPrice.put(productId,MenuList.temporaryMenuPrice.get(productId));
            cartMapProductName.put(productId,MenuList.temporaryMenuProductName.get(productId));
            MenuList.updatedQuantity(productId, productQuantity);       
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
     * @param productId indicates product id
     * @return return whether the item is removed or not
     */
    boolean removeitems(int productId)
    {
        if(cartMapPrice.containsKey(productId))
        {
            MenuList.updatedQuantity(productId,(MenuList.temporaryMenuQuantity.get(productId)+cartMapQuantity.get(productId)));
            cartMapPrice.remove(productId,cartMapPrice.get(productId));
            cartMapQuantity.remove(productId,cartMapQuantity.get(productId));
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
     * @param productId represents the product id
     * @param productQuantity represents the updated quantity 
     * @return whether the quantity has been changed or not
     */
    boolean updateCart(int productId,int productQuantity)
    {
        if(cartMapPrice.containsKey(productId) && MenuList.temporaryMenuQuantity.get(productId)>=productQuantity)
        {
            cartMapQuantity.replace(productId,productQuantity);
            MenuList.updatedQuantity(productId,productQuantity-cartMapQuantity.get(productId));
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
    void generateBill()
    {
        System.out.println("Product Id"+"\t\t"+"Name"+"\t\t\t\t\t\t"+"Quantity"+"\t\t"+"Price");
        int totalCartProducts=cartMapQuantity.size();
        Iterator<Integer> keyValues=cartMapPrice.keySet().iterator();
        for(int i=0;i<totalCartProducts;i++)
        {
            int productId=keyValues.next();
            System.out.println(productId+"\t\t\t"+cartMapProductName.get(productId)+"\t\t\t\t\t"+cartMapQuantity.get(productId)+"\t\t\t"+cartMapPrice.get(productId));
        }
        System.out.println("\n\nTotal Price=Rs "+calculateTotalAmount());
    }
    /**
     * Used to calculate the total amount of items in cart
     * @return total price other items in the cart
     */
    int calculateTotalAmount()
    {
        int totalPrice=0,cartSize=cartMapQuantity.size();
        Iterator<Integer> keyValues=cartMapPrice.keySet().iterator();
        while(cartSize>0)
        {
            int pid=keyValues.next();
            totalPrice+=cartMapPrice.get(pid)*cartMapQuantity.get(pid);
            cartSize--;
        }
        return totalPrice;
    }
    /**
     * Used to show cart items
     */
    void showCart()
    {
        System.out.println("Product Id"+"\t\t"+"Name"+"\t\t\t\t\t\t"+"Quantity"+"\t\t"+"Price");
        int totalCartProducts=cartMapQuantity.size();
        Iterator<Integer> keyValues=cartMapPrice.keySet().iterator();
        for(int i=0;i<totalCartProducts;i++)
        {
            int productId=keyValues.next();
            System.out.println(productId+"\t\t\t"+cartMapProductName.get(productId)+"\t\t\t\t\t"+cartMapQuantity.get(productId)+"\t\t\t"+cartMapPrice.get(productId));
        }
    }  
}
