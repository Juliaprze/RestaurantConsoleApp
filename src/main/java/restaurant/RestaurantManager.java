package restaurant;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class RestaurantManager {
    private List<Restaurant> restaurants = new ArrayList<>();

    public RestaurantManager() {
        initializeData();
    }

    private void initializeData() {
        Restaurant kebab = new Restaurant("Kebab u Grubego", "Warszawska 11, Kraków 31-222");
        kebab.addMeal("Doner Kebab", 15.99);
        kebab.addMeal("Falafel", 12.50);
        kebab.addMeal("Baklava", 7.99);

        Restaurant pizza = new Restaurant("Milano Pizza", "Sobczyka 12/3, Warszawa 33-312");
        pizza.addMeal("Margherita", 28.99);
        pizza.addMeal("Pepperoni", 35.99);
        pizza.addMeal("Hawaiian", 31.99);

        Restaurant burger = new Restaurant("Meat Burger", "Lipowa 31b/1 Gdańsk 18-111");
        burger.addMeal("Cheeseburger", 29.99);
        burger.addMeal("Hamburger", 27.99);
        burger.addMeal("Fries", 14.50);

        restaurants.add(kebab);
        restaurants.add(pizza);
        restaurants.add(burger);
    }

    public void showRestaurants() {
        for (Restaurant r : restaurants) {
            r.showInfo();
        }
    }

    public void addRestaurant(Scanner scanner) {
        System.out.println("Enter the restaurant name: ");
        String name = scanner.nextLine();
        System.out.println("Enter the restaurant address: ");
        String address = scanner.nextLine();
        restaurants.add(new Restaurant(name, address));
        System.out.println("Restaurant added!");
    }

    public void addMealToRestaurant(Scanner scanner) {
        showRestaurants();
        System.out.print("\nSelect the restaurant ID to add a meal: ");
        int restId = scanner.nextInt();
        scanner.nextLine();

        Restaurant selected = findRestaurantById(restId);
        if (selected != null) {
            System.out.print("Enter the meal name: ");
            String mealName = scanner.nextLine();
            System.out.print("Enter the price: ");
            double price = scanner.nextDouble();
            scanner.nextLine();

            selected.addMeal(mealName, price);
            System.out.println("Meal added!");
        } else {
            System.out.println("Restaurant not found.");
        }
    }

    public void showMealsInRestaurant(Scanner scanner) {
        showRestaurants();
        System.out.print("\nSelect the restaurant ID to view the menu: ");
        int restId = scanner.nextInt();
        scanner.nextLine();

        Restaurant selected = findRestaurantById(restId);
        if (selected != null) {
            selected.showMenu();
        } else {
            System.out.println("Restaurant not found.");
        }
    }

    public void placeOrder(Scanner scanner) {
        showRestaurants();
        System.out.print("\nSelect the restaurant ID to place an order: ");
        int restId = scanner.nextInt();
        scanner.nextLine();

        Restaurant selected = findRestaurantById(restId);
        if (selected == null) {
            System.out.println("Restaurant not found.");
            return;
        }

        Order order = new Order(restId);
        selected.showMenu();

        while (true) {
            System.out.print("Select meal ID (or type '0' to finish the order): ");
            int mealId = scanner.nextInt();
            scanner.nextLine();

            if (mealId == 0) break;

            Meal meal = selected.getMealById(mealId);
            if (meal != null) {
                order.addMeal(meal);
                System.out.println("Added: " + meal);
            } else {
                System.out.println("Meal not found.");
            }
        }

        order.displayOrder();
        System.out.println("Order sent to the restaurant!");
    }

    private Restaurant findRestaurantById(int id) {
        for (Restaurant r : restaurants) {
            if (r.getId() == id) return r;
        }
        return null;
    }


}
