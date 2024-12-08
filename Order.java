import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Order {
    public void placeOrder(Tray tray) {
        int total = tray.getTotal();
        double vat = total * 0.12; // 12% VAT
        double finalPrice = total + vat;

        // Get current date and time
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // Receipt header
        System.out.println("\n");
        System.out.println("====================================");
        System.out.println("       Menu-DO Restaurant");
        System.out.println("     Serving Happiness Daily");
        System.out.println("====================================");
        System.out.println("Date: " + now.format(dateFormatter));
        System.out.println("Order No: " + (int) (Math.random() * 10000)); // Random Order No.
        System.out.println("------------------------------------");

        // Tray contents
        tray.displayTray();

        // Summary
        System.out.println("------------------------------------");
        System.out.printf("Subtotal:         ₱%.2f\n", (double) total);
        System.out.printf("VAT (12%%):        ₱%.2f\n", vat);
        System.out.printf("Total:            ₱%.2f\n", finalPrice);
        System.out.println("------------------------------------");
        System.out.println("    THANK YOU FOR YOUR ORDER!");
        System.out.println("        Have a great day!");
        System.out.println("====================================\n");

        tray.clearTray(); // Clear the tray after ordering
    }
}
