package model;

public class Animal {
    protected String name;
    protected String country;
    protected int age;
    protected Zookeeper careTaker;
    protected Double weight;

    public Animal(String nm, String ct, int age, Zookeeper zk, double wgt) {
        name = nm;
        country = ct;
        this.age = age;
        careTaker = zk;
        weight = wgt;
    }

    // getters
    public String getName() { return name; }

    public String getCountry() { return country; }

    public int getAge() { return age; }

    public Zookeeper getCareTaker() { return careTaker; }

    public double getWeight() { return weight; }
}
