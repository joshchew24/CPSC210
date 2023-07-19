package flyers;

public class Seagull extends AvianFlyer {

    //REQUIRES: height > 2m
    //EFFECTS: travels through the air at an altitude of no more than height metres
    @Override
    public void fly(int height) {
        System.out.println("flap flap");
    }

    //REQUIRES: miles <= 200
    //EFFECTS: travels specified distance
    @Override
    public void travel(int miles) {
        for (int i = 0; i < miles; i++){
            fly(10);
        }
    }
}
