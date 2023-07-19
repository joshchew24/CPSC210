package tests;


import model.TrafficLight;
import model.exceptions.ColourException;
import model.exceptions.SequenceException;
import model.exceptions.TrafficLightException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class TrafficLightTests {
    private TrafficLight light;

    @BeforeEach
    public void setUpBeforeEachTest() {
        light = new TrafficLight();
    }

    @Test
    public void testBadColourExpectColourException() {
        try {
            light.setColour("blue");
            fail("No ColourException was thrown.");
        } catch (ColourException e) {
            // expected
        } catch (SequenceException e) {
            fail("SequenceException thrown, ColourException expected");
        }
    }

    @Test
    //Expecting sequence exception
    public void testSetfromRedtoYellowExpectSequenceException() {
        // default is red -- no need to call light.advance
        try {
            light.setColour("yellow");
        } catch (ColourException e) {
            fail("ColourException thrown, SequenceException expected");
        } catch (SequenceException e) {
            // expected
        }
    }

    @Test void testSetFullCycleNothingThrown(){
        try {
            light.setColour("green");
            light.setColour("yellow");
            light.setColour("red");
        } catch (TrafficLightException e) {
            fail("Exception thrown when none expected.");
        }
        assertEquals("red", light.getColour());
    }

    @Test
    public void testSetfromYellowtoGreenExpectSequenceException() {
        light.advance();  // red to green
        light.advance();  // green to yellow
        try {
            light.setColour("green");
        } catch (ColourException e) {
            fail("ColourException thrown, SequenceException expected");
        } catch (SequenceException e) {
        }
    }

    @Test
    public void testSetfromGreentoRedExpectSequenceException() {
        light.advance(); // red to green
        try {
            light.setColour("red");
        } catch (ColourException e) {
            fail("ColourException thrown, SequenceException expected");
        } catch (SequenceException e) {
            // expected
        }
    }

    @Test
    public void testAdvanceYellowToRed() {
        light.advance(); // red to green
        light.advance(); // green to yellow
        light.advance(); // yellow to red
        assertEquals("red", light.getColour());
    }

    @Test
    public void testAdvanceRedToGreen() {
        light.advance(); // red to green
        assertEquals("green", light.getColour());
    }

    @Test
    public void testAdvanceGreenToYellow() {
        light.advance(); // red to green
        light.advance(); // green to yellow
        assertEquals("yellow", light.getColour());
    }

    @Test
    public void testSetGreenToGreenNothingThrown() {
        light.advance(); // red to green
        try {
            light.setColour("green");
        } catch (TrafficLightException e) {
            fail();
        }
    }

    @Test
    public void testSetRedToRedNothingThrown() {
        // default is red
        try {
            light.setColour("red");
        } catch (TrafficLightException e) {
            fail();
        }
    }

    @Test
    public void testSetYellowToYellowNothingThrown() {
        light.advance(); // red to green
        light.advance(); // green to yellow
        try {
            light.setColour("yellow");
        } catch (TrafficLightException e) {
            fail();
        }
    }

    @Test
    public void testAdvanceRedGreenYellowRed() {
        assertEquals("red", light.getColour());
        light.advance();
        assertEquals("green", light.getColour());
        light.advance();
        assertEquals("yellow", light.getColour());
        light.advance();
        assertEquals("red", light.getColour());
    }
}
