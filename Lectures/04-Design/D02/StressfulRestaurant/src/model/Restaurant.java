package model;


public class Restaurant {

    //REQUIRES: booking time must be between 1700 and 2300 hrs
    //EFFECTS: returns a table booking duration of 0-2 hours long
    //         If the booking time falls outside of the operating hours,
    //         throws NoSuchTimeException()
    public int bookTable(int bookingTime) {
        if (inRange(bookingTime)) return 1;
        throw new NoSuchTimeException();
    }

    protected boolean inRange(int bookingTime) {
        return 17 <= bookingTime && bookingTime <= 23;
    }
}



