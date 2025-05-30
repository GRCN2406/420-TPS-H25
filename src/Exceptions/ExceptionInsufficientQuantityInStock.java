package Item.Exceptions;

/**
 * Exception levée lorsqu'une opération tente de retirer une quantité
 * supérieure à celle disponible en stock.
 */
public class ExceptionInsufficientQuantityInStock extends RuntimeException {
    /**
     * Constructeur
     *
     * @param quantity la quantité manquante en stock
     */
    public ExceptionInsufficientQuantityInStock(int quantity) {
        super("La quantité en stock est insuffisante. \n Déficit : " + quantity);
    }

    /**
     * Retourne le nom de l'exception.
     *
     * @return une chaîne représentant l'exception
     */
    @Override
    public String toString() {
        return "ExceptionInsufficientQuantityInStock";
    }
}
