package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


public class Inventory implements Iterable<Toy> {
    private Collection<Toy> toys = new ArrayList<>();
    private Collection<Toy> backlog = new ArrayList<>();
    private ArrayList<String> log = new ArrayList<>();

    // getters
    public int getSize() { return toys.size(); }

    public void add(Toy t) {
        toys.add(t);
        log.add("New toy added: "+t);
    }

    public void remove(Toy t){
        toys.remove(t);
        log.add("Toy "+t+" removed");
    }


    public void printQueryStats(){
        for(String logEntry : log){
            System.out.println(logEntry);
        }
    }

    public void moveToBacklog(Toy toy) {
        toys.remove(toy);
        backlog.add(toy);
    }


    @Override
    public Iterator<Toy> iterator() {
        return new InventoryIterator();
    }

    private class InventoryIterator implements Iterator<Toy> {
        Iterator<Toy> toysIterator = toys.iterator();
        Iterator<Toy> backlogIterator = backlog.iterator();
        @Override
        public boolean hasNext() {
            return toysIterator.hasNext() || backlogIterator.hasNext();
        }

        @Override
        public Toy next() {
            Toy toy;
            if (toysIterator.hasNext()) {
                toy = toysIterator.next();
            } else {
                toy = backlogIterator.next();
            }
            return toy;
        }
    }
}