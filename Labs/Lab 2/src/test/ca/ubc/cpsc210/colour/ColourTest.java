package ca.ubc.cpsc210.colour;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ColourTest {
    Colour c1;
    Colour c2;
    Colour c3;
    Colour c4;
    Colour c5;

    @BeforeEach
    void runBefore() {
        c1 = new Colour(31, 30, 51);
        c2 = new Colour(244, 105, 105);
        c3 = new Colour(100, 100, 100);
        c4 = new Colour(0, 0, 0);
        c5 = new Colour(255, 255, 255);
    }

    @Test
    void testIsGreyScale() {
        assertFalse(c1.isGreyScale());
        assertFalse(c2.isGreyScale());
        assertTrue(c3.isGreyScale());
        assertTrue(c4.isGreyScale());
        assertTrue(c5.isGreyScale());
    }

    @Test
    void testToHex() {
        assertEquals("1f1e33", c1.toHex());
        assertEquals("f46969", c2.toHex());
        assertEquals("646464", c3.toHex());
        assertEquals("0", c4.toHex());
        assertEquals("ffffff",c5.toHex());
    }
}