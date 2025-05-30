package Item.Exceptions;

/**
 * Exception levée lorsqu'on tente d'ajouter un item avec un identifiant déjà existant.
 */
public class ExceptionItemAlreadyExists extends RuntimeException {
    /**
     * Constructeur
     * @param ID l'identifiant de l'item existant
     */
    public ExceptionItemAlreadyExists(int ID)
    {
        super("L'item avec le ID : " + ID + " est déjà présent en magasin");
    }

    /**
     * Retourne le nom de l'exception
     *
     * @return une chaîne représentant l'exception
     */
    @Override
    public String toString() {
        return "ExceptionItemAlreadyExists";
    }
}
