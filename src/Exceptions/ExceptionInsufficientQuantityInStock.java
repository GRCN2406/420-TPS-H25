package Item.Exceptions;

public class ExceptionInsufficientQuantityInStock extends RuntimeException {
    public ExceptionInsufficientQuantityInStock(int quantity) {
        super("La quantité en stock est insuffisante");
        System.out.println("La quantité en stock est inférieure à celle demandée : " + quantity);
    }

    @Override
    public String toString() {
        return "ExceptionInsufficientQuantityInStock";
    }
}
