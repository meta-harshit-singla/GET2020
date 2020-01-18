import java.util.*;
/**
 * This class is used to display the items available in the store
 * @author Harshit
 *
 */
public class MenuList 
{
    public static HashMap<String,Integer> temporaryMenuPrice=new HashMap<String,Integer>();
    public static HashMap<String,Integer> temporaryMenuQuantity=new HashMap<String,Integer>();
    public static HashMap<String,String> temporaryMenuProductName=new HashMap<String,String>();
    /**
     * Used to Add products in the store list
     */
    public static void addProductToMenu()
    {
        temporaryMenuProductName.put("1","Apple     ");
        temporaryMenuProductName.put("2","Banana    ");
        temporaryMenuProductName.put("3","Kiwi      ");
        temporaryMenuProductName.put("4","Uno Card  ");
        temporaryMenuProductName.put("5","Soft toy  ");
        temporaryMenuProductName.put("6","Towel     ");
        temporaryMenuProductName.put("7","Racing Car");
        temporaryMenuPrice.put("1",80);
        temporaryMenuPrice.put("2",30);
        temporaryMenuPrice.put("3",50);
        temporaryMenuPrice.put("4",20);
        temporaryMenuPrice.put("5",400);
        temporaryMenuPrice.put("6",200);
        temporaryMenuPrice.put("7",1000);
        temporaryMenuQuantity.put("1",20);
        temporaryMenuQuantity.put("2",10);
        temporaryMenuQuantity.put("3",20);
        temporaryMenuQuantity.put("4",20);
        temporaryMenuQuantity.put("5",30);
        temporaryMenuQuantity.put("6",50);
        temporaryMenuQuantity.put("7",40);
    }
    /**
     * Displays the available items in the store
     */
    public static void showMenu()
    {
        System.out.println("Product Id"+"\t\t"+"Name"+"\t\t\t\t\t\t"+"Price"+"\t\t\t"+"Available Quantity");
        int totalCartProducts=temporaryMenuQuantity.size();
        Iterator<String> keyValues=temporaryMenuPrice.keySet().iterator();
        for(int i=0;i<totalCartProducts;i++)
        {
            String productId=keyValues.next();
            //System.out.println(cartvalue.getProductid()+"\t\t\t"+cartvalue.getProductname()+"\t\t\t\t\t"+cartvalue.getProductquantity()+"\t\t\t"+cartvalue.getProductprice());
            System.out.println(productId+"\t\t\t"+temporaryMenuProductName.get(productId)+"\t\t\t\t\t"+temporaryMenuQuantity.get(productId)+"\t\t\t"+temporaryMenuPrice.get(productId));
        }
    }
    /**
     * Used to update the remaining quantity of items in the store
     * @param productId indicates product id
     * @param productQuantity indicates product quantity after updation of cart
     */
    public static void updatedQuantity(String productId,int productQuantity)
    {
        int availableQuantity=temporaryMenuQuantity.get(productId)-productQuantity;
        temporaryMenuQuantity.replace(productId,availableQuantity);
        if(availableQuantity==0)
        {
            temporaryMenuPrice.remove(productId);
        }
    }
}
