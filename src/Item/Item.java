package Item.Item;

public abstract class Item {

    private Category category ;
    private int ID ;
    private String name ;
    private double price ;
    private int quantityInStock ;

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

    public void setQuantityInStock(int quantity) {
        this.quantityInStock = quantity;
    }

    public void increaseQuantityInStock(int quantity) {
        this.quantityInStock += quantity;
    }

    public void decreaseQuantityInStock(int quantity) {
        this.quantityInStock -= quantity;
    }

    public String infoToString(){
        return null ;
    }

    @Override
    public String toString() {
        return "Item{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantityInStock=" + quantityInStock +
                '}';
    }
}

