package test;

import model.FriendlyRestaurant;
import model.Restaurant;
import model.SnootyRestaurant;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RestaurantTest {
    @Test
    public void testGoodBooking() {
        Restaurant r = new Restaurant();
        assertTrue(r.bookTable(17) >= 1);
        assertTrue(r.bookTable(20) >= 1);
        assertTrue(r.bookTable(23) >= 1);
    }

    @Test
    public void testGoodBookingSnooty() {
        Restaurant r = new SnootyRestaurant();
        assertTrue(r.bookTable(17) >= 1);
        assertTrue(r.bookTable(20) >= 1);
        assertTrue(r.bookTable(23) >= 1);
    }

    @Test
    public void testGoodBookingFriendly() {
        Restaurant r = new FriendlyRestaurant();
        assertTrue(r.bookTable(17) >= 1);
        assertTrue(r.bookTable(20) >= 1);
        assertTrue(r.bookTable(23) >= 1);
    }
}
