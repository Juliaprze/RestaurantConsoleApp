package restaurant;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private static int idCounter = 1;
    private int id;
    private String name;
    private String address;
    private List<Meal> menu;

    public Restaurant(String name, String address) {
        this.id = idCounter++;
        this.name = name;
        this.address = address;
        this.menu = new ArrayList<>();
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getAddress() { return address; }
    public List<Meal> getMenu() { return menu; }

    public void addMeal(String mealName, double price) {
        menu.add(new Meal(mealName, price));
    }

    public void showMenu() {
        System.out.println("\nMenu for restaurant: " + name);
        if (menu.isEmpty()) {
            System.out.println("No dishes available in this restaurant.");
        } else {
            for (int i = 0; i < menu.size(); i++) {
                System.out.println("   " + (i + 1) + ". " + menu.get(i));
            }
        }
    }


    public void showInfo() {
        System.out.println(id + ". " + name + " - " + address);
    }

    public Meal getMealById(int id) {
        if (id > 0 && id <= menu.size()) {
            return menu.get(id - 1);
        }
        return null;
    }
}
