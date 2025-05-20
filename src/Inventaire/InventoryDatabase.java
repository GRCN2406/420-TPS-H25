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
        boolean find = false ;
        while (actual.next != null && !find){
            if (actual.getItem().getID() == ID){
                find = true ;
            }else{
                actual = actual.next ;
            }
        }
        return actual.getItem() ;
    }


    public void remove(int ID){
        boolean removed = false ;
        InventoryDatabaseNode actual ;
        /*if (findByID(ID).getID() == first.getItem().getID()){
            first = first.next ;
        } else if (findByID(ID).getID() == getBeforeLast().next.getItem().getID()) {
            getBeforeLast().next = null ;
        }else {*/
            actual = first ;
            while (actual.next.next != null && !removed){
                if (actual.next.getItem().getID() == ID){
                    actual.next = actual.next.next ;
                    removed = true ;
                }
                actual = actual.next ;
            }
       // }
        itemsCount-- ;
    }

    private InventoryDatabaseNode getBeforeLast(){
        InventoryDatabaseNode actual = first ;
        while (actual.next.next != null){
            actual = actual.next ;
        }
        return actual ;
    }

    public Item[] getArrayOfItems(){
        System.out.println("nbItems " + itemsCount);
        Item[] itemsArray = new Item[itemsCount] ;
        InventoryDatabaseNode actual = first ;
        int index = 0 ;
        while (actual.next != null){
            System.out.println(" index " + index);
            itemsArray[index] = actual.getItem() ;
            actual = actual.next ;
            index++ ;
        }
        return itemsArray;
    }
}
