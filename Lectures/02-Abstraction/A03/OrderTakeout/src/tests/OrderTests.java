package tests;

import model.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderTests {

    Order orderA;
    Order orderB;
    Order orderC;
    Order orderD;
    Order orderE;
    Order orderF;

    @BeforeEach
    public void setup(){
        orderA = new Order(1, "A", "josh");
        orderB = new Order(2, "B", "semensucker");
        orderC = new Order(3, "C", "tittylicker");
        orderD = new Order(4, "D", "assfucker");
        orderE = new Order(5, "E", "urmomlol");
        orderF = new Order(6, "F", "dumbass");
    }

    @Test
    public void testGiveSpecialInstructions(){
        orderA.giveSpecialInstructions("put extra jizz on it baby");
        assertEquals("put extra jizz on it baby", orderA.getSpecialInstructions());
    }

    @Test
    public void testAutoPrice(){
        assertEquals(6.90, orderA.getPrice());
        assertEquals(4.20, orderB.getPrice());
        assertEquals(1.23, orderC.getPrice());
        assertEquals(100.00, orderD.getPrice());
        assertEquals(0.00, orderE.getPrice());
        assertEquals(6.66, orderF.getPrice());
    }
}
