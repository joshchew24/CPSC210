package ca.ubc.cpsc210.estates.model;

public class House {

	private String colour;
	private int squarefeet;

	public House(String c, int sf) {
		this.colour = c;
		this.squarefeet = sf;
	}

	public void visit() {
		System.out.println("Welcome! It is: " + colour + " and is " + squarefeet + " sq.ft. large");
	}
}
