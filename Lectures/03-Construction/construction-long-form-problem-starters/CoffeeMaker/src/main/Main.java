package main;

import model.CoffeeMaker;
import model.exceptions.*;

public class Main {

    public static void main(String[] args){
        CoffeeMaker cm = new CoffeeMaker();
        try {
            cm.brew(2,15);
        } catch (BeansAmountException e) {
            System.out.println("You need between 2.40 and 2.60 cups of beans!");
        } catch (WaterException e) {
            System.out.println("You need at least 14.75 cups of water!");
        }
        try {
            cm.pourCoffee();
        } catch (NoCupsRemainingException e) {
            System.out.println("You have no cups left!");
        } catch (StaleCoffeeException e) {
            System.out.println("You need to brew a fresh pot!");
        }
        try {
            cm.brew(2.5, 15);
        } catch (BeansAmountException e) {
            System.out.println("You need between 2.40 and 2.60 cups of beans!");
        } catch (WaterException e) {
            System.out.println("You need at least 14.75 cups of water!");
        }
        try {
            cm.pourCoffee();
        } catch (NoCupsRemainingException e) {
            System.out.println("You have no cups left!");
        } catch (StaleCoffeeException e) {
            System.out.println("You need to brew a fresh pot!");
        }
        try {
            cm.pourCoffee();
        } catch (NoCupsRemainingException e) {
            System.out.println("You have no cups left!");
        } catch (StaleCoffeeException e) {
            System.out.println("You need to brew a fresh pot!");
        }
        try {
            cm.pourCoffee();
        } catch (NoCupsRemainingException e) {
            System.out.println("You have no cups left!");
        } catch (StaleCoffeeException e) {
            System.out.println("You need to brew a fresh pot!");
        }
        try {
            cm.pourCoffee();
        } catch (NoCupsRemainingException e) {
            System.out.println("You have no cups left!");
        } catch (StaleCoffeeException e) {
            System.out.println("You need to brew a fresh pot!");
        }
        try {
            cm.brew(3, 15);
        } catch (BeansAmountException e) {
            System.out.println("You need between 2.40 and 2.60 cups of beans!");
        } catch (WaterException e) {
            System.out.println("You need at least 14.75 cups of water!");
        }
        try {
            cm.brew(2.5, 10);
        } catch (BeansAmountException e) {
            System.out.println("You need between 2.40 and 2.60 cups of beans!");
        } catch (WaterException e) {
            System.out.println("You need at least 14.75 cups of water!");
        }
        try {
            cm.brew(2.5, 34);
        } catch (BeansAmountException e) {
            System.out.println("You need between 2.40 and 2.60 cups of beans!");
        } catch (WaterException e) {
            System.out.println("You need at least 14.75 cups of water!");
        }
    }


}