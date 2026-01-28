package pastry.shop; 
 
public class Main { 
 
    public static void main(String[] args) { 
 
        PastryShop shop = new PastryShop(); 
 
        // إضافة أصناف 
        shop.addPastry(new SweetPastry("Donut", 2.5)); 
        shop.addPastry(new SavoryPastry("Cheese Croissant", 3.0)); 
        shop.addPastry(new SweetPastry("Chocolate Cake", 5.0)); 
 
        // عرض كل الأصناف 
        System.out.println("=== All Pastries ==="); 
        for (Pastry p : shop.getMenu()) { 
            p.displayInfo(); 
        } 
 
        // البحث عن صنف 
        try { 
            Pastry found = shop.searchPastry("Donut"); 
            System.out.println("\nFound:"); 
            found.displayInfo(); 
        } catch (Exception e) { 
            System.out.println(e.getMessage()); 
        } 
    } 
}
