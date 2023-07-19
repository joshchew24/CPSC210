package starter;

public class Main {
    public static void main(String[] args) {
        OffshootMonitor offshootMonitor = new OffshootMonitor("Trey");
        Branch tree = new Branch("tree");
        tree.addObserver(offshootMonitor);
        Branch b1 = new Branch("b1");
        b1.addObserver(offshootMonitor);
        tree.grow(b1);
        Leaf l1 = new Leaf("leafy");
        l1.addObserver(offshootMonitor);
        b1.grow(l1);
        tree.changeColor();
        tree.changeColor();
        tree.changeColor();
        System.out.println();
        offshootMonitor.printStats();
    }
}
