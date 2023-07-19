package model;

import java.util.*;

// Represents a restaurant having a list of take-out orders and a list
// of in-house orders
public class Restaurant implements Iterable<Order> {
    private List<Order> takeOutOrders;
    private List<Order> inHouseOrders;

    // EFFECTS: constructs restaurant with empty lists of in-house and take-out orders
    public Restaurant() {
        takeOutOrders = new ArrayList<>();
        inHouseOrders = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: adds takeOutOrder to this restaurant
    public void addTakeOutOrder(Order takeOutOrder) {
        takeOutOrders.add(takeOutOrder);
    }

    // MODIFIES: this
    // EFFECTS: adds inHouseOrder to this restaurant
    public void addInHouseOrder(Order inHouseOrder) {
        inHouseOrders.add(inHouseOrder);
    }

    // EFFECTS: returns a map that maps a menu item to the corresponding list of orders
    // that include that menu item
    public Map<String, List<Order>> organizeOrders() {
        Map<String, List<Order>> OrganizedOrders = new HashMap<>();
        Iterator<Order> orderIterator = this.iterator();

        while (orderIterator.hasNext()) {
            Order nextOrder = orderIterator.next();
            for (String menuItem : nextOrder.getMenuItems()) {
                if (OrganizedOrders.containsKey(menuItem)) {
                    OrganizedOrders.get(menuItem).add(nextOrder);
                } else {
                    List<Order> ordersWithMenuItem = new ArrayList<>();
                    ordersWithMenuItem.add(nextOrder);
                    OrganizedOrders.put(menuItem, ordersWithMenuItem);
                }
            }
        }
        return OrganizedOrders;
    }

    @Override
    public Iterator<Order> iterator() {
        return new OrderIterator();
    }


    // Represents an iterator over the orders added to this restaurant
    // which accesses orders in increasing order number
    private class OrderIterator implements Iterator<Order> {
        private int takeOutIndex;  // an index (or cursor) into takeOutOrders
        private int inHouseIndex;  // an index (or cursor) into inHouseOrders

        public OrderIterator() {
            takeOutIndex = 0;
            inHouseIndex = 0;
        }

        @Override
        public boolean hasNext() {
            return takeOutIndex < takeOutOrders.size() || inHouseIndex < inHouseOrders.size();
        }

        @Override
        public Order next() {
            Order nextTakeOutOrder = null;
            Order nextInHouseOrder = null;

            // check if index out of bounds, then get nextOrders
            if (takeOutIndex < takeOutOrders.size()) {
                nextTakeOutOrder = takeOutOrders.get(takeOutIndex);
            }
            if (inHouseIndex < inHouseOrders.size()) {
                nextInHouseOrder = inHouseOrders.get(inHouseIndex);
            }

            // check if any orders are null, then return order with smaller order number
            if ((nextTakeOutOrder != null) && (nextTakeOutOrder.getOrderNum() < nextInHouseOrder.getOrderNum())) {
                takeOutIndex++;
                return nextTakeOutOrder;
            } else if ((nextInHouseOrder != null)) {
                inHouseIndex++;
                return nextInHouseOrder;
            } else {
                return null;
            }
        }
    }
}