package Item.Inventaire;

import Item.Item.Item;
import Item.Item.ItemBread;
import Item.Item.ItemEggs;
import Item.Item.ItemMilk;

public class InventoryManager {
    private InventoryDatabase inventoryDatabase;

    public InventoryManager(){
        inventoryDatabase = new InventoryDatabase();
    }

    public void addNewBreadItem(int ID, String name, double price, String color, int weight){
        Item item = new ItemBread(ID, name,price,color,weight);
        inventoryDatabase.insert(item);
    }

    public void addNewEggsItem(int ID, String name, double price, String color, int number){
        Item item = new ItemEggs(ID, name,price,color,number);
        inventoryDatabase.insert(item);
    }

    public void addNewMilkItem(int ID, String name, double price, double fat, double liters){
        Item item = new ItemMilk(ID, name,price,fat,liters);
        inventoryDatabase.insert(item);
    }

    public void removeItem(int ID){
        inventoryDatabase.remove(ID);
    }

    public void increaseItemQuantity(int ID, int quantity){
        Item item = inventoryDatabase.findByID(ID) ;
        item.setQuantityInStock(item.getQuantityInStock() + quantity);
    }

    public void decreaseItemQuantity(int ID, int quantity){
        Item item = inventoryDatabase.findByID(ID) ;
        item.setQuantityInStock(item.getQuantityInStock() - quantity);
    }

    public Item getItem(int ID){
        return inventoryDatabase.findByID(ID) ;
    }

    public Item[] getArrayOfItems(){
        return inventoryDatabase.getArrayOfItems() ;
    }
}
