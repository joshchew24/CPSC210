package iterator;

public class Thing {
    private String name;

    public Thing(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void display() {
        System.out.println("Behold, the beautiful " + name);
    }
}
