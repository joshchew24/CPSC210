package ca.ubc.cpsc210.tpd.test;

import ca.ubc.cpsc210.tpd.clock.AlarmClock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AlarmClockTests extends ClockTests {

	private AlarmClock aClk;
	
	@BeforeEach
	@Override
	public void runBefore() {
		aClk = new AlarmClock();
		clk = aClk;
	}
	
	@Test
	public void testAlarmClockConstructor() {
		assertEquals(0, aClk.getAlarmHrs());
		assertEquals(0, aClk.getAlarmMins());
		assertFalse(aClk.isSounding());
		assertFalse(aClk.isAlarmOn());
	}
	
	@Test
	public void testSetAlarmTime() {
		aClk.setAlarmTime(7, 52);
		assertEquals(7, aClk.getAlarmHrs());
		assertEquals(52, aClk.getAlarmMins());
		assertTrue(aClk.isAlarmOn());
		assertFalse(aClk.isSounding());
	}
	
	@Test
	public void turnAlarmOnOff() {
		assertFalse(aClk.isAlarmOn());
		aClk.setAlarm(true);
		assertTrue(aClk.isAlarmOn());
		aClk.setAlarm(false);
		assertFalse(aClk.isAlarmOn());
	}
	
	@Test
	public void testAlarmClockSounding() {
		aClk.setAlarmTime(6, 23);
		assertTrue(aClk.isAlarmOn());
		assertFalse(aClk.isSounding());
		advanceClock(6, 22, 59);
		assertTrue(aClk.isAlarmOn());
		assertFalse(aClk.isSounding());
		aClk.tick();
		assertTrue(aClk.isSounding());
		assertTrue(aClk.isAlarmOn());
		aClk.tick();
		aClk.tick();
		assertTrue(aClk.isSounding());
		assertTrue(aClk.isAlarmOn());
		aClk.setAlarm(false);
		assertFalse(aClk.isSounding());
		assertFalse(aClk.isAlarmOn());
	}
    
    @Test
    public void testAlarmDoesNotRingWhenTurnedOff() {
        aClk.setAlarmTime(6, 30);
        assertTrue(aClk.isAlarmOn());
        assertFalse(aClk.isSounding());
        advanceClock(6, 29, 59);
        assertTrue(aClk.isAlarmOn());
        assertFalse(aClk.isSounding());
        aClk.setAlarm(false);
        aClk.tick();
        assertFalse(aClk.isSounding());
        assertFalse(aClk.isAlarmOn());
        aClk.tick();
        aClk.tick();
        assertFalse(aClk.isSounding());
        assertFalse(aClk.isAlarmOn());
        aClk.setAlarm(true);
        assertFalse(aClk.isSounding());
        assertTrue(aClk.isAlarmOn());
    }

    @Test
    public void testAlarmDoesNotStartRingingUnlessSecondsAreZero() {
        advanceClock(6, 30, 1);
        aClk.setAlarmTime(6, 30);
        assertTrue(aClk.isAlarmOn());
        assertFalse(aClk.isSounding());
        aClk.tick();
        assertFalse(aClk.isSounding());
        assertTrue(aClk.isAlarmOn());
    }
}
