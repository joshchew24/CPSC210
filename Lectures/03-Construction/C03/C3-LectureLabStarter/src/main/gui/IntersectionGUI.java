package gui;

import model.TrafficLight;
import model.exceptions.ColourException;
import model.exceptions.SequenceException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class IntersectionGUI extends JFrame {
	private static final String STATUS_OK = "System OK";
	private TrafficLight light;
	private TrafficLightGUI trafficLightArea;
	private JLabel statusLabel;

	public IntersectionGUI() {
		super("Intersection UI");

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		statusLabel = new JLabel(STATUS_OK);
		add(statusLabel, BorderLayout.NORTH);

		// Create the intersection and GUI for intersection
		createIntersection();

		JButton advanceButton = new JButton("Advance");
		advanceButton.setActionCommand("advance");
		advanceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				light.advance();
				drawLights();
			}
		});
		
		add(advanceButton, BorderLayout.SOUTH);
		
		pack();
		setVisible(true);
	}

	public void setLight(String colour) { 
		try {
			light.setColour(colour);
			drawLights();
			statusLabel.setText(STATUS_OK);
		} catch (ColourException e) {
			statusLabel.setText("System error: " + e.getMessage());
		} catch (SequenceException e) {
			statusLabel.setText("System error: can't change to " + e.getMessage());
		}
		
	}

	private void createIntersection() {
		light = new TrafficLight();
		trafficLightArea = new TrafficLightGUI(this);
		add(trafficLightArea, BorderLayout.CENTER);
	}

	private void drawLights() {
		trafficLightArea.setLight(light.getColour());
		validate();
		repaint();
	}

	public static void main(String[] args) {
		new IntersectionGUI();
	}
}
