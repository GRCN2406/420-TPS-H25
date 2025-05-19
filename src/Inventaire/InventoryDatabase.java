package Item.Inventaire;

import Item.Item.Item;

public class InventoryDatabase {
    private int itemsCount ;
    private InventoryDatabaseNode first ;

    public InventoryDatabase(){

    }

    public void insert(Item item){
        InventoryDatabaseNode newItem = new InventoryDatabaseNode(item) ;
        this.getLast().next = newItem ;
    }

    private InventoryDatabaseNode getLast(){
        InventoryDatabaseNode actual = first ;
        while (actual.next != null){
            actual = actual.next ;
        }
        return actual ;
    }

    public Item findByID(int ID){
        return null ;
    }

    public void remove(int ID){

    }

    public Item[] getArrayOfItems(){
        return null;
    }
}
