package ui;

import model.Order;

import java.util.ArrayList;
import java.util.List;

public class main {
    Order orderB;
    Order orderC;
    Order orderD;
    Order orderE;
    Order orderF;

    public static void main(String[] args) {
        Order orderA = new Order(1, "A", "josh");
        Order orderB = new Order(2, "B", "semensucker");
        Order orderC = new Order(3, "C", "tittylicker");
        Order orderD = new Order(4, "D", "assfucker");
        Order orderE = new Order(5, "E", "urmomlol");
        Order orderF = new Order(6, "F", "dumbass");

        orderA.giveSpecialInstructions("extra coooooom baby boy");
        orderB.giveSpecialInstructions("shit in my mouth");
        orderF.giveSpecialInstructions("serve it on ur cock head");

        List<Order> orders = new ArrayList<>();

        orders.add(orderA);
        orders.add(orderB);
        orders.add(orderC);
        orders.add(orderD);
        orders.add(orderE);
        orders.add(orderF);

        for(Order o : orders){
            if (!o.checkStatus()){
                o.completed();
            }
        }
    }
}
