package model;

import java.util.Random;

public class Coin {
    private boolean coinFaceUp;

    //EFFECTS: constructs a coin facing heads up
    public Coin(){
        coinFaceUp = true;
    }

    //MODIFIES: this
    //EFFECTS: randomly flips the coin to have heads(true) or tails(false)
    public void flip(){
        Random ran = new Random();
        coinFaceUp= ran.nextBoolean();
    }
    //EFFECTS: returns the side of the coin that is currently facing up
    public String checkStatus(){
        if(coinFaceUp){
            return "heads";
        }
        else {
            return "tails";
        }

    }

}
