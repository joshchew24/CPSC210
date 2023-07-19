package model.exceptions;

public class StaleCoffeeException extends Exception {

    private int timeSinceLastBrew;

    public StaleCoffeeException(int time) {
        super("It has been too long since the lsat time coffee was brewed.");
    }

    public int getTimeSinceLastBrew() {
        return timeSinceLastBrew;
    }
}
