package Item.Item;

public class ItemBread extends Item{
    private String color;
    private double weight;

    public ItemBread(int ID, String name, double price, String color, int weight){
        super(Category.Bread, ID, name, price);
        this.color = color ;
        this.weight = weight ;
    }

    @Override
    public Category getCategory() {
        return category;
    }

    public String getCategoryString(){
        return "[" + getCategory() + "]";
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String infoToString(){
        return this + " Couleur [" + getColor() + "] Poids [" + getWeight() + "]"  ;
    }
}
