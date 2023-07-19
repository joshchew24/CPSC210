package ca.ubc.cs.thermostat.app;

import ca.ubc.cs.thermostat.model.Thermostat;

// Simple application to illustrate use of Thermostat
public class Main {
    public static void main(String[] args) {
        Thermostat myThermostat = new Thermostat();
        myThermostat.setTemperature(70);
        myThermostat.turnOn();
        myThermostat.decrease();
        myThermostat.decrease();
        System.out.println(myThermostat.getTemperature());

    }
}
