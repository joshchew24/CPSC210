package model;

import java.util.ArrayList;
import java.util.List;

public class Server extends FOHEmployee {

    private static final double DISH_PRICE = 10.00;
    private static final String PREFIX = "SERVER - ";

    public Server(Dish dish) {
        super(dish);
    }

    //getter
    public List<Order> getActiveOrders() {
        return orders;
    }

    public double getCash() { return cash; }

    @Override
    public String getPrefix() {
        return PREFIX;
    }

    //MODIFIES: this
    //EFFECTS: creates new order with the dish on the menu
    public Order takeOrder() {
        System.out.println(PREFIX + "Taking order...");
        Order o = new Order(this.dish, currentOrderNumber++);
        orders.add(o);
        System.out.print("Order taken: ");
        o.print();
        return o;
    }


    //MODIFIES: this
    //EFFECTS: takes payment for the guest and removes order from system
    public void takePayment(Order order) {
        System.out.println(PREFIX + "Taking payment...");
        orders.remove(order);
        cash += DISH_PRICE;
        System.out.println("\"Thanks for visiting Busy's Diner!\"");
    }

}
