package restaurant;

public class Meal {
    private String name;
    private double price;

    public Meal(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() { return price; }

    @Override
    public String toString() {
        return name + " - " + price + " PLN";
    }
}
