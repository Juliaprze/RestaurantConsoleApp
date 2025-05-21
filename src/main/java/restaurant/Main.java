package restaurant;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RestaurantManager manager = new RestaurantManager();

        while (true) {
            System.out.println("\n--- Restaurant Manager ---");
            System.out.println("1. Add a restaurant");
            System.out.println("2. Add a dish to a restaurant");
            System.out.println("3. Show all restaurants");
            System.out.println("4. Show restaurant menu");
            System.out.println("5. Place an order");
            System.out.println("Type 'exit' to quit the program");
            System.out.print("Choose an option: ");


            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("exit")) break;

            switch (choice) {
                case "1" -> manager.addRestaurant(scanner);
                case "2" -> manager.addMealToRestaurant(scanner);
                case "3" -> manager.showRestaurants();
                case "4" -> manager.showMealsInRestaurant(scanner);
                case "5" -> manager.placeOrder(scanner);
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
        System.out.println("Program has ended.");
    }
}
