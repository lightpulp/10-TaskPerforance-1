### **README: Menu-DO System**

---

## **Description**
Menu-DO is a Java-based console application for restaurant menu management and order processing. Users can view a menu, add items to a tray, and generate a receipt with VAT.

---

## **Features**
- View and manage a menu.
- Add items to a tray and calculate the total.
- Generate a receipt with VAT.

---

## **How to Use**
1. Run the program:
   ```bash
   javac MenuDOSystem.java
   java MenuDOSystem
   ```
2. Main Options:
   - `[M]`: View menu and add items to the tray.
   - `[T]`: View tray and place an order.
   - `[A]`: Add, update, or remove menu items (Admin).
   - `[E]`: Exit the program.

---

## **Classes Used**
1. **Menu**: Handles menu items using `HashMap`.
2. **Tray**: Manages tray contents using `ArrayList`.
3. **Order**: Processes orders and generates receipts.
4. **MenuDOSystem**: Main class for program flow.

---

## **Requirements**
- Java JDK installed on your system.