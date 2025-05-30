package Item.Inventaire;

import Item.Exceptions.ExceptionItemAlreadyExists;
import Item.Exceptions.ExceptionItemNotFound;
import Item.Item.Item;

/**
 * Gère la base de données des articles sous forme de liste chaînée.
 */
public class InventoryDatabase {
    private int itemsCount ;
    private InventoryDatabaseNode first ;

    /**
     * Constructeur
     * Initialise une base de données vide.
     */
    public InventoryDatabase(){
        first = null ;
        itemsCount = 0 ;
    }

    /**
     * Insère un nouvel article dans la base.
     *
     * @param item l'article à ajouter
     * @throws ExceptionItemAlreadyExists si un article avec le même ID existe déjà
     */
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

    /**
     * Recherche un article par son identifiant.
     *
     * @param ID identifiant de l'article
     * @return l'article correspondant
     * @throws ExceptionItemNotFound si l'article n'existe pas
     */
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

    /**
     * Supprime un article de la base par son ID.
     *
     * @param ID identifiant de l'article à supprimer
     * @throws ExceptionItemNotFound si l'article n'existe pas
     */
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

    /**
     * Retourne un tableau contenant tous les articles dans la base.
     *
     * @return tableau d'articles
     */
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
