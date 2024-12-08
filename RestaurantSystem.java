import java.util.Scanner;

public class RestaurantSystem {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Tray tray = new Tray();
        Order order = new Order();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            ConsoleUtils.clearConsole();
            System.out.println("\n=====================================");
            System.out.println("          Rice To Meet You ");
            System.out.println("=====================================");
            System.out.println("\nWelcome! Please choose an option to get started:");
            
            System.out.println("\n Enter [M] to see the Menu");
            System.out.println(" Enter [T] to view your Tray");
            System.out.println(" Enter [E] to Exit");
            System.out.println("");
            
            System.out.println("Enter [A] to Manage the Menu (Add/Remove/Update Dish)");
            System.out.println("=====================================");
            
            System.out.print("Your choice: ");
            
            char choice = scanner.next().toUpperCase().charAt(0);
            switch (choice) {
                case 'M':
                    menu.displayMenu();
                    tray.addToTray(menu);
                    break;
                    case 'T':
                    tray.displayTray();
                    System.out.print("\nInput [O] to Order, [C] to Clear Tray, [R] to Remove Latest Item, or [B] to go back: ");
                    char subChoice = scanner.next().toUpperCase().charAt(0);
                    switch (subChoice) {
                        case 'O':
                            order.placeOrder(tray);
                            return; // End program after ordering
                        case 'C':
                            tray.clearTray();
                            break;
                        case 'R':
                            tray.removeLatestItem();
                            break;
                        case 'B':
                            break;
                        default:
                            System.out.println("Invalid choice. Returning to tray menu.");
                    }
                    break;
                case 'A':
                    System.out.println("\nManage Menu");
                    System.out.println("Enter [1] to Add Item");
                    System.out.println("Enter [2] to Remove Item");
                    System.out.println("Enter [3] to Update Item");
                    System.out.print("Your choice: ");
                    int adminChoice = scanner.nextInt();
                    switch (adminChoice) {
                        case 1:
                            menu.addItem(scanner);
                            break;
                        case 2:
                            menu.removeItem(scanner);
                            break;
                        case 3:
                            menu.updateItem(scanner);
                            break;
                        default:
                            System.out.println("Invalid choice. Returning to main menu.");
                    }
                    break;
                case 'E':
                    System.out.println("Thank you for using Menu-DO!");
                    return; // Exit the loop
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
