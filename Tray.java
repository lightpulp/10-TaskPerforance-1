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
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("\nEnter the item number to add to the tray (0 to stop): ");
            
            // Check if the user entered a valid integer
            if (scanner.hasNextInt()) {
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
            } else {
                // If the input is not an integer, print an error and consume the invalid input
                System.out.println("Invalid input. Please enter a valid item number.");
                scanner.next(); // Consume the invalid input
            }
        }
    }    

    public void displayTray() {
        ConsoleUtils.clearConsole();
        System.out.println("\nTray Contents:");
        if (items.isEmpty()) {
            System.out.println("Tray is empty!");
        } else {
            for (int i = 0; i < items.size(); i++) {
                System.out.printf(" - %s    $%d\n", items.get(i), prices.get(i));
            }
            System.out.printf("\nTotal Price: $%d\n", total);
        }
    }

    public int getTotal() {
        return total;
    }

    public void clearTray() {
        items.clear();
        prices.clear();
        total = 0;
        System.out.println("Tray has been cleared.");
    }

    public void removeLatestItem() {
        if (!items.isEmpty()) {
            String removedItem = items.remove(items.size() - 1);
            int removedPrice = prices.remove(prices.size() - 1);
            total -= removedPrice;
            System.out.printf("Removed the latest item: %s ($%d).\n", removedItem, removedPrice);
        } else {
            System.out.println("Tray is already empty, no items to remove.");
        }
    }
}
