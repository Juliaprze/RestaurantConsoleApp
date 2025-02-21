package restaurant;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private int restaurantId;
    private List<Meal> orderedMeals;
    private double totalPrice;

    public Order(int restaurantId) {
        this.restaurantId = restaurantId;
        this.orderedMeals = new ArrayList<>();
        this.totalPrice = 0;
    }

    public void addMeal(Meal meal) {
        orderedMeals.add(meal);
        totalPrice += meal.getPrice();
    }

    public void displayOrder() {
        System.out.println("\nZamówienie dla restauracji ID: " + restaurantId);
        if (orderedMeals.isEmpty()) {
            System.out.println("Zamówienie jest puste.");
        } else {
            for (Meal meal : orderedMeals) {
                System.out.println("   - " + meal);
            }
            System.out.println("koszt zamówienia: " + totalPrice + " PLN");
        }
    }
}
