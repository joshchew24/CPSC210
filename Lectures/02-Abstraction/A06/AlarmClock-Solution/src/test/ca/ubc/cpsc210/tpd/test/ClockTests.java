package ca.ubc.cpsc210.tpd.test;

import ca.ubc.cpsc210.tpd.clock.Clock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ClockTests {
	protected Clock clk;
	
	@BeforeEach
	public void runBefore() {
		clk = new Clock();
	}
	
	@Test
	public void testConstructor() {
		assertEquals(0, clk.getHours());
		assertEquals(0, clk.getMinutes());
		assertEquals(0, clk.getSeconds());
	}
	
	@Test
	public void testTickOnce() {
		clk.tick();
		assertEquals(0, clk.getHours());
		assertEquals(0, clk.getMinutes());
		assertEquals(1, clk.getSeconds());
	}
	
	@Test
	public void testTickMinute() {
		advanceClock(0, 1, 0);
		
		assertEquals(0, clk.getHours());
		assertEquals(1, clk.getMinutes());
		assertEquals(0, clk.getSeconds());
	}
	
	@Test
	public void testTickHour() {
		advanceClock(1, 0, 0);
		
		assertEquals(1, clk.getHours());
		assertEquals(0, clk.getMinutes());
		assertEquals(0, clk.getSeconds());
	}
	
	@Test
	public void testTickDay() {
		advanceClock(24, 0, 0);
		
		assertEquals(0, clk.getHours());
		assertEquals(0, clk.getMinutes());
		assertEquals(0, clk.getSeconds());
	}
	
	protected void advanceClock(int numHrs, int numMins, int numSecs) {
		int advanceSeconds = (numHrs * Clock.MINS_PER_HOUR + numMins) * Clock.SECONDS_PER_MINUTE + numSecs;
		
		for(int i = 0; i < advanceSeconds; i++) {
			clk.tick();
		}
	}
}
