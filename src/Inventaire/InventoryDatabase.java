package Item.Inventaire;

import Item.Exceptions.ExceptionItemAlreadyExists;
import Item.Exceptions.ExceptionItemNotFound;
import Item.Item.Item;


public class InventoryDatabase {
    private int itemsCount ;
    private InventoryDatabaseNode first ;

    public InventoryDatabase(){
        first = null ;
        itemsCount = 0 ;
    }

    public void insert(Item item) throws ExceptionItemAlreadyExists{
        try{
            findByID(item.getID());
            throw new ExceptionItemAlreadyExists(item.getID());
        }catch (ExceptionItemNotFound e){
            InventoryDatabaseNode newItem = new InventoryDatabaseNode(item) ;
            newItem.next = first ;
            first = newItem ;
            itemsCount++ ;
        }
    }
    public Item findByID(int ID) throws ExceptionItemNotFound {
        InventoryDatabaseNode actual = first ;
        while (actual != null){
            if (actual.getItem().getID() == ID){
                return actual.getItem() ;
            }
            actual = actual.next ;
        }
       throw new ExceptionItemNotFound(ID)  ;
    }


    public void remove(int ID) throws ExceptionItemNotFound{
        InventoryDatabaseNode actual ;

        if (first == null){
            return;
        }

        if (first.getItem().getID() == ID){
            first = first.next ;
            itemsCount-- ;
            return;
        }

        actual = first ;
        while (actual.next != null){
            if (actual.next.getItem().getID() == ID){
                actual.next = actual.next.next ;
                itemsCount-- ;
                return;
            }
            actual = actual.next ;
        }

        throw new ExceptionItemNotFound(ID);

    }

    public Item[] getArrayOfItems(){
        Item[] itemsArray = new Item[itemsCount] ;
        InventoryDatabaseNode actual = first ;
        int index = 0 ;
        while (actual != null && index < itemsCount){
            itemsArray[index] = actual.getItem() ;
            actual = actual.next ;
            index++ ;
        }
        return itemsArray;
    }
}
