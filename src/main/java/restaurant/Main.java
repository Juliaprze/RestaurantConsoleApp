package restaurant;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RestaurantManager manager = new RestaurantManager();

        while (true) {
            System.out.println("\n--- Restaurant Manager ---");
            System.out.println("1. Dodaj restaurację");
            System.out.println("2. Dodaj danie do restauracji");
            System.out.println("3. Pokaż wszystkie restauracje");
            System.out.println("4. Pokaż menu restauracji");
            System.out.println("5. Złóż zamówienie");
            System.out.println("Wpisz 'exit', aby zakończyć program");
            System.out.print("Wybierz opcję: ");

            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("exit")) break;

            switch (choice) {
                case "1" -> manager.addRestaurant(scanner);
                case "2" -> manager.addMealToRestaurant(scanner);
                case "3" -> manager.showRestaurants();
                case "4" -> manager.showMealsInRestaurant(scanner);
                case "5" -> manager.placeOrder(scanner);
                default -> System.out.println("Niepoprawny wybór. Spróbuj ponownie.");
            }
        }

        scanner.close();
        System.out.println("Zakończono program.");
    }
}
