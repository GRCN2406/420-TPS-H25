package Item.Exceptions;

public class ExceptionItemAlreadyExists extends RuntimeException {
    public ExceptionItemAlreadyExists(int ID)
    {
        super("Cet item exixte déjà");
        System.out.println("L'item avec le ID : " + ID + " est déjà présent en magasin");
    }

    @Override
    public String toString() {
        return "ExceptionItemAlreadyExists";
    }
}
