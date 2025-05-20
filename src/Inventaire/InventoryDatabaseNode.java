package Item.Inventaire;

import Item.Item.Item;

public class InventoryDatabaseNode {
    private Item item ;
    public InventoryDatabaseNode next ;

    public InventoryDatabaseNode(Item item){
        this.item = item ;
        this.next = null ;
    }

    public Item getItem(){
        return item ;
    }
}
