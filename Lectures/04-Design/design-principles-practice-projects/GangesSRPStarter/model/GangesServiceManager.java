package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * model.Customer interface for making requests of various Ganges.com, Inc. services.
 */
public class GangesServiceManager {

    private BookRetailer bookRetailer;
    private CloudStorage cloudStorage;

    private List<BookOrder> customerBookOrders;
    private int orderNumberCounter;
    private int customerIdCounter;

    public static final int FIRST_CUSTOMER_NUMBER = 100;
    private static final int FIRST_ORDER_NUMBER = 1000;

    public GangesServiceManager() {

        bookRetailer = new BookRetailer();
        cloudStorage = new CloudStorage();

        this.customerBookOrders = new ArrayList<>();

        this.customerIdCounter = FIRST_CUSTOMER_NUMBER;
        this.orderNumberCounter = FIRST_ORDER_NUMBER;
    }

    // EFFECTS: Create a new customer with the given address and name
    public Customer signUpNewCustomer(String address, String name) {
        return new Customer(name, address, customerIdCounter++);
    }

    // EFFECTS: Print all books for sale to the console, along with the index number + 1.
    public void listAvailableBooks() {
        bookRetailer.listAvailableBooks();
    }

    // REQUIRES: bookNumber is >= 1
    // MODIFIES: this
    // EFFECTS: Creates a purchase order for given customer and book number
    public BookOrder orderBook(Customer c, int bookNumber) {
        return bookRetailer.orderBook(c, bookNumber);
    }

    // MODIFIES: this
    // EFFECTS: if this order number matches a current order, then the order is cancelled (removed from the orders list)
    public boolean cancelBookOrder(int orderNumber) {
        return bookRetailer.cancelBookOrder(orderNumber);
    }

    // MODIFIES: this
    // EFFECTS: Stores the given data in the cloud under this customer's account
    public void putData(Customer c, String data) {
        cloudStorage.putData(c, data);
    }

    // Returns the given customer's data from the cloud
    public String getData(Customer c) {
        return cloudStorage.getData(c);
    }

    // MODIFIES: this
    // EFFECTS: Deletes this customer's data from the cloud
    public String deleteData(Customer c) {
        return cloudStorage.deleteData(c);
    }
}
