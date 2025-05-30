package Item.Exceptions;
/**
 * Exception levée lorsqu'on tente d'accéder à un item inexistant dans l'inventaire.
 */
public class ExceptionItemNotFound extends RuntimeException {
    /**
     * Constructeur
     *
     * @param ID l'identifiant de l'item introuvable
     */
    public ExceptionItemNotFound(int ID) {
        super("Il n'existe pas d'item avec cet ID " + ID);
    }

    /**
     * Retourne le nom de la classe de l'exception.
     *
     * @return une chaîne représentant l'exception
     */
    @Override
    public String toString() {
        return "ExceptionItemNotFound";
    }
}
