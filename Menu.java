import java.util.HashMap;
import java.util.Scanner;

public class Menu {
    private HashMap<Integer, String> menuItems;
    private HashMap<Integer, Integer> prices;

    public Menu() {
        menuItems = new HashMap<>();
        prices = new HashMap<>();
        // Populate default menu
        menuItems.put(1, "Mechado");
        menuItems.put(2, "Afritada");
        menuItems.put(3, "Menudo");
        menuItems.put(4, "Caldereta");
        menuItems.put(5, "Giniling");
        menuItems.put(6, "Sisig");
        menuItems.put(7, "Cola-Cola");
        menuItems.put(8, "Stripe");
        menuItems.put(9, "Fountain Due");
        menuItems.put(10, "Rice");
        prices.put(1, 50);
        prices.put(2, 45);
        prices.put(3, 40);
        prices.put(4, 60);
        prices.put(5, 50);
        prices.put(6, 90);
        prices.put(7, 25);
        prices.put(8, 25);
        prices.put(9, 25);
        prices.put(10, 15);
    }

    public void displayMenu() {
        ConsoleUtils.clearConsole();
        System.out.println("Welcome to Rice To Meet You");
        System.out.println("Today's Special Menu");
        System.out.println("-------------------------------------");
        
        menuItems.forEach((key, value) -> 
            System.out.printf(" %2d. %-20s $%d\n", key, value, prices.get(key))
        );
        
        System.out.println("-------------------------------------");
        System.out.println("💡 Tip: Enter the number to add an item to your tray!");
    }
    public String getItemName(int id) {
        return menuItems.getOrDefault(id, "Unknown Item");
    }

    public int getItemPrice(int id) {
        return prices.getOrDefault(id, 0);
    }

    public void addItem(Scanner scanner) {
        System.out.print("\nEnter item ID (unique number): ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume the newline
        if (menuItems.containsKey(id)) {
            System.out.println("Item ID already exists. Try again.");
            return;
        }
        System.out.print("Enter item name: ");
        String name = scanner.nextLine();
        System.out.print("Enter item price: ");
        int price = scanner.nextInt();
        menuItems.put(id, name);
        prices.put(id, price);
        System.out.println("Item added successfully!");
    }

    public void removeItem(Scanner scanner) {
        System.out.print("\nEnter item ID to remove: ");
        int id = scanner.nextInt();
        if (menuItems.containsKey(id)) {
            menuItems.remove(id);
            prices.remove(id);
            System.out.println("Item removed successfully!");
        } else {
            System.out.println("Item ID not found.");
        }
    }

    public void updateItem(Scanner scanner) {
        System.out.print("\nEnter item ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume the newline
        if (menuItems.containsKey(id)) {
            System.out.print("Enter new name (or press Enter to keep current name): ");
            String name = scanner.nextLine();
            if (!name.isEmpty()) {
                menuItems.put(id, name);
            }
            System.out.print("Enter new price (or 0 to keep current price): ");
            int price = scanner.nextInt();
            if (price > 0) {
                prices.put(id, price);
            }
            System.out.println("Item updated successfully!");
        } else {
            System.out.println("Item ID not found.");
        }
    }
}
