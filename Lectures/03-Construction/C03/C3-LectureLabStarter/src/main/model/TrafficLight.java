package model;

import model.exceptions.ColourException;
import model.exceptions.SequenceException;
import model.exceptions.TrafficLightException;

/*
 * Represent a traffic light.
 * 
 * @author Gail Murphy
 *         - modified by Paul Carter, Jan 2011
 *
 * invariant
 *    (lastColour is "yellow" AND getColour().equals("red"))
 * OR
 *    (lastColour is "red" AND getColour().equals("green"))
 * OR
 *    (lastColour is "green" AND getColour().equals("yellow"))
 *    
 */
public class TrafficLight {

	private String lightColour;
	private String lastColour;
	

	// Constructor
	public TrafficLight() {
		lightColour = "red";
		lastColour = "yellow";
	}

	/*
	 * Set the current colour of the traffic light
	 *  
	 * MODIFIES: this 
	 * EFFECTS: if !(colour.equals("red") 
	 * 					or colour.equals("yellow") 
	 * 					or colour.equals("green")) 
	 * 				then ColourException is thrown;
	 *          else if colour is out of sequence with getColour()
	 *              then SequenceException is thrown;
	 *          else if getColour().equals(colour)
	 *          	then silently returns;
	 *          else 
	 *              traffic light has given colour and previous colour is stored
	 */
	public void setColour(String colour) 
			throws ColourException, SequenceException {
		hasValidState();
		if (!lightColour.equals(colour)) {
			if (!isValidColour(colour))
				throw new ColourException(colour);
			if (!isInSequence(colour))
				throw new SequenceException(colour);
			lastColour = lightColour;
			lightColour = colour;
		}
		hasValidState();
	}

	/*
	 * Advance the traffic light to the next colour
	 * 
	 * MODIFIES: this 
	 * EFFECTS: if traffic light was red, now is green; 
	 * 			otherwise if traffic light was green, now is yellow; 
	 *          otherwise if traffic light was yellow, now is red
	 */
	public void advance() {
		hasValidState();
		try {
			if (lightColour.equals("red")) {
				setColour("green");
			} else if (lightColour.equals("green")) {
				setColour("yellow");
			} else if (lightColour.equals("yellow")){
				setColour("red");
			}
		} catch (TrafficLightException e) {
			// If we get here it's due to logic error in this method
			// (postcondition has not been satisfied)
			e.printStackTrace(); // for debugging
		}
		
		hasValidState();
	}
	
	/*
	 * Resets light to default safe state.
	 * MODIFIES: this
	 * EFFECTS: getColour.equals("red") and last colour is yellow
	 */
	public void reset() {
		lightColour = "red";
		lastColour = "yellow";
	}
	
	/*
	 * Provide the current colour of the traffic light
	 * 
	 * EFFECTS: Returns one of "red", "yellow" or "green"
	 */
	public String getColour() {
		hasValidState();
		String returnValue = lightColour;
		hasValidState();
		return returnValue;
	}
	
	/*
	 * Is colour valid?
	 * EFFECTS: returns true if colour is valid, false otherwise
	 */
	private boolean isValidColour(String colour) {
		return (colour.equals("red") || colour.equals("yellow")
				|| colour.equals("green"));
	}
	
	/*
	 * Is next colour in sequence with current colour?
	 * REQUIRES: nextColour is one of "red", "green" or "yellow"
	 * EFFECTS: returns true if nextColour is in sequence with current
	 * colour of light, false otherwise
	 */
	private boolean isInSequence(String nextColour) {
		return (lightColour.equals("red") && nextColour.equals("green")) || 
		(lightColour.equals("green") && nextColour.equals("yellow")) ||
		(lightColour.equals("yellow") && nextColour.equals("red"));
	}
	
	/*
	 * Check invariant. 
	 */
	private void hasValidState() {
		assert (lastColour.equals("red") && lightColour.equals("green")) || 
		(lastColour.equals("green") && lightColour.equals("yellow")) ||
		(lastColour.equals("yellow") && lightColour.equals("red"));				
	}
}
