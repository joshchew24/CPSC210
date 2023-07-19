package tests;

import model.Coin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CoinTests {
    Coin c;

    @BeforeEach
    public void setup(){
        c = new Coin();
    }
// checks if number of heads is within 10 of number of tails
    @Test
    public void testFlip(){
//        ArrayList<String> results = new ArrayList();
        int currentRun = 1;
        int longestRun = 0;
        String previous;
        for (int i = 0; i < 100 ; i++) {
            previous = c.checkStatus();
            c.flip();
            if (c.checkStatus() == previous) {
                currentRun++;
            } else {
                currentRun = 1;
            }

            if (currentRun > longestRun){
                longestRun = currentRun;
            }
        }
        System.out.println(longestRun);
        assertTrue(longestRun < 25);
    }


}
