package model.exceptions;

@SuppressWarnings("serial")
public class TrafficLightException extends Exception {
	
	public TrafficLightException() {
	}
	
	public TrafficLightException(String msg) {
		super(msg);
	}
}
