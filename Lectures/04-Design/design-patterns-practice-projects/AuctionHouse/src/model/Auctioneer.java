package model;

import model.ObserverPattern.Subject;

public class Auctioneer extends Subject {

    private String name;
    private double currentBid;

    public Auctioneer(String name) {
        this.name = name;
    }

    public void acceptBid(double bid) {
        if (bid <= currentBid) {
            System.out.println("That bid isn't larger than the current bid!");
        } else {
            currentBid = bid;
            notifyObservers(currentBid);
        }
    }

    public void notifyObservers(double newBidAmt) {
        super.notifyObservers(this, newBidAmt);
    }






    // getters:

    public String getName() {
        return name;
    }

    public double getCurrentBid() {
        return currentBid;
    }
}
