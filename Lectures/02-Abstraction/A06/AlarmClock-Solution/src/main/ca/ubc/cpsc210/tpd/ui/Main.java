package ca.ubc.cpsc210.tpd.ui;

import ca.ubc.cpsc210.tpd.clock.AlarmClock;
import ca.ubc.cpsc210.tpd.clock.Clock;

public class Main {
    public static void main(String[] args) {
        Clock myClock = new Clock();
        myClock.tick();

        Clock myOtherClock = new AlarmClock();  // Type substitution
                                                // Apparent type: Clock, Actual type: AlarmClock
                                                // can call only those methods specified in Clock

        int hours = myOtherClock.getHours();    // Call dispatched to AlarmClock;
                                                // we don't find a definition in AlarmClock, so work
                                                // our way up the hierarchy and call the first
                                                // definition found.

        myOtherClock.tick();                    // So which tick() method is called?
                                                // calls tick() on AlarmClock
    }
}
