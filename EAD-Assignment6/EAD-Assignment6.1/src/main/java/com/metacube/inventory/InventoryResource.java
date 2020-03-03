package com.metacube.inventory;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/inventory")
public class InventoryResource
{
    InventoryRepository repo = new InventoryRepository();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Inventory> getInventory()
    {
        return repo.getInventory();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Inventory> insertItem(Inventory item)
    {
        return repo.insertItem(item);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Inventory> replaceFullInventory(List<Inventory> newInventory)
    {
        return repo.replaceFullInventory(newInventory);
    }

    @PUT
    @Path("{itemname}")
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Inventory> replaceItem(@PathParam("itemname") String replacingItem, Inventory replacedItem)
    {
        return repo.replaceitem(replacingItem, replacedItem);
    }

    @DELETE
    public String deleteAllItems()
    {
        return repo.deleteAllItems();
    }

    @DELETE
    @Path("{itemname}")
    public List<Inventory> deleteItem(@PathParam("itemname") String deleteItem)
    {
        return repo.deleteItem(deleteItem);
    }
}