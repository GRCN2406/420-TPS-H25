package Item;

import Exceptions.ExceptionInsufficientQuantityInStock;
/**
 * Classe abstraite représentant un article Item avec une catégorie,
 * un identifiant, un nom, un prix et une quantité en stock.
 * Elle sert de base pour différents types d'articles.
 *
 * @author Graciela Ruth Carole Nouga
 * @version mai 2025
 */

public abstract class Item {

    protected Category category ;
    protected int ID ;
    protected String name ;
    protected double price ;
    protected int quantityInStock ;

    /**
     * Constructeur de la classe Item.
     *
     * @param category Catégorie de l'article
     * @param ID Identifiant de l'article
     * @param name Nom de l'article
     * @param price Prix de l'article
     */

    public Item(Category category, int ID, String name, double price){
        this.category = category ;
        this.ID = ID ;
        this.name = name ;
        this.price = price ;
        this.quantityInStock = 0 ;
    }

    /**
     * Retourne la catégorie de l'article.
     *
     * @return la catégorie de l'article
     */
    public abstract Category getCategory();
    /**
     * Retourne la catégorie sous forme de chaîne de caractères.
     *
     * @return la catégorie sous forme de chaîne
     */
    public abstract String getCategoryString();

    /**
     * Retourne l'identifiant de l'article.
     *
     * @return l'ID
     */
    public int getID(){
        return this.ID;
    }

    /**
     * Modifie l'identifiant de l'article.
     *
     * @param ID le nouvel identifiant
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * Retourne le nom de l'article.
     *
     * @return le nom
     */
    public String getName() {
        return name;
    }

    /**
     * Modifie le nom de l'article.
     *
     * @param name le nouveau nom
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retourne le prix de l'article.
     *
     * @return le prix
     */
    public double getPrice() {
        return price;
    }

    /**
     * Modifie le prix de l'article.
     *
     * @param price le nouveau prix
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Retourne la quantité en stock.
     *
     * @return la quantité en stock
     */
    public int getQuantityInStock() {
        return quantityInStock;
    }

    /**
     * Modifie la quantité en stock.
     *
     * @param quantity la nouvelle quantité
     * @throws ExceptionInsufficientQuantityInStock si la quantité est négative
     */
    public void setQuantityInStock(int quantity) throws ExceptionInsufficientQuantityInStock {
        if (quantity >= 0){
            this.quantityInStock = quantity;
        }else{
            throw new ExceptionInsufficientQuantityInStock(quantity);
        }
    }

    /**
     * Augmente la quantité en stock d'une certaine valeur.
     *
     * @param quantity la quantité à ajouter
     */
    public void increaseQuantityInStock(int quantity) {
       setQuantityInStock(getQuantityInStock() + quantity);
    }

    /**
     * Diminue la quantité en stock d'une certaine valeur.
     *
     * @param quantity la quantité à soustraire
     */
    public void decreaseQuantityInStock(int quantity) {
        setQuantityInStock(getQuantityInStock() - quantity);
    }

    /**
     * Retourne les informations de l'article sous forme de chaîne.
     *
     * @return les informations de l'article
     */
    public String infoToString(){
        return this.toString() ;
    }

    /**
     * Retourne une représentation textuelle de l'article.
     *
     * @return chaîne représentant l'article
     */
    @Override
    public String toString() {
        return "Catégorie [" + getCategory() + "] ID [" + getID() + "] Nom [" + getName() + "] Prix [" + getPrice() + "]"  ;
    }
}

