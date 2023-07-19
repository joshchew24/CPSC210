package ca.ubc.cpsc210.spaceinvaders.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ca.ubc.cpsc210.spaceinvaders.model.SIGame;
import ca.ubc.cpsc210.spaceinvaders.model.Tank;

/*
 * Unit tests for the Tank class.
 */
public class TankTest {
	private static final int XLOC = SIGame.WIDTH / 2;
	private Tank tank;
	
	@Before
	public void runBefore() {
		tank = new Tank(XLOC);
	}
	
	@Test
	public void testXXX() {
		// template for tests
	}
}
