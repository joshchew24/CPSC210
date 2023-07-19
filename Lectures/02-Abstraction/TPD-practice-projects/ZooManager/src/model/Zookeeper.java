package model;


import java.util.ArrayList;
import java.util.List;

public class Zookeeper {

    private String name;
    private int age;
    private List<Animal> animalList;
    private Animal favourite;

    public Zookeeper(String nm, int age){
        name = nm;
        this.age = age;
        animalList = new ArrayList<Animal>();
        favourite = null;
    }

    // MODIFIES: this
    // EFFECTS: sets the zookeeper's favourite animal
    public void setFavourite(Animal a) {
        favourite = a;
    }

    // MODIFIES: this
    // EFFECTS: adds animal to zookeeper's list
    public void addToList(Animal a) {
        animalList.add(a);
    }

    // MODIFIES: this
    // EFFECTS: removes an animal from a zookeeper's list, return true if successful, false if not found
    public boolean removeFromList(Animal a) {
        if (animalList.contains(a)) {
            animalList.remove(a);
            return true;
        } else {
            return false;
        }
    }


    // getters:
    public String getName() {
        return name;
    }
    public int getAge(){
        return age;
    }

    public List<Animal> getAnimalList() {
        return animalList;
    }

    public Animal getFavourite() {
        return favourite;
    }

}