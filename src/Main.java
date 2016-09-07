import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by jeremypitt on 9/6/16.
 */
public class Main {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<InventoryItem> items = new ArrayList<>();

    public static void main(String[] args) {


        while (true) {
            int i = 1;
            System.out.println("Item List:");
            for (InventoryItem item : items) {
                System.out.printf("%s. [%s] %s, %s \n", i, item.category, item.name, item.quantity);
                i++;
            }
            System.out.println("---");
            System.out.println("1. Enter a new item.");
            System.out.println("2. Remove an item.");
            System.out.println("3. Update an item's quantity.");

            String option = scanner.nextLine();
            InventoryItem item = null;

            switch (option) {
                case "1":
                    item = createItem();
                    items.add(item);
                    break;
                case "2":
                    removeItem();
                    break;
                case "3":
                    updateItem();
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    public static void newItem() {
        InventoryItem item = null;
        String foodName = scanner.nextLine();
        InventoryItem foodItem = new InventoryItem();
        Food food = new Food(foodName, 0);
        item = food;
        items.add(item);
    }

    public static void removeItem() {
        System.out.println("Enter the number of the item you wish to remove:");
        String removeChoice = scanner.nextLine();
        int itemNum = Integer.parseInt(removeChoice);
        items.remove(itemNum - 1);

    }

    public static void updateItem() {
        System.out.println("Enter the number of the item you wish to update:");
        int itemNum = Integer.valueOf(scanner.nextLine());

        InventoryItem item = items.get(itemNum - 1);
        System.out.println("Enter the quantity of the item:");
        int itemQuantity = Integer.valueOf(scanner.nextLine());
        item.quantity = itemQuantity;

    }

    public static boolean catValidation(String s){
        boolean b = true;
        for (InventoryItem item: items){
            if (s.equalsIgnoreCase(item.getCategory())){
                b = false;
            }
        }
        return b;
    }
    public static InventoryItem createItem() {
        InventoryItem item = null;
        boolean isInvalidCat = true;
        String catChoice="";
        while (isInvalidCat) {
            System.out.println("Enter the category of the item you wish to add: [Car/Electronics/Equipment/Food/Furniture]");
            catChoice = scanner.nextLine();
            if(catChoice.equalsIgnoreCase("Food")|| catChoice.equalsIgnoreCase("Car") || catChoice.equalsIgnoreCase("Furniture")
                    ||catChoice.equalsIgnoreCase("Equipment")||catChoice.equalsIgnoreCase("Electronics")) {
                isInvalidCat = false;
            } else{
                System.out.println("Invalid category.");
            }
        }
        System.out.println("Enter the name of the item:");
        String itemName = scanner.nextLine();




        switch (catChoice) {
            case "Food":
                item = new Food(itemName, 0);
                break;
            case "Car":
                item = new Car(itemName, 0);
                break;
            case "Electronics":
                item = new Electronics(itemName, 0);
                break;
            case "Equipment":
                item = new Equipment(itemName, 0);
                break;
            case "Furniture":
                item = new Furniture(itemName, 0);
                break;
            default:
                System.out.printf("Error - Invalid category: %s", catChoice);
        }
        return item;
    }


}
