package iterator;


public class Main {
    public static void main(String[] args) {
        Thing doll = new Thing("Doll");
        Thing marigold = new Thing("Marigold");
        Thing puppy = new Thing("Puppy");
        Thing marble = new Thing("Marble");

        ThingCollection myThings = new ThingCollection();
        myThings.add(doll);
        myThings.add(marigold);
        myThings.add(puppy);
        myThings.add(marble);

        System.out.println("\nDisplay my things:");
        for (Thing thing : myThings) {
            thing.display();
        }

        // TODO: uncomment these lines when you are ready to start step 2
        myThings.removeThingsThatStartWith("Mar");

        System.out.println("\nDisplay my things:");
        for (Thing thing : myThings) {
            thing.display();
        }
    }
}
