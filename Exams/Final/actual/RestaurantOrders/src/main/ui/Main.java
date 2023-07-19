package ui;

import model.Order;
import model.Restaurant;

public class Main {
    public static void main(String[] args) {
        Order o1 = new Order(1);
        Order o2 = new Order(2);
        Order o3 = new Order(3);
        Order o4 = new Order(4);
        Order o5 = new Order(5);
        Order o6 = new Order(6);
        Order o7 = new Order(7);
        Order o8 = new Order(8);

        Restaurant restaurant = new Restaurant();
        restaurant.addInHouseOrder(o1);
        restaurant.addTakeOutOrder(o2);
        restaurant.addTakeOutOrder(o3);
        restaurant.addInHouseOrder(o4);
        restaurant.addTakeOutOrder(o5);
        restaurant.addTakeOutOrder(o6);
        restaurant.addTakeOutOrder(o7);
        restaurant.addInHouseOrder(o8);

        for(Order order : restaurant) {
            System.out.println(order.toString());
        }

        o1.addItemToOrder("cock");
        o1.addItemToOrder("ass");
        o2.addItemToOrder("cock");
        o2.addItemToOrder("asdf");
        o3.addItemToOrder("asdf");
        o4.addItemToOrder("ass");

        restaurant.organizeOrders();
        System.out.println(restaurant.organizeOrders());
    }
}
