package Item.Item;

public class ItemEggs extends Item {
    private String color;
    private int number ;

    public ItemEggs(int ID, String name, double price, String color, int weight){
        super(Category.Eggs, ID, name,price);
        this.color = color;
        this.number = number;
    }

    public Category getCategory() {
        return category;
    }

    public String getCategoryString(){
        return null;
    }


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String infoToString(){
        return null ;
    }
}
