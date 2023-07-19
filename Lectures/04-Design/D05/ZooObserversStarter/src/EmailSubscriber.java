// Represents an email subscriber to the zoo
public class EmailSubscriber implements Observer {
    private String name;

    // EFFECTS: constructs an email subscriber with name
    public EmailSubscriber(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void update(Animal a) {
        System.out.println(name + " says: Great to hear that " + a.getName() + " was added to the zoo!");
    }
}
