package solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

public class Branch extends Offshoot {
    private List<Offshoot> offshoots;

    // EFFECTS: constructs branch with name
    public Branch(String name, Observer observer) {
        super(name);
        offshoots = new ArrayList<>();
        addObserver(observer);
    }

    // MODIFIES: this
    // EFFECTS: adds offshoot to branch
    public void grow(Offshoot offshoot) {
        offshoots.add(offshoot);
        setChanged();
        notifyObservers(offshoot);
    }

    @Override
    public void changeColor() {
        for (Offshoot offshoot : offshoots) {
            offshoot.changeColor();
        }
    }
}
