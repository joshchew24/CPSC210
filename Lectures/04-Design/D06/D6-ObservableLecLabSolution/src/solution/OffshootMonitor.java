package solution;

import java.util.*;

public class OffshootMonitor implements Observer {
    private int reds;
    private int greens;
    private String name;
    private Map<Branch, HashMap<String,Integer>> branchCounts = new HashMap<>();

    // EFFECTS: constructs leaf monitor with name, sets # of red and green color changes to zero
    public OffshootMonitor(String name) {
        super();
        this.name = name;
        reds = 0;
        greens = 0;
    }

    /**
     * This method is called whenever the observed object is changed. An
     * application calls an <tt>Observable</tt> object's
     * <code>notifyObservers</code> method to have all the object's
     * observers notified of the change.
     *
     * @param o   the observable object.
     * @param arg an argument passed to the <code>notifyObservers</code>
     */
    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Leaf) {
            Leaf theLeaf = (Leaf) o;
            if (theLeaf.getColour().equals("red")) {
                reds += 1;
            } else if (theLeaf.getColour().equals("green")) {
                greens += 1;
            }
            System.out.println(this.name + " --- " + theLeaf.getName() + " changed to " + theLeaf.getColour());
        } else {
            Branch theBranch = (Branch) o;
            Offshoot added = (Offshoot) arg;
            String kind = kindof(added);
            System.out.println(name + " --- " + theBranch.getName() + " added a " + kind + " called " + added.getName());
            HashMap<String, Integer> counts = branchCounts.get(theBranch);
            if (counts == null) {
                counts = new HashMap<>();
                counts.put("leaf", 0);
                counts.put("branch", 0);
                branchCounts.put(theBranch, counts);
            }
            counts.put(kind, counts.get(kind) + 1);
        }
    }

    private String kindof(Offshoot offshoot) {
        return offshoot instanceof Leaf ? "leaf" : "branch";
    }

    // EFFECTS: prints stats on number of red and green color changes
    public void printStats() {
        System.out.println(this.name + " PRINTING STATS----");
        System.out.println("reds: " + reds);
        System.out.println("greens: " + greens);
        System.out.println();
        for (Branch b : branchCounts.keySet()) {
            System.out.println("Branch " + b.getName() + " added " +
                    branchCounts.get(b).get("branch") + " branches and " +
                    branchCounts.get(b).get("leaf") + " leaves");
        }
    }
}
