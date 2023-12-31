package model.exceptions;

/*
 * Exception to signal bad colour for traffic light.
 */
@SuppressWarnings("serial")
public class ColourException extends TrafficLightException {

	public ColourException() {
	}
	
	public ColourException(String colour) {
		super("Illegal colour for traffic light: " + colour);
	}
}
