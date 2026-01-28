package pastry.shop;

import java.sql.*;


import java.sql.*;
import java.util.ArrayList;

public class PastryShop {

    private ArrayList<Pastry> menu = new ArrayList<>();
    private Connection conn;

    public PastryShop() {
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:pastries.db");
            Statement stmt = conn.createStatement();

            stmt.execute(
                    "CREATE TABLE IF NOT EXISTS pastries (" +
                            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                            "name TEXT," +
                            "price REAL," +
                            "type TEXT)"
            );

            loadFromDB();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addPastry(Pastry p) {
        menu.add(p);
        saveToDB(p);
    }

    private void saveToDB(Pastry p) {
        try {
            String type = (p instanceof SweetPastry) ? "Sweet" : "Savory";

            PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO pastries (name, price, type) VALUES (?, ?, ?)"
            );

            ps.setString(1, p.getName());
            ps.setDouble(2, p.getPrice());
            ps.setString(3, type);

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadFromDB() {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM pastries");

            while (rs.next()) {
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                String type = rs.getString("type");

                if (type.equalsIgnoreCase("Sweet")) {
                    menu.add(new SweetPastry(name, price));
                } else {
                    menu.add(new SavoryPastry(name, price));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Pastry findPastry(String name) throws Exception {
        for (Pastry p : menu) {
            if (p.getName().equalsIgnoreCase(name)) {
                return p;
            }
        }
        throw new Exception("Pastry not found!");
    }

    public ArrayList<Pastry> getMenu() {
        return menu;
    }
}