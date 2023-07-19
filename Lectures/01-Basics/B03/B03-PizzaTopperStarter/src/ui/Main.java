package ui;

import model.Pizza;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Pizza> pizzas = new ArrayList<>();
        Pizza pizza1 = new Pizza("pizza1");
        Pizza pizza2 = new Pizza("pizza2");
        pizza1.addATopping();
        pizza2.addATopping();
        pizza2.addATopping();
        pizzas.add(pizza1);
        pizzas.add(pizza2);
        pizzas.get(0).print();
        pizzas.get(1).print();
    }
}
