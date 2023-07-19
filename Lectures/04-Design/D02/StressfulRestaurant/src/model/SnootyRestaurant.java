package model;


public class SnootyRestaurant extends Restaurant {

    //REQUIRES: booking time must be between 1900 and 2200 hrs
    //EFFECTS: Returns a booking time of 0-2 hours long (classy dinner!).
    //         If the booking time falls outside of the operating hours,
    //         throws NoSuchTimeException()
    public int bookTable(int bookingTime) {
        if (inRange(bookingTime)) return 2;
        else throw new NoSuchTimeException();
    }

    public boolean inRange(int bookingTime) {
        return 19 <= bookingTime && bookingTime <= 22;
    }
}
