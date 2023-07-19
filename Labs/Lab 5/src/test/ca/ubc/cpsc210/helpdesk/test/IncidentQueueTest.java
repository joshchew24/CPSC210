package ca.ubc.cpsc210.helpdesk.test;


import ca.ubc.cpsc210.helpdesk.model.Incident;
import ca.ubc.cpsc210.helpdesk.model.IncidentQueue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IncidentQueueTest {

    IncidentQueue testQueue;
    Incident i1;
    Incident i2;
    Incident i3;
    Incident i4;
    Incident i5;
    Incident i6;
    Incident i7;
    Incident i8;
    Incident i9;
    Incident i10;
    Incident i11;


    @BeforeEach
    public void setup() {
        testQueue = new IncidentQueue();
        i1 = new Incident(1, "test incident 1");
        i2 = new Incident(2, "test incident 2");
        i3 = new Incident(3, "test incident 3");
        i4 = new Incident(4, "test incident 4");
        i5 = new Incident(5, "test incident 5");
        i6 = new Incident(6, "test incident 6");
        i7 = new Incident(7, "test incident 7");
        i8 = new Incident(8, "test incident 8");
        i9 = new Incident(9, "test incident 9");
        i10 = new Incident(10, "test incident 10");
        i11 = new Incident(11, "test incident 11");
    }

    @Test
    public void testEmpty() {
        assertTrue(testQueue.isEmpty());
    }

    @Test
    public void testAddIncidentFew() {
        assertTrue(testQueue.isEmpty());

        assertTrue(testQueue.addIncident(i1));
        assertTrue(testQueue.addIncident(i3));
        assertTrue(testQueue.addIncident(i2));

        assertEquals(3, testQueue.length());
        assertFalse(testQueue.isFull());
        assertFalse(testQueue.isEmpty());
    }

    @Test
    public void testAddIncidentFull() {
        testQueue.addIncident(i1);
        testQueue.addIncident(i2);
        testQueue.addIncident(i3);
        testQueue.addIncident(i4);
        testQueue.addIncident(i5);
        testQueue.addIncident(i6);
        testQueue.addIncident(i7);
        testQueue.addIncident(i8);
        testQueue.addIncident(i9);

        assertFalse(testQueue.isFull());
        assertEquals(9, testQueue.length());

        assertTrue(testQueue.addIncident(i10));
        assertTrue(testQueue.isFull());

        assertFalse(testQueue.addIncident(i11));
        assertTrue(testQueue.isFull());
        assertEquals(10, testQueue.length());
    }

    @Test
    public void testGetNextIncidentFew() {
        testQueue.addIncident(i1);
        testQueue.addIncident(i2);
        testQueue.addIncident(i3);
        testQueue.addIncident(i4);
        testQueue.addIncident(i5);
        assertEquals(5, testQueue.length());

        assertEquals(i1, testQueue.getNextIncident());
        assertEquals(4, testQueue.length());

        assertEquals(i2, testQueue.getNextIncident());
        assertEquals(3, testQueue.length());

        assertEquals(i3, testQueue.getNextIncident());
        assertEquals(2, testQueue.length());

        assertEquals(i4, testQueue.getNextIncident());
        assertEquals(1, testQueue.length());

        assertEquals(i5, testQueue.getNextIncident());
        assertEquals(0, testQueue.length());
    }

    @Test
    public void testGetPositionInQueueOfCaseNumberNone() {
        assertEquals(0, testQueue.length());
        assertEquals(-1, testQueue.getPositionInQueueOfCaseNumber(42));
    }

    @Test
    public void testGetPositionInQueueOfCaseNumberSome() {
        testQueue.addIncident(i3);
        testQueue.addIncident(i1);
        testQueue.addIncident(i5);
        testQueue.addIncident(i4);
        testQueue.addIncident(i2);
        assertEquals(5, testQueue.length());

        // case where case number not found
        assertEquals(-1, testQueue.getPositionInQueueOfCaseNumber(10));

        // case where case number matches queue position
        assertEquals(4, testQueue.getPositionInQueueOfCaseNumber(4));

        // check rest of cases are correct
        assertEquals(1, testQueue.getPositionInQueueOfCaseNumber(3));
        assertEquals(2, testQueue.getPositionInQueueOfCaseNumber(1));
        assertEquals(3, testQueue.getPositionInQueueOfCaseNumber(5));
        assertEquals(5, testQueue.getPositionInQueueOfCaseNumber(2));
    }

    @Test
    public void testLengthEmpty() {
        IncidentQueue emptyQueue = new IncidentQueue();
        assertEquals(0, emptyQueue.length());
    }

    @Test
    public void testLengthFew() {
        assertEquals(0, testQueue.length());
        testQueue.addIncident(i1);
        assertEquals(1, testQueue.length());
        testQueue.addIncident(i2);
        assertEquals(2, testQueue.length());
        testQueue.addIncident(i3);
        assertEquals(3, testQueue.length());
        testQueue.addIncident(i4);
        assertEquals(4, testQueue.length());
        testQueue.addIncident(i5);
        assertEquals(5, testQueue.length());
    }

    @Test
    public void testLengthFull() {
        assertEquals(0, testQueue.length());
        testQueue.addIncident(i1);
        assertEquals(1, testQueue.length());
        testQueue.addIncident(i2);
        assertEquals(2, testQueue.length());
        testQueue.addIncident(i3);
        assertEquals(3, testQueue.length());
        testQueue.addIncident(i4);
        assertEquals(4, testQueue.length());
        testQueue.addIncident(i5);
        assertEquals(5, testQueue.length());
        testQueue.addIncident(i6);
        assertEquals(6, testQueue.length());
        testQueue.addIncident(i7);
        assertEquals(7, testQueue.length());
        testQueue.addIncident(i8);
        assertEquals(8, testQueue.length());
        testQueue.addIncident(i9);
        assertEquals(9, testQueue.length());
        testQueue.addIncident(i10);
        assertEquals(10, testQueue.length());
        testQueue.addIncident(i11);
        assertEquals(10, testQueue.length());
    }
}