package Item.Exceptions;

public class ExceptionItemNotFound extends RuntimeException {
    public ExceptionItemNotFound(int ID) {
        super("Aucun item ne correspond à cet ID");
        System.out.println("Il n'existe pas d'item avec cet ID " + ID);
    }

    @Override
    public String toString() {
        return "ExceptionItemNotFound";
    }
}
