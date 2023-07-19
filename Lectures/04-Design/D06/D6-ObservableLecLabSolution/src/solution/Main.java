package solution;

public class Main {
    public static void main(String[] args) {
        OffshootMonitor offshootMonitor = new OffshootMonitor("Trey's Monitor");
        Branch tree = new Branch("tree", offshootMonitor);
        Branch b1 = new Branch("b1", offshootMonitor);
        tree.grow(b1);
        b1.grow(new Leaf("leafy", offshootMonitor));
        tree.changeColor();
        tree.changeColor();
        tree.changeColor();
        offshootMonitor.printStats();
    }
}
