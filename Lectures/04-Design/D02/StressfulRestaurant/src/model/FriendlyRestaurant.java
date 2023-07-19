package model;

public class FriendlyRestaurant extends Restaurant {

    //REQUIRES: booking time must be between 1000 and 2400 hrs
    //EFFECTS: only ever returns 1, because everyone always gets a table
    public int bookTable(int bookingTime){
        return 1;
    }

}


