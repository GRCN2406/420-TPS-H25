package Item.Item;

public class ItemMilk extends Item{
    private double fat;
    private double liters;

    public ItemMilk(int ID, String name, double price, double fat, double liters){
        super(Category.Milk, ID, name, price);
        this.fat = fat ;
        this.liters = liters ;
    }

    public Category getCategory() {
        return category;
    }

    public String getCategoryString(){
        return null;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public double getLiters() {
        return liters;
    }

    public void setLiters(double liters) {
        this.liters = liters;
    }

    public String infoToString(){
        return null ;
    }

}
