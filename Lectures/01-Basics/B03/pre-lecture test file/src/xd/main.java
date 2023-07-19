package xd;

import java.util.ArrayList;

public class main {

    public static void main(String[] args) {
        int x;
        x = 3;
        Dog d;
        d = new Dog();
        Dog fido;
        fido = d;
        d.bark();
        d.name = "Jim";
        fido.name = "Fido";
        Dog urmom;
        urmom = new Dog();
        urmom.name = "loser";
        ArrayList<Dog> dogs = new ArrayList<Dog>();
        dogs.add(d);
        dogs.add(urmom);
        dogs.add(urmom);
        System.out.println(dogs);
    }
}
