package ca.ubc.cs.thermostat.model;

// Represents a thermostat that can be turned on or off
// and have its temperature set.
//
// The thermostat is initially off and set to
// INITIAL_TEMP. The temperatures to which the
// thermostat can be set are restricted to lie in
// the range MIN_TEMP to MAX_TEMP, inclusive.
public class Thermostat {
    public static final int MIN_TEMP = 55;
    public static final int MAX_TEMP = 75;
    public static final int INITIAL_TEMP = 65;

    boolean isOn;
    int temperature;

    // EFFECTS: constructs a thermostat that is off and that has
    //          the temperature set to INITIAL_TEMP
    public Thermostat() {
        temperature = INITIAL_TEMP;
        isOn = false;
    }

    // MODIFIES: this
    // EFFECTS:  turns the thermostat on
    public void turnOn() {
        isOn = true;
    }

    // MODIFIES: this
    // EFFECTS:  turns the thermostat off
    public void turnOff() {
        isOn = false;
    }

    // EFFECTS: returns true if thermostat is on; false otherwise
    public boolean isOn() {
        return isOn;
    }

    // MODIFIES: this
    // EFFECTS:  increases temperature by 1C but to no more than MAX_TEMP
    public void increase() {
        temperature = temperature++;
    }

    // MODIFIES: this
    // EFFECTS: decreases temperature by 1C but to no less than MIN_TEMP
    public void decrease() {
        temperature = temperature--;
    }

    // REQUIRES: MIN_TEMP <= temperature <= MAX_TEMP
    // MODIFIES: this
    // EFFECTS: sets temperature to given temperature in degrees Celsius
    public void setTemperature(int temperature) {
        if (MIN_TEMP <= temperature && temperature <= MAX_TEMP) {
            this.temperature = temperature;
        }
        else {
            System.out.println(temperature + " is out of range.");
        }
    }

    // MODIFIES: this
    // EFFECTS: resets the temperature to initial value and turns thermostat off
    public void reset() {
        temperature = INITIAL_TEMP;
        isOn = false;
    }

    // EFFECTS: returns the current temperature in Celsius
    public int getTemperature() {
        return temperature;
    }
}
