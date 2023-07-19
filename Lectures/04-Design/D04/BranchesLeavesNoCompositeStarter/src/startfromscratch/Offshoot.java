package startfromscratch;

public abstract class Offshoot {

    protected String name;

    public Offshoot(String s) {
        name = s;
    }

    public abstract void changeColour(String c);

    public String getName() {
        return name;
    }
}
