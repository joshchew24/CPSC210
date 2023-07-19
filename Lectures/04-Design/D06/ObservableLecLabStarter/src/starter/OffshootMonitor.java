package starter;

import java.util.*;

public class OffshootMonitor implements Observer {

    private static final String PREFIX = "'s Leaf Monitor --- ";

    private String owner;

    private int numTimesRed;
    private int numTimesGreen;

    private Map<String, List<Offshoot>> growths;

    public OffshootMonitor(String name) {
        owner = name;
        growths = new HashMap<>();
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Leaf) {
            Leaf leaf = (Leaf) o;
            if (leaf.getColour().equals("red")) {
                numTimesRed++;
            } else {
                numTimesGreen++;
            }
            System.out.println(owner + PREFIX + leaf.getName() + " changed to " + leaf.getColour());
        } else {
            Branch branch = (Branch) o;
            String branchName = branch.getName();
            Offshoot offshoot = (Offshoot) arg;
            if (!growths.containsKey(branchName)) {
                growths.put(branchName, new ArrayList<>());
            }
            growths.get(branchName).add(offshoot);
            System.out.println(owner + PREFIX + branchName + ": " + offshoot + " added.");
        }
    }

    public void printStats() {
        System.out.println(owner + PREFIX + "Printing Stats ---");
        System.out.println("reds: " + numTimesRed);
        System.out.println("greens: " + numTimesGreen);

        int numOffshoots = 0;

        for (String name : growths.keySet()) {
            List<Offshoot> offshoots = growths.get(name);
            for (Offshoot o : offshoots) {
                numOffshoots++;
            }
        }

        System.out.println(owner + PREFIX + "number of offshoots: " + numOffshoots);
    }

    public String getOwner() {
        return owner;
    }
}
