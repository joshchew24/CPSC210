package ca.ubc.cs.cpsc210.servicecard.tests;

import ca.ubc.cs.cpsc210.servicecard.model.FoodServicesCard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// Unit tests for FoodServiceCard class
class FoodServicesCardTest {

    FoodServicesCard testCard;

    @BeforeEach
    public void setup() {
        testCard = new FoodServicesCard(100);
        FoodServicesCard.POINTS_NEEDED_FOR_CASH_BACK = 2000;
        FoodServicesCard.REWARD_POINTS_PER_CENT_CHARGED = 1;
        FoodServicesCard.CASH_BACK_REWARD = 10;
    }

    @Test
    public void testReload() {
        assertEquals(100, testCard.getBalance());
        testCard.reload(1);
        assertEquals(101, testCard.getBalance());
        testCard.reload(500);
        assertEquals(601, testCard.getBalance());
        testCard.reload(2000);
        assertEquals(2601, testCard.getBalance());
    }

    @Test
    public void testMakePurchaseZero() {
        assertTrue(testCard.makePurchase(0));
        assertEquals(100, testCard.getBalance());
        assertEquals(0, testCard.getRewardPoints());
    }

    @Test
    public void testMakePurchaseFullOver() {
        assertTrue(testCard.makePurchase(100));
        assertEquals(0, testCard.getBalance());
        assertEquals(100, testCard.getRewardPoints());

        assertFalse(testCard.makePurchase(500));
    }

    @Test
    public void testMakePurchaseCashBackSingle() {
        testCard.reload(1900);

        assertTrue(testCard.makePurchase(360));
        assertEquals(1640, testCard.getBalance());
        assertEquals(360, testCard.getRewardPoints());

        assertTrue(testCard.makePurchase(1640));
        assertEquals(10, testCard.getBalance());
        assertEquals(0, testCard.getRewardPoints());

    }

    @Test
    public void testMakePurchaseCashBackLeftover() {
        testCard.reload(2500);

        assertTrue(testCard.makePurchase(2400));
        assertEquals(210, testCard.getBalance());
        assertEquals(400, testCard.getRewardPoints());

    }

    @Test
    public void testMakePurchaseLarge() {
        testCard.reload(99900);

        assertTrue(testCard.makePurchase(100000));
        assertEquals(500, testCard.getBalance());
        assertEquals(0, testCard.getRewardPoints());
    }
}
