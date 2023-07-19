package model;

import model.exceptions.*;

/**
 * A coffee maker used to train baristas.
 *
 * Class invariant: cups remaining >= 0, time since last brew >= 0
 */

public class CoffeeMaker {

    public CoffeeMaker(){
        // TODO: complete the implementation of this method
    }

    // getters
    public int getTimeSinceLastBrew() {
        // TODO: complete the implementation of this method
        return 0;
    }
    public int getCupsRemaining() {
        // TODO: complete the implementation of this method
        return 0;
    }

    // EFFECTS: return true if there are coffee cups remaining
    public boolean areCupsRemaining() {
        // TODO: complete the implementation of this method
        return false;
    }

    //EFFECTS: sets time since last brew. Throws NegativeInputException if negative integer
    public void setTimeSinceLastBrew(int time) throws NegativeInputException {
        // TODO: complete the implementation of this method
    }

    //EFFECTS: sets cups remaining to full (20 cups) and time since last brew to 0
    //          throws NotEnoughBeansException if beans < 2.40
    //          throws TooManyBeansException if beans > 2.60
    //          throws WaterException if water < 14.75
    public void brew(double beans, double water) throws NotEnoughBeansException, TooManyBeansException, WaterException {
        // TODO: complete the implementation of this method
    }

    //MODIFIES: this
    //EFFECTS: subtracts one cup from cups remaining
    //          throws NoCupsRemainingException if cups <= 0
    //          throws StaleCoffeeException if time since last brew > 60
    public void pourCoffee() throws NoCupsRemainingException, StaleCoffeeException {
        // TODO: complete the implementation of this method
    }


}
