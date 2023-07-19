package model;

import model.ObserverPattern.Observer;
import model.ObserverPattern.Subject;

import java.util.Random;

public class Bidder implements Observer {

    private String name;
    private double personalBid;
    private double currentBid;
    private double maxBid;

    public Bidder(String name, double maxBid) {
        this.name = name;
        this.maxBid = maxBid;
    }

    @Override
    public void update(Subject subj, Object obj) {
        currentBid = (double) obj;
        System.out.println(name + " has been updated with the current bid of " + currentBid);
        if (currentBid < maxBid) {
            makeBid(currentBid);
        } else {
            System.out.println(name + ": I can't bid any higher!");
        }
    }

    public void makeBid(double currentBid) {
        // generates random double from 0.0 to 1.0 and multiplies it by 9
        // by adding 1, we get a double between 1.0 and 10.0
        Random rand = new Random();
        double delta = 1 + rand.nextDouble()*9;
        personalBid = currentBid + delta;
        System.out.println(name + "'s current bid is: " + personalBid);
    }

    // getters:
    public String getName() {
        return name;
    }

    public double getPersonalBid() {
        return personalBid;
    }

    public double getCurrentBid() {
        return currentBid;
    }

    public double getMaxBid() {
        return maxBid;
    }
}
