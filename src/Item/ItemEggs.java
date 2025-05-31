package Item;

/**
 * Représente un article de type œufs avec des propriétés spécifiques
 * comme la couleur et le nombre d'œufs.
 * Hérite de la classe {@code Item}.
 *
 * @author GRCN
 * @version mai 2025
 */
public class ItemEggs extends Item {
    private String color;
    private int number ;

    /**
     * Constructeur de l'article œufs.
     *
     * @param ID Identifiant de l'article
     * @param name Nom de l'article
     * @param price Prix de l'article
     * @param color Couleur des œufs
     * @param number Nombre d'œufs (erreur dans le paramètre, voir remarque ci-dessous)
     */
    public ItemEggs(int ID, String name, double price, String color, int number){
        super(Category.Eggs, ID, name,price);
        this.color = color;
        this.number = number;
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
        return "[" + getCategory() + "]";
    }

    /**
     * Retourne le nombre d'œufs.
     *
     * @return le nombre d'œufs
     */
    public int getNumber() {
        return number;
    }

    /**
     * Modifie le nombre d'œufs.
     *
     * @param number nouveau nombre
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * Retourne la couleur des œufs.
     *
     * @return la couleur
     */
    public String getColor() {
        return color;
    }

    /**
     * Modifie la couleur des oeufs
     *
     * @param color couleur de modifiction
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Retourne les informations des œufs sous forme de chaîne.
     *
     * @return informations complètes des œufs
     */
    public String infoToString(){
        return super.infoToString() + " Couleur [" + getColor() + "] Nombre [" + getNumber() + "]"  ;
    }
}
