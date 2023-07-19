package ui;

import model.*;

public class main {
    public static void main(String[] args) {
        Father f = new Son();
        Grandfather g = f;
        register(f);
    }

    public static void register(Father x) {
        System.out.println(x + " is a registered cunt");
    }

}
