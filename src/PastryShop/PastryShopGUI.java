package pastry.shop;

import javax.swing.*;

public class PastryShopGUI {

    private PastryShop shop = new PastryShop();

    public PastryShopGUI() {

        JFrame frame = new JFrame("Pastry Shop");
        frame.setSize(550, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Name
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(20, 20, 80, 25);
        frame.add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(100, 20, 200, 25);
        frame.add(nameField);

        // Price
        JLabel priceLabel = new JLabel("Price:");
        priceLabel.setBounds(20, 60, 80, 25);
        frame.add(priceLabel);

        JTextField priceField = new JTextField();
        priceField.setBounds(100, 60, 200, 25);
        frame.add(priceField);

        // Buttons
        JButton addSweet = new JButton("Add Sweet");
        addSweet.setBounds(20, 100, 140, 30);
        frame.add(addSweet);

        JButton addSavory = new JButton("Add Savory");
        addSavory.setBounds(180, 100, 140, 30);
        frame.add(addSavory);

        // Output area
        JTextArea output = new JTextArea();
        output.setBounds(20, 150, 480, 240);
        output.setEditable(false);
        frame.add(output);

        // Add Sweet Action
        addSweet.addActionListener(e -> {
            try {
                String name = nameField.getText();
                double price = Double.parseDouble(priceField.getText());

                shop.addPastry(new SweetPastry(name, price));
                output.setText("Sweet pastry added successfully!");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Invalid input");
            }
        });

        // Add Savory Action
        addSavory.addActionListener(e -> {
            try {
                String name = nameField.getText();
                double price = Double.parseDouble(priceField.getText());

                shop.addPastry(new SavoryPastry(name, price));
                output.setText("Savory pastry added successfully!");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Invalid input");
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new PastryShopGUI();
    }
}
