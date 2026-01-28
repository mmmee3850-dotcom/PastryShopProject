package pastry.shop;

public class Pastry {

    protected String name;
    protected double price;

    public Pastry(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void displayInfo() {
        System.out.println("Pastry: " + name + " | Price: " + price);
    }
}