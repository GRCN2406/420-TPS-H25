package Inventaire;
import Item.*;

/**
 * Gère les opérations principales sur l'inventaire, telles que l'ajout,
 * la suppression et la modification des quantités d'articles.
 */
public class InventoryManager {
    private InventoryDatabase inventoryDatabase;

    /**
     * Construit un gestionnaire d'inventaire vide.
     */
    public InventoryManager(){
        inventoryDatabase = new InventoryDatabase();
    }

    /**
     * Ajoute un nouvel article de type pain à l'inventaire.
     *
     * @param ID identifiant de l'article
     * @param name nom du pain
     * @param price prix du pain
     * @param color couleur du pain
     * @param weight poids du pain
     */
    public void addNewBreadItem(int ID, String name, double price, String color, int weight){
        Item item = new ItemBread(ID, name,price,color,weight);
        inventoryDatabase.insert(item);
    }

    /**
     * Ajoute un nouvel article de type œufs à l'inventaire.
     *
     * @param ID identifiant de l'article
     * @param name nom des œufs
     * @param price prix
     * @param color couleur
     * @param number nombre d'œufs
     */
    public void addNewEggsItem(int ID, String name, double price, String color, int number){
        Item item = new ItemEggs(ID, name,price,color,number);
        inventoryDatabase.insert(item);
    }

    /**
     * Ajoute un nouvel article de type lait à l'inventaire.
     *
     * @param ID identifiant
     * @param name nom
     * @param price prix
     * @param fat pourcentage de gras
     * @param liters quantité en litres
     */
    public void addNewMilkItem(int ID, String name, double price, double fat, double liters){
        Item item = new ItemMilk(ID, name,price,fat,liters);
        inventoryDatabase.insert(item);
    }

    /**
     * Supprime un article de l'inventaire par son ID.
     *
     * @param ID identifiant de l'article à supprimer
     */
    public void removeItem(int ID){
            inventoryDatabase.remove(ID);
    }

    /**
     * Augmente la quantité en stock d'un article.
     *
     * @param ID identifiant de l'article
     * @param quantity quantité à ajouter
     */
    public void increaseItemQuantity(int ID, int quantity){
        Item item = inventoryDatabase.findByID(ID) ;
        item.increaseQuantityInStock(quantity);
    }

    /**
     * Diminue la quantité en stock d'un article.
     *
     * @param ID identifiant de l'article
     * @param quantity quantité à retirer
     */
    public void decreaseItemQuantity(int ID, int quantity){
        Item item = inventoryDatabase.findByID(ID) ;
        item.decreaseQuantityInStock(quantity);
    }

    /**
     * Retourne un article spécifique par son ID.
     *
     * @param ID identifiant de l'article
     * @return l'article correspondant
     */
    public Item getItem(int ID){
        return inventoryDatabase.findByID(ID) ;
    }

    /**
     * Retourne un tableau de tous les articles dans l'inventaire.
     *
     * @return tableau des articles
     */
    public Item[] getArrayOfItems(){
        return inventoryDatabase.getArrayOfItems() ;
    }

}
