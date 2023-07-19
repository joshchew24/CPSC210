package model;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class Drawing extends JPanel {

    private static final int MUSIC_LINES_SPACE = 30;

	private List<Rectangle> rectangles;
	private int playLineColumn;


	public Drawing() {
		super();
		rectangles = new ArrayList<Rectangle>();
		setBackground(Color.white);
	}

	// getters
    public List<Rectangle> getShapes() { return this.rectangles; }
    public int getPlayLineColumn() { return this.playLineColumn; }

    // setters
	public void setPlayLineColumn(int plc) { playLineColumn = plc; }

    // EFFECTS: return true if the given Shape s is contained in Drawing
    public boolean containsShape(Rectangle s) {
		return rectangles.contains(s);
	}

    // EFFECTS: paints grid, playback line, and all figures in drawing
	//          Note to students: calls to repaint gets here via the Java graphics framework
    @Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawHorizontalNotesLines(g);
		for (Rectangle shape : rectangles) {
            shape.draw(g);
        }
	}

	// EFFECTS: draws grid with lines GRIDSPACE apart, and draws red line at its current position
    private void drawHorizontalNotesLines(Graphics g) {
        Color save = g.getColor();
        g.setColor(new Color(227,227,227));
        for (int y = MUSIC_LINES_SPACE; y < getHeight(); y += MUSIC_LINES_SPACE) {
            g.drawLine(0, y, getWidth(), y);
        }
        if (playLineColumn > 0 && playLineColumn < getWidth()) {
            g.setColor(Color.RED);
            g.drawLine(playLineColumn, 0, playLineColumn, getHeight());
        }
        g.setColor(save);
    }

    // MODIFIES: this
    // EFFECTS:  adds the given shape to the drawing
	public void addShape(Rectangle shape) {
		rectangles.add(shape);
	}


    // MODIFIES: this
    // EFFECTS:  removes shape from the drawing
	public void removeShape(Rectangle shape) {
		rectangles.remove(shape);
		repaint();
	}

	// EFFECTS: returns the Shape at a given Point in Drawing, if any
	public Rectangle getShapesAtPoint(Point point) {
		for (Rectangle shape : rectangles) {
			if (shape.contains(point))
				return shape;
		}
		return null;
	}

	// EFFECTS: returns all Shapes at given column corresponding to an x-coordinate
	public List<Rectangle> getShapesAtColumn(int x) {
	    List<Rectangle> shapesAtColumn = new ArrayList<Rectangle>();
		for (Rectangle shape : rectangles) {
			if (shape.containsX(x))
				shapesAtColumn.add(shape);
		}
		return shapesAtColumn;
	}
}
