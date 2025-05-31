package Item;

/**
 * Représente un article de type lait avec un pourcentage de matières grasses
 * et un volume en litres. Hérite de la classe {@code Item}.
 *
 * @author GRCN
 * @version mai 2025
 */
public class ItemMilk extends Item{
    private double fat;
    private double liters;

    /**
     * Constructeur de l'article lait.
     *
     * @param ID Identifiant de l'article
     * @param name Nom du produit
     * @param price Prix
     * @param fat Pourcentage de matières grasses
     * @param liters Quantité en litres
     */
    public ItemMilk(int ID, String name, double price, double fat, double liters){
        super(Category.Milk, ID, name, price);
        this.fat = fat ;
        this.liters = liters ;
    }

    /**
     * {@inheritDoc}
     */
    public Category getCategory() {
        return category;
    }

    /**
     * {@inheritDoc}
     */
    public String getCategoryString(){
        return null;
    }

    /**
     * Retourne le pourcentage de matières grasses.
     *
     * @return pourcentage de matières grasses
     */
    public double getFat() {
        return fat;
    }

    /**
     * Modifie le pourcentage de matières grasses.
     *
     * @param fat nouveau pourcentage
     */
    public void setFat(double fat) {
        this.fat = fat;
    }

    /**
     * Retourne la quantité de lait en litres.
     *
     * @return quantité en litres
     */
    public double getLiters() {
        return liters;
    }

    /**
     * Modifie la quantité de lait en litres.
     *
     * @param liters nouvelle quantité
     */
    public void setLiters(double liters) {
        this.liters = liters;
    }

    /**
     * Retourne les informations du lait sous forme de chaîne.
     *
     * @return informations complètes du lait
     */
    public String infoToString(){
        return this + " Gras [" + getFat() + "] Litres [" + getLiters() + "]"  ;
    }

}
