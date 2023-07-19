package startfromscratch;

import java.util.ArrayList;
import java.util.List;

public class Branch extends Offshoot {

    private List<Offshoot> offshoots;

    public Branch(String s) {
        super(s);
        offshoots = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: adds o to offshoots
    public void grow(Offshoot o) {
        offshoots.add(o);
    }

    @Override
    public void changeColour(String c) {
        for (Offshoot o : offshoots) {
            o.changeColour(c);
        }
    }

    // getters:
    public List<Offshoot> getOffshoots() {
        return offshoots;
    }
}
