package Item.Inventaire;

import Item.Item.Item;

public class InventoryDatabase {
    private int itemsCount ;
    private InventoryDatabaseNode first ;

    public InventoryDatabase(){
        first = null ;
        itemsCount = 0 ;
    }

    public void insert(Item item){
        InventoryDatabaseNode newItem = new InventoryDatabaseNode(item) ;
        newItem.next = first ;
        first = newItem ;
        itemsCount++ ;
    }

    public Item findByID(int ID){
        InventoryDatabaseNode actual = first ;
        while (actual.next != null){
            if (actual.getItem().getID() == ID){
                 return actual.getItem() ;
            }
            actual = actual.next ;
        }
        return null ;
    }


    public void remove(int ID){
        boolean removed = false ;
        InventoryDatabaseNode actual = first ;
        while (actual.next != null && !removed){
            if (actual.next.getItem().getID() == ID){
                actual.next = actual.next.next ;
                itemsCount-- ;
                removed = true ;
            }
            actual = actual.next ;
        }
    }

    public Item[] getArrayOfItems(){
        Item[] itemsArray = new Item[itemsCount] ;
        InventoryDatabaseNode actual = first ;
        int index = 0 ;
        while (actual.next != null){
            itemsArray[index] = actual.getItem() ;
            index++ ;
        }
        return itemsArray;
    }
}
