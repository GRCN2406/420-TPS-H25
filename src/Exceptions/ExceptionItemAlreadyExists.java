package Item.Exceptions;

public class ExceptionItemAlreadyExists extends RuntimeException {
    public ExceptionItemAlreadyExists(int ID)
    {
        super("L'item avec le ID : " + ID + " est déjà présent en magasin");
    }

    @Override
    public String toString() {
        return "ExceptionItemAlreadyExists";
    }
}
