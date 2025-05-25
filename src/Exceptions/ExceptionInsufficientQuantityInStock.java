package Item.Exceptions;

public class ExceptionInsufficientQuantityInStock extends RuntimeException {
    public ExceptionInsufficientQuantityInStock(int quantity) {
        super("La quantité en stock est insuffisante. \n Déficit : " + quantity);
    }

    @Override
    public String toString() {
        return "ExceptionInsufficientQuantityInStock";
    }
}
