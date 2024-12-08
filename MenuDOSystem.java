import java.util.Scanner;

public class MenuDOSystem {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Tray tray = new Tray();
        Order order = new Order();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nWelcome To Menu-DO");
            System.out.println("Enter [M] for Menu");
            System.out.println("Enter [T] to see Tray");
            System.out.println("Enter [E] to Exit");
            System.out.println("Enter [A] to Manage Menu (Add/Remove/Update)");
            System.out.print("Your choice: ");
            
            char choice = scanner.next().toUpperCase().charAt(0);
            switch (choice) {
                case 'M':
                    menu.displayMenu();
                    tray.addToTray(menu);
                    break;
                case 'T':
                    tray.displayTray();
                    System.out.print("\nInput [O] to Order, or [B] to go back: ");
                    char subChoice = scanner.next().toUpperCase().charAt(0);
                    if (subChoice == 'O') {
                        order.placeOrder(tray);
                        return; // End program after ordering
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
