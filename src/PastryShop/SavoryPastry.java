package pastry.shop;

public class SavoryPastry extends Pastry {

    public SavoryPastry(String name, double price) {
        super(name, price);
    }

    @Override
    public void displayInfo() {
        System.out.println("Savory Pastry: " + name + " | Price: " + price);
    }
}