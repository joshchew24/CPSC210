package startfromscratch;

public class Leaf extends Offshoot {

    private String colour;

    public Leaf(String s) {
        super(s);
        colour = "GREEN";
    }

    @Override
    public void changeColour(String c) {
        colour = c;
        System.out.println("Leaf " + name + " has changed colour from " + colour);
    }
}
