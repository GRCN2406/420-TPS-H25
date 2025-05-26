package Item.Item;

import Item.Exceptions.ExceptionInsufficientQuantityInStock;

public abstract class Item {

    protected Category category ;
    protected int ID ;
    protected String name ;
    protected double price ;
    protected int quantityInStock ;

    public Item(Category category, int ID, String name, double price){
        this.category = category ;
        this.ID = ID ;
        this.name = name ;
        this.price = price ;
        this.quantityInStock = 0 ;
    }

    public abstract Category getCategory();

    public abstract String getCategoryString();

    public int getID(){
        return this.ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantity) throws ExceptionInsufficientQuantityInStock {
        if (quantity >= 0){
            this.quantityInStock = quantity;
        }else{
            throw new ExceptionInsufficientQuantityInStock(quantity);
        }
    }

    public void increaseQuantityInStock(int quantity) {
       setQuantityInStock(getQuantityInStock() + quantity);
    }

    public void decreaseQuantityInStock(int quantity) {
        setQuantityInStock(getQuantityInStock() - quantity);
    }

    public String infoToString(){
        return this.toString() ;
    }

    @Override
    public String toString() {
        return "Catégorie [" + getCategory() + "] ID [" + getID() + "] Nom [" + getName() + "] Prix [" + getPrice() + "]"  ;
    }
}

