package model;


import model.media.AbstractMedia;
import model.media.*;

public class Main {

    private static iPod nano = new iPod("John");
    private static Movie m1 = new Movie("Dunkirk (2017)", "Christopher Nolan", "Drama",  107);
    private static Movie m2 = new Movie("ur mom's sex tape", "me", "adult", 69);
    private static Photo p1 = new Photo("Moonrise", "Ansel Adams", "Landscape", "Yosemite");
    private static Photo p2 = new Photo("ur mom's nudes", "me", "gore", "ur bedroom");
    private static Song s1 = new Song("Writing's on the Wall", "Sam Smith", "Ballad", 3.02);
    private static Song s2 = new Song("hitler was a sensitive man", "anal cunt", "gospel", 4.20);

    public static void main(String[] args) {

        nano.add(m1);
        nano.add(m2);
        nano.add(p1);
        nano.add(p2);
        nano.add(s1);
        nano.add(s2);

        System.out.println(nano.getName() +"'s iPod contains: ");
        // TODO: Use the Iterator Design Pattern to make the following for-each loop run
        for (AbstractMedia m : nano) {
            System.out.println(m.getName() + " by: " + m.getCreator());
        }
    }


}