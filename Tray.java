import java.util.ArrayList;
import java.util.Scanner;

public class Tray {
    private ArrayList<String> items;
    private ArrayList<Integer> prices;
    private int total;

    public Tray() {
        items = new ArrayList<>();
        prices = new ArrayList<>();
        total = 0;
    }

    public void addToTray(Menu menu) {
        System.out.print("\nEnter the item number to add to the tray (0 to stop): ");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int itemId = scanner.nextInt();
            if (itemId == 0) break;
            String itemName = menu.getItemName(itemId);
            int price = menu.getItemPrice(itemId);
            if (!itemName.equals("Unknown Item")) {
                items.add(itemName);
                prices.add(price);
                total += price;
                System.out.printf("%s added to the tray.\n", itemName);
            } else {
                System.out.println("Invalid item number. Try again.");
            }
        }
    }

    public void displayTray() {
        System.out.println("\nTray Contents:");
        for (int i = 0; i < items.size(); i++) {
            System.out.printf(" - %s    ₱%d\n", items.get(i), prices.get(i));
        }
        System.out.printf("\nTotal Price: ₱%d\n", total);
    }

    public int getTotal() {
        return total;
    }

    public void clearTray() {
        items.clear();
        prices.clear();
        total = 0;
    }
}
