package Package1;

public class Item {
    private String name;
    private double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public static Item createItem(String name, double price){
        return new Item(name, price);
    }



    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
