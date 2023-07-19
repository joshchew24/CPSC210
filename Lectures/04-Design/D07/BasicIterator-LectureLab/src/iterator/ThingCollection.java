package iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ThingCollection implements Iterable<Thing> {
    private ArrayList<Thing> things = new ArrayList<>();

    public void add(Thing thing) {
        System.out.println("Ooh --- I have a new " + thing.getName());
        things.add(thing);
    }

    public void removeThingsThatStartWith(String prefix) {
        List<Thing> toRemove = new ArrayList<>();
        for (Thing thing : things) {
            if (thing.getName().startsWith(prefix)) {
                toRemove.add(thing);
            }
        }
        things.removeAll(toRemove);
    }

    @Override
    public Iterator<Thing> iterator() {
        return things.iterator();
    }
}
