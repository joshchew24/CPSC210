package model;

import java.util.ArrayList;
import java.util.List;

// Represents an order at a restaurant having an order number
// and a list of menu items that have been added to the order
public class Order {
    private int orderNum;
    private List<String> menuItems;

    // EFFECTS: constructors order having orderNum and an empty list of menu
    // items
    public Order(int orderNum) {
        this.orderNum = orderNum;
        menuItems = new ArrayList<>();
    }

    public int getOrderNum() {
        return orderNum;
    }

    public String toString() {
        return "Order number: " + orderNum;
    }

    // MODIFIES: this
    // EFFECTS: adds menuItem to order
    public void addItemToOrder(String menuItem) {
        menuItems.add(menuItem);
    }

    public List<String> getMenuItems() {
        return menuItems;
    }
}

