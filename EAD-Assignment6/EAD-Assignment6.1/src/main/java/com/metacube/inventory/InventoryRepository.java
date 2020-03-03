package com.metacube.inventory;

import java.util.ArrayList;
import java.util.List;

public class InventoryRepository
{
    List<Inventory> items;

    public InventoryRepository()
    {
        items = new ArrayList<>();
        Inventory firstItem = new Inventory();
        firstItem.setName("Apples");
        firstItem.setQuantity(3);
        Inventory secondItem = new Inventory();
        secondItem.setName("Oranges");
        secondItem.setQuantity(7);
        Inventory thirdItem = new Inventory();
        thirdItem.setName("Pomegranates");
        thirdItem.setQuantity(55);
        items.add(firstItem);
        items.add(secondItem);
        items.add(thirdItem);
    }

    public List<Inventory> getInventory()
    {
        return items;
    }

    public List<Inventory> insertItem(Inventory item)
    {
        items.add(item);
        return items;
    }

    public List<Inventory> replaceFullInventory(List<Inventory> newInventory)
    {
        items.removeAll(items);
        items.addAll(newInventory);
        return items;
    }

    public List<Inventory> replaceitem(String replacingItem, Inventory replacedItem)
    {
        Inventory item1 = null;
        int index = 0;
        for (Inventory item : items)
        {
            if (replacingItem.equalsIgnoreCase(item.getName()))
            {
                item1 = item;
                break;
            }
            index++;
        }
        if (item1 != null)
        {
            items.set(index, replacedItem);
        } else
            System.out.println("Element Not Found");
        return items;
    }

    public String deleteAllItems()
    {
        items.clear();
        return "Deleted";
    }

    public List<Inventory> deleteItem(String deleteName)
    {
        Inventory item1 = null;
        for (Inventory item : items)
        {
            if (deleteName.equalsIgnoreCase(item.getName()))
            {
                item1 = item;
                break;
            }
        }
        if (item1 != null)
        {
            items.remove(item1);
        } else
            System.out.println("Element Not Found");
        return items;
    }
}
