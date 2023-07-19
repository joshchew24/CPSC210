package solution;

import java.util.Observer;

public class Leaf extends Offshoot {
    private boolean isGreen;

    // EFFECTS: constructs leaf with given name and observer, and color set to green
    public Leaf(String name, Observer observer) {
        super(name);
        addObserver(observer);
        isGreen = true;
    }

    @Override
    // MODIFIES: this
    // EFFECTS: changes color of leaf from green to red or vice versa
    public void changeColor() {
        this.isGreen = !isGreen;
        System.out.println(getName() + " says: I AM CHANGING TO: " + getColour());
        setChanged();
        notifyObservers();
    }

    // EFFECTS: returns color of leaf
    public String getColour() {
        if (isGreen) return "green";
        return "red";
    }
}
