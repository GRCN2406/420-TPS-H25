package Inventaire;
import Item.*;

/**
 * Représente un élément(noeud) dans la base de données de l'inventaire(liste chaînée).
 * Chaque nœud contient un article {@code Item} et une référence vers le nœud suivant.
 */
public class InventoryDatabaseNode {
    private Item item ;
    /** Le prochain nœud de la liste chaînée. */
    public InventoryDatabaseNode next ;

    /**
     * Constructeur
     *
     * @param item l'article à stocker dans ce nœud
     */
    public InventoryDatabaseNode(Item item){
        this.item = item ;
        this.next = null ;
    }

    /**
     * Retourne l'article contenu dans ce nœud.
     *
     * @return l'article {@code Item}
     */
    public Item getItem(){
        return item ;
    }
}
