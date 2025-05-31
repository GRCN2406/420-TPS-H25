package Item;

/**
 * Représente un article de type pain avec des propriétés spécifiques
 * comme la couleur et le poids.
 * Hérite de la classe abstraite {@code Item} .
 *
 * @author GRCN
 * @version mai 2025
 */

public class ItemBread extends Item{
    private String color;
    private double weight;

    /**
     * Constructeur de l'article pain.
     *
     * @param ID Identifiant de l'article
     * @param name Nom du pain
     * @param price Prix du pain
     * @param color Couleur du pain
     * @param weight Poids du pain en grammes
     */
    public ItemBread(int ID, String name, double price, String color, int weight){
        super(Category.Bread, ID, name, price);
        this.color = color ;
        this.weight = weight ;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Category getCategory() {
        return category;
    }

    /**
     * {@inheritDoc}
     */
    public String getCategoryString(){
        return "[" + getCategory() + "]";
    }

    /**
     * Retourne la couleur du pain.
     *
     * @return la couleur
     */
    public String getColor() {
        return color;
    }

    /**
     * Modifie la couleur du pain.
     *
     * @param color nouvelle couleur
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Retourne le poids du pain.
     *
     * @return poids
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Modifie le poids du pain.
     *
     * @param weight nouveau poids
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Retourne les informations du pain sous forme de chaîne.
     *
     * @return informations complètes du pain
     */
    public String infoToString(){
        return this + " Couleur [" + getColor() + "] Poids [" + getWeight() + "]"  ;
    }
}
