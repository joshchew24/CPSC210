package model.exceptions;

@SuppressWarnings("serial")
public class SequenceException extends TrafficLightException {
	
	public SequenceException() {
	}
	
	public SequenceException(String msg) {
		super(msg);
	}
}
