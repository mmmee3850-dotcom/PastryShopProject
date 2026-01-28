package pastry.shop;

public class SweetPastry extends Pastry {

    public SweetPastry(String name, double price) {
        super(name, price);
    }

    @Override
    public void displayInfo() {
        System.out.println("Sweet Pastry: " + name + " | Price: " + price);
    }
}