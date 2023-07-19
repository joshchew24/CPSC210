package test;

import flyers.Flyer;
import flyers.Penguin;
import flyers.Seagull;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestFlyer {
    @Test
    public void testFly() {
        Flyer f = new Seagull();
        f.fly(6);
        assertTrue(f.isHealthy());
    }
    @Test
    public void testFlyPenguin() {
        Flyer f = new Penguin();
        f.fly(6);
        assertTrue(f.isHealthy());
    }
}
